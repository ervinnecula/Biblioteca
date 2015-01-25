create index idx_carte on carti(id_carte,upper(nume)));
//foarte util,fac cautari dupa id_cartii si apoi dupa nume, in general. toate selecturile sunt pe baza id-ului cartii pentru rezervarea de carti

create index idx_carte2 on carti(gen);
//rar se fac cautari dupa gen, dar este eficient in continuare

create index idx_carte3 on carti(nume,an_aparitie);
//inutil indexul, deoarece numele sunt comparate cu upper(name) deci nu vom folosi indexul