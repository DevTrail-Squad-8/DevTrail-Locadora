# Locadora de Veículos

Este é um projeto de exemplo de uma aplicação Spring Boot 3.3 que simula o funcionamento de uma locadora de veículos. A aplicação fornece uma API REST para gerenciar veículos, clientes e reservas.

## Requisitos
- **Java 21**
- **MYSQL**
- **SGBD PARA MYSQL**




## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3**
- **Spring Data JPA**
- **H2 Database** (Banco de dados em memória para testes)
- **MYSQL**
- **Springdoc OpenAPI** (Integração com Swagger para documentação da API)
- **Maven** (Gestão de dependências e build)
- **Dozer Mapper**

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
## Acesse o banco de dados MYSQL: 

NOME DO BANCO DE DADOS: locadoradb   

User Name: (nome do seu banco de dados)

Senha: (sua senha do banco de dados)


## Diagrama de Classes
![Main](https://github.com/user-attachments/assets/4a3d38b1-5611-45fd-8fda-548c6ba71fd3)


## TESTES PARA POPULAR BANCO DE DADOS

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
**CRIAR APOLICES**
http://localhost:8080/api/apolices
```bash
{
  "valorFranquia": 100,
  "protecaoTerceiro": true,
  "protecaoCausasNaturais": true,
  "protecaoRoubo": true
}
```
**CRIAR ALUGUEIS**
http://localhost:8080/api/alugueis
```bash
{
  "dataEntrega": "2024-01-15",
  "dataDevolucao": "2024-01-20",
  "valorTotal": 0,
  "motorista_id": 2,
  "apolicesSeguro_id": 2,
  "carros_id": [
    2
  ]
}
```
## COMPONENTES

<table style="width:100%">
  <tr align=center>
    <th><strong>Davi Guabiraba</strong></th>
    <th><strong>Erick Truzzi</strong></th>
    <th><strong>Gustavo Silva</strong></th>
    <th><strong>Rafael Dias</strong></th>
    <th><strong>Ricardo Andretta</strong></th>
    <th><strong>Thiago Sales</strong></th>

  </tr>
  <tr align=center>
    <td>
      <a href="https://github.com/DGuabiraba">
        <img src="https://avatars.githubusercontent.com/u/81264511?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/Truzzi1">
        <img src="https://avatars.githubusercontent.com/u/114123981?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/GustavoSilvalgs">
        <img src="https://avatars.githubusercontent.com/u/111322525?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/rafael-bit">
        <img src="https://avatars.githubusercontent.com/u/67400064?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/RickIX">
        <img src="https://avatars.githubusercontent.com/u/118491601?v=4">
      </a>
           </td>
    <td>
       <a href="https://github.com/txiami">
        <img src="https://avatars.githubusercontent.com/u/86448522?v=4">
      </a>
    </td>
  </tr>
</table>


##
