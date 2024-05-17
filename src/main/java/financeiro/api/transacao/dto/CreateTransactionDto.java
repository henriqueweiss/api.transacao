package financeiro.api.transacao.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTransactionDto(
    @NotBlank String origin_account,
    @NotBlank String target_account,
    @NotNull @Digits(integer = 10, fraction = 2) BigDecimal value
    ) {
}
