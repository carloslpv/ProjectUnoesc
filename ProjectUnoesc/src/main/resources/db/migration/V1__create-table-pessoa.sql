CREATE TABLE IF NOT EXISTS tb_pessoa (
  codigo INT NOT NULL,
  nome VARCHAR(100) NULL,
  cpf INT NULL,
  dataNascimento DATETIME NULL,
  sexo VARCHAR(12) NULL,
  PRIMARY KEY (codigo));