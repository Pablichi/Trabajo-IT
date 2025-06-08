-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2025 a las 21:17:45
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
(4, 'Pablo Falcón Rodríguez', 'pfalrod@alu.upo.es', 722518338, 'Plaza San José Nº2, Bajo A', 1),
(5, 'Jose Francisco Torres Maldonado', 'jftormal@upo.es', 782436144, 'Calle Bruselas Nº3, 1ºD', 2),
(6, 'Daniel Sánchez-Matamoros Carmona', 'dsancar@alu.upo.es', 442564732, 'Calle Europa, Nº5, 3ºC', 1);

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
(1, 'Danilo', 'PotiPate678', '2025-05-01', 'Activo'),
(2, 'jftormal', 'jft0rma1~~#', '2025-05-07', 'Activo'),
(3, 'Pablichi', 'Pab10&$44', '2025-06-06', 'Activa');

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
(1, 'Roma', 'Italia', 'Turismo', 'Verano', 'Ciudad capital del país de Italia'),
(2, 'París', 'Francia', 'Turismo urbano', 'Verano', 'Capital del país de Francia, conocida por su cultura, historia y monumentos'),
(306128, 'Marbella', 'España', 'Turismo costero', 'Verano', 'Ciudad de la costa Sur de España conocida por sus grandes playas');

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

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id`, `fecha_pago`, `total`, `metodo_pago`, `estado`, `id_reserva`) VALUES
(1, '1233-12-04', 1200, 'Pago en efectivo', 'Pagado', 3),
(2, '1233-12-11', 1000, 'Pago en efectivo', 'Pagado', 5),
(3, '1233-12-25', 1300, 'Pago con tarjeta', 'Pagado', 4);

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
(3, 'Turismo por Roma', '1 semana de turismo por la ciudad de Roma, capital de Italia para disfrutar de sus monumentos y su i', '2025-06-13', 4, 600, 'Maletas extra', 1, 3),
(4, 'Turismo por París', 'Un viaje turístico de una semana por la ciudad de París para empaparte de su sociedad, cultura e his', '2025-06-04', 7, 500, 'Recogida en aeropuerto', 2, 1),
(5, 'Resort en Marbella', '5 días en uno de los mejores Resorts de Marbella', '2025-06-04', 5, 400, 'Maletas Extra', 306128, 2);

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

--
-- Volcado de datos para la tabla `promocion`
--

INSERT INTO `promocion` (`id`, `nombre_promocion`, `tipo_descuento`, `valor_descuento`, `fecha_inicio`, `fecha_finalizacion`, `descripcion`, `id_paquete`) VALUES
(1, 'Descuento por familiar', 'Porcentaje', 20, '2025-06-01', '2025-06-30', 'Por cada familiar recibirás un 15% de descuento, hasta un máximo de 3', 5),
(2, 'Descuento por niños', 'Porcentaje', 30, '2025-06-01', '2025-06-30', 'Para los niños menores de 16 años se aplicará un descuento del 30%', 3);

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
(1, 'Viajalia', 'Ocio', 'https://viajaliampg.es/', 'España', 'Buen trato al cliente'),
(2, 'LogiTravel', 'Alojamiento', 'www.logitravel.com', 'España', 'Buen trato con el cliente'),
(3, 'Trivago', 'Alojamiento', 'www.trivago.com', 'España', 'Buen trato con el cliente, Rapidez de procesos de búsqueda.');

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

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `fecha_reserva`, `numero_personas`, `estado`, `precio_total`, `id_cliente`, `id_paquete`) VALUES
(3, '2025-06-12', 2, 'Pagada', 1200, 5, 3),
(4, '2025-06-11', 4, 'Pagada', 1300, 4, 5),
(5, '2025-06-18', 2, 'Pagada', 1000, 6, 4);

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
-- Volcado de datos para la tabla `valoracion`
--

INSERT INTO `valoracion` (`id`, `puntuacion`, `comentario`, `fecha_publicacion`, `id_cliente`, `id_paquete`) VALUES
(1, 4, 'Muy buena experiencia', '2025-06-30', 4, 5),
(2, 1, 'Experiencia pésima', '2025-06-30', 5, 3),
(3, 5, 'Experiencia increíble, confianza absoluta en la compañía proveedora', '2025-06-30', 6, 4);

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
