Create table Personagem (
	Id					int				primary key identity,
	Nome				varchar(32)		not null,
	Nascimento			DateTime		not null,
	Altura				int				not null,
	Peso				decimal			not null,
	Origem				varchar(2)		not null,
	Imagem				varchar(256),
	GolpesEspeciais		varchar(256),
	PersonagemOculto		bit 
);

Select * from Personagem Where Nome like '%%%'

Create table Usuario (
	Username				varchar(32)		primary key,
	Senha				varchar(32)		not null,
	Permissoes			varchar(256)		not null
);

Insert into Usuario (Username, Senha, Permissoes)
Values ('felipe.souza', '8622f73326f2aad4ac3292cc37fc7895', 'admin;');

Select * From Usuario;