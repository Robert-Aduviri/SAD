-- MySQL Script generated by MySQL Workbench
-- 05/24/15 19:47:18
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema inf226g1
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `inf226g1` ;

-- -----------------------------------------------------
-- Schema inf226g1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inf226g1` DEFAULT CHARACTER SET utf8 ;
USE `inf226g1` ;

-- -----------------------------------------------------
-- Table `inf226g1`.`accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`accion` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`accion` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`condicion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`condicion` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`condicion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`almacen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`almacen` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`almacen` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `capacidad` INT(11) NULL DEFAULT NULL,
  `area` INT(11) NULL DEFAULT NULL,
  `fecha_registro` DATETIME NULL DEFAULT NULL,
  `estado` VARCHAR(20) NULL DEFAULT NULL,
  `ubic_libres` INT(11) NULL DEFAULT NULL,
  `id_tipo_almacen` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Almacen_Tipo_Almacen_idx` (`id_tipo_almacen` ASC),
  CONSTRAINT `fk_Almacen_Tipo_Almacen`
    FOREIGN KEY (`id_tipo_almacen`)
    REFERENCES `inf226g1`.`condicion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`cliente` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL DEFAULT NULL,
  `ruc` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`tipo_unidad_transporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`tipo_unidad_transporte` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`tipo_unidad_transporte` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `id_condicion` INT(11) NOT NULL,
  `capacidad_pallets` INT NULL,
  `velocidad_promedio` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Tipo_Unidad_Transporte_Condicion1_idx` (`id_condicion` ASC),
  CONSTRAINT `fk_Tipo_Unidad_Transporte_Condicion1`
    FOREIGN KEY (`id_condicion`)
    REFERENCES `inf226g1`.`condicion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`unidad_transporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`unidad_transporte` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`unidad_transporte` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `transportista` VARCHAR(60) NULL DEFAULT NULL,
  `placa` VARCHAR(6) NULL DEFAULT NULL,
  `id_tipo_unidad_transporte` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Unidad_Transporte_Tipo_Unidad_Transporte1_idx` (`id_tipo_unidad_transporte` ASC),
  CONSTRAINT `fk_Unidad_Transporte_Tipo_Unidad_Transporte1`
    FOREIGN KEY (`id_tipo_unidad_transporte`)
    REFERENCES `inf226g1`.`tipo_unidad_transporte` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`despacho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`despacho` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`despacho` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_unidad_transporte` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Despacho_Unidad_Transporte1_idx` (`id_unidad_transporte` ASC),
  CONSTRAINT `fk_Despacho_Unidad_Transporte1`
    FOREIGN KEY (`id_unidad_transporte`)
    REFERENCES `inf226g1`.`unidad_transporte` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`local`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`local` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`local` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `latitud` DOUBLE NULL DEFAULT NULL,
  `longitud` DOUBLE NULL DEFAULT NULL,
  `nombre` VARCHAR(60) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `direccion` VARCHAR(200) NULL DEFAULT NULL,
  `id_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Local_Cliente1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_Local_Cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `inf226g1`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`pedido` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`pedido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_local` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Local1_idx` (`id_local` ASC),
  CONSTRAINT `fk_Pedido_Local1`
    FOREIGN KEY (`id_local`)
    REFERENCES `inf226g1`.`local` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`pedido_parcial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`pedido_parcial` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`pedido_parcial` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_despacho` INT(11) NULL DEFAULT NULL,
  `id_pedido` INT(11) NOT NULL,
  `id_guia_remision` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Parcial_Despacho1_idx` (`id_despacho` ASC),
  INDEX `fk_Pedido_Parcial_Pedido1_idx` (`id_pedido` ASC),
  INDEX `fk_Pedido_Parcial_Guia_Remision1_idx` (`id_guia_remision` ASC),
  CONSTRAINT `fk_Pedido_Parcial_Despacho1`
    FOREIGN KEY (`id_despacho`)
    REFERENCES `inf226g1`.`despacho` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Parcial_Guia_Remision1`
    FOREIGN KEY (`id_guia_remision`)
    REFERENCES `inf226g1`.`guia_remision` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Parcial_Pedido1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `inf226g1`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`guia_remision`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`guia_remision` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`guia_remision` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_despacho` INT(11) NOT NULL,
  `id_pedido_parcial` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Guia_Remision_Despacho1_idx` (`id_despacho` ASC),
  INDEX `fk_Guia_Remision_Pedido_Parcial1_idx` (`id_pedido_parcial` ASC),
  CONSTRAINT `fk_Guia_Remision_Despacho1`
    FOREIGN KEY (`id_despacho`)
    REFERENCES `inf226g1`.`despacho` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Guia_Remision_Pedido_Parcial1`
    FOREIGN KEY (`id_pedido_parcial`)
    REFERENCES `inf226g1`.`pedido_parcial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`rack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`rack` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`rack` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `num_fil` INT(11) NULL DEFAULT NULL,
  `num_col` INT(11) NULL DEFAULT NULL,
  `estado` VARCHAR(20) NULL DEFAULT NULL,
  `fecha_registro` DATETIME NULL DEFAULT NULL,
  `id_almacen` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Rack_Almacen1_idx` (`id_almacen` ASC),
  CONSTRAINT `fk_Rack_Almacen1`
    FOREIGN KEY (`id_almacen`)
    REFERENCES `inf226g1`.`almacen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`ubicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`ubicacion` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`ubicacion` (
  `id` INT(11) NOT NULL,
  `fila` INT(11) NULL DEFAULT NULL,
  `columna` INT(11) NULL DEFAULT NULL,
  `lado` VARCHAR(1) NULL DEFAULT NULL,
  `id_rack` INT(11) NOT NULL,
  `estado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Ubicacion_Rack1_idx` (`id_rack` ASC),
  CONSTRAINT `fk_Ubicacion_Rack1`
    FOREIGN KEY (`id_rack`)
    REFERENCES `inf226g1`.`rack` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`pallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`pallet` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`pallet` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ean128` VARCHAR(128) NULL DEFAULT NULL,
  `id_ubicacion` INT(11) NOT NULL,
  `id_tipo_pallet` INT(11) NOT NULL,
  `fecha_registro` DATETIME NULL DEFAULT NULL,
  `id_despacho` INT(11) NOT NULL,
  `fecha_vencimiento` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pallet_Ubicacion1_idx` (`id_ubicacion` ASC),
  INDEX `fk_Pallet_Despacho1_idx` (`id_despacho` ASC),
  CONSTRAINT `fk_Pallet_Despacho1`
    FOREIGN KEY (`id_despacho`)
    REFERENCES `inf226g1`.`despacho` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pallet_Ubicacion1`
    FOREIGN KEY (`id_ubicacion`)
    REFERENCES `inf226g1`.`ubicacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`historial_movimientos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`historial_movimientos` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`historial_movimientos` (
  `id_pallet` INT(11) NOT NULL,
  `id_almacen_in` INT(11) NOT NULL,
  `id_almacen_out` INT(11) NOT NULL,
  PRIMARY KEY (`id_pallet`, `id_almacen_in`, `id_almacen_out`),
  INDEX `fk_Pallet_has_Almacen_Almacen1_idx` (`id_almacen_in` ASC),
  INDEX `fk_Pallet_has_Almacen_Pallet1_idx` (`id_pallet` ASC),
  INDEX `fk_Pallet_has_Almacen_Almacen2_idx` (`id_almacen_out` ASC),
  CONSTRAINT `fk_Pallet_has_Almacen_Almacen1`
    FOREIGN KEY (`id_almacen_in`)
    REFERENCES `inf226g1`.`almacen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pallet_has_Almacen_Almacen2`
    FOREIGN KEY (`id_almacen_out`)
    REFERENCES `inf226g1`.`almacen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pallet_has_Almacen_Pallet1`
    FOREIGN KEY (`id_pallet`)
    REFERENCES `inf226g1`.`pallet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`producto` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `stock_total` INT(11) NULL DEFAULT NULL,
  `cantidad_unidades` INT(11) NULL DEFAULT NULL,
  `id_condicion` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Producto_Condicion1_idx` (`id_condicion` ASC),
  CONSTRAINT `fk_Producto_Condicion1`
    FOREIGN KEY (`id_condicion`)
    REFERENCES `inf226g1`.`condicion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`item_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`item_producto` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`item_producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ean13` VARCHAR(13) NULL DEFAULT NULL,
  `id_pallet` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad_en_pallet` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Item_Producto_Pallet1_idx` (`id_pallet` ASC),
  INDEX `fk_Item_Producto_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Item_Producto_Pallet1`
    FOREIGN KEY (`id_pallet`)
    REFERENCES `inf226g1`.`pallet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Producto_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `inf226g1`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`kardex`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`kardex` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`kardex` (
  `id_producto` INT(11) NOT NULL,
  `id_almacen` INT(11) NOT NULL,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `fecha` DATETIME NULL DEFAULT NULL,
  `tipo_movimiento` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_producto`, `id_almacen`),
  INDEX `fk_Producto_has_Almacen_Almacen1_idx` (`id_almacen` ASC),
  INDEX `fk_Producto_has_Almacen_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Producto_has_Almacen_Almacen1`
    FOREIGN KEY (`id_almacen`)
    REFERENCES `inf226g1`.`almacen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Almacen_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `inf226g1`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`orden_internamiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`orden_internamiento` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`orden_internamiento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`pedido_parcial_x_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`pedido_parcial_x_producto` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`pedido_parcial_x_producto` (
  `id_pedido_parcial` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad_pallets` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido_parcial`, `id_producto`),
  INDEX `fk_Pedido_Parcial_has_Producto_Producto1_idx` (`id_producto` ASC),
  INDEX `fk_Pedido_Parcial_has_Producto_Pedido_Parcial1_idx` (`id_pedido_parcial` ASC),
  CONSTRAINT `fk_Pedido_Parcial_has_Producto_Pedido_Parcial1`
    FOREIGN KEY (`id_pedido_parcial`)
    REFERENCES `inf226g1`.`pedido_parcial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Parcial_has_Producto_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `inf226g1`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`perfil` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`perfil` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_perfil` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`perfil_x_accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`perfil_x_accion` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`perfil_x_accion` (
  `id_perfil` INT(11) NOT NULL,
  `id_accion` INT(11) NOT NULL,
  PRIMARY KEY (`id_perfil`, `id_accion`),
  INDEX `fk_Perfil_has_Accion_Accion1_idx` (`id_accion` ASC),
  INDEX `fk_Perfil_has_Accion_Perfil1_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_Perfil_has_Accion_Accion1`
    FOREIGN KEY (`id_accion`)
    REFERENCES `inf226g1`.`accion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Perfil_has_Accion_Perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `inf226g1`.`perfil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`pregunta_secreta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`pregunta_secreta` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`pregunta_secreta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pregunta` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`usuario` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`usuario` (
  `id` CHAR(40) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido_paterno` VARCHAR(50) NULL DEFAULT NULL,
  `apellido_materno` VARCHAR(50) NULL DEFAULT NULL,
  `respuesta` VARCHAR(45) NULL DEFAULT NULL,
  `id_perfil` INT(11) NULL,
  `id_pregunta_secreta` INT(11) NULL DEFAULT NULL,
  `estado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Perfil1_idx` (`id_perfil` ASC),
  INDEX `fk_Usuario_Pregunta_Secreta1_idx` (`id_pregunta_secreta` ASC),
  CONSTRAINT `fk_Usuario_Perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `inf226g1`.`perfil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Pregunta_Secreta1`
    FOREIGN KEY (`id_pregunta_secreta`)
    REFERENCES `inf226g1`.`pregunta_secreta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `inf226g1`.`orden_internamiento_x_item_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inf226g1`.`orden_internamiento_x_item_producto` ;

CREATE TABLE IF NOT EXISTS `inf226g1`.`orden_internamiento_x_item_producto` (
  `orden_internamiento_id` INT(11) NOT NULL,
  `item_producto_id` INT(11) NOT NULL,
  `cantidad` INT NULL,
  `cantidad_ingresada` INT NULL,
  PRIMARY KEY (`orden_internamiento_id`, `item_producto_id`),
  INDEX `fk_orden_internamiento_has_item_producto_item_producto1_idx` (`item_producto_id` ASC),
  INDEX `fk_orden_internamiento_has_item_producto_orden_internamient_idx` (`orden_internamiento_id` ASC),
  CONSTRAINT `fk_orden_internamiento_has_item_producto_orden_internamiento1`
    FOREIGN KEY (`orden_internamiento_id`)
    REFERENCES `inf226g1`.`orden_internamiento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_internamiento_has_item_producto_item_producto1`
    FOREIGN KEY (`item_producto_id`)
    REFERENCES `inf226g1`.`item_producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
