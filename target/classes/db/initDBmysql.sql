DROP TABLE IF EXISTS names CASCADE;
DROP TABLE IF EXISTS products CASCADE;


create table products(
  id         INTEGER PRIMARY KEY AUTO_INCREMENT,
  pr_type    INTEGER NOT NULL,
  spice      BOOLEAN not null
);


create table names(
  lang VARCHAR(20),
  name varchar(250),
  product_id INTEGER,
  FOREIGN KEY ( product_id) REFERENCES products(id) on DELETE CASCADE,
  primary key ( product_id, lang)
);

create UNIQUE INDEX names_unique_lang_name on names( lang, name);

