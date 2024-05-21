package financeiro.api.transacao.service;
import financeiro.api.transacao.dto.CreateTransactionDto;
import financeiro.api.transacao.dto.UpdateAccountDto;
import financeiro.api.transacao.models.Transaction;
import financeiro.api.transacao.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;

    private boolean executeTransaction(Transaction transaction) {
        var originAccount = accountService.getByAccount(transaction.getOriginAccount());
        var targetAccount = accountService.getByAccount(transaction.getTargetAccount());

        System.out.println(originAccount);
        System.out.println(targetAccount);

        if (originAccount.isPresent() && targetAccount.isPresent()) {
            var existingOriginAccount = originAccount.get();
            var existingTargetAccount = targetAccount.get();
            BigDecimal newOriginBalance = existingOriginAccount.getBalance().subtract(transaction.getValue());
            BigDecimal newTargetBalance = existingTargetAccount.getBalance().add(transaction.getValue());

            if (newOriginBalance.compareTo(BigDecimal.ZERO) >= 0) {
                Optional<String> accountOrigin = Optional.of(existingOriginAccount.getAccount());
                Optional<BigDecimal> balanceOrigin = Optional.of(newOriginBalance);
                UpdateAccountDto updateAccountOrigin = new UpdateAccountDto(accountOrigin, balanceOrigin);
                accountService.updateAccount(existingOriginAccount.getId(), updateAccountOrigin);

                Optional<String> accountTarget = Optional.of(existingTargetAccount.getAccount());
                Optional<BigDecimal> balanceTarget = Optional.of(newTargetBalance);
                UpdateAccountDto updateAccountTarget = new UpdateAccountDto(accountTarget, balanceTarget);
                accountService.updateAccount(existingTargetAccount.getId(), updateAccountTarget);

                return true;
            }
        }
        return false;
    }

    public boolean createTransaction(CreateTransactionDto transaction) {

        var createTransaction = new Transaction(
                UUID.randomUUID().toString(),
                transaction.origin_account(),
                transaction.target_account(),
                transaction.value(),
                Instant.now(),
                null);

        if (executeTransaction(createTransaction)){
            transactionRepository.save(createTransaction);
        }

        return false;
    }
}
