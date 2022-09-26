# Credsystem-Api
Aplicação para gerenciar clientes e cartões na credsystem.

## Recursos expostos

Recursos para cliente:

- **/GET** Clientes - Busca e lista todos os clientes
- **/GET** Cliente - Busca cliente por id e exibe
- **/POST** Clientes - Registra um novo cliente
- **/PUT** Cliente - Busca cliente por id e atualiza
- **/DELETE** Cliente - Deleta um cliente por id

Recursos para cartões:

- **/GET** Cartoes - Busca e lista todos os cartões
- **/GET** Cartao - Busca cartão por id e exibe
- **/POST** Cartoes - Gera um novo cartão para o cliente
- **/DELETE** Cartao - Cancela um cartão

Recursos para cartões:

- **/POST** Transacao - Registra transação do cartão (*Em desenvolvimento*)


## License

MIT License

## Alguns dos requisitos utilizados

- Spring Boot
- Spring MVC
- Maven
- Banco de dados H2
- Testes unitários com jUnit e Mockito
- REST
- JSON
- Swagger
- POO
- SOLID

## Você pode testar os recursos expostos:

- http://localhost:8081/swagger-ui.html

## Itens a desenvolver/evoluir

- Cobertura de testes (Atualmente em 20%)
- Segurança
- Nomenclatura
- Profiles
- Entre outros.