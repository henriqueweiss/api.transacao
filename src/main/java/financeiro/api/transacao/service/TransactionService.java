package financeiro.api.transacao.service;
import financeiro.api.transacao.dto.CreateTransactionDto;
import financeiro.api.transacao.models.Transaction;
import financeiro.api.transacao.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;

@Service
public class TransactionService {

    /**
     * FAZER TRANSAÇÃO ENTRE AS CONTAS COM O ACCOUNT SERVICE
     */
    @Autowired
    TransactionRepository transactionRepository;

    public boolean createTransaction(CreateTransactionDto transaction) {

        var createTransaction = new Transaction(
                UUID.randomUUID().toString(),
                transaction.origin_account(),
                transaction.origin_account(),
                transaction.value(),
                Instant.now(),
                null);

        transactionRepository.save(createTransaction);
        return true;
    }
}
