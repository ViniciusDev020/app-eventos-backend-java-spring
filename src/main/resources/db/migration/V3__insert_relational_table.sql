CREATE TABLE usuarios_eventos(
    usuario_id int NOT NULL,
    evento_id int NOT NULL,
    foreign key ( usuario_id) references usuarios(id),
    foreign key (evento_id) references eventos(id)
)