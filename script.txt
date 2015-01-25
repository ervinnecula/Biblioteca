  drop table carti cascade constraints;
  drop table imprumutCarte cascade constraints;
  drop table imprumutFilm cascade constraints;
  drop table autori cascade constraints;
  drop table persoane cascade constraints;
  drop table filme cascade constraints;
  drop materialized view log on imprumutCarte;
  drop materialized view view_nr_borrowed_books;
  

  create table autori(
  cod_autor number(4) PRIMARY KEY,
  nume varchar2(50),
  an_nastere number(4),
  nationalitate varchar2(20)
  );
  
  create table persoane(
  id_persoana number(5) PRIMARY KEY,
  nume varchar2(50),
  adresa varchar2(100),
  email varchar2(50),
  telefon varchar2(40),
  password varchar2(40),
  admin number(1)
  );
  
  create table carti (
  id_carte number(3) PRIMARY KEY,
  nume varchar2(150),
  cod_autor number(4),
  gen varchar2(30),
  editura varchar2(100),
  an_aparitie number(4),
  limba varchar2(20),
  CONSTRAINT fk_carti FOREIGN KEY (cod_autor) REFERENCES autori(cod_autor)
  );
  
  create table filme (
  id_film number(3) PRIMARY KEY,
  nume varchar2(150),
  regizor varchar2(50),
  gen varchar2(30),
  an_aparitie number(4),
  nota_vot number(2,1)
  );
  
  create table imprumutCarte (
  cod_imprumut number(4) PRIMARY KEY,
  id_carte number(3),
  id_persoana number(5),
  data_imprumut DATE,
  FOREIGN KEY (id_carte) REFERENCES carti(id_carte),
  FOREIGN KEY (id_persoana) REFERENCES persoane(id_persoana),
  CONSTRAINT unicitate UNIQUE (id_carte ,id_persoana)
  );
  
  create table imprumutFilm(
  cod_imprumut number(4) PRIMARY KEY,
  id_film number(4),
  id_persoana number(5),
  data_imprumut DATE,
  FOREIGN KEY (id_film) REFERENCES filme(id_film),
  FOREIGN KEY (id_persoana) REFERENCES persoane(id_persoana),
  CONSTRAINT unicitate2 UNIQUE (id_film  ,id_persoana)
  ); 

--tabela de autori

insert into autori values ( 1000, 'Camil Petrescu', 1894, 'romana' );
insert into autori values ( 1001, 'Mihail Sadoveanu', 1880, 'romana' );
insert into autori values ( 1002, 'Ion Luca Caragiale', 1852, 'romana' );
insert into autori values ( 1003, 'Vasile Alecsandri', 1821, 'romana' );
insert into autori values ( 1004, 'Mihai Eminescu', 1850, 'romana' );
insert into autori values ( 1005, 'George Calinescu', 1899, 'romana' );

insert into autori values ( 2006, 'Alexander Haley', 1921, 'americana' );
insert into autori values ( 2007, 'Jules Verne', 1828, 'franceza' );
insert into autori values ( 2008, 'Alexandre Dumas', 1802, 'franceza' );
insert into autori values ( 2009, 'Mark Twain', 1835, 'americana' );
insert into autori values ( 2010, 'H. G. Wells', 1896, 'americana' );
insert into autori values ( 2011, 'Miguel de Cervantes', 1605, 'spaniola' ); 
commit;


--tabela de carti 

