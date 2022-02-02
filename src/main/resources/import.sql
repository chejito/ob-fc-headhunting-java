--Países
INSERT INTO countries (name) VALUES ('España')
INSERT INTO countries (name) VALUES ('Argentina')
INSERT INTO countries (name) VALUES ('México')
INSERT INTO countries (name) VALUES ('Colombia')
INSERT INTO countries (name) VALUES ('Perú')

--Ciudades
INSERT INTO cities (name, country_id) VALUES ('Madrid', 1)
INSERT INTO cities (name, country_id) VALUES ('Barcelona', 1)
INSERT INTO cities (name, country_id) VALUES ('Valencia', 1)
INSERT INTO cities (name, country_id) VALUES ('Sevilla', 1)
INSERT INTO cities (name, country_id) VALUES ('Zaragoza', 1)
INSERT INTO cities (name, country_id) VALUES ('Málaga', 1)
INSERT INTO cities (name, country_id) VALUES ('Murcia', 1)
INSERT INTO cities (name, country_id) VALUES ('Palma de Mallorca', 1)
INSERT INTO cities (name, country_id) VALUES ('Las Palmas de G.C.', 1)
INSERT INTO cities (name, country_id) VALUES ('Bilbao', 1)

INSERT INTO cities (name, country_id) VALUES ('Buenos Aires', 2)
INSERT INTO cities (name, country_id) VALUES ('Córdoba', 2)
INSERT INTO cities (name, country_id) VALUES ('Rosario', 2)
INSERT INTO cities (name, country_id) VALUES ('Mar del Plata', 2)
INSERT INTO cities (name, country_id) VALUES ('San Miguel de Tucumán', 2)
INSERT INTO cities (name, country_id) VALUES ('Salta', 2)
INSERT INTO cities (name, country_id) VALUES ('Santa Fe', 2)
INSERT INTO cities (name, country_id) VALUES ('Corrientes', 2)
INSERT INTO cities (name, country_id) VALUES ('Bahía Blanca', 2)
INSERT INTO cities (name, country_id) VALUES ('Resistencia', 2)

INSERT INTO cities (name, country_id) VALUES ('Ciudad de México', 3)
INSERT INTO cities (name, country_id) VALUES ('Tijuana', 3)
INSERT INTO cities (name, country_id) VALUES ('San Cristóbal Ecatepec', 3)
INSERT INTO cities (name, country_id) VALUES ('León', 3)
INSERT INTO cities (name, country_id) VALUES ('Puebla de Zaragoza', 3)
INSERT INTO cities (name, country_id) VALUES ('Ciudad Juárez', 3)
INSERT INTO cities (name, country_id) VALUES ('Guadalajara', 3)
INSERT INTO cities (name, country_id) VALUES ('Zapopan', 3)
INSERT INTO cities (name, country_id) VALUES ('Monterrey', 3)
INSERT INTO cities (name, country_id) VALUES ('Nezahualcóyotl', 3)

INSERT INTO cities (name, country_id) VALUES ('Bogotá', 4)
INSERT INTO cities (name, country_id) VALUES ('Medellín', 4)
INSERT INTO cities (name, country_id) VALUES ('Cali', 4)
INSERT INTO cities (name, country_id) VALUES ('Barranquilla', 4)
INSERT INTO cities (name, country_id) VALUES ('Cartagena', 4)
INSERT INTO cities (name, country_id) VALUES ('Cúcuta', 4)
INSERT INTO cities (name, country_id) VALUES ('Soacha', 4)
INSERT INTO cities (name, country_id) VALUES ('Soledad', 4)
INSERT INTO cities (name, country_id) VALUES ('Bucaramanga', 4)
INSERT INTO cities (name, country_id) VALUES ('Bello', 4)

INSERT INTO cities (name, country_id) VALUES ('Lima', 5)
INSERT INTO cities (name, country_id) VALUES ('Arequipa', 5)
INSERT INTO cities (name, country_id) VALUES ('Callao', 5)
INSERT INTO cities (name, country_id) VALUES ('Trujillo', 5)
INSERT INTO cities (name, country_id) VALUES ('Chiclayo', 5)
INSERT INTO cities (name, country_id) VALUES ('Piura', 5)
INSERT INTO cities (name, country_id) VALUES ('Huancayo', 5)
INSERT INTO cities (name, country_id) VALUES ('Cusco', 5)
INSERT INTO cities (name, country_id) VALUES ('Iquitos', 5)
INSERT INTO cities (name, country_id) VALUES ('Chimbote', 5)

--Usuarios
INSERT INTO users (full_name, user_name, email, password) VALUES ('user1 LastName1', 'user1', 'user1@example.com', '$2a$10$5Tb69TAsbNtD0GUbeaWn7eJOMYsFfylumUsnu.R5zA9Jh7.hSVubC'); --12345
INSERT INTO users (full_name, user_name, email, password) VALUES ('FirstName2 LastName2', 'user2', 'user2@example.com', '$2a$10$WzzQkbuSZTnUvLqhVpk1Cug7P/Tpr16tyNgH3/qtM6.WCjtwI/mUK'); --user5
INSERT INTO users (full_name, user_name, email, password) VALUES ('FirstName3 LastName3', 'user3', 'user3@example.com', '$2a$10$2H2Gnl5YuLBpYhcSlDvZIexAI6GUJqFzW3Tn4enJhoA5Typ2zQjF6'); --abcde

