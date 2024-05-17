package financeiro.api.transacao.repository;
import financeiro.api.transacao.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
