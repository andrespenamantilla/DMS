-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2017 a las 16:25:09
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dmsgestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '500');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_adm_grupos`
--

CREATE TABLE `tb_adm_grupos` (
  `gr_nombre_grupo` varchar(50) NOT NULL,
  `gr_usu_login` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_adm_roles`
--

CREATE TABLE `tb_adm_roles` (
  `ro_codigo` int(11) NOT NULL,
  `ro_descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_adm_roles`
--

INSERT INTO `tb_adm_roles` (`ro_codigo`, `ro_descripcion`) VALUES
(1, 'ADMIN_SISTEMA'),
(2, 'ADMIN_BD'),
(3, 'EJECUTIVO_CUENTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_adm_usuarios`
--

CREATE TABLE `tb_adm_usuarios` (
  `us_cod_usuario` int(11) NOT NULL,
  `us_login` varchar(10) NOT NULL,
  `us_password` varchar(35) NOT NULL,
  `us_rol` int(11) NOT NULL,
  `us_tipo_id` varchar(2) NOT NULL,
  `us_estado` char(1) NOT NULL,
  `us_id` varchar(25) NOT NULL,
  `us_area` varchar(30) NOT NULL,
  `us_cargo` varchar(40) NOT NULL,
  `us_nombre` varchar(100) NOT NULL,
  `us_email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_adm_usuarios`
--

INSERT INTO `tb_adm_usuarios` (`us_cod_usuario`, `us_login`, `us_password`, `us_rol`, `us_tipo_id`, `us_estado`, `us_id`, `us_area`, `us_cargo`, `us_nombre`, `us_email`) VALUES
(1, 'apenam', 'addc7fbb9dc17a188d708b03be8b5e12', 1, '1', '1', '1022371831', '1', '1', 'andrés peña mantilla', 'andrespenamantilla@hotmail.com'),
(2, 'sasalo', '202cb962ac59075b964b07152d234b70', 3, '1', '1', '123456', '1', '1', 'Santos Salazar López', NULL),
(4, 'usuprueba', 'e10adc3949ba59abbe56e057f20f883e', 2, '1', '1', '124565', '1', '1', 'usuprueba', 'juan@gmail.com'),
(6, 'prueba1', 'e10adc3949ba59abbe56e057f20f883e', 2, '1', '1', '123456', '3', '40', 'prueba1', 'skjsdak@gmail.com'),
(7, 'aaaaa', 'e10adc3949ba59abbe56e057f20f883e', 1, '2', '1', '321321', '1', '1', 'asddsa', 'juan@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_casos_empresas`
--

CREATE TABLE `tb_casos_empresas` (
  `ce_sec_caso` int(11) NOT NULL,
  `ce_descripcion` varchar(200) NOT NULL,
  `ce_estado` varchar(3) NOT NULL,
  `ce_linea_negocio` varchar(2) NOT NULL,
  `ce_contacto` int(11) NOT NULL,
  `ce_causal` varchar(2) DEFAULT NULL,
  `ce_empresa` int(11) NOT NULL,
  `ce_tipo_cont` varchar(2) NOT NULL,
  `ce_etapa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_casos_empresas`
--

INSERT INTO `tb_casos_empresas` (`ce_sec_caso`, `ce_descripcion`, `ce_estado`, `ce_linea_negocio`, `ce_contacto`, `ce_causal`, `ce_empresa`, `ce_tipo_cont`, `ce_etapa`) VALUES
(30, 'Holas', 'C', '1', 51, NULL, 1, '2', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_ciudades`
--

CREATE TABLE `tb_ciudades` (
  `CI_PAIS` varchar(3) NOT NULL,
  `CI_DEPTO` varchar(2) NOT NULL,
  `CI_CIUDAD` varchar(5) NOT NULL,
  `ci_nombre` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_ciudades`
--

INSERT INTO `tb_ciudades` (`CI_PAIS`, `CI_DEPTO`, `CI_CIUDAD`, `ci_nombre`) VALUES
('1', '1', '1', 'Caqueza'),
('1', '1', '2', 'Girardot'),
('1', '1', '3', 'Tocancipa'),
('1', '1', '4', 'Sibate'),
('1', '1', '5', 'Villa Pinzon'),
('2', '1', '1', 'Mendieta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_contactos_empresas`
--

CREATE TABLE `tb_contactos_empresas` (
  `ce_secuencial` int(11) NOT NULL,
  `ce_codigo_empresa` int(11) NOT NULL,
  `ce_nombres` varchar(60) NOT NULL,
  `ce_apellidos` varchar(60) NOT NULL,
  `ce_cargo` varchar(15) DEFAULT NULL,
  `ce_area` varchar(15) DEFAULT NULL,
  `ce_descripcion_funcion` varchar(255) NOT NULL,
  `ce_telefono` varchar(50) DEFAULT NULL,
  `ce_ext_tel` int(11) DEFAULT NULL,
  `ce_direccion` varchar(100) DEFAULT NULL,
  `ce_pais` varchar(3) DEFAULT NULL,
  `ce_depto` varchar(2) DEFAULT NULL,
  `ce_ciudad` varchar(5) DEFAULT NULL,
  `ce_email_corp` varchar(100) DEFAULT NULL,
  `ce_email_personal` varchar(100) DEFAULT NULL,
  `ce_estado` char(1) DEFAULT NULL,
  `ce_celular` varchar(15) DEFAULT NULL,
  `ce_sw_contacto` char(1) DEFAULT NULL,
  `ce_fecha_crea` datetime DEFAULT NULL,
  `ce_fecha_ult_mod` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_contactos_empresas`
--

INSERT INTO `tb_contactos_empresas` (`ce_secuencial`, `ce_codigo_empresa`, `ce_nombres`, `ce_apellidos`, `ce_cargo`, `ce_area`, `ce_descripcion_funcion`, `ce_telefono`, `ce_ext_tel`, `ce_direccion`, `ce_pais`, `ce_depto`, `ce_ciudad`, `ce_email_corp`, `ce_email_personal`, `ce_estado`, `ce_celular`, `ce_sw_contacto`, `ce_fecha_crea`, `ce_fecha_ult_mod`) VALUES
(51, 1, 'Edith', 'Salazar Lopez', '40', '2', 'ddd', '654654', 123, NULL, '1', '1', '4', NULL, 'prueba@gmail.com', NULL, NULL, NULL, '2017-07-11 17:16:07', NULL),
(101, 1, 'Olga', 'Ríos Bernal', '39', '2', 'ddddd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2017-07-11 17:24:29', NULL),
(351, 1, 'Cristian', 'Camilo Salazar', '1', '4', 'Desarrollo', NULL, 123, NULL, NULL, NULL, NULL, NULL, 'ccsalazarr@unal.edu.co', 'A', NULL, NULL, '2017-07-12 09:16:05', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cotizaciones`
--

CREATE TABLE `tb_cotizaciones` (
  `co_cod_cotiz` int(11) NOT NULL,
  `co_empresa` int(11) DEFAULT NULL,
  `co_ejecutivo` int(11) DEFAULT NULL,
  `co_fecha` datetime DEFAULT NULL,
  `co_caso` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_cotizaciones`
--

INSERT INTO `tb_cotizaciones` (`co_cod_cotiz`, `co_empresa`, `co_ejecutivo`, `co_fecha`, `co_caso`) VALUES
(2, 1, 1, '2017-09-26 13:41:28', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_departamentos`
--

CREATE TABLE `tb_departamentos` (
  `de_pais` varchar(3) NOT NULL,
  `de_codigo` varchar(2) NOT NULL,
  `de_nombre` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_departamentos`
--

INSERT INTO `tb_departamentos` (`de_pais`, `de_codigo`, `de_nombre`) VALUES
('1', '1', 'Cundinamarca'),
('1', '2', 'Antioquia'),
('1', '3', 'Amazonas'),
('2', '1', 'Tachira'),
('8', '1', 'Mendoza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalle_catalogo`
--

CREATE TABLE `tb_detalle_catalogo` (
  `dc_catalogo` varchar(15) NOT NULL DEFAULT '',
  `dc_codigo` varchar(15) NOT NULL DEFAULT '',
  `dc_descripcion` varchar(100) DEFAULT NULL,
  `dc_estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_detalle_catalogo`
--

INSERT INTO `tb_detalle_catalogo` (`dc_catalogo`, `dc_codigo`, `dc_descripcion`, `dc_estado`) VALUES
('CA_AREAS', '1', 'ADMINISTRATIVA', 'V'),
('CA_AREAS', '2', 'GESTIÓN HUMANA', 'V'),
('CA_AREAS', '3', 'COMERCIAL', 'V'),
('CA_AREAS', '4', 'DESCONOCIDA', 'V'),
('CA_CARGOS', '1', 'DESCONOCIDO', 'V'),
('CA_CARGOS', '38', 'GERENTE FINANCIERO', 'V'),
('CA_CARGOS', '39', 'GERENTE ADMINISTRATIVO Y FINANCIERO', 'V'),
('CA_CARGOS', '40', 'GERENTE GENERAL Y ADMINISTRATIVO', 'V'),
('CA_CARGOS', '41', 'GERENTE COMERCIAL', 'C'),
('CA_CAU_EST_PRO', '1', 'EL CLIENTE COMPRO', 'V'),
('CA_CAU_EST_PRO', '2', 'EL CLIENTE NO COMPRO', 'V'),
('CA_CAU_EST_PRO', '3', 'EL CLIENTE ATENDERA EN OTRA OCASION', 'V'),
('CA_CLASIF_CLIEN', '1', 'PROSPECTO A - BUEN POTENCIAL', 'V'),
('CA_CLASIF_CLIEN', '2', 'PROSPECTO B - POTENCIAL', 'V'),
('CA_CLASIF_CLIEN', '3', 'POR DEFINIR', 'V'),
('CA_ESTADO_EMP', 'A', 'ACTIVA', 'V'),
('CA_ESTADO_EMP', 'I', 'INACTIVA', 'V'),
('CA_ESTADO_PROC', '1', 'VIGENTE', 'V'),
('CA_ESTADO_PROC', '2', 'ANULADO', 'V'),
('CA_ESTADO_PROC', '3', 'FINALIZADO', 'V'),
('CA_ESTADO_PROC', 'A', 'ABIERTO', 'V'),
('CA_ESTADO_PROC', 'C', 'CERRADO', 'V'),
('CA_ESTADO_PROC', 'P', 'POSTERGADO', 'V'),
('CA_ESTADO_TAR', '1', 'PENDIENTE', 'V'),
('CA_ESTADO_TAR', '2', 'FINALIZADA', 'V'),
('CA_ESTADO_USU', '1', 'ACTIVO', 'V'),
('CA_ESTADO_USU', '2', 'INACTIVO', 'V'),
('CA_EVENTOS', '1', 'LLAMADA', 'V'),
('CA_EVENTOS', '2', 'REUNIÓN', 'V'),
('CA_EVENTOS', '3', 'VISITA', 'V'),
('CA_LINEA_NEG', '1', 'GUIA DE SOLUCIONES TIC', 'V'),
('CA_LINEA_NEG', '2', 'MAIL MARKETING', 'V'),
('CA_NIVEL_EJE', '1', 'NIVEL 1', 'V'),
('CA_NIVEL_EJE', '2', 'NIVEL 2', 'V'),
('CA_NIVEL_EJE', '3', 'NIVEL 3', 'V'),
('CA_PROCESOS_EMP', '1', 'PREVENTA', 'V'),
('CA_PROCESOS_EMP', '2', 'POSTVENTA', 'V'),
('CA_PROV_TEC', '1', 'SI', 'V'),
('CA_PROV_TEC', '2', 'NO', 'V'),
('CA_REF_PROSP_EM', '1', 'REFERIDO', 'V'),
('CA_REF_PROSP_EM', '2', 'POR INTERNET', 'V'),
('CA_REF_PROSP_EM', '3', 'EVENTO', 'V'),
('CA_SECTOR', '1', 'BASES DE DATOS', 'V'),
('CA_SECTOR', '2', 'AGROPECUARIO', 'V'),
('CA_TIPOCONT_INI', '1', 'LLAMADA AL CLIENTE', 'V'),
('CA_TIPOCONT_INI', '2', 'EL CLIENTE LLAMO', 'V'),
('CA_TIPOCONT_INI', '3', 'SE ENVIO EMAIL AL CLIENTE', 'V'),
('CA_TIPOCONT_INI', '4', 'EL CLIENTE ENVIO EMAIL', 'V');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalle_cotizacion`
--

CREATE TABLE `tb_detalle_cotizacion` (
  `dc_num_detalle` int(11) NOT NULL,
  `dc_cantidad` int(11) DEFAULT NULL,
  `dc_precio` double DEFAULT NULL,
  `dc_cotizacion` int(11) NOT NULL,
  `dc_id_producto` int(11) NOT NULL,
  `dc_cortesia` char(1) DEFAULT NULL,
  `dc_porc_descto` float NOT NULL,
  `dc_opcion` smallint(6) DEFAULT NULL,
  `dc_observacion` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_detalle_cotizacion`
--

INSERT INTO `tb_detalle_cotizacion` (`dc_num_detalle`, `dc_cantidad`, `dc_precio`, `dc_cotizacion`, `dc_id_producto`, `dc_cortesia`, `dc_porc_descto`, `dc_opcion`, `dc_observacion`) VALUES
(2, 5, 123522, 2, 1, 'N', 0, 1, 3),
(1, 5, 123522, 2, 1, 'N', 0, 1, 2),
(3, 5, 123522, 2, 1, 'N', 0, 2, 4),
(4, 5, 123522, 2, 1, 'N', 0, 2, 5),
(5, 5, 123522, 2, 1, 'N', 0, 3, 6),
(6, 5, 123522, 2, 1, 'N', 0, 3, 7),
(7, 5, 123522, 2, 1, 'N', 0, 4, 8),
(8, 5, 123522, 2, 1, 'N', 0, 4, 9),
(9, 5, 123522, 2, 1, 'N', 0, 5, 10),
(10, 5, 123522, 2, 1, 'N', 0, 5, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_ejecutivos`
--

CREATE TABLE `tb_ejecutivos` (
  `ej_estado` varchar(3) NOT NULL,
  `ej_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_ejecutivos`
--

INSERT INTO `tb_ejecutivos` (`ej_estado`, `ej_codigo`) VALUES
('1', 1),
('1', 2),
('1', 4),
('1', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_empresas`
--

CREATE TABLE `tb_empresas` (
  `em_id_empresas` int(11) NOT NULL,
  `em_nit` varchar(20) NOT NULL,
  `em_dv` varchar(1) DEFAULT NULL,
  `em_nombre` varchar(200) NOT NULL,
  `em_sector` int(11) NOT NULL,
  `em_subsector` int(11) DEFAULT NULL,
  `em_pais` varchar(3) NOT NULL,
  `em_depto` varchar(2) NOT NULL,
  `em_ciudad` varchar(5) NOT NULL,
  `em_telefono1` varchar(25) NOT NULL,
  `em_telefono2` varchar(25) DEFAULT NULL,
  `em_direccion` varchar(150) NOT NULL,
  `em_telefono3` varchar(25) DEFAULT NULL,
  `em_fax` int(11) DEFAULT NULL,
  `em_web` varchar(50) DEFAULT NULL,
  `em_anio_fundacion` int(11) DEFAULT NULL,
  `em_fecha_creacion` datetime DEFAULT NULL,
  `em_email` varchar(100) DEFAULT NULL,
  `em_actividad_princ` varchar(200) DEFAULT NULL,
  `em_ciiu1` varchar(10) DEFAULT NULL,
  `em_ciiu2` varchar(10) DEFAULT NULL,
  `em_ciiu3` varchar(10) DEFAULT NULL,
  `em_num_empleados` int(11) DEFAULT NULL,
  `em_celular` varchar(15) DEFAULT NULL,
  `em_nro_comp` int(11) DEFAULT NULL,
  `em_observaciones` varchar(200) DEFAULT NULL,
  `em_origen` varchar(20) DEFAULT NULL,
  `em_fecha_ult_mod` datetime DEFAULT NULL,
  `em_tipo_per` char(1) DEFAULT NULL,
  `em_estado` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_empresas`
--

INSERT INTO `tb_empresas` (`em_id_empresas`, `em_nit`, `em_dv`, `em_nombre`, `em_sector`, `em_subsector`, `em_pais`, `em_depto`, `em_ciudad`, `em_telefono1`, `em_telefono2`, `em_direccion`, `em_telefono3`, `em_fax`, `em_web`, `em_anio_fundacion`, `em_fecha_creacion`, `em_email`, `em_actividad_princ`, `em_ciiu1`, `em_ciiu2`, `em_ciiu3`, `em_num_empleados`, `em_celular`, `em_nro_comp`, `em_observaciones`, `em_origen`, `em_fecha_ult_mod`, `em_tipo_per`, `em_estado`) VALUES
(1, '900435250 - 7', NULL, 'DATAMARKET SOLUTIONS S.A.S', 2, NULL, '1', '1', '1', '2616977', '26171911', 'Calle 15 No. 56 - 47', NULL, 0, NULL, 0, '0000-00-00 00:00:00', NULL, NULL, NULL, '', '', 0, NULL, 0, NULL, NULL, '2017-08-31 10:31:49', '', ''),
(2, '564645', NULL, 'asdsa', 2, 2, '1', '1', '4', '56456465', NULL, 'sadasdas', NULL, NULL, NULL, NULL, '2017-07-18 20:09:36', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '333', NULL, 'FormularioNuevo', 2, 2, '1', '1', '5', '12345678', NULL, 'calle 123', NULL, NULL, NULL, NULL, '2017-08-10 16:16:42', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, '4444', NULL, 'fORMULARIONUEVO', 1, 1, '1', '1', '4', '33333', NULL, 'calle 123', NULL, NULL, NULL, NULL, '2017-08-10 16:19:55', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_empresas_prospecto`
--

CREATE TABLE `tb_empresas_prospecto` (
  `pe_empresa` int(11) NOT NULL,
  `pe_nombre` varchar(200) NOT NULL,
  `pe_numero_id` varchar(20) NOT NULL,
  `pe_dv` varchar(1) DEFAULT NULL,
  `pe_direccion` varchar(150) NOT NULL,
  `pe_departamento` varchar(2) NOT NULL,
  `pe_ciudad` varchar(5) NOT NULL,
  `pe_telefono` varchar(25) NOT NULL,
  `pe_email` varchar(100) DEFAULT NULL,
  `pe_sitio_web` varchar(50) DEFAULT NULL,
  `pe_sector` int(11) NOT NULL,
  `pe_productos` varchar(200) NOT NULL,
  `pe_referencia` varchar(2) NOT NULL,
  `pe_nombre_contacto` varchar(60) DEFAULT NULL,
  `pe_apellido_contacto` varchar(60) DEFAULT NULL,
  `pe_descripcion_funcion` varchar(255) DEFAULT NULL,
  `pe_fecha_creacion` datetime NOT NULL,
  `pe_pais` varchar(3) NOT NULL,
  `pe_ejecutivo` int(11) NOT NULL,
  `pe_cargo` varchar(15) DEFAULT NULL,
  `pe_area` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_empresas_prospecto`
--

INSERT INTO `tb_empresas_prospecto` (`pe_empresa`, `pe_nombre`, `pe_numero_id`, `pe_dv`, `pe_direccion`, `pe_departamento`, `pe_ciudad`, `pe_telefono`, `pe_email`, `pe_sitio_web`, `pe_sector`, `pe_productos`, `pe_referencia`, `pe_nombre_contacto`, `pe_apellido_contacto`, `pe_descripcion_funcion`, `pe_fecha_creacion`, `pe_pais`, `pe_ejecutivo`, `pe_cargo`, `pe_area`) VALUES
(2, 'EmpresaProspecto1', '415151-2', NULL, 'Calle 123', '1', '3', '11565116', 'correo@gmail.com', 'www.google.com', 1, 'Productos', '1', 'pepito', 'Perez', 'El no hace nada', '2017-06-22 18:30:17', '1', 1, '39', '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_empresa_comercial`
--

CREATE TABLE `tb_empresa_comercial` (
  `ec_empresa` int(11) NOT NULL,
  `ec_linea_negocio` varchar(2) NOT NULL,
  `ec_clasificacion` varchar(2) NOT NULL,
  `ec_prov_tecn` varchar(1) DEFAULT NULL,
  `ec_ejecutivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_empresa_comercial`
--

INSERT INTO `tb_empresa_comercial` (`ec_empresa`, `ec_linea_negocio`, `ec_clasificacion`, `ec_prov_tecn`, `ec_ejecutivo`) VALUES
(1, '2', '2', '1', 1),
(2, '2', '3', '1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_etapas_proceso`
--

CREATE TABLE `tb_etapas_proceso` (
  `ep_etapa` varchar(3) NOT NULL,
  `ep_sec_etapa` int(11) NOT NULL,
  `ep_desc_etapa` varchar(100) NOT NULL,
  `ep_tipo_proceso` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_etapas_proceso`
--

INSERT INTO `tb_etapas_proceso` (`ep_etapa`, `ep_sec_etapa`, `ep_desc_etapa`, `ep_tipo_proceso`) VALUES
('1', 1, 'CONTACTO INICIAL', '1'),
('2', 2, 'SEGUIMIENTO ENTREGA DE INFORMACION AL CLIENTE', '1'),
('3', 3, 'SEGUIMIENTO COTIZACION', '1'),
('4', 4, 'SOLICITUD DE INFORMACION AL CLIENTE', '1'),
('5', 5, 'ORDEN DE COMPRA', '1'),
('6', 6, 'SEGUIMIENTO FACTURA', '1'),
('7', 7, 'SEGUIMIENTO POSTVENTA', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_historial_casos`
--

CREATE TABLE `tb_historial_casos` (
  `hc_sec_historial` int(11) NOT NULL,
  `hc_sec_caso` int(11) NOT NULL,
  `hc_cod_empresa` int(11) NOT NULL,
  `h_cod_contacto` int(11) DEFAULT NULL,
  `hc_cod_etapa` varchar(2) NOT NULL,
  `hc_estado_caso` varchar(2) DEFAULT NULL,
  `hc_evento` varchar(2) DEFAULT NULL,
  `hc_cod_tarea` int(11) DEFAULT NULL,
  `hc_estado_tarea` varchar(3) DEFAULT NULL,
  `hc_anotacion` varchar(200) NOT NULL,
  `hc_fecha` datetime NOT NULL,
  `hc_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_historial_casos`
--

INSERT INTO `tb_historial_casos` (`hc_sec_historial`, `hc_sec_caso`, `hc_cod_empresa`, `h_cod_contacto`, `hc_cod_etapa`, `hc_estado_caso`, `hc_evento`, `hc_cod_tarea`, `hc_estado_tarea`, `hc_anotacion`, `hc_fecha`, `hc_usuario`) VALUES
(1, 24, 1, NULL, '1', NULL, '1', 11, '2', 'jkkhjk', '2017-04-07 16:13:56', 1),
(2, 24, 1, NULL, '1', NULL, '1', 12, '1', 'ffsdffsdf', '2017-04-28 12:46:39', 1),
(3, 24, 1, NULL, '1', NULL, '1', 13, '1', 'dfdfdf', '2017-04-28 12:53:11', 1),
(4, 30, 1, NULL, '4', NULL, '2', 25, '2', '45556', '2017-06-16 00:00:00', 1),
(5, 30, 1, NULL, '4', NULL, '1', 25, '2', 'dsfsdf', '2017-04-11 00:00:00', 1),
(6, 30, 1, NULL, '4', NULL, '2', 26, '1', 'ddasads', '2017-06-26 00:00:00', 1),
(7, 30, 1, NULL, '4', NULL, '3', 27, '2', 'PEndiente', '2017-06-24 07:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_observaciones`
--

CREATE TABLE `tb_observaciones` (
  `dc_codigo` int(11) NOT NULL,
  `dc_clase` varchar(1) NOT NULL,
  `dc_texto` varchar(150) NOT NULL,
  `ob_dc` int(11) DEFAULT NULL,
  `ob_fac` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_observaciones`
--

INSERT INTO `tb_observaciones` (`dc_codigo`, `dc_clase`, `dc_texto`, `ob_dc`, `ob_fac`) VALUES
(3, '1', 'lajslkajslk', NULL, NULL),
(2, '1', 'lajslkajslk', NULL, NULL),
(4, '1', 'lajslkajslk', NULL, NULL),
(5, '1', 'lajslkajslk', NULL, NULL),
(6, '1', 'lajslkajslk', NULL, NULL),
(7, '1', 'lajslkajslk', NULL, NULL),
(8, '1', 'lajslkajslk', NULL, NULL),
(9, '1', 'lajslkajslk', NULL, NULL),
(10, '1', 'lajslkajslk', NULL, NULL),
(11, '1', 'lajslkajslk', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_paises`
--

CREATE TABLE `tb_paises` (
  `pa_codigo` varchar(3) NOT NULL,
  `pa_nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_paises`
--

INSERT INTO `tb_paises` (`pa_codigo`, `pa_nombre`) VALUES
('1', 'Colombia'),
('10', 'Ecuador'),
('11', 'Bolivia'),
('12', 'Chile'),
('13', 'Panamá'),
('14', 'México'),
('16', 'Guatemala'),
('17', 'Haiti'),
('18', 'El Salvador'),
('19', 'Republica dominicana'),
('2', 'Venezuela'),
('21', 'Puerto Rico'),
('3', 'Rusia'),
('4', 'Brasil'),
('5', 'Uruguay'),
('6', 'Guayana Francesa'),
('7', 'Paraguay'),
('8', 'Argentina'),
('9', 'Peru');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_productos`
--

CREATE TABLE `tb_productos` (
  `pr_codigo` int(11) NOT NULL,
  `pr_nombre` varchar(100) DEFAULT NULL,
  `pr_precio` double DEFAULT NULL,
  `pr_stock` int(11) DEFAULT NULL,
  `pr_categoria` varchar(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_productos`
--

INSERT INTO `tb_productos` (`pr_codigo`, `pr_nombre`, `pr_precio`, `pr_stock`, `pr_categoria`) VALUES
(1, 'Producto1', 123522, 23, 'C1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_sector_economico`
--

CREATE TABLE `tb_sector_economico` (
  `se_codigo` int(11) NOT NULL,
  `se_descripcion` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_sector_economico`
--

INSERT INTO `tb_sector_economico` (`se_codigo`, `se_descripcion`) VALUES
(1, 'AGROPECUARIO'),
(2, 'BASES DE DATOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_sequence`
--

CREATE TABLE `tb_sequence` (
  `seq_dc_num_detalle` bigint(20) DEFAULT NULL,
  `seq_dc_cotizacion` bigint(20) DEFAULT NULL,
  `seq_key` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tareas_empresas`
--

CREATE TABLE `tb_tareas_empresas` (
  `te_sec_tarea` int(11) NOT NULL,
  `te_caso` int(11) NOT NULL,
  `te_evento` varchar(3) NOT NULL,
  `te_fecha_inicial` datetime NOT NULL,
  `te_estado` varchar(3) NOT NULL,
  `te_fecha_fin` datetime DEFAULT NULL,
  `te_descripcion` varchar(200) NOT NULL,
  `te_responsable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_tareas_empresas`
--

INSERT INTO `tb_tareas_empresas` (`te_sec_tarea`, `te_caso`, `te_evento`, `te_fecha_inicial`, `te_estado`, `te_fecha_fin`, `te_descripcion`, `te_responsable`) VALUES
(24, 30, '2', '2017-06-22 00:00:00', '2', '2017-06-23 00:00:00', 'tarea1', 1),
(25, 30, '1', '2017-04-11 00:00:00', '1', '2017-04-12 23:00:00', 'tarea2', 1),
(27, 30, '3', '2017-06-30 07:00:00', '2', '2017-06-30 10:00:00', 'PEndiented', 2);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `usuariosporrol`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `usuariosporrol` (
`us_login` varchar(10)
,`us_password` varchar(35)
,`ro_descripcion` varchar(255)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `usuariosporrol2`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `usuariosporrol2` (
`us_login` varchar(10)
,`us_password` varchar(35)
,`ro_descripcion` varchar(255)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `usuariosporrol`
--
DROP TABLE IF EXISTS `usuariosporrol`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `usuariosporrol`  AS  select `tb_adm_usuarios`.`us_login` AS `us_login`,`tb_adm_usuarios`.`us_password` AS `us_password`,`tb_adm_roles`.`ro_descripcion` AS `ro_descripcion` from (`tb_adm_usuarios` join `tb_adm_roles`) where (`tb_adm_usuarios`.`us_rol` = `tb_adm_roles`.`ro_codigo`) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `usuariosporrol2`
--
DROP TABLE IF EXISTS `usuariosporrol2`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `usuariosporrol2`  AS  select `tb_adm_usuarios`.`us_login` AS `us_login`,`tb_adm_usuarios`.`us_password` AS `us_password`,`tb_adm_roles`.`ro_descripcion` AS `ro_descripcion` from (`tb_adm_usuarios` join `tb_adm_roles`) where (`tb_adm_usuarios`.`us_rol` = `tb_adm_roles`.`ro_codigo`) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indices de la tabla `tb_adm_grupos`
--
ALTER TABLE `tb_adm_grupos`
  ADD PRIMARY KEY (`gr_nombre_grupo`);

--
-- Indices de la tabla `tb_adm_roles`
--
ALTER TABLE `tb_adm_roles`
  ADD PRIMARY KEY (`ro_codigo`);

--
-- Indices de la tabla `tb_adm_usuarios`
--
ALTER TABLE `tb_adm_usuarios`
  ADD PRIMARY KEY (`us_cod_usuario`),
  ADD KEY `fk_tb_adm_usuarios_tb_roles` (`us_rol`);

--
-- Indices de la tabla `tb_casos_empresas`
--
ALTER TABLE `tb_casos_empresas`
  ADD PRIMARY KEY (`ce_sec_caso`),
  ADD KEY `fk_tb_casos_empresas_tb_empresa_comercial1_idx` (`ce_empresa`);

--
-- Indices de la tabla `tb_ciudades`
--
ALTER TABLE `tb_ciudades`
  ADD PRIMARY KEY (`CI_PAIS`,`CI_DEPTO`,`CI_CIUDAD`),
  ADD KEY `CI_DEPTO` (`CI_DEPTO`);

--
-- Indices de la tabla `tb_contactos_empresas`
--
ALTER TABLE `tb_contactos_empresas`
  ADD PRIMARY KEY (`ce_secuencial`),
  ADD KEY `fk_tb_contactos_tb_empresas` (`ce_codigo_empresa`);

--
-- Indices de la tabla `tb_cotizaciones`
--
ALTER TABLE `tb_cotizaciones`
  ADD PRIMARY KEY (`co_cod_cotiz`),
  ADD KEY `fk_tb_cotizaciones_tb_casos_empresas` (`co_caso`);

--
-- Indices de la tabla `tb_departamentos`
--
ALTER TABLE `tb_departamentos`
  ADD PRIMARY KEY (`de_pais`,`de_codigo`);

--
-- Indices de la tabla `tb_detalle_catalogo`
--
ALTER TABLE `tb_detalle_catalogo`
  ADD PRIMARY KEY (`dc_catalogo`,`dc_codigo`);

--
-- Indices de la tabla `tb_detalle_cotizacion`
--
ALTER TABLE `tb_detalle_cotizacion`
  ADD PRIMARY KEY (`dc_num_detalle`,`dc_cotizacion`),
  ADD KEY `fk_tb_detalle_cotizacion_tb_cotizaciones` (`dc_cotizacion`);

--
-- Indices de la tabla `tb_ejecutivos`
--
ALTER TABLE `tb_ejecutivos`
  ADD PRIMARY KEY (`ej_codigo`);

--
-- Indices de la tabla `tb_empresas`
--
ALTER TABLE `tb_empresas`
  ADD PRIMARY KEY (`em_id_empresas`);

--
-- Indices de la tabla `tb_empresas_prospecto`
--
ALTER TABLE `tb_empresas_prospecto`
  ADD PRIMARY KEY (`pe_empresa`);

--
-- Indices de la tabla `tb_empresa_comercial`
--
ALTER TABLE `tb_empresa_comercial`
  ADD PRIMARY KEY (`ec_empresa`),
  ADD KEY `fk_tb_empresa_comercial_tb_ejecutivos` (`ec_ejecutivo`);

--
-- Indices de la tabla `tb_etapas_proceso`
--
ALTER TABLE `tb_etapas_proceso`
  ADD PRIMARY KEY (`ep_sec_etapa`,`ep_etapa`);

--
-- Indices de la tabla `tb_historial_casos`
--
ALTER TABLE `tb_historial_casos`
  ADD PRIMARY KEY (`hc_sec_historial`);

--
-- Indices de la tabla `tb_observaciones`
--
ALTER TABLE `tb_observaciones`
  ADD PRIMARY KEY (`dc_codigo`);

--
-- Indices de la tabla `tb_paises`
--
ALTER TABLE `tb_paises`
  ADD PRIMARY KEY (`pa_codigo`);

--
-- Indices de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  ADD PRIMARY KEY (`pr_codigo`);

--
-- Indices de la tabla `tb_sector_economico`
--
ALTER TABLE `tb_sector_economico`
  ADD PRIMARY KEY (`se_codigo`);

--
-- Indices de la tabla `tb_sequence`
--
ALTER TABLE `tb_sequence`
  ADD PRIMARY KEY (`seq_key`);

--
-- Indices de la tabla `tb_tareas_empresas`
--
ALTER TABLE `tb_tareas_empresas`
  ADD PRIMARY KEY (`te_sec_tarea`),
  ADD KEY `fk_Tarea_Caso` (`te_caso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_casos_empresas`
--
ALTER TABLE `tb_casos_empresas`
  MODIFY `ce_sec_caso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `tb_contactos_empresas`
--
ALTER TABLE `tb_contactos_empresas`
  MODIFY `ce_secuencial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=352;
--
-- AUTO_INCREMENT de la tabla `tb_historial_casos`
--
ALTER TABLE `tb_historial_casos`
  MODIFY `hc_sec_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tb_observaciones`
--
ALTER TABLE `tb_observaciones`
  MODIFY `dc_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  MODIFY `pr_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `tb_sequence`
--
ALTER TABLE `tb_sequence`
  MODIFY `seq_key` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tb_tareas_empresas`
--
ALTER TABLE `tb_tareas_empresas`
  MODIFY `te_sec_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_adm_usuarios`
--
ALTER TABLE `tb_adm_usuarios`
  ADD CONSTRAINT `fk_tb_adm_usuarios_tb_roles` FOREIGN KEY (`us_rol`) REFERENCES `tb_adm_roles` (`ro_codigo`);

--
-- Filtros para la tabla `tb_casos_empresas`
--
ALTER TABLE `tb_casos_empresas`
  ADD CONSTRAINT `fk_tb_casos_empresas_tb_empresa_comercial1` FOREIGN KEY (`ce_empresa`) REFERENCES `tb_empresa_comercial` (`ec_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_contactos_empresas`
--
ALTER TABLE `tb_contactos_empresas`
  ADD CONSTRAINT `fk_tb_contactos_tb_empresas` FOREIGN KEY (`ce_codigo_empresa`) REFERENCES `tb_empresas` (`em_id_empresas`);

--
-- Filtros para la tabla `tb_departamentos`
--
ALTER TABLE `tb_departamentos`
  ADD CONSTRAINT `fk_tb_departamentos_tb_paises` FOREIGN KEY (`de_pais`) REFERENCES `tb_paises` (`pa_codigo`);

--
-- Filtros para la tabla `tb_ejecutivos`
--
ALTER TABLE `tb_ejecutivos`
  ADD CONSTRAINT `fk_tb_ejecutivos_tb_adm_usuarios` FOREIGN KEY (`ej_codigo`) REFERENCES `tb_adm_usuarios` (`us_cod_usuario`);

--
-- Filtros para la tabla `tb_empresa_comercial`
--
ALTER TABLE `tb_empresa_comercial`
  ADD CONSTRAINT `fk_tb_empresa_comercial_tb_ejecutivos` FOREIGN KEY (`ec_ejecutivo`) REFERENCES `tb_ejecutivos` (`ej_codigo`),
  ADD CONSTRAINT `fk_tb_empresa_comercial_tb_empresas` FOREIGN KEY (`ec_empresa`) REFERENCES `tb_empresas` (`em_id_empresas`);

--
-- Filtros para la tabla `tb_tareas_empresas`
--
ALTER TABLE `tb_tareas_empresas`
  ADD CONSTRAINT `fk_Tarea_Caso` FOREIGN KEY (`te_caso`) REFERENCES `tb_casos_empresas` (`ce_sec_caso`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
