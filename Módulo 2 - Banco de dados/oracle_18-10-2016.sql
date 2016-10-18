-- Cria usuário URNA com senha URNA
CREATE USER URNA IDENTIFIED BY URNA;

-- Concede privilégios de conexão e criação ao usuário URNA.
GRANT CONNECT, RESOURCE TO URNA;