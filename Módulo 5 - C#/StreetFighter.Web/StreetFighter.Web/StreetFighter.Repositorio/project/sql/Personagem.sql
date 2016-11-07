Create table Personagem (
	Id					int				primary key,
	Nome				varchar(32)		not null,
	Nascimento			DateTime		not null,
	Altura				int				not null,
	Peso				decimal			not null,
	Origem				varchar(2)		not null,
	Imagem				varchar(256),
	GolpesEspeciais		varchar(256),
	PersonagemOculto	bit 
);

Create table Usuario (
	Usuario				varchar(32)		primary key,
	Senha				varchar()
);