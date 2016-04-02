DROP TABLE IF EXISTS products CASCADE;

DROP SEQUENCE IF EXISTS neostore_seq CASCADE ;

create sequence products_seq start with 1;
create sequence names_seq    start with 1;


create table products(
  id         INTEGER PRIMARY KEY DEFAULT nextval('products_seq'),
  pr_type    INTEGER NOT NULL,
  spice      BOOLEAN not null
);


create table names(
  lang VARCHAR,
  name varchar,
  product_id INTEGER,
  FOREIGN KEY ( product) REFERENCES products(id) on DELETE CASCADE,
  primary key ( product_id, lang)
);

create UNIQUE INDEX names_unique_lang_name on names( lang, name);

