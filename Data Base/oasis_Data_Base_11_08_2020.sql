-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.28 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para dbbiblio
CREATE DATABASE IF NOT EXISTS `dbbiblio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbbiblio`;

-- Copiando estrutura para view dbbiblio.book_view
-- Criando tabela temporária para evitar erros de dependência de VIEW
CREATE TABLE `book_view` (
	`id_book` INT(11) NOT NULL,
	`book_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`book_author` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`book_publisher` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`book_stock` INT(11) NOT NULL,
	`book_genre` VARCHAR(45) NULL COLLATE 'utf8_general_ci',
	`book_acquired_date` DATE NOT NULL,
	`id_images` INT(11) NULL,
	`image_name` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`image_bytes` VARBINARY(55530) NULL,
	`image_way` TEXT(65535) NULL COLLATE 'latin1_swedish_ci',
	`id_image_book` INT(11) NULL
) ENGINE=MyISAM;

-- Copiando estrutura para view dbbiblio.client_view
-- Criando tabela temporária para evitar erros de dependência de VIEW
CREATE TABLE `client_view` (
	`client_name` VARCHAR(150) NOT NULL COLLATE 'utf8_general_ci',
	`client_CEP` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`client_address` VARCHAR(150) NOT NULL COLLATE 'utf8_general_ci',
	`client_phone` VARCHAR(25) NOT NULL COLLATE 'utf8_general_ci',
	`cliente_login` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`client_password` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`client_image_perfil` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`client_email` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`id_client` INT(11) NOT NULL,
	`id_images` INT(11) NULL,
	`image_name` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`image_bytes` VARBINARY(55530) NULL,
	`image_way` TEXT(65535) NULL COLLATE 'latin1_swedish_ci',
	`id_image_book` INT(11) NULL
) ENGINE=MyISAM;

-- Copiando estrutura para view dbbiblio.data_of_rents_view
-- Criando tabela temporária para evitar erros de dependência de VIEW
CREATE TABLE `data_of_rents_view` (
	`id_rent` INT(11) NOT NULL,
	`rented_date` DATE NOT NULL,
	`id_of_book` INT(11) NOT NULL,
	`id_of_student` INT(11) NOT NULL,
	`return_date` DATE NOT NULL,
	`rent_returned` TINYINT(1) NOT NULL,
	`rent_penality` DOUBLE(22,0) NULL,
	`rent_observation` TEXT(65535) NULL COLLATE 'utf8_general_ci',
	`id_of_client` INT(11) NOT NULL,
	`client_name` VARCHAR(150) NULL COLLATE 'utf8_general_ci',
	`client_CEP` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`client_address` VARCHAR(150) NULL COLLATE 'utf8_general_ci',
	`client_phone` VARCHAR(25) NULL COLLATE 'utf8_general_ci',
	`cliente_login` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`client_password` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`client_image_perfil` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`client_email` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`id_client` INT(11) NULL,
	`id_student` INT(11) NULL,
	`student_name` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_registration` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_email` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_phone` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`student_CEP` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_address` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_module` VARCHAR(45) NULL COLLATE 'utf8_general_ci',
	`student_grade` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_course` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_school` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_shift` VARCHAR(25) NULL COLLATE 'utf8_general_ci',
	`student_login` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_password` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_image_perfil` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`id_book` INT(11) NULL,
	`book_name` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`book_author` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`book_publisher` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`book_stock` INT(11) NULL,
	`book_genre` VARCHAR(45) NULL COLLATE 'utf8_general_ci',
	`book_acquired_date` DATE NULL,
	`id_images` INT(11) NULL,
	`image_name` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`image_bytes` VARBINARY(55530) NULL,
	`image_way` TEXT(65535) NULL COLLATE 'latin1_swedish_ci',
	`id_image_book` INT(11) NULL
) ENGINE=MyISAM;

-- Copiando estrutura para view dbbiblio.student_view
-- Criando tabela temporária para evitar erros de dependência de VIEW
CREATE TABLE `student_view` (
	`id_student` INT(11) NOT NULL,
	`student_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`student_registration` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`student_email` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_phone` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`student_CEP` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`student_address` TINYTEXT NOT NULL COLLATE 'utf8_general_ci',
	`student_module` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`student_grade` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`student_course` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`student_school` TINYTEXT NOT NULL COLLATE 'utf8_general_ci',
	`student_shift` VARCHAR(25) NOT NULL COLLATE 'utf8_general_ci',
	`student_login` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`student_password` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`student_image_perfil` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`id_images` INT(11) NULL,
	`image_name` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`image_bytes` VARBINARY(55530) NULL,
	`image_way` TEXT(65535) NULL COLLATE 'latin1_swedish_ci',
	`id_image_book` INT(11) NULL
) ENGINE=MyISAM;

-- Copiando estrutura para tabela dbbiblio.tb_book
CREATE TABLE IF NOT EXISTS `tb_book` (
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) NOT NULL,
  `book_author` varchar(100) NOT NULL,
  `book_publisher` varchar(100) NOT NULL,
  `book_stock` int(11) NOT NULL,
  `book_genre` varchar(45) DEFAULT NULL,
  `book_acquired_date` date NOT NULL,
  PRIMARY KEY (`id_book`),
  UNIQUE KEY `book_publisher` (`book_publisher`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbbiblio.tb_book: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_book` DISABLE KEYS */;
INSERT INTO `tb_book` (`id_book`, `book_name`, `book_author`, `book_publisher`, `book_stock`, `book_genre`, `book_acquired_date`) VALUES
	(1, 'O pequeno Samuel', 'Samuel', 'Leumas Produçoes', 8, 'Romance', '2020-07-23'),
	(2, 'Como fazer Churrasco vegetariano', 'Fernanda', 'Fitness Life', 2, 'Culinária', '2020-08-05');
/*!40000 ALTER TABLE `tb_book` ENABLE KEYS */;

-- Copiando estrutura para tabela dbbiblio.tb_client
CREATE TABLE IF NOT EXISTS `tb_client` (
  `client_name` varchar(150) NOT NULL,
  `client_CEP` varchar(30) DEFAULT NULL,
  `client_address` varchar(150) NOT NULL,
  `client_phone` varchar(25) NOT NULL,
  `cliente_login` varchar(50) NOT NULL,
  `client_password` varchar(50) NOT NULL,
  `client_image_perfil` varchar(50) DEFAULT NULL,
  `client_email` tinytext,
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `client_password` (`client_password`),
  UNIQUE KEY `id_client` (`id_client`),
  KEY `FK_id_client_image` (`client_image_perfil`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbbiblio.tb_client: 0 rows
/*!40000 ALTER TABLE `tb_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_client` ENABLE KEYS */;

-- Copiando estrutura para tabela dbbiblio.tb_images
CREATE TABLE IF NOT EXISTS `tb_images` (
  `id_images` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(50) NOT NULL,
  `image_bytes` varbinary(55530) DEFAULT NULL,
  `image_way` text,
  `id_image_book` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_images`),
  UNIQUE KEY `image_name_UNIQUE` (`image_name`),
  KEY `FK_id_image_book` (`id_image_book`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela dbbiblio.tb_images: 0 rows
/*!40000 ALTER TABLE `tb_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_images` ENABLE KEYS */;

-- Copiando estrutura para tabela dbbiblio.tb_rent
CREATE TABLE IF NOT EXISTS `tb_rent` (
  `id_rent` int(11) NOT NULL AUTO_INCREMENT,
  `rented_date` date NOT NULL,
  `id_of_book` int(11) NOT NULL,
  `id_of_student` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `rent_returned` tinyint(1) NOT NULL,
  `rent_penality` double DEFAULT NULL,
  `rent_observation` text,
  `id_of_client` int(11) NOT NULL,
  PRIMARY KEY (`id_rent`),
  KEY `idlivro` (`id_of_book`),
  KEY `idcli` (`id_of_student`),
  CONSTRAINT `tb_rent_ibfk_1` FOREIGN KEY (`id_of_book`) REFERENCES `tb_book` (`id_book`),
  CONSTRAINT `tb_rent_ibfk_2` FOREIGN KEY (`id_of_student`) REFERENCES `tb_student` (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbbiblio.tb_rent: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_rent` ENABLE KEYS */;

-- Copiando estrutura para tabela dbbiblio.tb_student
CREATE TABLE IF NOT EXISTS `tb_student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `student_registration` varchar(100) NOT NULL,
  `student_email` tinytext,
  `student_phone` varchar(30) DEFAULT NULL,
  `student_CEP` tinytext,
  `student_address` tinytext NOT NULL,
  `student_module` varchar(45) NOT NULL,
  `student_grade` varchar(100) NOT NULL,
  `student_course` varchar(100) DEFAULT NULL,
  `student_school` tinytext NOT NULL,
  `student_shift` varchar(25) NOT NULL,
  `student_login` varchar(100) NOT NULL,
  `student_password` varchar(100) NOT NULL,
  `student_image_perfil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_student`),
  UNIQUE KEY `senha` (`student_password`),
  UNIQUE KEY `student_password` (`student_password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbbiblio.tb_student: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;

-- Copiando estrutura para tabela dbbiblio.tb_user
CREATE TABLE IF NOT EXISTS `tb_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_login` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_access_level` int(11) NOT NULL,
  `user_image_perfil` varchar(50) DEFAULT NULL,
  `user_email` tinytext,
  `user_address` tinytext NOT NULL,
  `user_cep` varchar(30) DEFAULT NULL,
  `user_phone` varchar(30) DEFAULT NULL,
  `user_school` varchar(100) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_password` (`user_password`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbbiblio.tb_user: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id_user`, `user_name`, `user_login`, `user_password`, `user_access_level`, `user_image_perfil`, `user_email`, `user_address`, `user_cep`, `user_phone`, `user_school`) VALUES
	(1, 'teste', 'teste', '123', 3, NULL, 'teste@gmail', 'macaxeira', '235234254', '235243452', 'ETEMB');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

-- Copiando estrutura para view dbbiblio.user_view
-- Criando tabela temporária para evitar erros de dependência de VIEW
CREATE TABLE `user_view` (
	`id_user` INT(11) NOT NULL,
	`user_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`user_login` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`user_password` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`user_access_level` INT(11) NOT NULL,
	`user_image_perfil` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`user_email` TINYTEXT NULL COLLATE 'utf8_general_ci',
	`user_address` TINYTEXT NOT NULL COLLATE 'utf8_general_ci',
	`user_cep` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`user_phone` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`user_school` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`id_images` INT(11) NULL,
	`image_name` VARCHAR(50) NULL COLLATE 'latin1_swedish_ci',
	`image_bytes` VARBINARY(55530) NULL,
	`image_way` TEXT(65535) NULL COLLATE 'latin1_swedish_ci',
	`id_image_book` INT(11) NULL
) ENGINE=MyISAM;

-- Copiando estrutura para view dbbiblio.book_view
-- Removendo tabela temporária e criando a estrutura VIEW final
DROP TABLE IF EXISTS `book_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `book_view` AS select `tb_book`.`id_book` AS `id_book`,`tb_book`.`book_name` AS `book_name`,`tb_book`.`book_author` AS `book_author`,`tb_book`.`book_publisher` AS `book_publisher`,`tb_book`.`book_stock` AS `book_stock`,`tb_book`.`book_genre` AS `book_genre`,`tb_book`.`book_acquired_date` AS `book_acquired_date`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_book` left join `tb_images` on((`tb_book`.`id_book` = `tb_images`.`id_image_book`)));

-- Copiando estrutura para view dbbiblio.client_view
-- Removendo tabela temporária e criando a estrutura VIEW final
DROP TABLE IF EXISTS `client_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `client_view` AS select `tb_client`.`client_name` AS `client_name`,`tb_client`.`client_CEP` AS `client_CEP`,`tb_client`.`client_address` AS `client_address`,`tb_client`.`client_phone` AS `client_phone`,`tb_client`.`cliente_login` AS `cliente_login`,`tb_client`.`client_password` AS `client_password`,`tb_client`.`client_image_perfil` AS `client_image_perfil`,`tb_client`.`client_email` AS `client_email`,`tb_client`.`id_client` AS `id_client`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_client` left join `tb_images` on((`tb_client`.`client_image_perfil` = convert(`tb_images`.`image_name` using utf8))));

-- Copiando estrutura para view dbbiblio.data_of_rents_view
-- Removendo tabela temporária e criando a estrutura VIEW final
DROP TABLE IF EXISTS `data_of_rents_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `data_of_rents_view` AS select `tb_rent`.`id_rent` AS `id_rent`,`tb_rent`.`rented_date` AS `rented_date`,`tb_rent`.`id_of_book` AS `id_of_book`,`tb_rent`.`id_of_student` AS `id_of_student`,`tb_rent`.`return_date` AS `return_date`,`tb_rent`.`rent_returned` AS `rent_returned`,`tb_rent`.`rent_penality` AS `rent_penality`,`tb_rent`.`rent_observation` AS `rent_observation`,`tb_rent`.`id_of_client` AS `id_of_client`,`tb_client`.`client_name` AS `client_name`,`tb_client`.`client_CEP` AS `client_CEP`,`tb_client`.`client_address` AS `client_address`,`tb_client`.`client_phone` AS `client_phone`,`tb_client`.`cliente_login` AS `cliente_login`,`tb_client`.`client_password` AS `client_password`,`tb_client`.`client_image_perfil` AS `client_image_perfil`,`tb_client`.`client_email` AS `client_email`,`tb_client`.`id_client` AS `id_client`,`tb_student`.`id_student` AS `id_student`,`tb_student`.`student_name` AS `student_name`,`tb_student`.`student_registration` AS `student_registration`,`tb_student`.`student_email` AS `student_email`,`tb_student`.`student_phone` AS `student_phone`,`tb_student`.`student_CEP` AS `student_CEP`,`tb_student`.`student_address` AS `student_address`,`tb_student`.`student_module` AS `student_module`,`tb_student`.`student_grade` AS `student_grade`,`tb_student`.`student_course` AS `student_course`,`tb_student`.`student_school` AS `student_school`,`tb_student`.`student_shift` AS `student_shift`,`tb_student`.`student_login` AS `student_login`,`tb_student`.`student_password` AS `student_password`,`tb_student`.`student_image_perfil` AS `student_image_perfil`,`tb_book`.`id_book` AS `id_book`,`tb_book`.`book_name` AS `book_name`,`tb_book`.`book_author` AS `book_author`,`tb_book`.`book_publisher` AS `book_publisher`,`tb_book`.`book_stock` AS `book_stock`,`tb_book`.`book_genre` AS `book_genre`,`tb_book`.`book_acquired_date` AS `book_acquired_date`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from ((((`tb_rent` left join `tb_client` on((`tb_rent`.`id_of_client` = `tb_client`.`id_client`))) left join `tb_student` on((`tb_rent`.`id_of_student` = `tb_student`.`id_student`))) left join `tb_book` on((`tb_rent`.`id_of_book` = `tb_book`.`id_book`))) left join `tb_images` on(((`tb_client`.`client_image_perfil` = `tb_images`.`id_images`) or (`tb_student`.`student_image_perfil` = `tb_images`.`id_images`) or (`tb_book`.`id_book` = `tb_images`.`id_image_book`))));

-- Copiando estrutura para view dbbiblio.student_view
-- Removendo tabela temporária e criando a estrutura VIEW final
DROP TABLE IF EXISTS `student_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `student_view` AS select `tb_student`.`id_student` AS `id_student`,`tb_student`.`student_name` AS `student_name`,`tb_student`.`student_registration` AS `student_registration`,`tb_student`.`student_email` AS `student_email`,`tb_student`.`student_phone` AS `student_phone`,`tb_student`.`student_CEP` AS `student_CEP`,`tb_student`.`student_address` AS `student_address`,`tb_student`.`student_module` AS `student_module`,`tb_student`.`student_grade` AS `student_grade`,`tb_student`.`student_course` AS `student_course`,`tb_student`.`student_school` AS `student_school`,`tb_student`.`student_shift` AS `student_shift`,`tb_student`.`student_login` AS `student_login`,`tb_student`.`student_password` AS `student_password`,`tb_student`.`student_image_perfil` AS `student_image_perfil`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_student` left join `tb_images` on((`tb_student`.`student_image_perfil` = convert(`tb_images`.`image_name` using utf8))));

-- Copiando estrutura para view dbbiblio.user_view
-- Removendo tabela temporária e criando a estrutura VIEW final
DROP TABLE IF EXISTS `user_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `user_view` AS select `tb_user`.`id_user` AS `id_user`,`tb_user`.`user_name` AS `user_name`,`tb_user`.`user_login` AS `user_login`,`tb_user`.`user_password` AS `user_password`,`tb_user`.`user_access_level` AS `user_access_level`,`tb_user`.`user_image_perfil` AS `user_image_perfil`,`tb_user`.`user_email` AS `user_email`,`tb_user`.`user_address` AS `user_address`,`tb_user`.`user_cep` AS `user_cep`,`tb_user`.`user_phone` AS `user_phone`,`tb_user`.`user_school` AS `user_school`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_user` left join `tb_images` on((`tb_user`.`user_image_perfil` = convert(`tb_images`.`image_name` using utf8))));

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
