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

Select * from Personagem Where Nome like '%%%'

Insert into Personagem(Id, Nome, Nascimento, Altura, Peso, Origem, Imagem, GolpesEspeciais, PersonagemOculto)
Values (1, 'Felpera', convert(datetime, '02/06/1997'), 167, 62, 'BR', 'https://www.royalcanin.com/~/media/Royal-Canin/Product-Categories/cat-adult-landing-hero.ashx', 'Muitos golpes especiais pra citar', 1);

Create table Usuario (
	Usuario				varchar(32)		primary key,
	Senha				varchar()
);