insert into carti values (100, 'Ultima noapte de dragoste, intaia noapte de razboi', 1000, 'Roman', 'Editura de stat pentru literatura si arta, Bucuresti',1930 ,'romana');
insert into carti values (101, 'Patul lui Procust', 1000, 'Roman' ,'Editura Nationala Ciornei', 1933, 'romana');
insert into carti values (102, 'Baltagul', 1001, 'Roman', 'Cartea Romaneasca', 1930, 'romana');
insert into carti values (103, 'Noptile de Sanziene', 1001, 'Roman', 'Cartea Romaneasca', 1934,'romana');
insert into carti values (104, 'Hanu-Ancutei', 1001, 'Povestire', 'Cartea Romaneasca', 1928, 'romana');
insert into carti values (105, 'O noapte furtunoasa', 1002, 'Comedie', 'Convorbiri literare', 1879,'romana');
insert into carti values (106, 'O scrisoare pierduta', 1002, 'Comedie', 'Convorbiri literare', 1884,'romana');
insert into carti values (107, 'D-ale carnavalului',1002, 'Comedie', 'Convorbiri literare',1885,'romana');
insert into carti values (108, 'Chirita in provintie',1003,'Comedie', 'Convorbiri literare',1852,'romana');
insert into carti values (109, 'Chirita in voiagiu',1003,'Comedie', 'Convorbiri literare', 1864,'romana');
insert into carti values (110, 'Chirita in balon',1003,'Comedie', 'Convorbiri literare',1874,'romana');
insert into carti values (111, 'Miorita',1003,'Poezie','Poezii populare ale romanilor',1866,'romana');
insert into carti values (112, 'Holera',1003,'Poezie','Poezii populare ale romanilor',1866,'romana');
insert into carti values (113, 'Horea si Closca',1003,'Poezie', 'Poezii populare ale romanilor',1866,'romana');
insert into carti values (114, 'Sarmanul Dionis',1004,'Nuvele','Convorbiri literare',1872,'romana');
insert into carti values (115, 'Fat-frumos din lacrima',1004,'Poveste','Convorbiri literare',1870,'romana');
insert into carti values (116, 'Enigma Otiliei',1005,'Roman','Editura Nationala Ciornei',1939,'romana');
insert into carti values (117, 'Radacini',2006,'Roman','Doubleday',1976,'engleza');
insert into carti values (118, 'Douazeci de mii de leghe sub mari',2007,'Roman','Hetzel',1870,'franceza');
insert into carti values (119, 'Ocolul Pamantului in 80 de zile',2007,'Roman','Hetzel',1873,'franceza');
insert into carti values (120, 'O calatorie spre centrul Pamantului',2007,'Roman','Hetzel',1864,'franceza');
insert into carti values (121, 'Cinci saptamani in balon',2007,'Roman','Hetzel',1863,'franceza');
insert into carti values (122, 'Copiii capitanului Grant',2007,'Roman','Hetzel',1868,'franceza');
insert into carti values (123, 'Insula misterioasa',2007,'Roman','Hetzel',1874,'franceza');
insert into carti values (124, 'Doi ani de vacanta',2007,'Roman','Hetzel',1888,'franceza');
insert into carti values (125, 'Capitan la cincisprezece ani',2007,'Roman','Hetzel',1878,'franceza');
insert into carti values (126, 'Castelul din Carpati',2007,'Roman','Hetzel',1893,'franceza');
insert into carti values (127, 'Pilotul de pe Dunare',2007,'Roman','Hetzel',1908,'franceza');
insert into carti values (128, 'Cei trei muschetari',2007,'Roman','Hetzel',1844,'franceza');
insert into carti values (129, 'Contele de Monte-Cristo',2008,'Roman','Hetzel',1845,'franceza');
insert into carti values (130, 'Omul cu masca de fier',2008,'Roman','Hetzel',1850,'franceza');
insert into carti values (131, 'Aventurile lui Tom Sawyer',2009,'Roman','American Publishing Company', 1877,'engleza');
insert into carti values (132, 'Aventurile lui Huckleberry Finn',2009,'Roman','American Publishing Company',1884,'engleza');
insert into carti values (133, 'Print si cersetor',2009,'Roman','American Publishing Company',1881,'engleza');
insert into carti values (134, 'Masina timpului',2010,'Roman','Editura Heinemann',1895,'engleza');
insert into carti values (135, 'Insula dr. Moreau',2010,'Roman','Editura Heinemann',1896,'engleza');
insert into carti values (136, 'Minunata vizita',2010,'Roman','MacMillan and Co.',1895,'engleza');
insert into carti values (137, 'El ingenioso hidalgo don Quijote de la Mancha',2011,'Roman','Ediciones de La Lectura',1615,'spaniola');
commit;


--tabela cu filme

