CREATE TABLE ITEM (
	id integer(21) NOT NULL AUTO_INCREMENT, 
	title VARCHAR(100) NOT NULL,
	description VARCHAR(300),
	category_id integer(20) NOT NULL,
	price_id double(20,3),
	item_state VARCHAR(10) NOT NULL,
	size integer(5),
	colors integer(21),
	created_by VARCHAR(30) NOT NULL,
	created_date DATE NOT NULL,
	modified_by VARCHAR(30) NOT NULL,
	modified_date DATE NOT NULL,
	CONSTRAINT item_pk PRIMARY KEY (id)
);

ALTER TABLE ITEM AUTO_INCREMENT = 1;

    