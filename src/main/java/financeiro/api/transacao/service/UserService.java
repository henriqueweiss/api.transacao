package financeiro.api.transacao.service;
import financeiro.api.transacao.configuration.SecurityConfiguration;
import financeiro.api.transacao.dto.CreateUserDto;
import financeiro.api.transacao.dto.LoginUserDto;
import financeiro.api.transacao.dto.RecoveryJwtTokenDto;
import financeiro.api.transacao.models.Role;
import financeiro.api.transacao.models.RoleName;
import financeiro.api.transacao.models.User;
import financeiro.api.transacao.models.UserDetailsImpl;
import financeiro.api.transacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    // Método responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    // Método responsável por criar um usuário
    public void createUser(CreateUserDto createUserDto) {

        Role role = new Role(createUserDto.role());

        User newUser = new User(
                createUserDto.email(),
                securityConfiguration.passwordEncoder().encode(createUserDto.password()),
                List.of(role)
        );

        userRepository.save(newUser);
    }
}
