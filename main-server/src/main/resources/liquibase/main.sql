--liquibase formatted sql

--changeset chenhao:permission-create
CREATE TABLE permission
(
  id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
  create_by          VARCHAR(255) NULL,
  create_time        DATETIME     NULL,
  last_modified_by   VARCHAR(255) NULL,
  last_modified_time DATETIME     NULL,
  base               BIT          NULL,
  code               VARCHAR(255) NULL,
  method             VARCHAR(255) NULL,
  name               VARCHAR(255) NULL,
  remark             VARCHAR(255) NULL,
  uri                VARCHAR(255) NULL,
  parent_id          BIGINT       NULL,
  CONSTRAINT permission_code_unique_key UNIQUE (code),
  CONSTRAINT permission_parent_id_key FOREIGN KEY (parent_id) REFERENCES permission (id)
) ENGINE =InnoDB DEFAULT CHARSET = utf8;

--changeset chenhao:role-create
CREATE TABLE role
(
  id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
  create_by          VARCHAR(255) NULL,
  create_time        DATETIME     NULL,
  last_modified_by   VARCHAR(255) NULL,
  last_modified_time DATETIME     NULL,
  code               VARCHAR(255) NULL,
  name               VARCHAR(255) NULL,
  remark             VARCHAR(255) NULL,
  CONSTRAINT role_code_unique_key UNIQUE (code)
) ENGINE =InnoDB DEFAULT CHARSET = utf8;

--changeset chenhao:user-create
CREATE TABLE user
(
  id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
  create_by          VARCHAR(255) NULL,
  create_time        DATETIME     NULL,
  last_modified_by   VARCHAR(255) NULL,
  last_modified_time DATETIME     NULL,
  email              VARCHAR(255) NULL,
  nick_name          VARCHAR(255) NULL,
  password           VARCHAR(255) NULL,
  phone              VARCHAR(255) NULL,
  remark             VARCHAR(255) NULL,
  user_name          VARCHAR(255) NULL,
  CONSTRAINT user_name_unique_key UNIQUE (user_name)
) ENGINE =InnoDB DEFAULT CHARSET = utf8;

--changeset chenhao:user_roles-create
CREATE TABLE user_roles
(
  users_id BIGINT NOT NULL,
  roles_id BIGINT NOT NULL,
  PRIMARY KEY (users_id, roles_id),
  CONSTRAINT user_roles_users_id_foreign_key FOREIGN KEY (users_id) REFERENCES user (id),
  CONSTRAINT user_roles_roles_id_foreign_key FOREIGN KEY (roles_id) REFERENCES role (id)
) ENGINE =InnoDB DEFAULT CHARSET = utf8;

--changeset chenhao:role_permissions-create
CREATE TABLE role_permissions
(
  roles_id       BIGINT NOT NULL,
  permissions_id BIGINT NOT NULL,
  PRIMARY KEY (roles_id, permissions_id),
  CONSTRAINT role_permissions_role_id_foreign_key
  FOREIGN KEY (roles_id) REFERENCES role (id),
  CONSTRAINT role_permissions_permission_id_foreign_key
  FOREIGN KEY (permissions_id) REFERENCES permission (id)
) ENGINE =InnoDB DEFAULT CHARSET = utf8;

