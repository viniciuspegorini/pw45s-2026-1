# Aulas da disciplina: Tópicos Avançados Em Programação Para Web - PW45S-5SI (2026/1)

## Back-end 
### Softwares
	- JDK 25 ou superior
	- IDE:
		- ItelliJ IDEA
		- Spring Tools Suite	
		- Eclipe for JavaEE, etc...
	- SDBG:
		- Postgresql
	- Ferramenta para testar a API:
		- Postman
		- Insomnia
	- Git
	- Docker
	
## Front-end 
### Softwares
	- IDE:
		- Visual Studio Code (VSCode)
		- Web Storm, etc...
	- Git
	- Node.js
	- Docker

## Projetos:


### aula01
- Documentação da API REST com Open API 3.0 + versionamento do Banco de Dados com Flyway.

### aula02
- Adição de permissões de usuário. Criação de uma classe para representar as permissões de usuário e associação da mesma na entidade de usuário.

### aula03
- Autenticação e autorização com validações das permissões no lado cliente.

### aula04
- **Autenticação utilizando o Google - lado cliente**. Criação da conta no Google Cloud Console e uso das credenciais na aplicação cliente para autenticação (retorno do idToken pelo Google) e na aplicação servidor para validação do idToken.

### aula05
- **Autenticação utilizando o Google - lado servidor**. Criação da conta no Google Cloud Console e uso das credenciais na aplicação servidor para autenticação (retorno do idToken pelo Google).

### aula06
- Upload de arquivos com armazenamento em **Banco de dados** e em Disco no **Sistema de arquivos**.

### aula07
- Upload de arquivos com armazenamento em um **sistema de armazenamento de objetos** utilizando **MINIO** (sistema de armazenamento de objetos **semelhante ao Amazon S3**).

### aula08
- Admininstração das aplicações com Spring Boot Admin e Registros de Log.

### aula09
- Admininstração das aplicações com Spring Boot Admin e Registros de Log (OpenTelemetry).

### aula10
- Integração da API REST com APIs de processamento de Inteligência Artificial (IA).

### aula11
- Deploy de aplicações utilizando Docker.

### aula12
- Consultas na API com Spring Data JPA e Specification.


# Avaliações da disciplina:

## 1 - Seminário
### Escolha uma linguagem, plataforma e/ou framework para desenvolvimento Web (Java, PHP, Node.js, Perl, Ruby on Rails, .NET(C♯, VB), Python, etc.) ou Híbrido (Android, IOs):

