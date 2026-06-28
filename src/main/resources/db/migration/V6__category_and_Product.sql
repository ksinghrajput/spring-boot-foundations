create table categories
    (
        id tinyint AUTO_INCREMENT primary key ,
        name varchar(255) not null
);

create table products
(
    id bigint auto_increment primary key,
    name varchar(255) not null ,
    price decimal(10, 2) NOT NULL ,
    category_id TINYINT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
    ON DELETE restrict
)

