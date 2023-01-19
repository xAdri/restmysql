create TABLE users (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   birthdate date NULL,
   address VARCHAR(255) NULL,
   email VARCHAR(255) NOT NULL,
   phone_number VARCHAR(255) NULL,
   entry_date date NULL,
   client_group CHAR NOT NULL,
   city VARCHAR(255) NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

alter table users add CONSTRAINT uc_users_email UNIQUE (email);

alter table users add CONSTRAINT uc_users_id UNIQUE (id);