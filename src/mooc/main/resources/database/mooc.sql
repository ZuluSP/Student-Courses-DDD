CREATE TABLE IF NOT EXISTS courses (
    `id`       CHAR(36)     NOT NULL,
    `name`     VARCHAR(255) NOT NULL,
    `duration` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
    )
    #utf8mb4 to support emojis in the name ;)
    ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
