package com.example.instagramclone.shop.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameHistory {
    private Long id;
    private Long userId;
    private int userCardSum;
    private int dealerCardSum;
    private String result;
    private LocalDateTime createAt;
}
