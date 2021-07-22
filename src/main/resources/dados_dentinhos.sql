use dentinhos;

INSERT INTO turn_status(name, description) 
values('Concluido','Consulta concluido'),
('Cancelado','Consulta cancelado'),
('Pendente','Consulta pendente');

INSERT INTO address (street, district) VALUES
('Rua dos alphaneiros', 'Barra'),
('Rua Parque da agua branca', 'Lapa'),
('Rua Alpha Numeros', 'Porto');

INSERT INTO user (name, last_name, dni, birth_date, phone, email, password, user_status, id_address) VALUES
('dentinho0', 'dba0',  'DNIDNI0', '1990-07-21', '99009900', 'dentinho_2000@meli.com', 'dente', 'active', 1),
('dentinho1', 'dba1',  'DNIDNI1', '1990-07-21', '99009900', 'dentinho_2001@meli.com', 'dente', 'active', 2),
('dentinho2', 'dba2',  'DNIDNI2', '1990-07-21', '99009900', 'dentinho_2002@meli.com', 'dente', 'active', 3),
('dentinho3', 'dba3',  'DNIDNI3', '1990-07-21', '99009900', 'dentinho_2003@meli.com', 'dente', 'active', 1),
('dentinho4', 'dba4',  'DNIDNI4', '1990-07-21', '99009900', 'dentinho_2004@meli.com', 'dente', 'active', 2),
('dentinho5', 'dba5',  'DNIDNI5', '1990-07-21', '99009900', 'dentinho_2005@meli.com', 'dente', 'active', 3),
('dentinho6', 'dba6',  'DNIDNI6', '1990-07-21', '99009900', 'dentinho_2006@meli.com', 'dente', 'active', 1),
('dentinho7', 'dba7',  'DNIDNI7', '1990-07-21', '99009900', 'dentinho_2007@meli.com', 'dente', 'active', 2),
('dentinho8', 'dba8',  'DNIDNI8', '1990-07-21', '99009900', 'dentinho_2008@meli.com', 'dente', 'active', 3),
('dentinho9', 'dba9',  'DNIDNI9', '1990-07-21', '99009900', 'dentinho_2009@meli.com', 'dente', 'active', 1);

INSERT INTO dentists(id_user, code_mp) VALUES
(1,'124bc'), 
(2,'456de'),
(3,'789fg');

INSERT INTO diaries(start_time, ending_time, id_dentist) VALUES
('2021-07-21 09:00:00','2021-07-21 18:00:00',1),
('2021-07-22 09:00:00','2021-07-22 18:00:00',2),
('2021-07-23 09:00:00','2021-07-23 18:00:00',3);

INSERT INTO turns(days, id_diary, id_turn_status, id_patient) VALUES
('2021-07-21',1,1,4),
('2021-07-21',1,2,5),
('2021-07-21',1,3,6),
('2022-07-22',2,1,7),
('2021-07-22',2,2,8),
('2021-07-22',2,3,9),
('2021-07-23',3,1,4),
('2021-07-23',3,2,5),
('2021-07-23',3,3,6);