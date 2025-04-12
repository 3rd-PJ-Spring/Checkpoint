-- 데이터베이스 생성
CREATE DATABASE instagram_clone
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;


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




