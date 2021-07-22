-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dentinhos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dentinhos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dentinhos` DEFAULT CHARACTER SET utf8 ;
USE `dentinhos` ;

-- -----------------------------------------------------
-- Table `dentinhos`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`address` (
  `id_address` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  PRIMARY KEY (`id_address`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NULL,
  `user_status` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `id_address` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_address`),
  INDEX `fk_users_address1_idx` (`id_address` ASC) VISIBLE,
  CONSTRAINT `fk_users_address1`
    FOREIGN KEY (`id_address`)
    REFERENCES `dentinhos`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos`.`dentists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`dentists` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `code_mp` VARCHAR(45) NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_dentists_users1_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_dentists_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `dentinhos`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos`.`diaries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`diaries` (
  `id_diary` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NULL,
  `ending_time` DATETIME NULL,
  `id_dentist` INT NOT NULL,
  PRIMARY KEY (`id_diary`),
  INDEX `fk_diarys_dentists1_idx` (`id_dentist` ASC) VISIBLE,
  CONSTRAINT `fk_diarys_dentists1`
    FOREIGN KEY (`id_dentist`)
    REFERENCES `dentinhos`.`dentists` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos`.`turn_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`turn_status` (
  `id_turn_status` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_turn_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos`.`turns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos`.`turns` (
  `id_turn` INT NOT NULL AUTO_INCREMENT,
  `days` DATE NULL,
  `id_diary` INT NOT NULL,
  `id_turn_status` INT NOT NULL,
  `id_patient` INT NOT NULL,
  PRIMARY KEY (`id_turn`),
  INDEX `fk_turns_diarys1_idx` (`id_diary` ASC) VISIBLE,
  INDEX `fk_turns_turn_status1_idx` (`id_turn_status` ASC) VISIBLE,
  INDEX `fk_turns_users1_idx` (`id_patient` ASC) VISIBLE,
  CONSTRAINT `fk_turns_diarys1`
    FOREIGN KEY (`id_diary`)
    REFERENCES `dentinhos`.`diaries` (`id_diary`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turns_turn_status1`
    FOREIGN KEY (`id_turn_status`)
    REFERENCES `dentinhos`.`turn_status` (`id_turn_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turns_users1`
    FOREIGN KEY (`id_patient`)
    REFERENCES `dentinhos`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
