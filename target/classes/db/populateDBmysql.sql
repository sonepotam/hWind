DELETE FROM names;
DELETE FROM products;


insert into products( pr_type, spice) VALUES ( 1, FALSE );
insert into names( lang, name, product_id) VALUES( 'ru_ru', 'Курица1', last_insert_id());
insert into names( lang, name, product_id) VALUES( 'en_en', 'Hen1', last_insert_id());