- ALLAN VITOR PIRAN LEMES - Spark
- BEATRIZ MAROSTICA - Laravel
- EDUARDO MATEUS IMMIG - Hono
- EVERTON HIROYUKI MOREIRA NERES NAGAMINI - Nest.js
- GISELI SOUZA DE MATOS - Cypress
- GUILHERME BERNIERI - KMP
- GUSTAVO DOS SANTOS GUEDES - PHP + ?
- GUSTAVO MALAGE - Django
- HUMBERTO SABBI DE ALMEIDA - .Net Core (C#)
- JOAO PEDRO MASSMANN - Angular
- LUCAS MATHEUS DE CAMARGO - Go
- MATHEUS HENRIQUE DELLA VECHIA DE OLIVEIRA - Quarkus
- RICHARDSON SILVEIRA ROMIG - Node.js 
- VALBER SALES JUNIOR - Flutter

1. [Deverá ser entregue] Desenvolver uma apresentação (PPT, PDF ou Readme.MD no git) contendo uma breve apresentação do *framework*/biblioteca escolhida:
- As vantagens e desvantagens da linguagem, *framework* e/ou plataforma. 
- Citando as principais características. 
- Servidores Web disponíveis. 
- Configurações necessárias para rodar uma aplicação. 
- Tipo de licença de software. 
- Responsáveis pelo desenvolvimento (proprietário ou comunidade). 
- Suas conclusões sobre o uso do framework (facilidade para encontrar materiais, qualidade deses materiais; se é de fácil configuração, etc.)


2. [Deverá ser entregue] Deverá ser criado um tutorial de configuração do framework e criação de uma aplicação exemplo. No arquivo Readme.MD do git
	- A aplicação exemplo deve ser UM CRUD simples (não são necessários relacionamentos) para o cadastro de Pessoa ou qualquer outro tipo de entidade entidade (Pessoa, Livro, Produto, etc.).
		- pessoa: {nome, cpf, telefone, rua, numero, complemento, bairro, cep, cidade, estado}


3. O aluno deverá apresentar o trabalho e mostrar a aplicação/código-fonte da mesma (entre 15 e 30 minutos).

### 📆 Prazo de entrega:

#### 📌 Entrega com apresentação: 13/04/2026 e 14/04/2026 (Peso 0.30)



## 2 - Projeto final

### 🏪 Projeto final da disciplina - Área administrativa de uma aplicação de comércio eletrônico
No projeto final será desenvolvida a camada administrativa de um comércio eletrônico, na qual os pedidos realizados pelos clientes serão processados. Deverá ser desenvolvido um Cliente Web e uma API REST. 

O sistema deverá contar com diferentes perfis de usuário, que devem ter permissões distintas dentro da aplicação. Deve conter uma área para o gerenciamento dos usuários, em que apenas os usuários com perfil de ***administrador*** podem acessar e atribuir permissões nos novos usuários. Um usuário deverá realizar o próprio cadastro, mas deve permanecer como inativo no sistema até que um usuário com perfil ***administrador*** atribua uma permissão e ative esse usuário.

Após autenticado deverá ser exibido ao usuário autenticado uma tela no formato ***Painel Administrativo*** contendo alguns totalizadores como número de pedidos em cada situação.

Deverá existir uma tela para listagem de todos pedidos. Ainda sobre os pedidos, todo pedido realizado irá ter a situação *AGUARDANDO_PAGAMENTO*, por exemplo, mas poderá ter diferentes situações no processo, *PAGO*, *CANCELADO*, *EM_TRANSPORTE*, etc. (os pedidos poderão estar cadastrados diretamente no banco, via *script.sql*, será avaliado apenas a camada de administração do *e-commerce*).
Os usuários deverão poder visualizar e editar a situação dos pedidos. Ao atualizar o pedido que foi enviado para transporte deverá ser **Anexado** uma nota fiscal ao pedido, ou seja, deverá ser possível anexar um arquivo no formato .pdf ao pedido. Também poderão ser anexados comprovantes de documentos ou outros arquivos.
Sempre que a situação de um pedido seja alterada o cliente que efetuou o pedido deverá receber um e-mail com a atualização do Pedido.

1.  🗒️**Gerenciamento de pedidos**
    -   Listagem de pedidos com filtros (ex: por status, cliente, data).
    -   Alteração de **status** (ex: "Aguardando pagamento", "Pago", "Em transporte", "Concluído").
    -   Histórico de alterações de status (opcional, mas agrega valor).

2.  📎**Anexos em pedidos**
    -   Upload de documentos (ex: comprovante de pagamento, nota fiscal).
    -   Associação do anexo ao pedido.
    -   Possibilidade de visualizar ou baixar o anexo.

3.  📧**Envio de e-mail**
    -   Notificação para o cliente quando o status do pedido mudar.
    -   Notificação com documento anexado (opcional).
    -   Templates básicos (HTML simples ou texto).

4.  📈**Logs**
	-	Gerenciar a gravação de Log nas operações de atualização dos pedidos e envio de emails.

5. 🗒️**Documentação e Versionamento do Banco de dados**
    - Documentar a API utilizando Open API 3.x.
    - Realizar o versionamento do banco de dados.
   
### 📋Sugestões de arquitetura

-   💻***Fron-tend***: React + TypeScript.    
    -   Tela de cadastro.        
    -   Tela de autenticação.        
    -   Tela de Painel Administrativo.        
    -   Tela de gerenciamento de usuários.        
    -   Tela de listagem de pedidos.        
    -   Tela de detalhe do pedido (alterar status, anexar documentos, visualizar anexos).
        
-  📂 ***Back-end (API):*** Spring Boot.    
    -   Endpoints para CRUD de pedidos.        
    -   Endpoint de upload (salvar arquivos no MINIO, localmente ou em storage tipo AWS S3).        
    -   Serviço de envio de e-mail (Ex.: Spring Mail).

-  💾 **Banco de dados:** PostgreSQL, MySQL ou MongoDB.    
    -   Tabelas/coleções principais:        
        -   `usuarios` (admin)            
        -   `pedidos e pedidos_itens`            
        -   `documentos` (relacionados a pedidos)
        -  \*Existem as tabelas secundárias, como cadastro de produtos e categorias
        - \*Os clientes podem estar armazenados na mesma tabela de usuários com permissão diferente, ou podem estar em uma tabela de clientes.

### ➡️Alguns fluxos básicos

1.  Usuário autentica → vê painel administrativo.
2.  Usuário navega para o menu Pedidos → vê lista de pedidos.    
3.  Usuário abre pedido → altera status → *back-end* salva → dispara e-mail para cliente.
4.  Usuário anexa documento → *back-end* salva arquivo → associa ao pedido → opcionalmente envia notificação.

### 📆 Prazo de entrega:

#### 📌 Entrega com apresentação: 30/06/2026 (Peso 0.70)