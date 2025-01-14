CREATE DATABASE  IF NOT EXISTS `basepasteleria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `basepasteleria`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: basepasteleria
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `car_cod` int NOT NULL,
  `car_nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`car_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'ADMINISTRADOR'),(2,'VENDEDOR'),(3,'ENCARGADO DE ALMACEN');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `cat_cod` char(5) NOT NULL,
  `cat_nom` varchar(45) DEFAULT NULL,
  `cat_des` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cat_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cli_cod` char(5) NOT NULL,
  `cli_nom` varchar(45) DEFAULT NULL,
  `cli_ape` varchar(45) DEFAULT NULL,
  `cli_tel` int DEFAULT NULL,
  `cli_dir` varchar(45) DEFAULT NULL,
  `cli_cor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cli_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_recibo`
--

DROP TABLE IF EXISTS `detalle_recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_recibo` (
  `reb_cod` char(5) NOT NULL,
  `prod_can` int DEFAULT NULL,
  `prod_cod` char(5) DEFAULT NULL,
  PRIMARY KEY (`reb_cod`),
  KEY `fk_detalle_producto` (`prod_cod`),
  CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`prod_cod`) REFERENCES `producto` (`prod_cod`),
  CONSTRAINT `fk_detalle_recibo` FOREIGN KEY (`reb_cod`) REFERENCES `recibo` (`reb_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_recibo`
--

LOCK TABLES `detalle_recibo` WRITE;
/*!40000 ALTER TABLE `detalle_recibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientes` (
  `prod_cod` char(5) NOT NULL,
  `ins_cod` char(5) DEFAULT NULL,
  `ing_can` int DEFAULT NULL,
  PRIMARY KEY (`prod_cod`),
  KEY `fk_ingredientes_insumos` (`ins_cod`),
  CONSTRAINT `fk_ingredientes_insumos` FOREIGN KEY (`ins_cod`) REFERENCES `insumos` (`ins_cod`),
  CONSTRAINT `fk_ingredientes_producto` FOREIGN KEY (`prod_cod`) REFERENCES `producto` (`prod_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumos`
--

DROP TABLE IF EXISTS `insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumos` (
  `ins_cod` char(5) NOT NULL,
  `ins_nom` varchar(45) DEFAULT NULL,
  `ins_des` varchar(45) DEFAULT NULL,
  `ins_stk` int DEFAULT NULL,
  `pro_cod` char(5) DEFAULT NULL,
  PRIMARY KEY (`ins_cod`),
  KEY `fk_insumos_proveedor` (`pro_cod`),
  CONSTRAINT `fk_insumos_proveedor` FOREIGN KEY (`pro_cod`) REFERENCES `proveedor` (`pro_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumos`
--

LOCK TABLES `insumos` WRITE;
/*!40000 ALTER TABLE `insumos` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `pag_cod` char(5) NOT NULL,
  `pag_com` varchar(45) DEFAULT NULL,
  `pag_igv` double DEFAULT NULL,
  `pag_total` double DEFAULT NULL,
  `pag_fec` date DEFAULT NULL,
  `reb_cod` char(5) DEFAULT NULL,
  PRIMARY KEY (`pag_cod`),
  KEY `fk_pago_recibo` (`reb_cod`),
  CONSTRAINT `fk_pago_recibo` FOREIGN KEY (`reb_cod`) REFERENCES `recibo` (`reb_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `prod_cod` char(5) NOT NULL,
  `prod_nom` varchar(45) DEFAULT NULL,
  `prod_des` varchar(45) DEFAULT NULL,
  `prod_pre` double DEFAULT NULL,
  `prod_stk` int DEFAULT NULL,
  `cat_cod` char(5) DEFAULT NULL,
  PRIMARY KEY (`prod_cod`),
  KEY `fk_producto_categoria` (`cat_cod`),
  CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`cat_cod`) REFERENCES `categoria` (`cat_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `pro_cod` char(5) NOT NULL,
  `pro_nom` varchar(45) DEFAULT NULL,
  `pro_des` varchar(45) DEFAULT NULL,
  `pro_ruc` int DEFAULT NULL,
  PRIMARY KEY (`pro_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibo` (
  `reb_cod` char(5) NOT NULL,
  `reb_fec` date DEFAULT NULL,
  `cli_cod` char(5) DEFAULT NULL,
  PRIMARY KEY (`reb_cod`),
  KEY `fk_recibo_cliente` (`cli_cod`),
  CONSTRAINT `fk_recibo_cliente` FOREIGN KEY (`cli_cod`) REFERENCES `cliente` (`cli_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usr_cod` int NOT NULL AUTO_INCREMENT,
  `usr_name` varchar(45) NOT NULL,
  `usr_pass` varchar(45) NOT NULL,
  `usr_nom` varchar(45) NOT NULL,
  `usr_ape` varchar(45) NOT NULL,
  `usr_telf` char(9) NOT NULL,
  `usr_status` int NOT NULL,
  `car_cod` int NOT NULL,
  PRIMARY KEY (`usr_cod`),
  KEY `fk_usuario_cargo` (`car_cod`),
  CONSTRAINT `fk_usuario_cargo` FOREIGN KEY (`car_cod`) REFERENCES `cargo` (`car_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'kfernandezs','Password$1','Kevin','Fernandez Salas','914233345',1,1),(3,'jfernandezs','Password$1','Jean','Fernandez Salas','987654321',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-12 10:36:43
