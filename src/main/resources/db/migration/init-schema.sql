CREATE TABLE c_jc_instructor
(
    user_id BIGINT NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_c_jc_instructor PRIMARY KEY (user_id)
);

CREATE TABLE c_jc_mentor
(
    user_id      BIGINT NOT NULL,
    num_of_hours INT    NOT NULL,
    CONSTRAINT pk_c_jc_mentor PRIMARY KEY (user_id)
);

CREATE TABLE c_jc_ta
(
    user_id BIGINT NOT NULL,
    ratings INT    NOT NULL,
    CONSTRAINT pk_c_jc_ta PRIMARY KEY (user_id)
);

CREATE TABLE c_jc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_c_jc_user PRIMARY KEY (id)
);

CREATE TABLE c_msc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_c_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE c_msc_mentor
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    num_of_hours INT    NOT NULL,
    CONSTRAINT pk_c_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE c_msc_ta
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    ratings INT    NOT NULL,
    CONSTRAINT pk_c_msc_ta PRIMARY KEY (id)
);

CREATE TABLE c_st_user
(
    id           BIGINT NOT NULL,
    user_type    INT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    num_of_hours INT    NOT NULL,
    ratings      INT    NOT NULL,
    company      VARCHAR(255) NULL,
    CONSTRAINT pk_c_st_user PRIMARY KEY (id)
);

CREATE TABLE c_tpc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_c_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE c_tpc_mentor
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    num_of_hours INT    NOT NULL,
    CONSTRAINT pk_c_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE c_tpc_ta
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    ratings INT    NOT NULL,
    CONSTRAINT pk_c_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE c_tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_c_tpc_user PRIMARY KEY (id)
);

CREATE TABLE category
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price DOUBLE NULL,
    image_url       VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    is_special      BIT(1) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE table1
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    CONSTRAINT pk_table1 PRIMARY KEY (id)
);

ALTER TABLE c_jc_instructor
    ADD CONSTRAINT FK_C_JC_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES c_jc_user (id);

ALTER TABLE c_jc_mentor
    ADD CONSTRAINT FK_C_JC_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES c_jc_user (id);

ALTER TABLE c_jc_ta
    ADD CONSTRAINT FK_C_JC_TA_ON_USER FOREIGN KEY (user_id) REFERENCES c_jc_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);