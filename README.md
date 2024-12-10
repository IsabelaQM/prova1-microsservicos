# Prova Prática

Primeira prova da disciplina de Projeto Microsserviços e NoSQL, do curso de Tecnologia em Sistemas para Internet (IFTM).

Objetivo: Desenvolvimento de serviços para Usuários, Produtos e Shopping para no final do curso integrá-los formando um mini ecommerce.

Obs.: As datas adotadas nos projetos seguem o padrão internacional ISO-8601, que é yyyy-MM-dd. Isso significa que as datas devem ser fornecidas no formato "ano-mês-dia". 

## Tecnologias e Ferramentas

- Java
- Lombok
- MongoDB
- Spring Boot

## Endpoints e URLS

O projeto contou com a implementação dos seguintes endpoints, que foram testados a partir da extensão Thunder Client do Visual Studio Code

## User API (/user)

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
 
 ## Product API
 
  <h3>Category (/category)</h3>

  - POST category - http://localhost:8080/category
    + Exemplo do corpo da requisição em formato JSON:<br>
      {
      "name": "Celulares"
      }

  - GET all categories - http://localhost:8080/category

  - GET pageable - Exemplo: http://localhost:8080/category/pageable?page=0&size=5
 
  - PUT category - http://localhost:8080/category/{id}
    + Exemplo do corpo da requisição em formato JSON:<br>
      {
      "name": "Smartphones"
      }
      
  - DELETE category by id - http://localhost:8080/category/{id}
 
   <h3>Product (/product)</h3>

   - POST - http://localhost:8080/product
     Exemplo do corpo da requisição em formato JSON:
      {
        "name": "O homem que calculava",
        "description": "Um livro clássico",
        "price": 40.0,
        "categoryId": "674fb474da5d9241614a9882"
      }
     
  - GET all products - http://localhost:8080/product
       
  - GET findById - http://localhost:8080/product/{id}

  - PUT product - http://localhost:8080/product/{id}
     Exemplo do corpo da requisição em formato JSON:<br>
      {
        "name": "Smartphone Iphone 15",
        "description": "Aparelho celular do modelo 15",
        "productIdentifier": "iphone-15",
        "price": 7000.0,
        "categoryId": "674fb474da5d9241614a9882"
      }

  - DELETE product by id - http://localhost:8080/product/{id}

  - GET pageable - Exemplo: http://localhost:8080/product/pageable?page=0&size=5
    
  - GET by category Id - http://localhost:8080/product/category/{categoryId}

  - GET by product Identifier - http://localhost:8080/product/productIdentifier/{productIdentifier}
    
 
 ## Shopping API (/shopping)

  - POST - http://localhost:8080/shopping
    + Exemplo do corpo da requisição em formato JSON:<br>
        {
       "userIdentifier": "user1",
  "items": [{"productIdentifier": "a1","price": 100.0},{"productIdentifier": "iphone-15","price": 7000.0}]}

  - GET all shoppings - http://localhost:8080/shopping
       
  - GET findById - http://localhost:8080/shopping/{id}
    
  - GET shop by user - http://localhost:8080/shopping/shopByUser/{userIdentifier}

  - GET shop by date - http://localhost:8080/shopping/shopByDate/{date}
 
  - GET by product Identifier - http://localhost:8080/shopping/productIdentifier/{productIdentifier}
    
  - GET search by date and minimum value - http://localhost:8080/shopping/search?startDate={startDate}&endDate={endDate}&minimumValue={minimunValue}
    <p> Exemplo: http://localhost:8080/shopping/search?startDate=2024-01-01&endDate=2024-12-31&minimumValue=1000</p>

  - GET report - http://localhost:8080/shopping/search?startDate={startDate}&endDate={endDate}
     <p> Exemplo: http://localhost:8080/shopping/search?startDate=2024-01-01&endDate=2024-12-05</p>
    
