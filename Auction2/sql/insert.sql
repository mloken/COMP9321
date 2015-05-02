DELETE FROM TBL_CONTACTS;
DELETE FROM TBL_USERS;

insert into TBL_USERS values (1, 'Helen', 'Paik', 1, 'helen', 'helen','abc@gmail.com','0403727910');
insert into TBL_USERS values (2, 'Yun Ki', 'Lee', 2, 'yunki', 'yunki','jen@aniston.net', '22230098');

insert into TBL_ITEMS values (1, 1, 'MacBook Pro 2015', 'Computer', 'Cool notebook', 'http://cdn.cultofmac.com/wp-content/uploads/2014/03/old-MacBook-Pro-13.jpg', 'UNSW','UNSW','UNSW','UNSW','2032','100','50','10','','');
insert into TBL_CONTACTS values (2, 1, 'Jennifer', 'Jennifer Aniston', 'jen@aniston.net', '22230098', 'Has she really moved on?');
insert into TBL_CONTACTS values (3, 2, 'Angelina', 'Angelina Jolie', 'jolie@lara.org', null, 'The first Lara Croft');
