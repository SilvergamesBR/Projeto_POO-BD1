-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`Unidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Unidade` (
  `idUnidade` INT NOT NULL,
  `Localizacao` VARCHAR(45) NOT NULL,
  `Taxa` TINYINT NOT NULL,
  PRIMARY KEY (`idUnidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Cliente` (
  `CPF` VARCHAR(20) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Genero` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`CPF`, `Senha`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`Cliente_has_Unidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Cliente_has_Unidade` (
  `Cliente_CPF` VARCHAR(20) NOT NULL,
  `Unidade_idUnidade` INT NOT NULL,
  PRIMARY KEY (`Cliente_CPF`, `Unidade_idUnidade`),
  INDEX `fk_Cliente_has_Unidade_Unidade1_idx` (`Unidade_idUnidade` ASC) VISIBLE,
  INDEX `fk_Cliente_has_Unidade_Cliente1_idx` (`Cliente_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_Unidade_Cliente1`
    FOREIGN KEY (`Cliente_CPF`)
    REFERENCES `projeto`.`Cliente` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Cliente_has_Unidade_Unidade1`
    FOREIGN KEY (`Unidade_idUnidade`)
    REFERENCES `projeto`.`Unidade` (`idUnidade`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Produto` (
  `CodigoProduto` INT NOT NULL,
  `Unidade_idUnidade` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Valor` FLOAT NOT NULL,
  `Descricao` VARCHAR(120) NULL,
  `Quantidade` INT NOT NULL,
  PRIMARY KEY (`CodigoProduto`, `Unidade_idUnidade`),
  INDEX `fk_Produto_Unidade1_idx` (`Unidade_idUnidade` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_Unidade1`
    FOREIGN KEY (`Unidade_idUnidade`)
    REFERENCES `projeto`.`Unidade` (`idUnidade`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`SAC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`SAC` (
  `Unidade_idUnidade` INT NOT NULL,
  `IdSAC` INT NOT NULL,
  `Telefone` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Unidade_idUnidade`, `IdSAC`),
  CONSTRAINT `fk_SAC_Unidade1`
    FOREIGN KEY (`Unidade_idUnidade`)
    REFERENCES `projeto`.`Unidade` (`idUnidade`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

#populando as tabelas

insert into Unidade(idUnidade,Localizacao,Taxa) values (1,'Sao Paulo,SP',true);
insert into Unidade(idUnidade,Localizacao,Taxa) values (2,'Pouso Alegre,MG',true);
insert into Unidade(idUnidade,Localizacao,Taxa) values (3,'Rio de Janeiro,RJ',false);
insert into Unidade(idUnidade,Localizacao,Taxa) values (4,'Juiz de Fora,MG',false);


insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Descricao,Quantidade) values (1,1,'Mouse gamer',400,'Mouse Logitech G403 Hero',50);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Quantidade) values (2,1,'Monitor tubao',135,10);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Descricao,Quantidade) values (3,2,'Monitor gamer',1200,'Monitor 1080p 144Hz com luzinha',20);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Quantidade) values (4,2,'Mouse da hello kitty',10,400);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Descricao,Quantidade) values (5,3,'Fone de gatinho',1000,'Fone da Razer com orelinhas de gatinho, para ajudar vc a ganhar skinzinha no lolzinho',15);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Quantidade) values (6,3,'Teclado mecanico barulhento',500,40);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Descricao,Quantidade) values (7,4,'Luzinha RGB',10,'Luzinhas para deixar seu quarto gamer bem colorido',250);
insert into Produto(CodigoProduto,Unidade_idUnidade,Nome,Valor,Descricao,Quantidade) values (8,4,'PC da casas bahia',2600,'Seu netinho vai adorar esse presente de natal com um intel pentium de ultima geracao e incriveis 2 gb de memoria DDR2',50);


insert into SAC(Unidade_idUnidade,IdSAC,Telefone,Email) values (1,1,'(11) 1111-1111','SACSP@lojasluardo.com');
insert into SAC(Unidade_idUnidade,IdSAC,Telefone,Email) values (2,2,'(35) 3535-3535','SACPA@lojasluardo.com');
insert into SAC(Unidade_idUnidade,IdSAC,Telefone,Email) values (3,3,'(21) 2121-2121','SACRJ@lojasluardo.com');
insert into SAC(Unidade_idUnidade,IdSAC,Telefone,Email) values (4,4,'(32) 3232-3232','SACSP@lojasluardo.com');