insert into filme values (200,'The Shawshank Redemption','Frank Darabont','Drama',1994,9.4);
insert into filme values (201,'The Godfather','Francis Ford Coppola','Crima',1972,9.2);
insert into filme values (202,'The Godfather: Part II"','Francis Ford Coppola','Crima',1974,9.1);
insert into filme values (203,'The Dark Knight','Christopher Nolan','Actiune',2008,9.0);
insert into filme values (204,'Pulp Fiction','Quentin Tarantino','Thriller',1994,9.0);
insert into filme values (205,'Schindlers List','Steven Spielberg','Biography',1993,8.9);
insert into filme values (206,'The Lord of the Rings: The Return of the King','Peter Jackson','Fantasy',2003,8.9);
insert into filme values (207,'Fight Club','David Fincher','Drama',1999,8.9);
insert into filme values (208,'The Lord of the Rings: The Fellowship of the Ring','Peter Jackson','Fantasy',2001,8.8);
insert into filme values (209,'Star Wars: Episode V - The Empire Strikes Back','Irvin Kershner','Sci-Fi',1980,8.8);
insert into filme values (211,'Inception','Christopher Nolan','Mystery',2010,8.8);
insert into filme values (212,'Forrest Gump','Robert Zemeckis','Romance',1994,8.8);
insert into filme values (213,'One Flew Over the Cuckoos Nest','Milos Forman','Drama',1975,8.8);
insert into filme values (214,'Goodfellas','Martin Scorsese','Biography',1990,8.7);
insert into filme values (215,'The Lord of the Rings: The Two Towers','Peter Jackson','Fantasy',2002,8.8);
insert into filme values (216,'Star Wars','George Lucas','Sci-Fi',1977,8.7);
insert into filme values (217,'The Matrix','Andy Wachowski','Sci-Fi',1999,8.7);
insert into filme values (218,'Shichinin no samurai','Akira Kurosawa','Action',1954,8.8);
insert into filme values (219,'Cidade de Deus','Fernando Meirelles','Crime',2002,8.7);
insert into filme values (220,'Se7en','David Fincher','Crime',1995,8.7);
insert into filme values (221,'The Usual Suspects','Bryan Singer','Crime',1995,8.7);
insert into filme values (222,'The Silence of the Lambs','Jonathan Demme','Crime',1991,8.6);
insert into filme values (223,'Casablanca ','Michael Curtiz','Drama',1942,8.6);
insert into filme values (224,'Its a Wonderful Life','Frank Capra','Drama',1946,8.7);
insert into filme values (225,'La vita è bella','Roberto Benigni','Comedy',1997,8.6);
insert into filme values (226,'Saving Private Ryan','Steven Spielberg','War',1998,8.6);
insert into filme values (227,'American History X','Tony Kaye','Drama',1998,8.6);
insert into filme values (228,'The Pianist','Roman Polanski','Biography',2002,8.5);
insert into filme values (229,'Gladiator','Ridley Scott','Action',2000,8.5);
insert into filme values (230,'The Departed','Martin Scorsese','Crime',2006,8.5);
insert into filme values (231,'The Green Mile','Frank Darabont','Drama',1999,8.5);
insert into filme values (232,'Alien','Ridley Scott','Sci-Fi',1979,8.5);
insert into filme values (233,'Django Unchained','Quentin Tarantino','Western',2012,8.5);
insert into filme values (234,'The Dark Knight Rises','Christopher Nolan','Action',2012,8.4);
insert into filme values (235,'Oldboy','Chan-wook Park','Drama',2003,8.4);
insert into filme values (236,'Mononoke-hime','ayao Miyazaki','Animation',1997,8.5);
insert into filme values (237,'Requiem for a Dream','Darren Aronofsky','Drama',2000,8.4);
insert into filme values (238,'Once Upon a Time in America','Sergio Leone','Crime',1984,8.4);
insert into filme values (239,'Eternal Sunshine of the Spotless Mind','Michel Gondry','Drama',2004,8.4);
insert into filme values (240,'Amadeus','Milos Forman','Biography',1984,8.4);
insert into filme values (241,'Snatch','Guy Ritchie','Comedy',2000,8.4);
commit;


--tabela de persoane(clienti) ai bibliotecii

