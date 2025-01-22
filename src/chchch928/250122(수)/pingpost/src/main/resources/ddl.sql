-- 데이터베이스 생성
CREATE DATABASE postproject
-- 이모지 저장가능
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE TABLE posts
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    content TEXT,
    writer VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- 회원 테이블
CREATE TABLE users
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    username          VARCHAR(30) NOT NULL UNIQUE,
    password          VARCHAR(100),
    email             VARCHAR(100) UNIQUE,
    name              VARCHAR(50) NOT NULL,
    role              VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER',
    refresh_token     VARCHAR(255),        -- JWT Refresh Token
    created_at        TIMESTAMP            DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_login_at     TIMESTAMP,

    INDEX idx_email (email),
    INDEX idx_username (username)
);

