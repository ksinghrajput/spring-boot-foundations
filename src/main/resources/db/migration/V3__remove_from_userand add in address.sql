alter table users
    drop column state;

alter table addresses
    add address varchar(255) not null;