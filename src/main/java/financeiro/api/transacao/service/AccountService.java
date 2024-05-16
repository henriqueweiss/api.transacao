package financeiro.api.transacao.service;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.models.Account;
import financeiro.api.transacao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public boolean createAccount(CreateAccountDto account) {

        var createAccount = new Account(
                UUID.randomUUID().toString(),
                account.account(),
                account.balance(),
                Instant.now(),
                null);

        accountRepository.save(createAccount);
        return true;
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public String deleteById(String id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return "Deletado";
        } else {
            return "ID incorreto";
        }
    }

}
