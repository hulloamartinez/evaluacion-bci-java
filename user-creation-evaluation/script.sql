
    create table phone (
       id BINARY(16) not null,
        citycode varchar(255),
        contrycode varchar(255),
        number varchar(255),
        id_usuario BINARY(16),
        primary key (id)
    ) engine=InnoDB

    create table usuario (
       id BINARY(16) not null,
        created varchar(255),
        email varchar(255) not null,
        is_active bit not null,
        last_login varchar(255),
        modified varchar(255),
        nombre varchar(255) not null,
        password varchar(255) not null,
        token varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table usuario 
       drop index UK_5171l57faosmj8myawaucatdw

    alter table usuario 
       add constraint UK_5171l57faosmj8myawaucatdw unique (email)

    alter table phone 
       add constraint FK78x38qcmbemfdt58brckgq2ed 
       foreign key (id_usuario) 
       references usuario (id)