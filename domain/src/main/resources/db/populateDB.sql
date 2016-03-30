DELETE FROM names;
DELETE FROM product;

ALTER SEQUENCE product_seq RESTART WITH 1;
ALTER SEQUENCE nam_seq     RESTART WITH 1;


do language plpgsql $$
declare
  prod integer;
begin
  for ptr in 1..50 loop
    prod =nextval( 'products_seq');
    insert into products( id, pr_type, spice) VALUES ( prod, 1, FALSE );
    insert into names( lang, name, product) VALUES( 'ru_ru', 'Курица' || ptr, prod);
    insert into names( lang, name, product) VALUES( 'en_en', 'Hen' || ptr, prod);
  end loop;
end
$$;
