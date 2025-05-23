CREATE TABLE eventos(
    id serial,
    nome varchar(25) NOT NULL,
    estado varchar(25),
    cidade varchar(25),
    rua varchar(25),
    cep varchar(25),
    primary key(id)
)