













/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.25-MariaDB : Database - colegio
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`colegio` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `colegio`;
select * from alumno;
delete from curso_profesor where cod_curso = 2;

ALTER TABLE alumno_curso
ADD COLUMN id_alumno_curso INT(11) NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (id_alumno_curso);

ALTER TABLE curso_profesor
ADD COLUMN id_curso_profesor INT(11) NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (id_curso_profesor);

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `sexo` char(1) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `alumno` */

insert  into `alumno`(`id_alumno`,`nombres`,`apellidos`,`sexo`,`estado`) values (1,'Robert','Otiniano','M',1),(2,'Albert','Morales ','M',1),(3,'Yeni','Mendoza ','F',1),(4,'Alex','Mamaní','M',1),(5,'Bryan ','Condor ','M',1),(6,'TEST1','TEST2','F',1),(7,'TTT','TTT','F',1);

/*Table structure for table `alumno_curso` */

DROP TABLE IF EXISTS `alumno_curso`;

CREATE TABLE `alumno_curso` (
  `cod_alumno` int(11) NOT NULL,
  `cod_curso` int(11) NOT NULL,
  KEY `cod_alu_fk1` (`cod_alumno`),
  KEY `cod_cur_fk2` (`cod_curso`),
  CONSTRAINT `cod_alu_fk1` FOREIGN KEY (`cod_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `cod_cur_fk2` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno_curso` */

insert  into `alumno_curso`(`cod_alumno`,`cod_curso`) values (1,2),(2,1),(3,4),(4,3),(5,1);

/*Table structure for table `curso` */

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

select * from curso_profesor;


/*Data for the table `curso` */

insert  into `curso`(`id_curso`,`descripcion`,`estado`) values (1,'Análisis y Diseño',1),(2,'Base de Datos',1),(3,'Lenguaje de Programación',1),(4,'Inteligencia Artificial',1);

/*Table structure for table `curso_profesor` */

DROP TABLE IF EXISTS `curso_profesor`;

CREATE TABLE `curso_profesor` (
  `cod_curso` int(11) NOT NULL,
  `cod_profesor` int(11) NOT NULL,
  KEY `cod_curso_fk1` (`cod_curso`),
  KEY `cod_profesor_fk2` (`cod_profesor`),
  CONSTRAINT `cod_curso_fk1` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `cod_profesor_fk2` FOREIGN KEY (`cod_profesor`) REFERENCES `profesor` (`id_profesor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `curso_profesor` */

insert  into `curso_profesor`(`cod_curso`,`cod_profesor`) values (1,1),(2,2),(3,3),(2,1),(4,3);

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `id_profesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `sexo` char(1) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `profesor` */

insert  into `profesor`(`id_profesor`,`nombre`,`apellidos`,`sexo`,`estado`) values (1,'Juan','Salazar','M',1),(2,'Jose','Atunga','M',1),(3,'Celso','Calla','M',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
