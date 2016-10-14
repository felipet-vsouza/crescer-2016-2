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
From			Empregado
Group by		Cargo
Having		count(1) = (	Select			Top(1) count(1)
							From			Empregado
							Group by		Cargo
							Order by		count(1) desc
						);

-- 3) Liste a quantidade de cidades agrupando por UF - quantas cidades cada estado possui?
Select		UF, count(Nome) as CidadesPorUF
From			Cidade
Group by		UF;

-- 4) Liste as cidades que possuem o mesmo nome e UF - cidades duplicadas
Select		distinct a.UF, a.Nome
From		Cidade a
Where	(
			Select		count(1)
			From			Cidade b
			Group by		Nome, UF
			Having		b.nome = a.nome
		) > 1;

-- 5) Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado (maior + 1)
Insert into Associado 
    (IDAssociado, 
    Nome, 
    DataNascimento, 
	Sexo)
Select max(IDAssociado) + 1, 'Felipe Thomas Vargas de Souza', convert(datetime, '02/06/1997', 103), 'M' 
From Associado;

-- 6) Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda
Select	NomeEmpregado, 
		Salario, 
		case 
			when salario <= 1164	then	0
			when salario <= 2326	then	15
			else							27.5 
		end as PercentualDescontoIRPF 
From Empregado;

-- 7) Liste o nome do empregado, o nome do gerente e o departamento de cada um.
Select	emp.NomeEmpregado,
		ger.NomeEmpregado as NomeGerente,
		empd.NomeDepartamento as DepartamentoEmpregado,
		gerd.NomeDepartamento as DepartamentoGerente
From	Empregado emp
	Left Join Empregado ger on emp.IDGerente = ger.IDEmpregado
	Left Join Departamento empd on emp.IDDepartamento = empd.IDDepartamento
	Left Join Departamento gerd on ger.IDDepartamento = gerd.IDDepartamento;

-- 8) Faça uma cópia da tabela Empregado e altere o salário de todos os empregados 
--    (Empregado) cujo departamento fique na localidade de SAO PAULO, faça um 
--    reajuste de 14,5%.
Select *
Into EmpregadoCopia
From Empregado;
Update emp
	Set	emp.Salario	=	emp.Salario + (emp.Salario / 100) * 14.5
From EmpregadoCopia emp
	Inner Join Departamento empd on emp.IDDepartamento = empd.IDDepartamento
Where empd.Localizacao = 'SAO PAULO';
-- Consulta
Select c.NomeEmpregado as NomeEmpregado, c.Salario as SalarioCopiaEmpregado,
		e.Salario as SalarioOriginal 
From EmpregadoCopia c
	Inner join Empregado e on e.IDEmpregado = c.IDEmpregado;

-- 9) Liste a diferença que representará o reajuste aplicado no item anterior
--    no somatório dos salários de todos os empregados.
Select	sum(o.Salario) as TotalSalarioAnterior, sum(c.Salario) as TotalSalarioPosterior,
		sum(c.Salario) - sum(o.Salario) as Diferenca
From	Empregado o
	Inner Join EmpregadoCopia c on o.IDEmpregado = c.IDEmpregado;

-- 10) Liste o departamento com o empregado de maior salário.
Select	dep.NomeDepartamento, emp.NomeEmpregado, emp.Salario
From	Empregado emp
	Inner join	Departamento dep on emp.IDDepartamento = dep.IDDepartamento
Where	emp.Salario in	(
						Select	top(1) max(Salario)
						From	Empregado
						Where	0 <> isnull(IDDepartamento, 0)
						);