-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2016-10-18 17:18:52 BRST
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Candidato
  (
    IDCandidato    INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (75) NOT NULL ,
    NomePopular    VARCHAR2 (30) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    IDCidade       INTEGER NOT NULL ,
    RegistroTRE    VARCHAR2 (30) NOT NULL ,
    Partido        VARCHAR2 (5) NOT NULL ,
    Foto           VARCHAR2 (150) NOT NULL ,
    Numero         INTEGER NOT NULL ,
    Cargo          CHAR (1) NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT Candidato_PK PRIMARY KEY ( IDCandidato ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    Estado   CHAR (2) NOT NULL ,
    Nome     VARCHAR2 (35) NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT Cidade_PK PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor       INTEGER NOT NULL ,
    Nome            VARCHAR2 (75) NOT NULL ,
    TituloEleitoral VARCHAR2 (12) NOT NULL ,
    RG              VARCHAR2 (10) NOT NULL ,
    DataNascimento  DATE NOT NULL ,
    Zona            CHAR (3) NOT NULL ,
    Secao           CHAR (3) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_PK PRIMARY KEY ( IDEleitor ) ;


CREATE TABLE Voto
  (
    IDVoto      INTEGER NOT NULL ,
    IDEleitor   INTEGER NOT NULL ,
    IDCandidato INTEGER NOT NULL
  ) ;
ALTER TABLE Voto ADD CONSTRAINT Voto_PK PRIMARY KEY ( IDVoto ) ;
ALTER TABLE Voto ADD CONSTRAINT UK_Eleitor UNIQUE ( IDEleitor ) ;


ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Cidade FOREIGN KEY ( IDCidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Voto ADD CONSTRAINT FK_Voto_Candidato FOREIGN KEY ( IDCandidato ) REFERENCES Candidato ( IDCandidato ) ;

ALTER TABLE Voto ADD CONSTRAINT FK_Voto_Eleitor FOREIGN KEY ( IDEleitor ) REFERENCES Eleitor ( IDEleitor ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
