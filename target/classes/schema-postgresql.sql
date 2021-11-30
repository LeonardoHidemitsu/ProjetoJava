CREATE TABLE if NOT EXISTS sugestao (
	id serial PRIMARY KEY,
	nome 		varchar(30),
	sinopse 	varchar(120)
);

CREATE TABLE if NOT EXISTS edit (
	id serial PRIMARY KEY,
	nome 		varchar(30),
	sinopse 	varchar(120)
);