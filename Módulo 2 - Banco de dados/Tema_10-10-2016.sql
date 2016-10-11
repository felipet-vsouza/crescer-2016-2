-- 1)
Select *
Into CidadeAux
From Cidade;

-- 2)
Truncate table CidadeAux;
Insert into CidadeAux 
Select *
From Cidade;

-- 3)
Create table Produtos 
(
    ID            int               not null,
    Nome_curto    varchar(30)       not null,
    Nome_descr    varchar(100)      not null,
    Data_criacao  datetime          not null,
    Local_estoque varchar(50)       not null,
    Quantidade    int               not null,
    Preco         float             not null
);

-- 4)
Insert into Produtos(ID, Nome_curto, Nome_descr, Data_criacao, Local_estoque, Quantidade, Preco) 
values (1, 'Tênis All-Star Preto Clássico', 'Tênis All-Star Preto Clássico com Exterior em Lona e Interior Emborrachado', convert(datetime, '2016/10/10', 111), 'Expedição', 514, 119.20);

Insert into Produtos(ID, Nome_curto, Nome_descr, Data_criacao, Local_estoque, Quantidade, Preco) 
values (1, 'GPU Geforce GTX 1060 6 GB', 'Placa de Vídeo Galax EXOC Geforce GTX 1060 6 GB', convert(datetime, '2016/10/06', 111), 'Estoque S01', 1, 1388.99);

Select * From Produtos;
Select * From CidadeAux;