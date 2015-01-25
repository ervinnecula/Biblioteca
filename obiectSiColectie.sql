create or replace type carte as object(
id_carte number(3),
nume varchar2(150),
cod_autor number(4),
gen varchar2(30),
editura varchar2(100),
an_aparitie number(4),
limba varchar2(20)
);
/

create or replace type persoana as object(
  id_persoana number(5),
  nume varchar2(50),
  adresa varchar2(100),
  email varchar2(50),
  telefon varchar2(40),
  password varchar2(40),
  admin number(1)
);
/

create or replace type colectie_carti as table of carte;
/

create or replace type colectie_persoane as table of persoana;
/
