DROP TABLE IF EXISTS account;
CREATE TABLE account (
    id           bigint       not null auto_increment
   ,user_id      varchar(30)  not null
   ,password     varchar(100) not null
   ,name         varchar(30)
   ,created_by   bigint
   ,created_at   datetime
   ,updated_by   bigint
   ,updated_at   datetime
   ,primary key(id)
);

DROP TABLE IF EXISTS voc;
CREATE TABLE voc (
     id           bigint       not null auto_increment
    ,title        varchar(30)  not null
    ,content      varchar(300) not null
    ,voc_status   varchar(30)
    ,admin_id     bigint
    ,created_by   bigint       not null
    ,created_at   datetime     not null
    ,updated_by   bigint
    ,updated_at   datetime
    ,primary key(id)
    ,foreign key(admin_id) references account(id)
);

DROP TABLE IF EXISTS reply;
CREATE TABLE reply (
     id           bigint       not null auto_increment
    ,title        varchar(30)  not null
    ,content      varchar(300) not null
    ,voc_status   varchar(30)
    ,voc_id       bigint
    ,created_by   bigint       not null
    ,created_at   datetime     not null
    ,updated_by   bigint
    ,updated_at   datetime
    ,primary key(id)
    ,foreign key(voc_id) references voc(id)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
     id           bigint       not null auto_increment
    ,role_type    varchar(30)  not null
    ,description  varchar(500)
    ,primary key(id)
);

DROP TABLE IF EXISTS account_role;
CREATE TABLE account_role (
     account_id bigint not null
    ,role_id    bigint not null
    ,primary key(account_id, role_id)
    ,foreign key(account_id) references account(id)
    ,foreign key(role_id)    references role(id)
);