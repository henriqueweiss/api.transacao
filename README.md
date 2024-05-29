Desenvolvemos um projeto backend voltado a criação de contas e transações financeiras, com suas respectivas validações. Neste projeto, criamos uma API utilizando a linguagem Java por meio do framework SpringBoot.<br>
<strong>
▶️Get /api/account<br> 
▶️Post /api/account<br>
▶️Put /api/account<br>
▶️Del /api/account<br>
▶️Post /api/transaction<br>
</strong>
Como camada de segurança, adicionamos uma autenticação via JWT, limitando o acesso a alguns endpoints.<br>
<strong>
▶️Post /users<br>
▶️Post /users/login<br>
</strong>

💡Para documentação, subimos um Swagger<br>
http://localhost:8080/swagger-ui/index.html#/<br>

💡Documentação seguida para criação do JWT<br>
https://medium.com/@felipeacelinoo/protegendo-sua-api-rest-com-spring-security-e-autenticando-usu%C3%A1rios-com-token-jwt-em-uma-aplica%C3%A7%C3%A3o-d70e5b0331f9

🆘Arquivo de configuração das rotas<br>
configuration/SecurityConfiguration