-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: spcolegio
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `dni` int DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `dniapo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l48mpyy32xjxat2do2qypsx5v` (`celular`),
  UNIQUE KEY `UK_f2c9i14wnebiikl4lldh5yam2` (`dni`),
  KEY `FK67i0jyjsjei7ifiir3jsavco3` (`dniapo`),
  CONSTRAINT `FK67i0jyjsjei7ifiir3jsavco3` FOREIGN KEY (`dniapo`) REFERENCES `apoderados` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (14,'Pozo',985632544,69856365,'ACTIVO','Anibal','M',54858796),(15,'Palacin',985632,65965521,'INACTIVO','Julian','M',15236987),(16,'Huaman',36985632,14523698,'ACTIVO','KRISS','F',54858796),(17,'Lopez',985632587,15987452,'ACTIVO','Carlos','M',54858796),(18,'Carpena',98563258,15698741,'ACTIVO','Angel','M',15236987),(19,'Ganoza',985632564,54785632,'ACTIVO','Marta','F',54858796);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ano_escolares`
--

DROP TABLE IF EXISTS `ano_escolares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ano_escolares` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ehlt3by44j5j0k2cn1uxiq89y` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ano_escolares`
--

LOCK TABLES `ano_escolares` WRITE;
/*!40000 ALTER TABLE `ano_escolares` DISABLE KEYS */;
INSERT INTO `ano_escolares` VALUES (1,'Activo','2021-10-29','2021-06-10','Año del Bicentenario del Perú'),(2,'Activo','2021-08-30','2021-05-10','Año del Bicentenario 2021'),(3,'Activo','2022-12-29','2022-06-10','Año del Bicentendel'),(4,'Activo','2023-12-30','2023-05-10','Año del Bicenten 2021');
/*!40000 ALTER TABLE `ano_escolares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoderados`
--

DROP TABLE IF EXISTS `apoderados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apoderados` (
  `dni` int NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `UK_pjhuvhb8i70vywt42pra81are` (`celular`),
  UNIQUE KEY `UK_cppr346eb0o4bk0khgsbpfr0e` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoderados`
--

