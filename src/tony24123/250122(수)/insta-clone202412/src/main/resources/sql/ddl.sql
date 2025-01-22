-- 데이터베이스 생성
CREATE DATABASE instagram_clone
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

-- 게시물 테이블
CREATE TABLE posts
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    content    TEXT,
    writer     VARCHAR(100) NOT NULL,
    view_count INT       DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 게시물 이미지 테이블
CREATE TABLE post_images
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id     BIGINT       NOT NULL,
    image_url   VARCHAR(255) NOT NULL,
    image_order INT          NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);

-- ==============
-- 해시태그 테이블
CREATE TABLE hashtags
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 게시물-해시태그 연결 테이블
CREATE TABLE post_hashtags
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    hashtag_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE,
    FOREIGN KEY (hashtag_id) REFERENCES hashtags (id) ON DELETE CASCADE,
    UNIQUE KEY unique_post_hashtag (post_id, hashtag_id)
);

-- 인덱스 추가
CREATE INDEX idx_hashtag_name ON hashtags (name);
CREATE INDEX idx_post_hashtags_post_id ON post_hashtags (post_id);
CREATE INDEX idx_post_hashtags_hashtag_id ON post_hashtags (hashtag_id);


-- 회원 테이블
CREATE TABLE users
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    username          VARCHAR(30) NOT NULL UNIQUE,
    password          VARCHAR(100),        -- OAuth2 사용자는 password가 null일 수 있음
    email             VARCHAR(100) UNIQUE, -- 이메일과 전화번호 중 하나는 필수
    phone             VARCHAR(20) UNIQUE,
    name              VARCHAR(50) NOT NULL,
    profile_image_url VARCHAR(255),
    role              VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER',
    refresh_token     VARCHAR(255),        -- JWT Refresh Token
    created_at        TIMESTAMP            DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_login_at     TIMESTAMP,

    INDEX idx_email (email),
    INDEX idx_phone (phone),
    INDEX idx_username (username)
);

-- 기존 피드 와 해시태그 모두 삭제
DELETE FROM post_hashtags;
DELETE FROM hashtags;
DELETE FROM posts;

COMMIT;

-- posts 테이블 수정
ALTER TABLE posts
    DROP COLUMN writer, -- 기존 writer 컬럼 제거
    ADD COLUMN member_id BIGINT NOT NULL, -- 회원 ID 컬럼 추가
    ADD CONSTRAINT fk_posts_member -- FK 제약조건 추가
        FOREIGN KEY (member_id)
            REFERENCES users (id)
            ON DELETE CASCADE;

-- 인덱스 추가
CREATE INDEX idx_posts_member_id ON posts (member_id);

-- 댓글
CREATE TABLE comments
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    member_id  BIGINT NOT NULL,
    content    TEXT   NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES users (id) ON DELETE CASCADE
);

-- 조회 성능을 위한 인덱스 추가
CREATE INDEX idx_comments_post_id ON comments (post_id);
CREATE INDEX idx_comments_member_id ON comments (member_id);


--blackjack user 테이블
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    game_chips INT DEFAULT 500
);

--blackjack 전적 기록 테이블
CREATE TABLE game_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 전적의 고유 ID
    user_id BIGINT NOT NULL,               -- 사용자 ID (User 테이블과의 외래키)
    user_card_sum INT NOT NULL,            -- 사용자의 카드 합
    dealer_card_sum INT NOT NULL,          -- 딜러의 카드 합
    result VARCHAR(10) NOT NULL,           -- 게임의 최종 결과 (예: 'WIN', 'LOSE', 'DRAW')
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 전적이 기록된 시간
    FOREIGN KEY (user_id) REFERENCES User(id)  -- User 테이블과의 외래키 제약조건
);