<p align="right">
  <img src="https://img.shields.io/badge/Project completed-black?style=for-the-badge" alt="badge complete project">
</p>

# :ballot_box_with_check: Final Bootcamp Challenge

<br>

----------

<br>

## Table of contents

- [About the API](#about-the-api)
- [Skills](#skills)
- [What was developed](#what-was-developed)
- [Validations](#validations)
- [Testing](#testing)
- [Team Documentation](#team-documentation)
- [Individual Documentation](#individual-documentation)
- [How to access the project](#how-to-access-the-project)
- [Authors](#authors)
- [Portuguese Version](#portuguese-version)

<br>

-----------

<br>

## About the API
Development of a REST API for a Marketplace that already sells food products, but wants to be able to sell products that need refrigeration; called fresh products. It implies new challenges in how to store
transport and market the products, since it is done in a totally different way.

<details>
  <summary>The API was developed to:</summary>


- Be able to enter a batch of products in the distribution warehouse to record that existence in the stock.

- Have the necessary information to understand in which sector the goods should be stored so that they are in good condition while in the warehouse and to be able to show the employee who is going to look for the product (picking) where it is.

- To be able to detect if there are products that are about to expire in order to take some action about it (to be able to return them to the Salesman, throw them away or perform some specific commercial action to liquidate them).

- To be able to query the stock, list which products are in which warehouse, and given a specific product, also understand in which warehouse it is stored.

- To be able to register the purchase order so that the collaborators within Fullfilment
  can assemble the order(s) to ship them.
</details>

<br>


## Skills

Implement a REST API within the framework of the slogan and apply the content worked on during BOOTCAMP MELI (Git, Java, Spring, Testing, Database,
Quality and Security), which can be used from a proposal, requirements specification and attached documentation.

<details>
  <summary>MSC Architecture</summary>

- Structure the API according to good practices following the MSC architecture and some SOLID principles:
  - Entities: Responsible for modeling the entities.
  - Repository: This is the communication layer with the database.
  - Service: Layer where we manage the business rules.
  - Controller: Responsible for receiving the requests and sending the answers.
  - Advisor: Responsible for managing the application's exceptions.
  - DTO: Responsible for transporting data between different components of a system.
 
  </details>

<details>
  <summary>Technologies and Libraries</summary>

- The challenge was performed using Java 11 with Spring Boot, its validation annotations adding dependencies:
  - Spring Boot DevTools.
  - Spring Boot Web.
  - Spring Boot Validation.
  - Lombok.
  - JUnit.
  - Mockito.
  </details>

<br>

## What was developed
The routes implemented to contemplate these issues were:

- User stories are told from the **warehouse representative's** point of view based on their needs. Services are exposed from the **warehouse fullfilment**.
  - `/api/v1/fresh-products/inboundorder`: responsible for inserting the batch into the service warehouse to record the existence of stock.

- User stories are narrated from the point of view of the **buyer** based on
  their needs. The services are displayed from the **Marketplace** to be
  consumed by the buyer who requests them.
  - `/api/v1/fresh-products`: responsible for allowing the buyer to add the product to the shopping cart. Also in this route, we can query a product in stock in the warehouse to know its location in a sector and the different lots it is in.

- User stories are told from the **warehouse representative's** point of view based on their needs. Services are displayed from the **warehouse of care**.
  - `/api/v1/fresh-products/warehouse`: responsible for checking the location of a product in all warehouses to know the stock in each warehouse of that product.

- User stories are told from the point of view of the **warehouse representative** based on their needs. The services are exposed from the **warehouse of care**.
  - The user stories are told from the point of view of the **warehouse representative** based on his needs.

The routes used were designed to make the application more dynamic and functional for the target audience.

<br>

## Validations

Among Spring Boot's __validation__ annotations, which were used in the `Entities` layer of each entity, are:

- __NotBlank__, to validate that a String field cannot be empty;

- __NotNull__, to validate that a numeric field cannot be null;

- __Size__, to determine the minimum or maximum size of an Object or String;

- __DecimalMin__, to determine the minimum size of a number whose value is greater than or equal to that specified;

- __Email__, to determine if the email format is valid;

<br>

## Testing

Unit and integration testing was done using JUnit for the assertions and Mockito to do the Mocks.

The layers were tested, with at least 80% coverage of methods and lines, checking the consistency of the methods used for the development of the project.

<br>

## Team Documentation 
The tool chosen to document the API was Postman and JavaDoc for the project.

:warning: Access the Postman documentation [here](https://documenter.getpostman.com/view/23627905/2s8YmUKzJM).

<br> 

## Individual Documentation

### :small_red_triangle: Requiriment 6, Amanda Zotelli :small_red_triangle:

- The instruction for this requirement (individual and mandatory) was to create/add a new User Story to the Integrator Project, without the problem to be solved being specified by the Product Owner (PO).

- As an alternative to explore the different alternatives in the universe of the project proposal, I wanted to try to do something out of my comfort zone, taking the opportunity to practice new knowledge acquired in the Java Bootcamp, which was to __use ElasticSearch and Kibana to generate Charts with the data of the platform's buyers.__

- One of the important factors dealing with data these days, is to be able to use it to know your audience better and provide the best experiences, and if possible, in a sustainable way for the business.

- With these points in mind, my proposal was to feed the database, the Buyers table, in order to be as realistic as possible, and see what insights are possible to have by analyzing the data, which in practice could later be used to add value to the user and increase the perceived value of the platform.

- The routes implemented in this requirement were with the GET method, to retrieve different information from the Buyer Entity:

  - `/api/v6/buyers:` responsible for fetching all the buyers registered in the platform.

  - `/api/v6/buyers/profile/querytype=[buyerId]`: responsible for retrieving a buyer's profile. If it does not exist, it returns a 404 Not Found error.

  - `/api/v6/buyers/orders/list?querytype=[buyerId]`: responsible for retrieving all the purchases of a buyer. If the buyer does not exist, it returns a 404 Not Found Error. If there are no purchases, it returns a 204 No Content status.

- The integration tests involving the Buyer Entity were done, the Service and Controller methods show 100% coverage.

<br>

◽ After cloning and running the project (according to the step-by-step below ⬇️), go to http://localhost:8080/swagger-ui.html#/ to view the Swagger documentation.

◽ Go to Postman's documentation with the routes from the Individual requirement [here](https://documenter.getpostman.com/view/23644142/2s8YsnWw4T).

◽ Graphics and DER [here](https://github.com/amdzotelli/desafio_integrador/tree/feature/amanda/ml-get-buyer-data/src/main/resources/images)

<br>

## How to access the project
:warning: Access the challenge repository [here](https://github.com/wave7-grupo3/desafio_integrador)

Open the terminal and type the information in the sequence:
- Perform the project clone:
  - SSH: `git clone git@github.com:wave7-grupo3/desafio_integrador.git`
  - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_integrador.git`

- Have the environment configured to view java projects.
- Generate JavaDocs documentation:
  - On the top bar of the IntelliJ IDE, select the `Tools` tab;
  - Then select `generate JavaDoc`;


Translated with www.DeepL.com/Translator (free version)

<br>

## Authors
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Rosalia Padoin](https://github.com/rosalia-oliveira)


<br>

-------------

<br>

# Portuguese Version

<br>


## Sumário

- [Sobre a API](#sobre-a-api)
- [Habilidades](#habilidades)
- [O que foi desenvolvido](#o-que-foi-desenvolvido)
- [Validações](#validações)
- [Testes](#testes)
- [Documentação da API](#documentação-da-api)
- [Documentação Individual](#documentação-individual)
- [Como acessar o projeto](#como-acessar-o-projeto)
- [Autores](#autores)

<br>

-------------

<br>

## Sobre a API
Desenvolvimento de uma API REST para um Marketplace que já vende produtos alimentícios, mas quer poder vender produtos que precisam de refrigeração; chamados produtos frescos. Implica novos desafios na forma de armazenar,
transportar e comercializar os produtos, uma vez que é feito de uma forma totalmente diferente.

<details>
  <summary>A API foi desenvolvida para:</summary>

- Ser capaz de inserir um lote de produtos no armazém de distribuição para registrar essa existência no estoque.

- Ter as informações necessárias para entender em que setor deve ser armazenada a mercadoria para que fique em bom estado enquanto estiver no almoxarifado e para que se possa mostrar ao colaborador que vai procurar o produto (picking) onde está.

- Ser capaz de detectar se há produtos que estão prestes a expirar para tomar alguma medida a esse respeito (poder devolvê-los ao Vendedor, jogá-los fora ou realizar alguma ação comercial específica para liquidá-los).

- Para poder consultar o estoque, listar quais produtos estão em qual armazém e dado um produto específico, entender também em qual armazém ele está armazenado.

- Poder cadastrar o pedido de compra para que os colaboradores dentro do Fullfilment
possam montar o (s) pedido (s) para despachá-los.

</details>

<br>

## Habilidades

Implementa uma API REST no âmbito do slogan e aplicar os conteúdos trabalhados durante o BOOTCAMP MELI (Git, Java, Spring, Testes, Banco de Dados,
Qualidade e Segurança), que podem ser usados a partir de uma proposta, especificação de requisitos e documentação anexa.

<details>
  <summary>Arquitetura MSC</summary>
  
- Estruturar a API conforme as boas práticas seguindo a arquitetura MSC e alguns princípios do SOLID:
    - Entities: Reponsável por modelar as entidades.
    - Repository: É a camada de comunicação com o banco de dados.
    - Service: Camada onde gerenciamos as regras de négocio.
    - Controller: Responsável por receber as requisições e enviar as respostas.
    - Advisor: Responsável por gerenciar as exceções da aplicação.
    - DTO: Responsável pelo transporte de dados entre diferentes componentes de um sistema.
    
    </details>

<details>
  <summary>Tecnologias e Bibliotecas</summary>
  
- O desafio foi realizado utilizando Java 11 com Spring Boot, suas anotações de validação somando as dependências:
    - Spring Boot DevTools.
    - Spring Boot Web.
    - Spring Boot Validation.
    - Lombok.
    - JUnit.
    - Mockito.
    
    </details>
    
    <br>

## O que foi desenvolvido 
As rotas implementadas para contemplar estas questões foram:

- As histórias do usuário são contadas do ponto de vista do **representante do armazém** com base em suas necessidades. Os serviços são expostos a partir do **armazém de fullfilment**. 
  - `/api/v1/fresh-products/inboundorder`: responsável por inserir o lote no armazém do atendimento, para registrar a existência de estoque.

- As histórias de usuários são narradas do ponto de vista do **comprador** com base em
  suas necessidades. Os serviços são expostos a partir do **Marketplace** para serem
  consumidos pelo comprador que os solicita.
  - `/api/v1/fresh-products`: responsável por permitir ao comprador que adicione o produto ao carrinho de compras. Ainda nesta rota, podemos consultar um produto em estoque no armazém para saber a sua localização em um setor e os diferentes lotes onde se encontra.

- As histórias do usuário são contadas do ponto de vista do **representante do warehouse** com base em suas necessidades. Os serviços são expostos a partir do **armazém de atendimento**.
  - `/api/v1/fresh-products/warehouse`: responsável por verificar a localização de um produto em todos os armazéns para saber o estoque em cada armazém do referido produto.

- As histórias do usuário são contadas do ponto de vista do **representante do warehouse** com base em suas necessidades. Os serviços são expostos a partir do **armazém de atendimento**.
  - `/api/v1/fresh-products/due-date/`: responssável por consultar os produtos em estoque que estáo próximos a data de vencimento no almoxarifado, a fim de aplicar alguma ação comercial com eles.

_As rotas utilizadas foram idealizadas para deixar a aplicação mais dinâmica e funcional para o público alvo._

<br>

## Validações

Entre as anotações de __validação__ do Spring Boot, que foram utilizadas na camada `Entities` de cada entidade, estão:

- __NotBlank__, para validar que um campo de String não pode estar vazio;

- __NotNull__, para validar um campo numérico que não pode estar nulo;

- __Size__, para determinar o tamanho mínimo ou máximo de um Objeto ou String;

- __DecimalMin__, para determinar o tamanho mínimo de um número cujo valor seja maior ou igual ao especificado;

- __Email__, para determinar se o formato do e-mail é válido;


<br>

## Testes

Os testes de unidades e de integração foram feitos utilizando o JUnit para as assertions e Mockito para fazer os Mocks.

As camadas foram testadas, com cobertura de miníma de 80% de métodos e linhas, verificando a consistência dos métodos utilizados para o desenvolvimento do projeto.

<br>

## Documentação da API
A ferramenta escolhida para documentar a API foi o Postman e JavaDoc para o projeto.

:warning: Acesse a documentação do Postman [aqui](https://documenter.getpostman.com/view/23627905/2s8YmUKzJM).

<br>

## Documentação Individual 

### :small_red_triangle: Requisito 6, Amanda Zotelli :small_red_triangle:

- A instrução para esse requisito (individual e obrigatório) consistiu em criar/adicionar uma nova User Story ao Projeto
Integrador, sem que o problema a ser resolvido fosse especificado pelo Product Owner (PO).

- Como alternativa para explorar as diferentes alternativas no universo da proposta do projeto, quis tentar fazer algo fora da minha zona de conforto, aproveitando para praticar novos conhecimentos adquiridos no Bootcamp de Java, que foi __utilizar o ElasticSearch e Kibana para gerar Gráficos com os dados dos compradores da plataforma__. 

- Um dos importantes fatores lidando com dados nos tempos atuais, é poder utilizá-los para conhecer melhor o seu público e proporcionar as melhores experiências, e se possível, de forma sustentável para o negócio. 

- Com esses pontos em mente, a minha proposta foi de alimentar o banco de dados, a tabela de Compradores (Buyers), de modo a ficar o mais realista possível, e ver quais insights são possíveis de se ter analisando os dados, o que na prática posteriormente poderia ser utilizado para agregar valor para o usuário e aumentar o valor percebido da plataforma.

- As rotas implementadas nesse requisito foram com o método GET, para resgatar diferentes informações da Entidade Comprador:

  - `/api/v6/buyers`: responsável por trazer todos os compradores registrados na plataforma.
  
  - `/api/v6/buyers/profile/querytype=[buyerId]`: responsável por trazer o perfil de um comprador. Caso não exista, retorna um Erro 404 Not Found.
  
  - `/api/v6/buyers/orders/list?querytype=[buyerId]`: responsável por trazer todas as compras de um comprador. Caso o comprador não exista, retorna um Erro 404 Not Found. Caso não existam compras, retorna um Status 204 No Content.
  
- Foram feitos os testes de integração envolvendo a Entidade Comprador (Buyer), os métodos de Service e Controller apontam cobertura de 100%. 
  
<br>

:white_medium_small_square: Após clonar e rodar o projeto (de acordo com o passo a passo aqui embaixo :arrow_down:), acesse `http://localhost:8080/swagger-ui.html#/` para visualizar a documentação do Swagger.

<br>

:white_medium_small_square: Acesse a Documentação com as rotas do requisito Individual do Postman [aqui](https://documenter.getpostman.com/view/23644142/2s8YsnWw4T).

<br>

:white_medium_small_square: Gráficos e DER [aqui](https://github.com/amdzotelli/desafio_integrador/tree/feature/amanda/ml-get-buyer-data/src/main/resources/images)

<br>

## Como acessar o projeto
:warning: Acessar o repositório do desafio [aqui](https://github.com/wave7-grupo3/desafio_integrador)

Abrir o terminal e digitar as informações na sequência:
- Realizar o clone do projeto:
    - SSH: `git clone git@github.com:wave7-grupo3/desafio_integrador.git`
    - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_integrador.git`

- Ter o ambiente configurado para vizualização de projetos java.
- Gerar a documentação do JavaDocs:
    - Na barra superior da IDE IntelliJ, selecionar a aba `Tools`;
    - Em seguida, selecionar `generate JavaDoc`;
    

<br>

## Autores
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Rosalia Padoin](https://github.com/rosalia-oliveira)


