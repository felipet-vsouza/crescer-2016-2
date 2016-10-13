-- 1) Listar empregados admitidos entre 01/05/1980 e 20/01/1982. 
--    Exibir também o total de meses de trabalho até a data de 31/12/2000.
Select		NomeEmpregado, 
			DataAdmissao, 
			datediff(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as TotalMesesTrabalho
From		Empregado
Where		DataAdmissao >= convert(datetime, '01/05/1980', 103) and
			DataAdmissao <= convert(datetime, '20/01/1982', 103);

-- 2) Qual o cargo da tabela Empregado que tem mais empregados?
Select		Cargo, count(1) as EmpregadosPorCargo
From		Empregado
Group by	Cargo
Having		count(1) = (	Select		Top(1) count(1)
							From		Empregado
							Group by	Cargo
							Order by	count(1) desc
						);

-- 3) Liste a quantidade de cidades agrupando por UF - quantas cidades cada estado possui?
Select		UF, count(Nome) as CidadesPorUF
From		Cidade
Group by	UF;

-- 4) Liste as cidades que possuem o mesmo nome e UF - cidades duplicadas
Select		distinct a.UF, a.Nome
From		Cidade a
Where	(
			Select		count(1)
			From		Cidade b
			Group by	Nome, UF
			Having b.nome = a.nome
		) > 1;

-- 5) 