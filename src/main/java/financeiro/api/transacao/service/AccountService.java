package financeiro.api.transacao.service;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.dto.UpdateAccountDto;
import financeiro.api.transacao.models.Account;
import financeiro.api.transacao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public String createAccount(CreateAccountDto account) {

        var createAccount = new Account(
                UUID.randomUUID().toString(),
                account.account(),
                account.balance(),
                Instant.now(),
                null);

        Account accountCreated = accountRepository.save(createAccount);
        return accountCreated.getId();
    }

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Optional<Account> getById(String id){
        return accountRepository.findById(id);
    }

    public Optional<Account> getByAccount(String account) {
        return accountRepository.findByAccount(account);
    }

    public boolean deleteByIdAccount(String id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateAccount(String id, UpdateAccountDto account) {
        var accountToUpdate = accountRepository.findById(id);

        if (accountToUpdate.isPresent()) {
            var existingAccount = accountToUpdate.get();

            if (account.account().isPresent()){
                existingAccount.setAccount(account.account().get());
            }
            if (account.balance().isPresent()){
                existingAccount.setBalance(account.balance().get());
            }
            accountRepository.save(existingAccount);
            return true;
        } else {
            return false;
        }
    }
}
