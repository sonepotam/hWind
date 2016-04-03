DROP TABLE IF EXISTS names CASCADE;
DROP TABLE IF EXISTS products CASCADE;

drop sequence if EXISTS products_seq;

create sequence products_seq start with 1;

create table products(
  id         INTEGER PRIMARY KEY DEFAULT nextval('products_seq'),
  pr_type    INTEGER NOT NULL,
  spice      BOOLEAN not null
);


create table names(
  lang VARCHAR,
  name varchar,
  product_id INTEGER,
  FOREIGN KEY ( product_id) REFERENCES products(id) on DELETE CASCADE,
  primary key ( product_id, lang)
);

create UNIQUE INDEX names_unique_lang_name on names( lang, name);

