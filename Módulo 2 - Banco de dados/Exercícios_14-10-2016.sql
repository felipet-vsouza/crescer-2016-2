-- 1) Liste o total de pedidos realizados no m�s de setembro de 2016.
Select	p.IDPedido, c.Nome as Cliente, p.DataPedido, p.DataEntrega, p.ValorPedido, p.Situacao
From	Pedido p
	Inner join Cliente c on p.IDCliente = c.IDCliente
Where	p.DataPedido	between		convert(datetime, '01/09/2016', 103)
						and			convert(datetime, '30/09/2016', 103)
Order by	p.DataPedido;

-- 2) Liste quais os produtos que utilizam o material de IDMaterial = 15836.
Select	p.Nome, p.PrecoCusto, p.PrecoVenda
From	ProdutoMaterial pm
	Inner join	Produto p on p.IDProduto = pm.IDProduto
Where	pm.IDMaterial = 15836;

-- 3) Liste todos os clientes que tenham o LTDA no nome ou razao social.
Select	IDCliente, Nome, RazaoSocial
From	Cliente
Where	Nome like '%LTDA%' or RazaoSocial like '%LTDA%';

-- 4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--    Nome: Galocha Maragato
--    Pre�o de custo: 35.67
--    Pre�o de venda: 77.95
--    Situa��o: AInsert into	Produto			(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)Values		('Galocha Maragato', GetDate(), 35.67, 77.95, 'A');-- 5) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de
--    dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--    Obs.: o produto criado anteriormente dever� ser listado (apenas este)Select	p.Nome, p.IDProdutoFrom	Produto pWhere	p.IDProduto not in	(		Select	pit.IDProduto		From	PedidoItem pit	);-- 6) Identifique qual o estado (coluna UF da tabela Cidade) possui o maior n�mero de clientes (tabela Cliente), liste
--    tamb�m qual o Estado possui o menor n�mero de clientes.
Select * From		
		(Select		top 1 count(1) as MaximoClientesUF, cid.UF as UFMaisClientes
		From		Cliente cli
		Inner Join	Cidade cid	on	cli.IDCidade = cid.IDCidade
		Group by	cid.UF
		Order by	count(1) desc) a
Cross Join
		(Select		top 1 count(1) as MinimoClientesUF, cid.UF as UFMenosClientes
		From		Cliente cli
		Inner Join	Cidade cid	on	cli.IDCidade = cid.IDCidade
		Group by	cid.UF
		Order by	count(1) asc) b;

-- 7) Alguns materiais est�o em falta no estoque, com isso alguns pedidos sofrer�o atraso na entrega. Abaixo mais
--    informa��es:
--    a. A lista de materiais que est�o em falta, s�o os seguintes:
--    IDMaterial	Descricao
--    14650			Frente de caixa #14650
--    15703			Sistema de rastreabilidade #15703
--    15836			Intranet #15836
--    16003			Controle de permiss�es #16003
--    16604			Frente de caixa #16604
--    17226			Frente de caixa #17226--    b. Liste os pedidos com produtos que precisam destes materiais, considere somente os pedidos que ser�o
--		 entregues em outubro de 2016.
--		 i. Campos que devem ser exibidos: IDPedido, DataEntrega, ValorPedido, Quantidade de itensSelect	ped.IDPedido, ped.DataEntrega, ped.ValorPedido, pit.QuantidadeFrom	Pedido ped	Inner Join	PedidoItem pit on	pit.IDPedido = ped.IDPedido	Inner Join	Produto	prod on		prod.IDProduto = pit.IDProdutoWhere prod.IDProduto in	(	Select	p.IDProduto 	From	Produto p		Inner Join	ProdutoMaterial pm on p.IDProduto = pm.IDProduto	Where	pm.IDMaterial = 14650 or
			pm.IDMaterial = 15703 or
			pm.IDMaterial = 15836 or
			pm.IDMaterial = 16003 or
			pm.IDMaterial = 16604 or
			pm.IDMaterial = 17226
	);

-- c. Liste tamb�m os clientes destes pedidos, pois estes ser�o notificados pela �rea respons�vel.
Select	cli.Nome, cli.RazaoSocial
From	Cliente cli
	Inner Join Pedido ped on	ped.IDCliente = cli.IDCliente
Where	ped.IDPedido in
	(
	Select	ped.IDPedido	From	Pedido ped		Inner Join	PedidoItem pit on	pit.IDPedido = ped.IDPedido		Inner Join	Produto	prod on		prod.IDProduto = pit.IDProduto	Where prod.IDProduto in		(		Select	p.IDProduto 		From	Produto p			Inner Join	ProdutoMaterial pm on p.IDProduto = pm.IDProduto		Where	pm.IDMaterial = 14650 or
				pm.IDMaterial = 15703 or
				pm.IDMaterial = 15836 or
				pm.IDMaterial = 16003 or
				pm.IDMaterial = 16604 or
				pm.IDMaterial = 17226
		)
	);

-- 8) Dentro da atual estrutura, cada produto � composto por 1 ou v�rios materiais (tabela ProdutoMaterial).
--    Identifique se existe algum produto sem material relacionado.
--    Obs.: o produto criado anteriormente dever� ser listado.
Select	prod.Nome, prod.DataCadastro, prod.Situacao
From	Produto prod
Where	prod.IDProduto not in
	(
	Select	pm.IDProduto
	From	ProdutoMaterial pm
	);

-- 9) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
Select		top 1 Case charIndex(' ', cli.Nome, 0)
				when 0 then cli.Nome
				else substring(cli.Nome, 1, charIndex(' ', cli.Nome, 0))
			end as PrimeiroNome, 
			count(1) as Ocorrencias
From		Cliente cli
Group by	Case charIndex(' ', cli.Nome, 0)
				when 0 then cli.Nome
				else substring(cli.Nome, 1, charIndex(' ', cli.Nome, 0))
			end
Order by	count(1) desc;

-- 10) Atualize a situa��o na tabela de Produto, considere as seguintes condi��es:
--		Valor	Condi��o
--		F		Produtos que est�o com materiais em falta no estoque conforme a lista na tabela 7.a
--		Q		Produtos que n�o est�o em falta, por�m que est�o sem pedidos nos �ltimos 2 meses.
--		A		Todos os demais registros.
Begin transaction
Update	Produto
Set		Situacao = Case
				When IDProduto in 
					(
					Select	p.IDProduto 					From	Produto p						Inner Join	ProdutoMaterial pm on p.IDProduto = pm.IDProduto					Where	pm.IDMaterial = 14650 or
							pm.IDMaterial = 15703 or
							pm.IDMaterial = 15836 or
							pm.IDMaterial = 16003 or
							pm.IDMaterial = 16604 or
							pm.IDMaterial = 17226
					) then 'F'
				When IDProduto not in
					(
					Select	p.IDProduto 					From	Produto p						Inner Join	ProdutoMaterial pm on p.IDProduto = pm.IDProduto					Where	pm.IDMaterial = 14650 or
							pm.IDMaterial = 15703 or
							pm.IDMaterial = 15836 or
							pm.IDMaterial = 16003 or
							pm.IDMaterial = 16604 or
							pm.IDMaterial = 17226
					) 
					and IDProduto not in
					(
						Select	pit.IDProduto
						From	PedidoItem pit
							Inner Join	Pedido ped on ped.IDPedido = pit.IDPedido
						Where	ped.DataPedido between getDate() and dateAdd(month, -2, getDate())
					) then 'Q'
				Else 'A'
			End;