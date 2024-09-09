--
-- Base de datos: `spcolegio`

CREATE TABLE `alumnos` (
  `Id` int(11) NOT NULL  PRIMARY KEY AUTO_INCREMENT ,
   `Apellidos` varchar(60) NOT NULL,
    `Celular` int(10) NULL,  
  `Dni` int(8) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Sexo` varchar(20) NOT NULL,
  `Dniapo` int(8) NOT NULL  
) ;
ALTER TABLE `alumnos`ADD PRIMARY KEY (`Id`);

CREATE TABLE `ano_escolares` (
  `Id` int(11) NOT NULL PRIMARY KEY,
   `Estado` varchar(10) NOT NULL,
    `Fecha_Fin` date NOT NULL,
     `Fecha_Inicio` date NOT NULL,
  `Nombre` varchar(20) NOT NULL 
) ;
CREATE TABLE `calendarios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `concepto` varchar(80) NOT NULL,
    `flimite` date  NULL,
     `mes` varchar(50) NOT NULL,
  `monto` int NOT NULL 
) ;

--
-- Volcado de datos para la tabla `anio_escolar`
--

INSERT INTO `ano_escolarES` (`Id`, `Nombre`, `Fecha_Inicio`, `Fecha_Fin`, `Estado`) VALUES
(3, 'Año del Bicentendel', '2022-06-10', '2022-12-29', 'Activo'),
(4, 'Año del Bicenten 2021', '2023-05-10', '2023-12-30', 'Activo');

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grados` (
  `Id` int(11) NOT NULL PRIMARY KEY,  
   `Estado` varchar(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL, 
  `Codigo_AE` int(11) NOT NULL
) ;

--

INSERT INTO `grado` (`Id`, `Nombre`, `Estado`, `Codigo_AE`) VALUES
(1, '1 Secundaria', 'Activo', 1),
(2, '2 Secundaria', 'Activo', 1);

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matriculas` (
  `Id` int(11) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  `Fecha_Matricula` date  NULL,  
  `Codigo_Alum` int(11) NOT NULL,
  `Codigo_AE` int(11) NOT NULL
) ;
CREATE TABLE `pagos` (
  `Id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Estado` varchar(10) NOT NULL,
  `Fecha` date  NULL,
  `Monto` int NOT NULL,
  `calendario_id` int(11) NOT NULL,
  `matricula_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL 
) ;
ALTER TABLE `pagos`
  ADD CONSTRAINT `FK_pago` FOREIGN KEY (`Codigo_Matricula`) REFERENCES `matricula` (`Id`);

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matriculas` (`Id`, `Fecha_Matricula`, `Estado`, `Codigo_Alum`, `Codigo_ae`) VALUES
(4, '2021-04-20', 'Activo', 17, 4),
(5, '2021-05-05', 'Activo', 18, 4);

-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apoderado`
--

CREATE TABLE `apoderados` (
  `Dni` int(8) NOT NULL PRIMARY KEY,
   `Apellidos` varchar(60)  NULL,  
   `Celular` INT(9)  NULL,
   `Correo` varchar(50)  NULL,
   `Direccion` varchar(50)  NULL,  
  `Nombres` varchar(50)  NULL,  
  `Sexo` varchar(20)  NULL 
) ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`Id`, `Nombres`, `Ape_Paterno`, `Ape_Materno`, `Dni`, `Genero`, `Correo`, `Telefono`, `Direccion`, `Fecha_Creacion`) VALUES
(1, 'Carlos', 'Riojas', 'Chapoñan', '42158745', 'Masculino', 'carlosriojas42@gmail.com', '965248752', 'Av. Balta 48', '2021-09-03'),
(2, 'Juan', 'Romero', 'Sanchez', '75241563', 'Masculino', 'juanromero@gmail.com', '963254125', 'Av. Molina 420', '2021-09-02'),
(4, 'Luisa', 'Ramirez', 'Gutierrez', '72154852', 'Femenino', 'La victoria', '963254125', 'luisaramirez72@gmail.com', '2021-09-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `secciones` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,  
  `Estado` varchar(10) NOT NULL,
  `Codigo_Grado` int(11) NOT NULL
);

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `secciones` (`Id`, `Nombre`, `Estado`, `Codigo_Grado`) VALUES
(1, 'S101', 'Activo', 9),
(2, 'S201', 'Activo', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL PRIMARY KEY, 
  `Apellidos` varchar(60) NOT NULL,  
  `Clave` varchar(20) NOT NULL,  
  `Dni` varchar(8) NOT NULL,
   `estado` varchar(8) NOT NULL,
    `Nombre` varchar(50) NOT NULL,
  `User` varchar(20) NOT NULL  
) ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id`, `Nombre`, `Clave`, `Tipo`, `Descripcion`, `Estado`, `Codigo_Persona`) VALUES
(1, 'admin', '1234', 'A', 'Administrador', 'Activo', 1),
(2, 'secre', '1234', 'S', 'Secretaria', 'Activo', 4);


ALTER TABLE `ano_escolar`ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Escolar_Grado` (`Codigo_AE`);

-- Indices de la tabla `apoderado`
--
ALTER TABLE `apoderado`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`Id`);
  
--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`);
  
--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--

--
ALTER TABLE `anio_escolar`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
--
-- AUTO_INCREMENT de la tabla `grado`
--
ALTER TABLE `grado`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `apoderado`
--
ALTER TABLE `apoderado`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `seccion`
--
ALTER TABLE `seccion`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
----
-- Filtros para la tabla `grado`
--
ALTER TABLE `grado`
  ADD CONSTRAINT `FK_Escolar_Grado` FOREIGN KEY (`Codigo_AE`) REFERENCES `ano_escolar` (`Id`);


--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `FK_Alumno_Matricula` FOREIGN KEY (`Codigo_Alumno`) REFERENCES `alumno` (`Id`),
  ADD CONSTRAINT `FK_Grado_Matricula` FOREIGN KEY (`Codigo_Grado`) REFERENCES `grado` (`Id`);

--
-- Filtros para la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD CONSTRAINT `FK_Grado_Seccion` FOREIGN KEY (`Codigo_Grado`) REFERENCES `grado` (`Id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_Per_Usuario` FOREIGN KEY (`Codigo_Persona`) REFERENCES `persona` (`Id`);
COMMIT;

