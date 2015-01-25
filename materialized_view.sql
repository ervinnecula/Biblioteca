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
