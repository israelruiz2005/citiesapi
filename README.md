# Digital Innovation One

## Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção

Neste projeto foi desenvolvida uma API REST para a consulta de países, cidades e estados brasileiros, além de um *endpoint* para o cálculo de distância entre duas cidades. 

O projeto foi desenvolvido utilizando **Java** com **Spring Boot** e o banco de dados **PostgreSQL**, além do deploy na nuvem do Heroku.

---

### 📝 Instruções

Para executar o projeto são necessários os seguintes pré-requisitos:

- Java 11 ou versões superiores.
- Docker

1 — Crie o banco de dados *PostgreSQL* no **docker**, digitando seguinte comando no terminal:

```shell
docker run --name dio-cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

2 — Execute um dos comando abaixo para se conectar ao terminal do container **docker**, mapeando a pasta **fonte-sql** do projeto para a pasta **/tmp** do container:
-Importante!! - tem que se posicionar na pasta do **Projeto**

> Windows:
>
> ```shell
> docker run -it --rm --net=host -v %CD%\fonte-sql:/tmp postgres /bin/bash
> ```

> Linux:
>
> ```shell
> docker run -it --rm --net=host -v $PWD/fonte-sql:/tmp postgres /bin/bash
> ```

3 — Para popular a base de dados e ativar as extensões necessárias, execute todos os comandos abaixo:

```shell
psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

---
##Teoria

Você sabe o que é API? Essas três letras formam a sigla para Application Programming Interface, que pode ser traduzido como “Interface de Programação de Aplicações”.

As API são conjuntos de instruções e padrões de programação que servem para fornecer dados e informações relevantes de uma determinada aplicação.
Elas utilizam verbos para definir qual é a finalidade da requisição que está sendo enviada. Os verbos são:

**GET**: A requisição é um pedido de dados para a API. A API vai buscar os dados solicitados em algum banco e, provavelmente, vai retornar em formato JSON (formato de notação de objeto JavaScript);

**POST**: Tipo de requisição utilizada para criar um recurso em uma determinada API. São chamados de recursos o objeto que está sendo tratado naquela API.

**PUT**: Requisição utilizada para atualizar o recurso indicado com alguma informação.

**PATCH**: Requisição feita para atualização de somente uma parte de um recurso.

**DELETE**: Requisição para excluir um dado.

São acessadas por meio de Endpoints, que são as URLs nas quais são feitas as requisições. Cada requisição aos endpoints é composta por:

**O método HTTP**

**Cabeçalho requisição**,
- Que pode conter informações como dados de autenticação da API, dados de origem da requisição e formato do retorno.
  Embora o corpo da requisição e do retorno possam utilizar outros formatos, de modo geral é utilizado o formato JSON como padrão, tanto para o envio quanto para o retorno das requisições. Esse formato é escolhido, principalmente, por sua compatibilidade simples entre as linguagens e frameworks existentes, tanto de backend quanto de frontend.

##Endpoints no heroku

### ⚙ Endpoints - Deployed to Heroku


- [/countries](https://citiesapi-israel.heroku.com/api/v1/countries)
- [/states](https://citiesapi-israel.heroku.com/api/v1/states)
- [/cities](https://citiesapi-israel.heroku.com/api/v1/cities)


- [/distance/by-points - Distância entre pontos (milhas)](https://citiesapi-israel.herokuapp.com/api/v1/distance/by-points?from=616&to=318)
- [/distance/by-cube - Distância entre pontos (metros)](https://citiesapi-israel.herokuapp.com/api/v1/distance/by-cube?from=616&to=318)

---

### 📚 Referências
 
- [Java JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io/)
- [PostgreSQL](https://www.postgresql.org/)


- [Andre Gomes - Cities API GitHub](https://github.com/andrelugomes/digital-innovation-one/tree/master/cities-api)
- [SQL data files - chinnonsantos GitHub](https://github.com/chinnonsantos/sql-paises-estados-cidades)