insert into persoane values (10000, 'Vasile', 'Str. Prunului', 'vasile@example.com','0721000000' , 'mypass', 0 );
insert into persoane values (10001, 'Andrei', 'Str. Marului', 'andrei@example.com','0721000001' , 'suntclient', 0 );
insert into persoane values (10002, 'George', 'Str. Prunului', 'george@example.com','0721000002' ,'suntadmin', 1 );
insert into persoane values (10003, 'Petru', 'Str. Prunului', 'petru@example.com','0721000003', '123',0 );
insert into persoane values (10004, 'Marius', 'Str. Prunului', 'marius@example.com','0721000004' , '123', 0);
insert into persoane values (10005, 'Liviu', 'Str. Prunului', 'liviu@example.com','0721000005' , '123', 0);
insert into persoane values (10006, 'Cosmin', 'Str. Prunului', 'cosmin@example.com','0721000006', '123', 0);
insert into persoane values (10007, 'Laurentiu', 'Str. Prunului', 'laurentiu@example.com','0721000007','123',0);
insert into persoane values (10008, 'Emilian', 'Str. Prunului', 'emilian@example.com','0721000008' ,'123',0);
insert into persoane values (10009, 'Georgiana', 'Str. Prunului', 'georgiana@example.com','0721000009', '123',0);
insert into persoane values (10010, 'Andreea', 'Str. Prunului', 'andreea@example.com','0721000010','123',0);
insert into persoane values (10011, 'Maria', 'Str. Prunului', 'maria@example.com','0721000011','123',0);
insert into persoane values (10012, 'Laura', 'Str. Pantofului', 'laura@example.com','0721000012','123',0);
commit;


--table myimprumutCarte ne va ajuta sa putem face un autorefresh pe un view care este creeat din imprumuturile de carti

--tabela de imprumuturi carti

insert into imprumutCarte values (3020, 100, 10000, TO_DATE('12-3-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3021, 101, 10000, TO_DATE('12-3-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3231, 102, 10000, TO_DATE('15-3-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3220, 102, 10001, TO_DATE('13-3-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3221, 103, 10001, TO_DATE('13-3-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3521, 104, 10001, TO_DATE('10-3-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3473, 107, 10002, TO_DATE('5-4-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3422, 108, 10002, TO_DATE('6-1-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3478, 109, 10002, TO_DATE('5-3-2014', 'DD-MM-YYYY' ));


insert into imprumutCarte values (3773, 101, 10003, TO_DATE('3-04-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3777, 110, 10003, TO_DATE('3-04-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3732, 111, 10005, TO_DATE('3-04-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3312, 112, 10005, TO_DATE('3-04-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3230, 103, 10007, TO_DATE('5-4-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3377, 113, 10007, TO_DATE('5-4-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3364, 114, 10009, TO_DATE('8-4-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3316, 115, 10009, TO_DATE('8-4-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3163, 116, 10009, TO_DATE('8-4-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3614, 119, 10010, TO_DATE('2-5-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3616, 120, 10011, TO_DATE('4-5-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3613, 125, 10011, TO_DATE('10-5-2014', 'DD-MM-YYYY' ));

insert into imprumutCarte values (3611, 130, 10012, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutCarte values (3618, 131, 10012, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));

--myimprumutCarte
commit;


create materialized view log on imprumutCarte
 with rowid(id_persoana) including new values;
commit;


-- 
create materialized view view_nr_borrowed_books
refresh fast on commit
as
select id_persoana, count(*) nr_carti
from imprumutCarte
group by id_persoana;


commit;




--tabela de imprumuturi de filme 

insert into imprumutFilm values ( 5121, 201, 10000, TO_DATE('4-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5112, 201, 10001, TO_DATE('4-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5125, 202, 10001, TO_DATE('4-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5126, 203, 10001, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5177, 204, 10002, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5160, 205, 10002, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5199, 206, 10002, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5333, 207, 10002, TO_DATE('4-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5401, 201, 10005, TO_DATE('10-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5402, 204, 10005, TO_DATE('10-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5405, 205, 10005, TO_DATE('10-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5431, 209, 10005, TO_DATE('12-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5492, 211, 10006, TO_DATE('13-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5422, 223, 10006, TO_DATE('15-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5523, 221, 10007, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5533, 223, 10007, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5563, 225, 10007, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5583, 227, 10007, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5559, 230, 10009, TO_DATE('7-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5553, 233, 10009, TO_DATE('8-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5610, 231, 10011, TO_DATE('9-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5620, 240, 10011, TO_DATE('9-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5640, 234, 10011, TO_DATE('9-5-2014', 'DD-MM-YYYY' ));

insert into imprumutFilm values ( 5650, 235, 10012, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5670, 236, 10012, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));
insert into imprumutFilm values ( 5664, 237, 10012, TO_DATE('1-5-2014', 'DD-MM-YYYY' ));

commit;

