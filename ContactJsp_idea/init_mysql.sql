CREATE TABLE contact_tbl (
	id INT UNSIGNED auto_increment NOT NULL,
	name varchar(20) NULL,
	phoneNumber varchar(20) NULL,
	zipNumber varchar(5) NULL,
	email varchar(100) NULL,
	CONSTRAINT contact_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

INSERT INTO contact_tbl VALUES (1,'김성민','010-1111-1111','11111','ksm@gmail.com');
INSERT INTO contact_tbl VALUES (2,'진서연','010-2222-2222','22222','jsy@gmail.com');
