-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2025 a las 11:45:51
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aldapa`
--
CREATE DATABASE IF NOT EXISTS `aldapa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aldapa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `rol_permisos` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_cuenta` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `nombre_usuario`, `email`, `rol_permisos`, `id_cuenta`) VALUES
(1, 'Jose Francisco Torres Maldonado', 'jftormal@upo.es', 'CRUD', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL COMMENT 'id del cliente',
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'nombre completo del cliente',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'email del cliente',
  `telefono` int(100) NOT NULL COMMENT 'telefono del cliente',
  `direccion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'direccion del cliente',
  `id_cuenta` int(11) DEFAULT 0 COMMENT 'id de la cuenta asociada al cliente '
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `email`, `telefono`, `direccion`, `id_cuenta`) VALUES
(0, 'Pablo Falcón Rodríguez', 'pfalrod@alu.upo.es', 722564789, 'Calle Palangana Nº8', 0),
(1, 'Daniel Sánchez-Matamoros Carmona', 'dsancar@alu.upo.es', 944856436, 'Calle Bruselas Nº3', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL,
  `usuario` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ultimo_acceso` date NOT NULL,
  `estado` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id`, `usuario`, `password`, `ultimo_acceso`, `estado`) VALUES
(0, 'Pablichi', 'PitiPata@#', '2025-05-05', 'Activo'),
(1, 'Danilo', 'PotiPate678', '2025-05-01', 'Activo'),
(2, 'jftormal', 'jft0rma1~~#', '2025-05-07', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destino`
--

CREATE TABLE `destino` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'Nombre del destino',
  `pais` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'Pais o región del destino',
  `tipo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tipos de entorno que puede ser el destino',
  `temporada` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tipo de clima ',
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'Descripcion del destino'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `destino`
--

INSERT INTO `destino` (`id`, `nombre`, `pais`, `tipo`, `temporada`, `descripcion`) VALUES
(0, 'Sevilla', 'España', 'Turismo', 'Verano', 'Capital de la comunidad autónoma de Andalucía, España'),
(1, 'Roma', 'Italia', 'Turismo', 'Verano', 'Ciudad capital del país de Italia'),
(2, 'Gran Canaria', 'España', 'Resort', 'Verano', 'Isla de la provincia de Las Palmas en las Islas Canarias, España');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id` int(11) NOT NULL,
  `fecha_pago` date NOT NULL,
  `total` float NOT NULL,
  `metodo_pago` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_reserva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_turistico`
--

CREATE TABLE `paquete_turistico` (
  `id` int(11) NOT NULL COMMENT 'Id del paquete turistico',
  `titulo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'titulo del paquete turistico',
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'descripcion del paquete turisitco',
  `fecha_salida` date NOT NULL COMMENT 'fechya de salida del paquete turistico',
  `duracion` int(11) NOT NULL COMMENT 'duracion del viaje del paquete turistico',
  `precio` float NOT NULL COMMENT 'precio del paquete turistico',
  `servicios_incluidos` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'servicios del paquete turistico',
  `id_destino` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL COMMENT 'id proveedor'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `paquete_turistico`
--

INSERT INTO `paquete_turistico` (`id`, `titulo`, `descripcion`, `fecha_salida`, `duracion`, `precio`, `servicios_incluidos`, `id_destino`, `id_proveedor`) VALUES
(0, 'Turismo por la ciudad de Sevilla', '5 días de turismo por la ciudad de Sevilla para visitar todos sus monumentos y toda su historia', '2025-07-23', 5, 743, 'Alojamiento, Guía turístico', 0, 0),
(1, 'Turismo por Roma', '5 días de turismo por la ciudad de Roma', '2025-06-15', 5, 800, 'Alojamiento, Visita guiada por los distintos monumentos de la  ciudad', 1, 1),
(2, 'HD Parque Cristóbal Gran Canaria', '¿Buscas donde alojarte en Playa del Inglés? Entonces no te pierdas HD Parque Cristobal Gran Canaria,', '2025-05-18', 2, 157, 'Alojamiento y acceso a las actividades de las instalaciones, desayuno incluido', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promocion`
--

CREATE TABLE `promocion` (
  `id` int(11) NOT NULL,
  `nombre_promocion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipo_descuento` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `valor_descuento` float NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_paquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor_servicios`
--

CREATE TABLE `proveedor_servicios` (
  `id` int(11) NOT NULL,
  `nombre_empresa` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipo_servicios` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contacto` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `comentarios_reputacion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `proveedor_servicios`
--

INSERT INTO `proveedor_servicios` (`id`, `nombre_empresa`, `tipo_servicios`, `contacto`, `pais`, `comentarios_reputacion`) VALUES
(0, 'Logitravel', 'Turismo', 'www.logitravel.com', 'España', ''),
(1, 'Viajalia', 'Turismo', 'www.viajaliampg.es', 'España', ''),
(2, 'Booking', 'Turismo, Resort', 'Booking.com', 'España', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `numero_personas` int(11) NOT NULL,
  `estado` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `precio_total` float NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_paquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion`
--

CREATE TABLE `valoracion` (
  `id` int(11) NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `comentario` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_paquete` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkadmin_cuenta_id` (`id_cuenta`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkcliente_cuenta_id` (`id_cuenta`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `destino`
--
ALTER TABLE `destino`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pago` (`id_reserva`);

--
-- Indices de la tabla `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_destino` (`id_destino`),
  ADD KEY `fk_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_paquete_id` (`id_paquete`);

--
-- Indices de la tabla `proveedor_servicios`
--
ALTER TABLE `proveedor_servicios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkreserva_cliente_id` (`id_cliente`),
  ADD KEY `fkreserva_paquete_id` (`id_paquete`);

--
-- Indices de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkvaloracion_cliente_id` (`id_cliente`),
  ADD KEY `fkvaloracion_paquete_id` (`id_paquete`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `fkadmin_cuenta_id` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fkcliente_cuenta_id` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `fk_pago` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD CONSTRAINT `fk_destino` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor_servicios` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD CONSTRAINT `fk_paquete_id` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fkreserva_cliente_id` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fkreserva_paquete_id` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD CONSTRAINT `fkvaloracion_cliente_id` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fkvaloracion_paquete_id` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
