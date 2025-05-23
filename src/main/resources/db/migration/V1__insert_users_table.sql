CREATE TABLE usuarios(
    id serial,
    cpf varchar(25),
    email varchar(25),
    nome varchar(25) NOT NULL,
    nascimento date,
    estado varchar(25),
    cidade varchar(25),
    rua varchar(25),
    cep varchar(25),
    primary key (id)
)