--Etiquetas
INSERT INTO tags (name) VALUES ('html-css');
INSERT INTO tags (name) VALUES ('bootstrap');
INSERT INTO tags (name) VALUES ('tailwind');
INSERT INTO tags (name) VALUES ('javascript');
INSERT INTO tags (name) VALUES ('angular');
INSERT INTO tags (name) VALUES ('react');
INSERT INTO tags (name) VALUES ('vue');
INSERT INTO tags (name) VALUES ('node');
INSERT INTO tags (name) VALUES ('java');
INSERT INTO tags (name) VALUES ('springboot');
INSERT INTO tags (name) VALUES ('php');
INSERT INTO tags (name) VALUES ('symfony');
INSERT INTO tags (name) VALUES ('laravel');
INSERT INTO tags (name) VALUES ('drupal');
INSERT INTO tags (name) VALUES ('wordpress');
INSERT INTO tags (name) VALUES ('magento');
INSERT INTO tags (name) VALUES ('python');
INSERT INTO tags (name) VALUES ('django');
INSERT INTO tags (name) VALUES ('flask');
INSERT INTO tags (name) VALUES ('fastapi');
INSERT INTO tags (name) VALUES ('c#');
INSERT INTO tags (name) VALUES ('.net');
INSERT INTO tags (name) VALUES ('unity3d');
INSERT INTO tags (name) VALUES ('kotlin');
INSERT INTO tags (name) VALUES ('android');
INSERT INTO tags (name) VALUES ('swift');
INSERT INTO tags (name) VALUES ('ios');
INSERT INTO tags (name) VALUES ('go');
INSERT INTO tags (name) VALUES ('gin');
INSERT INTO tags (name) VALUES ('gorilla');
INSERT INTO tags (name) VALUES ('scala');
INSERT INTO tags (name) VALUES ('spark');
INSERT INTO tags (name) VALUES ('dart');
INSERT INTO tags (name) VALUES ('flutter');
INSERT INTO tags (name) VALUES ('git');
INSERT INTO tags (name) VALUES ('docker');
INSERT INTO tags (name) VALUES ('kubernetes');


--Alumnos
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Álvaro Sánchez Monteagudo', '+34 657 85 25 46', 'smonteagudo@gmail.com', 'España', 'Valencia', true, true, '','', 1)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Amparo Herrera Climent', '+34 689 25 48 65', 'hcliment@gmail.com', 'España', 'Sevilla', true, false, '','', 1)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Ana Gutierrez Lozano', '+34 925 65 87 658', 'glozano@gmail.com', 'España', 'Valencia', false, true, '','', 2)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Antonio Miguel Lacunza', '+34 658 95 24 56', 'mlacunza@gmail.com', 'España', 'Madrid', true, true, '','', 3)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Antonio Delgado Jimeno', '+34 925 65 54 25', 'djimeno@gmail.com', 'España', 'Gijón', false, false, '','', 1)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Belén Jerez Rivera', '+34 697 82 95 24', 'jrivera@gmail.com', 'España', 'Barcelona', false, true, '','', 3)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Carla Barroso Soriano', '+34 958 65 41 54', 'bsoriano@gmail.com', 'España', 'Valencia', true, true, '','', 2)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Carlos Yuste Guerrero', '+34 697 82 95 65', 'yguerrero@gmail.com', 'España', 'Oviedo', false, true, '','', 2)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Carmina Pérez López', '+34 695 84 62 54', 'plopez@gmail.com', 'España', 'Lugo', false, true, '','', 2)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Joaquín López Massani', '+54 9 11 1234-5678', 'lmassani@gmail.com', 'Argentina', 'Buenos Aires', true, true, '','', 1)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('José Alberto López Martínez', '+57 6045904614', 'lmartinez@gmail.com', 'Colombia', 'Medellín', false, true, '','', 2)
INSERT INTO students (full_name, phone_number, email, country, city, remote, mobility, resumee_url, photo_url, user_id) VALUES ('Jéssica María Sánchez Montoya', '+52 483 1212891', 'smontoya@gmail.com', 'México', 'Ciudad de México', false, false, '','', 3)


--Alumnos-Etiquetas
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 8)
INSERT INTO students_tags (student_id, tag_id) VALUES (1, 19)

INSERT INTO students_tags (student_id, tag_id) VALUES (2, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (2, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (2, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (2, 6)

INSERT INTO students_tags (student_id, tag_id) VALUES (3, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (3, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (3, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (3, 6)

INSERT INTO students_tags (student_id, tag_id) VALUES (4, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (4, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (4, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (4, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (4, 8)

INSERT INTO students_tags (student_id, tag_id) VALUES (5, 1)

INSERT INTO students_tags (student_id, tag_id) VALUES (6, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (6, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (6, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (6, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (6, 8)
INSERT INTO students_tags (student_id, tag_id) VALUES (6, 19)

INSERT INTO students_tags (student_id, tag_id) VALUES (7, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (7, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (7, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (7, 7)
INSERT INTO students_tags (student_id, tag_id) VALUES (7, 11)
INSERT INTO students_tags (student_id, tag_id) VALUES (7, 13)

INSERT INTO students_tags (student_id, tag_id) VALUES (8, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 5)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 9)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 10)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 19)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 23)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 24)
INSERT INTO students_tags (student_id, tag_id) VALUES (8, 35)

--INSERT INTO students_tags (student_id, tag_id) VALUES (9, 1)

INSERT INTO students_tags (student_id, tag_id) VALUES (10, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (10, 4)

INSERT INTO students_tags (student_id, tag_id) VALUES (11, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (11, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (11, 6)
INSERT INTO students_tags (student_id, tag_id) VALUES (11, 9)
INSERT INTO students_tags (student_id, tag_id) VALUES (11, 10)

INSERT INTO students_tags (student_id, tag_id) VALUES (12, 1)
INSERT INTO students_tags (student_id, tag_id) VALUES (12, 4)
INSERT INTO students_tags (student_id, tag_id) VALUES (12, 9)
INSERT INTO students_tags (student_id, tag_id) VALUES (12, 10)



