package com.example.instagramclone.shop.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private Integer gameChips;

}
