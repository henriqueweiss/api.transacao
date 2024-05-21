package financeiro.api.transacao.repository;
import financeiro.api.transacao.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByAccount(String account);
}
