package com.example.instagramclone.shop.user;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryDto {
    private Long id;
    private Long userId;
    private int userCardSum;
    private int dealerCardSum;
    private String result;
    private String createAt;

    public HistoryDto(GameHistory G){
        this.id = G.getId();
        this.userId = G.getUserId();
        this.userCardSum = G.getUserCardSum();
        this.dealerCardSum = G.getDealerCardSum();
        this.result = G.getResult();
        this.createAt = G.getCreateAt().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
