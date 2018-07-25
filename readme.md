# Sistema de Pagamento


## Tecnologias

- Java 8
- Spring Boot
- Maven
- Mysql 
- Docker

# Rodando localmente

Para rodar localmente, você pode executar o Docker Compose para subir 
o sistema como um todo: 

```
docker-compose up
``` 

Para o comando anterior funcionar, você precisa estar na mesma pasta que o arquivo `docker-compose.yml`
está. Caso queria apenas o arquivo para rodar o sistema, sem o código, pode cria-lo com o seguinte 
 conteudo:

```

version: "2"
services:
  api:
    image: mathbrandino/moiptest
    depends_on:
      - database
    ports:
      - 80:8080

    restart: on-failure

    environment:
      - DATABASE_NAME=moiptest
      - DATABASE_USER=root
      - DATABASE_PASSWORD=
      - DATABASE_HOST=database


  database:
    image: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=
      - MYSQL_ALLOW_EMPTY_PASSWORD=yes
      - MYSQL_DATABASE=moiptest
      - MYSQL_USER=root


```

## Acessando o sistema

### Clientes

Antes de efetuar algum pagamento é necessário ter um
 cliente previamente salvo.
 
 
 
 * Salvando um cliente :
 
    - Para salvar um cliente você precisa fazer uma requisição 
    do tipo `Post` para `/client/` com o seguinte conteúdo:
    
    ```
    {
      "name": "Qualquer Nome Aqui"
    }
    ```
    
 * Consultando um cliente :
 
    - Para consultar os dados de algum cliente basta fazer uma 
    requisição do tipo `Get` para `/client/{id}` substituindo `{id}`
    pelo id a ser buscado no banco.
    
    
### Pagamentos

Tendo algum cliente já salvo no banco, você pode enviar o
 pagamento para ser processado.


   * Enviando o pagamento:
   
        - Para enviar o pagamento você precisa fazer uma requisição
        do tipo `Post` para `/payment/` com o seguintes conteúdos:
        
        * Boleto
        
        ```
        
        {
          "client": {
            "id": 1
          },
          "buyer": {
            "name": "Nome",
            "cpf": "CPF Válido",
            "email": "Email Válido"
          },
          "payment": {
            "amount": 500.00,
            "type": "Boleto"
           
          }
        }
        
        ```
   
        * Cartão de crédito
        
        ```
        
       {
         "client": {
           "id": 1
         },
         "buyer": {
           "name": "Nome",
           "cpf": "CPF Válido",
           "email": "Email Válido"
         },
         "payment": {
           "amount": 500.00,
           "type": "CreditCard",
           "card": {	
             "name": "Nome",
             "expirationDate": "dd/MM/yyyy",
             "number": 123456789012,
             "cvv": 123
           }
         }
       }
        
        ```
        

### Consultando os pagamentos já realizados


Agora que os pagamentos já estão salvos, para visualizar o status 
de cada pagamento há uma página onde é possível analisar isso. 

Para ter acesso a essa página basta chamar o endpoint `/payment/` através do navegador.