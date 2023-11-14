CREATE TABLE IF NOT EXISTS tb_endereco (
  codigo INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(9) NOT NULL,
  logradouro VARCHAR(100) NULL,
  numero VARCHAR(12) NULL,
  bairro VARCHAR(45) NULL,
  municipio VARCHAR(45) NULL,
  estado VARCHAR(45) NULL,
  tb_pessoa_codigo INT NOT NULL,
  PRIMARY KEY (codigo, tb_pessoa_codigo),
  INDEX fk_tb_endereco_tb_pessoa1_idx (tb_pessoa_codigo ASC) VISIBLE,
  CONSTRAINT fk_tb_endereco_tb_pessoa1
    FOREIGN KEY (tb_pessoa_codigo)
    REFERENCES tb_pessoa (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);