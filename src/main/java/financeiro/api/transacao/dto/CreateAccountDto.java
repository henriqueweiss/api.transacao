package financeiro.api.transacao.dto;

import java.math.BigDecimal;

public record CreateAccountDto(String account, BigDecimal balance) {

    // VALIDAR FORMATOS

}
