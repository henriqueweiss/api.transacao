package financeiro.api.transacao.dto;

import financeiro.api.transacao.models.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}
