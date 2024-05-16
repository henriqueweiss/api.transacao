package financeiro.api.transacao.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Optional;

public record UpdateAccountDto(
        Optional<String> account,
        Optional<BigDecimal> balance) {
}