LOCK TABLES `apoderados` WRITE;
/*!40000 ALTER TABLE `apoderados` DISABLE KEYS */;
INSERT INTO `apoderados` VALUES (15236987,'Rafaga�',NULL,NULL,'feredd','dcdvgb','r'),(54858796,'Sant',NULL,NULL,'osOO','GGGdefr','c'),(69856325,'Gar',NULL,NULL,'cia','SSSSb','g');
/*!40000 ALTER TABLE `apoderados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarios`
--

DROP TABLE IF EXISTS `calendarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `concepto` varchar(255) DEFAULT NULL,
  `flimite` date DEFAULT NULL,
  `mes` varchar(255) DEFAULT NULL,
  `monto` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarios`
--

LOCK TABLES `calendarios` WRITE;
/*!40000 ALTER TABLE `calendarios` DISABLE KEYS */;
INSERT INTO `calendarios` VALUES (1,'Mensualidad','2022-04-10','ABRIL',400),(2,'Matricula','2021-02-20','febrero',500),(3,'Matricula','2022-02-20','febrero',500),(4,'Mensualidad','2022-03-30','Marzo',400),(6,'Mensualidad','2022-02-20','Mayo',400),(8,'Mensualidad','2022-02-20','Julio',400),(9,'Mensualidad','2022-03-10','Octubre',400),(10,'Mensualidad','2022-06-10','Junio',400),(11,'Mensualidad','2022-07-10','Julio',400),(12,'Mensualidad','2022-08-10','Agosto',400),(13,'Mensualidad','2022-09-10','Setiembre',400),(14,'Mensualidad','2022-10-10','Octubre',400),(15,'Mensualidad','2022-11-10','Noviembre',400),(16,'Mensualidad','2022-12-10','Diciembre',400),(17,'Fiestas Patrias','2022-07-20','Julio',400);
/*!40000 ALTER TABLE `calendarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grados`
--

DROP TABLE IF EXISTS `grados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `codigo_ae` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb448r56bc70rp3sh0b2wcf804` (`codigo_ae`),
  CONSTRAINT `FKb448r56bc70rp3sh0b2wcf804` FOREIGN KEY (`codigo_ae`) REFERENCES `ano_escolares` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grados`
--

LOCK TABLES `grados` WRITE;
/*!40000 ALTER TABLE `grados` DISABLE KEYS */;
INSERT INTO `grados` VALUES (6,'ACTIVO','3er Grado',3),(9,'ACTIVO','6to Grado',3),(10,'ACTIVO','5to Grado',3);
/*!40000 ALTER TABLE `grados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriculas`
--

DROP TABLE IF EXISTS `matriculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriculas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_matricula` date DEFAULT NULL,
  `codigo_alum` int NOT NULL,
  `codigo_ae` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfc6fwea27hd5p6oxmqn8ru0c` (`codigo_alum`),
  KEY `FK2yw9wyt6r8ti8riph6f6l1hcf` (`codigo_ae`),
  CONSTRAINT `FK2yw9wyt6r8ti8riph6f6l1hcf` FOREIGN KEY (`codigo_ae`) REFERENCES `ano_escolares` (`id`),
  CONSTRAINT `FKfc6fwea27hd5p6oxmqn8ru0c` FOREIGN KEY (`codigo_alum`) REFERENCES `alumnos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriculas`
--

LOCK TABLES `matriculas` WRITE;
/*!40000 ALTER TABLE `matriculas` DISABLE KEYS */;
INSERT INTO `matriculas` VALUES (1,'Activo','2021-04-20',15,4),(3,'Activo','2021-05-05',16,4),(4,'Activo','2021-04-20',17,4),(5,'Activo','2021-05-05',18,4);
/*!40000 ALTER TABLE `matriculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `monto` int DEFAULT NULL,
  `calendario_id` int NOT NULL,
  `matricula_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtdbb7wmr9btp44vrsdjycgenq` (`calendario_id`),
  KEY `FK59atg2n97ddo46oef1kni0dy7` (`matricula_id`),
  KEY `FKnv3skx0qnku57yljq0bu88oot` (`usuario_id`),
  CONSTRAINT `FK59atg2n97ddo46oef1kni0dy7` FOREIGN KEY (`matricula_id`) REFERENCES `matriculas` (`id`),
  CONSTRAINT `FKnv3skx0qnku57yljq0bu88oot` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKtdbb7wmr9btp44vrsdjycgenq` FOREIGN KEY (`calendario_id`) REFERENCES `calendarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (2,'VIGENTE','2020-02-05',500,2,1,5),(10,'ACTIVO','2021-11-15',400,1,1,6),(13,'activo','2022-05-12',400,1,1,7),(14,'ACTIVO','2022-03-20',400,3,3,5),(15,'ACTIVO','2022-06-10',400,6,4,6),(16,'ACTIVO','2022-06-14',400,1,4,7),(33,'ACTIVO','2022-03-10',400,6,5,5);
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secciones`
--

DROP TABLE IF EXISTS `secciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `codigo_grado` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjmsmgqn1oje4tv6e3bp2x5f79` (`codigo_grado`),
  CONSTRAINT `FKjmsmgqn1oje4tv6e3bp2x5f79` FOREIGN KEY (`codigo_grado`) REFERENCES `grados` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secciones`
--

LOCK TABLES `secciones` WRITE;
/*!40000 ALTER TABLE `secciones` DISABLE KEYS */;
INSERT INTO `secciones` VALUES (1,'Activo','S101',9),(2,'Activo','S201',9);
/*!40000 ALTER TABLE `secciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ggd9d47p8x7m0ajavk1ayuyqs` (`dni`),
  UNIQUE KEY `UK_pvkc41cle7rmsf4ma2lrfbm1b` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'POLO','123','36587','ACTIVO','CESAR','ASIS1'),(2,'KILO','123','5478','ACTIVO','LUCHO','ASIS2'),(3,'DARLIN','123','15847855','INACTIVO','COCO','blasfemi'),(5,'QUISPE','123','14869874','INACTIVO','VANESSA','vaness'),(6,'SOCO','123','14587896','INACTIVO','MARY','MARY'),(7,'Zamora','123','25636985','ACTIVO','Kristina','tina'),(9,'Kun','123','65896523','INACTIVO','Carlos','carlitos');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-04 12:21:58
