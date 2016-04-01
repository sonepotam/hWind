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
  id integer primary key default nextval( 'names_seq'),
  lang VARCHAR,
  name varchar,
  product INTEGER,
  FOREIGN KEY ( product) REFERENCES products(id) on DELETE CASCADE
);

create UNIQUE INDEX names_unique_lang_name on names( lang, name);

