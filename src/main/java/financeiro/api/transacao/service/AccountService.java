package financeiro.api.transacao.service;
import financeiro.api.transacao.dto.CreateAccountDto;
import financeiro.api.transacao.models.Account;
import financeiro.api.transacao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public boolean createAccount(CreateAccountDto account) {
        var createAccount = new Account(UUID.randomUUID(),
                account.account(),
                account.balance(),
                Instant.now(),
                null);
        accountRepository.save(createAccount);
        return true;
    }
}
