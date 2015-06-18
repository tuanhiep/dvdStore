SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `dvdstore` ;
CREATE SCHEMA IF NOT EXISTS `dvdstore` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `dvdstore` ;

-- -----------------------------------------------------
-- Table `dvdstore`.`realisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`realisateur` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`realisateur` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  `compagny` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'maintains realisater of the DVD details\n';


-- -----------------------------------------------------
-- Table `dvdstore`.`auteur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`auteur` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`auteur` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  `compagny` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'maintains author details\n';


-- -----------------------------------------------------
-- Table `dvdstore`.`fournisseur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`fournisseur` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`fournisseur` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `entreprise` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dvdstore`.`dvd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`dvd` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`dvd` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `price` DECIMAL(5,2) NOT NULL ,
  `description` TINYTEXT NULL ,
  `last_release` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `realisateur_id` INT NOT NULL ,
  `auteur_id` INT UNSIGNED NOT NULL ,
  `quantitystock` INT NOT NULL ,
  `fournisseur_id` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_dvd_realisateur1_idx` (`realisateur_id` ASC) ,
  INDEX `fk_dvd_auteur1_idx` (`auteur_id` ASC) ,
  INDEX `fk_dvd_fournisseur1_idx` (`fournisseur_id` ASC) ,
  CONSTRAINT `fk_dvd_realisateur1`
    FOREIGN KEY (`realisateur_id` )
    REFERENCES `dvdstore`.`realisateur` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dvd_auteur1`
    FOREIGN KEY (`auteur_id` )
    REFERENCES `dvdstore`.`auteur` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dvd_fournisseur1`
    FOREIGN KEY (`fournisseur_id` )
    REFERENCES `dvdstore`.`fournisseur` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'maintains dvd details';


-- -----------------------------------------------------
-- Table `dvdstore`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`client` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`client` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `address` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `cc_number` VARCHAR(19) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dvdstore`.`commande`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`commande` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`commande` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `amount` DECIMAL(6,2) NULL ,
  `client_id` INT UNSIGNED NOT NULL ,
  `confirmation_number` INT UNSIGNED NOT NULL ,
  `state` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_commande_client1_idx` (`client_id` ASC) ,
  CONSTRAINT `fk_commande_client1`
    FOREIGN KEY (`client_id` )
    REFERENCES `dvdstore`.`client` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'maintains command details\n';


-- -----------------------------------------------------
-- Table `dvdstore`.`dvd_commande`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`dvd_commande` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`dvd_commande` (
  `commande_id` INT UNSIGNED NOT NULL ,
  `dvd_id` INT UNSIGNED NOT NULL ,
  `quantity` INT NOT NULL ,
  PRIMARY KEY (`commande_id`, `dvd_id`) ,
  INDEX `fk_commande_has_dvd_dvd1_idx` (`dvd_id` ASC) ,
  INDEX `fk_commande_has_dvd_commande1_idx` (`commande_id` ASC) ,
  CONSTRAINT `fk_commande_has_dvd_commande1`
    FOREIGN KEY (`commande_id` )
    REFERENCES `dvdstore`.`commande` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commande_has_dvd_dvd1`
    FOREIGN KEY (`dvd_id` )
    REFERENCES `dvdstore`.`dvd` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dvdstore`.`sous_commande`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dvdstore`.`sous_commande` ;

CREATE  TABLE IF NOT EXISTS `dvdstore`.`sous_commande` (
  `commande_id` INT UNSIGNED NOT NULL ,
  `fournisseur_id` INT UNSIGNED NOT NULL ,
  `dvd_id` INT UNSIGNED NOT NULL ,
  `missingquanty` INT NOT NULL ,
  PRIMARY KEY (`commande_id`, `fournisseur_id`, `dvd_id`) ,
  INDEX `fk_sous_commande_fournisseur1_idx` (`fournisseur_id` ASC) ,
  INDEX `fk_sous_commande_dvd1_idx` (`dvd_id` ASC) ,
  CONSTRAINT `fk_sous_commande_commande1`
    FOREIGN KEY (`commande_id` )
    REFERENCES `dvdstore`.`commande` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sous_commande_fournisseur1`
    FOREIGN KEY (`fournisseur_id` )
    REFERENCES `dvdstore`.`fournisseur` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sous_commande_dvd1`
    FOREIGN KEY (`dvd_id` )
    REFERENCES `dvdstore`.`dvd` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `dvdstore` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
