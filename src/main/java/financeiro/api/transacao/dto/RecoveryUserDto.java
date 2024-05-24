package financeiro.api.transacao.dto;

import financeiro.api.transacao.models.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}
