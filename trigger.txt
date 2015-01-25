CREATE OR REPLACE TRIGGER PREAMULTECARTI 
BEFORE INSERT ON IMPRUMUTCARTE 
DECLARE
v_id_persoana persoane.id_persoana%TYPE;
v_numar_carti number(1);
v_cod_err varchar(20);
cursor cur_my_view is select * from view_nr_borrowed_books;
BEGIN
 open cur_my_view;
 
 loop
    fetch cur_my_view into v_id_persoana,v_numar_carti;
    exit when cur_my_view%NOTFOUND;
    
    if v_numar_carti > 3
    then
        raise_application_error(-20100,v_id_persoana);
    end if;
 end loop;
END;
