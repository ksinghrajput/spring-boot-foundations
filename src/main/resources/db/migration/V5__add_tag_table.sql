CREATE TABLE tags
    (
        id INT auto_increment primary key ,
        name varchar(255) not null
);

CREATE TABLE user_tags
    (
        user_id BIGINT not null ,
        tag_id Int not null,
        primary key (user_id, tag_id),
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
        FOREIGN KEY (tag_id) references tags(id) ON DELETE CASCADE
)