Essa api foi construída com a ideia de cadastrar eventos e usuários e relacionar o evento específico ao usuário cadastrado.
 A api foi desenvolvida utilizando Java + Spring Boot, e Postgresql como banco de dados.

O projeto está organizado em camadas: 
 - controller (para lidar com as requisições HTTP),
 - domain > entities (para representar as entidades Usuario e Evento e referenciar a respectiva tabela),
 - dto (representa os atributos necessários para cadastrar usuarios e eventos),
 - repository (Repositório JPA).

 Foi utilizado Spring Data JPA para persistência de dados.
 O conceito de entidade para representar as tabelas Usuário e Evento, respectivamente.

 Para configurar a api, é necessário criar um banco de dados pelo pgAdmin, criar um usuário e senha, e, posteriormente,
 criar um arquivo env.properties (na pasta raiz do projeto) com as variáveis de ambiente disponíveis no arquivo env-example.properties, as variáveis de ambiente
 são o endereço localhost aonde irá rodar o banco, usuário e senha.

 Ao rodar a aplicação Spring, as migrations irão subir as tabelas no banco de forma automática, e, os eventos serão populados de acordo com o seed de eventos.
 
