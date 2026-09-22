CREATE TABLE pacientes (
    paciente_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    telefono VARCHAR(20),
    PRIMARY KEY (paciente_id),
    CONSTRAINT unique_nombre_fnac UNIQUE (nombre, fecha_nacimiento)
);

CREATE TABLE medicos (
    medico_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    especialidad VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    PRIMARY KEY (medico_id)
);

CREATE TABLE historia_clinica (
    historia_id INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    diagnostico TEXT,
    fecha_admision DATE,
    PRIMARY KEY (historia_id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(paciente_id),
    FOREIGN KEY (medico_id) REFERENCES medicos(medico_id)
);

CREATE TABLE citas (
    cita_id INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    fecha_cita DATETIME,
    PRIMARY KEY (cita_id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(paciente_id),
    FOREIGN KEY (medico_id) REFERENCES medicos(medico_id)
);
CREATE TABLE recetas (
    receta_id INT NOT NULL AUTO_INCREMENT,
    historia_id INT NOT NULL,
    medicamento VARCHAR(100),
    dosis VARCHAR(50),
    PRIMARY KEY (receta_id),
    FOREIGN KEY (historia_id) REFERENCES historia_clinica(historia_id)
);

CREATE TABLE facturas (
    factura_id INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    cantidad DECIMAL(10,2),
    fecha_pago DATE,
    PRIMARY KEY (factura_id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(paciente_id)
);

CREATE TABLE usuarios (
    usuario_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    paciente_id INT,
	medico_id INT,
    PRIMARY KEY (usuario_id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(paciente_id),
	FOREIGN KEY (medico_id) REFERENCES medicos(medico_id)
);

-- Datos de la tabla pacientes
INSERT INTO pacientes (nombre, fecha_nacimiento, telefono)
VALUES 
    ('John Smith', '1980-05-15', '555-1234'),
    ('Emily Johnson', '1975-10-20', '555-5678'),
    ('Michael Brown', '1992-03-08', '555-4321');

-- Datos de la tabla medicos
INSERT INTO medicos (nombre, especialidad, telefono)
VALUES 
    ('Dr. Sarah White', 'Cardiología', '555-1111'),
    ('Dr. David Miller', 'Pediatría', '555-2222'),
    ('Dr. Laura Wilson', 'Dermatología', '555-3333');

-- Datos de la tabla historia_clinica
INSERT INTO historia_clinica (paciente_id, medico_id, diagnostico, fecha_admision)
VALUES 
    (1, 1, 'Hipertensión', '2023-01-10'),
    (2, 2, 'Infección Respiratoria', '2023-02-05'),
    (3, 3, 'Dermatitis', '2023-03-15');

-- Datos de la tabla citas
INSERT INTO citas (paciente_id, medico_id, fecha_cita)
VALUES 
    (1, 1, '2023-01-15 09:00:00'),
    (2, 2, '2023-02-10 10:30:00'),
    (3, 3, '2023-03-20 14:00:00');

-- Datos de la tabla recetas
INSERT INTO recetas (historia_id, medicamento, dosis)
VALUES 
    (1, 'Losartan', '50mg'),
    (2, 'Amoxicilina', '500mg'),
    (3, 'Crema hidratante', 'A demanda');

-- Datos de la tabla facturas
INSERT INTO facturas (paciente_id, cantidad, fecha_pago)
VALUES 
    (1, 150.00, '2023-01-20'),
    (2, 100.00, '2023-02-15'),
    (3, 80.00, '2023-03-25');

-- Datos de la tabla usuarios
INSERT INTO usuarios (username, password, paciente_id, medico_id)
VALUES 
    ('patient1', 'passwordp1', 1, NULL),
    ('patient2', 'passwordp2', 2, NULL),
	('patient3', 'passwordp3', 3, NULL),
	('doctor1', 'passwordd1', NULL, 1),
	('doctor2', 'passwordd2', NULL, 2),
	('doctor3', 'passwordd3', NULL, 3),
    ('root', 'quevedo2dam', NULL, NULL);  