-- Cria usu�rio URNA com senha URNA
CREATE USER URNA IDENTIFIED BY URNA;

-- Concede privil�gios de conex�o e cria��o ao usu�rio URNA.
GRANT CONNECT, RESOURCE TO URNA;