CREATE TABLE IF NOT EXISTS tb_contato (
  codigo INT NOT NULL AUTO_INCREMENT,
  telefone VARCHAR(15) NULL,
  email VARCHAR(100) NULL,
  tb_pessoa_codigo INT NOT NULL,
  PRIMARY KEY (codigo, tb_pessoa_codigo),
  INDEX fk_tb_contato_tb_pessoa_idx (tb_pessoa_codigo ASC) VISIBLE,
  CONSTRAINT fk_tb_contato_tb_pessoa
    FOREIGN KEY (tb_pessoa_codigo)
    REFERENCES tb_pessoa (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);