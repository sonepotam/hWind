DROP PROCEDURE IF EXISTS insert_rows;

CREATE PROCEDURE insert_rows ()
  BEGIN
    DECLARE prod INT DEFAULT 1;
    WHILE prod < 1000 DO
      insert into products( pr_type, spice) VALUES ( 1, FALSE );
      insert into names( lang, name, product_id) VALUES( 'ru_ru', CONCAT('Курица', prod), last_insert_id());
      insert into names( lang, name, product_id) VALUES( 'en_en', CONCAT('Hen', prod), last_insert_id());
      SET prod = prod + 1;
    END WHILE;
  END;

CALL insert_rows();
