CREATE TABLE product(
  id BIGINT(20) AUTO_INCREMENT,
  product_type varchar(50) NOT NULL,
  product_value BIGINT NOT NULL,
  user_amount BIGINT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY product_UN (product_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product (id,product_type,product_value,user_amount) VALUES (1,'SURFBOARD',5000,1560);
INSERT INTO product (id,product_type,product_value,user_amount) VALUES (2,'BEACH_CHAIR',3500,500);
INSERT INTO product (id,product_type,product_value,user_amount) VALUES (3,'SUNSHADE',4000,1030);
INSERT INTO product (id,product_type,product_value,user_amount) VALUES (4,'SAND_BOARD',2500,900);
INSERT INTO product (id,product_type,product_value,user_amount) VALUES (5,'BEACH_TABLE',2500,810);

CREATE TABLE product_order(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  user_name varchar(50) NOT NULL,
  product_type varchar(50) NOT NULL,
  time_hour int NOT NULL,
  product_value BIGINT NOT NULL,
  product_total BIGINT NOT NULL,
  user_amount BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

