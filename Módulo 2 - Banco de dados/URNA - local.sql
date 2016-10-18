CREATE TABLE MESARIO (
  IDMesario integer       not null,
  Nome      varchar2(30)  not null,
    constraint  PK_MESARIO  primary key (IDMesario)
);

CREATE SEQUENCE SEQ_MESARIO;

INSERT INTO Mesario (IDMesario, Nome)
VALUES  (SEQ_MESARIO.NEXTVAL, 'Pedro de Souza');

SELECT * FROM MESARIO;