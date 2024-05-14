package financeiro.api.transacao.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "Account")
@Table(name = "account")

@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String account;
    private BigDecimal balance;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    public Account() {
    }

    public Account(UUID id, String account, BigDecimal balance, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.account = account;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
