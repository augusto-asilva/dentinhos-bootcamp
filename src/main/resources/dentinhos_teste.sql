-- MySQL Workbench Forward Engineering

SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- create user
CREATE
USER IF NOT EXISTS 'dentinhos_dba'@'localhost' IDENTIFIED BY 'dentinhos123';

GRANT ALL
ON dentinhos.* TO 'dentinhos_dba'@'localhost';

-- -----------------------------------------------------
-- Schema dentinhos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dentinhos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dentinhos_teste` DEFAULT CHARACTER SET utf8;
USE
`dentinhos_teste` ;

-- -----------------------------------------------------
-- Table `dentinhos_teste`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`address`
(
    `id_address`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `street`
    VARCHAR
(
    45
) NULL,
    `district` VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `id_address`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos_teste`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`users`
(
    `id_user`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `password`
    VARCHAR
(
    45
) NULL,
    `user_status` VARCHAR
(
    45
) NULL,
    `name` VARCHAR
(
    45
) NULL,
    `last_name` VARCHAR
(
    45
) NULL,
    `dni` VARCHAR
(
    45
) NULL,
    `birth_date` DATE NULL,
    `phone` VARCHAR
(
    45
) NULL,
    `email` VARCHAR
(
    45
) NULL,
    `id_address` INT NOT NULL,
    PRIMARY KEY
(
    `id_user`,
    `id_address`
),
    INDEX `fk_users_address1_idx`
(
    `id_address` ASC
) VISIBLE,
    CONSTRAINT `fk_users_address1`
    FOREIGN KEY
(
    `id_address`
)
    REFERENCES `dentinhos_teste`.`address`
(
    `id_address`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos_teste`.`dentists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`dentists`
(
    `id_user`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code_mp`
    VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `id_user`
),
    INDEX `fk_dentists_users1_idx`
(
    `id_user` ASC
) VISIBLE,
    CONSTRAINT `fk_dentists_users1`
    FOREIGN KEY
(
    `id_user`
)
    REFERENCES `dentinhos_teste`.`users`
(
    `id_user`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos_teste`.`diaries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`diaries`
(
    `id_diary`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `start_time`
    DATETIME
    NULL,
    `ending_time`
    DATETIME
    NULL,
    `id_dentist`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `id_diary`
),
    INDEX `fk_diarys_dentists1_idx`
(
    `id_dentist` ASC
) VISIBLE,
    CONSTRAINT `fk_diarys_dentists1`
    FOREIGN KEY
(
    `id_dentist`
)
    REFERENCES `dentinhos_teste`.`dentists`
(
    `id_user`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos_teste`.`turn_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`turn_status`
(
    `id_turn_status`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `name`
    VARCHAR
(
    45
) NULL,
    `description` VARCHAR
(
    45
) NULL,
    PRIMARY KEY
(
    `id_turn_status`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dentinhos_teste`.`turns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentinhos_teste`.`turns`
(
    `id_turn`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `days`
    DATE
    NULL,
    `id_diary`
    INT
    NOT
    NULL,
    `id_turn_status`
    INT
    NOT
    NULL,
    `id_patient`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `id_turn`
),
    INDEX `fk_turns_diarys1_idx`
(
    `id_diary` ASC
) VISIBLE,
    INDEX `fk_turns_turn_status1_idx`
(
    `id_turn_status` ASC
) VISIBLE,
    INDEX `fk_turns_users1_idx`
(
    `id_patient` ASC
) VISIBLE,
    CONSTRAINT `fk_turns_diarys1`
    FOREIGN KEY
(
    `id_diary`
)
    REFERENCES `dentinhos_teste`.`diaries`
(
    `id_diary`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_turns_turn_status1`
    FOREIGN KEY
(
    `id_turn_status`
)
    REFERENCES `dentinhos_teste`.`turn_status`
(
    `id_turn_status`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_turns_users1`
    FOREIGN KEY
(
    `id_patient`
)
    REFERENCES `dentinhos_teste`.`users`
(
    `id_user`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
