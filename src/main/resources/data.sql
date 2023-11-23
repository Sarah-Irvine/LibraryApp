insert into Address (id, line_one, line_two, state, postal_code, country) values (1,'123 Street','abc Road','Glasgow','G1 ABC','Scotland');
insert into Address (id, line_one, line_two, state, postal_code, country) values (2,'456 Street','def Road','Glasgow','G1 ABC','Scotland');
insert into Librarian (address_id,id,name,phone_number) values (1,1, 'Sarah','123456789');
insert into LIBRARY_User (address_id,id,name,phone_number) values (2,2, 'Zaggy','987654321');
insert into Author (id,name) values (1,'Sarah Irvine');
insert into Periodical (id,title,publication_date,genre,author_id) values (1, 'The Banach Tarski Paradox','2018-06-27','MATHS',1);
