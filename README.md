# Prova Prática

Primeira prova da disciplina de Projeto Microsserviços e NoSQL, do curso de Tecnologia em Sistemas para Internet (IFTM).

Objetivo: Desenvolvimento de serviços para Usuários, Produtos e Shopping para no final do curso integrá-los formando um mini ecommerce.

## Tecnologias e Ferramentas

- Java
- Lombok
- MongoDB
- Spring Boot

## Endpoints e URLS

O projeto contou com a implementação dos seguintes endpoints, que foram testados a partir da extensão Thunder Client do Visual Studio Code

- USER-API (/user)

  - POST - http://localhost:8080/user
    + Exemplo do corpo da requisição em formato JSON:<br>
        {
      "nome": "Maria",
      "cpf": 11122233311,
      "endereco": "Rua Blanche Galassi 160",
      "email": "maria@gmail.com",
      "telefone": "1234-3434"
      }

  - GET all users - http://localhost:8080/user
       
  - GET findById - http://localhost:8080/user/{id}
    
  - GET findByCpf - http://localhost:8080/user/cpf/{cpf}

  - GET searchByName - http://localhost:8080/user/search?nome={nome}

  - GET pageable - Exemplo: http://localhost:8080/user/pageable?page=0&size=5
 
  - PUT user - http://localhost:8080/user/{id}
    + Exemplo do corpo da requisição em formato JSON:<br>
        {
      "endereco": "Rua das Margaridas 1000",
      "email": "maria@outlook.com",
      "telefone": "11987654311"
      }
      
  - DELETE user by id - http://localhost:8080/user/{id}
    
