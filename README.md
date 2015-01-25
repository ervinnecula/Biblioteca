Library project for SGBD 

Developed by Necula Ervin

////////////////////////////////////////////////

Dependencies:


>Needs Oracle 12C database installed
>Oracle Database Service running at port 1521 having connections opened.
>Needs a previous run of the following scripts in this order:
>ojdbc6
	1. script.sql (schema creation + table creation + insertion 
	2. obiectSiColectie.sql
	3. trigger.sql
	4. materialized_view.sql
	5. indecsi.sql

///////////////////////////////////////////////