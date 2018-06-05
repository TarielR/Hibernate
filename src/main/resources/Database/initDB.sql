CREATE TABLE BOOKS (
  book_id     NUMBER,
  TITLE       VARCHAR(50)   NOT NULL,
  AUTHOR      VARCHAR(100)  NOT NULL,
  PRICE       NUMBER        NOT NULL,
  CONSTRAINT book_pk PRIMARY KEY(book_id)
);

--  создаем последовательность
CREATE SEQUENCE seq_books
  START WITH 1
  INCREMENT BY 1
  NOMAXVALUE;

--  создаем сам триггер
CREATE OR REPLACE TRIGGER tr_books
  before INSERT ON books FOR each row
  BEGIN
    IF :new.id IS NULL
    THEN
      SELECT SEQ_BOOKS.nextval
      INTO :new.id
      FROM dual;
    END IF;
  END;





