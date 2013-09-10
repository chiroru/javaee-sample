CREATE TABLE IF NOT EXISTS BOOKSHELF (
    ID int NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(128) NOT NULL,
    DESCRIPTION VARCHAR(1028),
    CREATED_AT TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CREATED_USER VARCHAR(128) NOT NULL,
    UPDATED_AT TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_USER VARCHAR(128) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS BOOK (
    ID int(8) NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(128) NOT NULL,
    VOLUME int(512) DEFAULT NULL,
    DESCRIPTION VARCHAR(1028),
    PICTURE varchar(256) DEFAULT NULL,
    BOOKSHELF_ID int (8) NOT NULL,
    CREATED_AT TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CREATED_USER VARCHAR(128) NOT NULL,
    UPDATED_AT TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_USER VARCHAR(128) NOT NULL,
    PRIMARY KEY (ID) --,
--    FOREIGN KEY(BOOKSHELF_ID) REFERENCES BOOKSHELF(ID)
);
