# Locadora de Veículos

Este é um projeto de exemplo de uma aplicação Spring Boot 3.3 que simula o funcionamento de uma locadora de veículos. A aplicação fornece uma API RESTful para gerenciar veículos, clientes e reservas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3**
- **Spring Data JPA**
- **H2 Database** (Banco de dados em memória para testes)
- **Springdoc OpenAPI** (Integração com Swagger para documentação da API)
- **Maven** (Gestão de dependências e build)

## Funcionalidades

- **Gerenciamento de Veículos**: Cadastro, listagem, atualização e remoção de veículos.
- **Gerenciamento de Clientes**: Cadastro, listagem, atualização e remoção de clientes.
- **Gerenciamento de Reservas**: Criação, consulta e cancelamento de reservas de veículos.

## Como Executar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/DevTrail-Squad-8/DevTrail-Locadora.git
   cd locadora-veiculos
    ```
   
2. **Execute a aplicação**:

   ```bash
   mvn spring-boot:run
   ```

3. **Acesse a documentação da API**: 

   Acesse a documentação da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).