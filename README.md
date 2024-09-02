# Locadora de Veículos

Este é um projeto de exemplo de uma aplicação Spring Boot 3.3 que simula o funcionamento de uma locadora de veículos. A aplicação fornece uma API REST para gerenciar veículos, clientes e reservas.

## Tecnologias Utilizadas

- **Java 21**
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

## Acesse a documentação da API: 

   Acesse a documentação da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
## Acesse o banco de dados H2: 

   Acesse o banco de dados H2 em [http://localhost:8080/database](http://localhost:8080/database).# 
   JDBC URL: jdbc:h2:mem:testdb
   User Name: sa
   **OBS: NÃO TEM SENHA**

## Diagrama de Classes
![Main](https://github.com/user-attachments/assets/4a3d38b1-5611-45fd-8fda-548c6ba71fd3)


## ORDEM PARA USO DOS ENDPOINTS (EXEMPLOS)

**CRIAR FABRICANTE**
http://localhost:8080/api/fabricantes
```bash
{
  "nome": "FORD"
}
```
**CRIAR MODELO**
http://localhost:8080/api/modelos-carros
```bash
{
  "descricao": "KA",
  "categoria": "HATCH_COMPACTO",
  "fabricante_id": 1
}
```
**CRIAR ACESSORIOS**
http://localhost:8080/api/acessorios
```bash
{
    "id": 1,
    "descricao": "AR-CONDICIONADO",
    "carros": null
}
```
**CRIAR CARRO**
http://localhost:8080/api/carros
```bash
{
  "placa": "ABC-1010",
  "chassi": "4363463463",
  "cor": "PRETO",
  "valorDiaria": 69,
  "acessorios_id": [
    1
  ],
  "modeloCarro_id": 1,
  "imagem": "URL-IMAGE"
}
```

**CRIAR MOTORISTA**
http://localhost:8080/api/motoristas
```bash
{
  "nome": "Thiago",
  "dataDeNascimento": "10/10/2000",
  "cpf": "0990999912",
  "email": "stringemail@email.com",
  "sexo": "MASCULINO",
  "numeroCNH": "078912366"
}
```



