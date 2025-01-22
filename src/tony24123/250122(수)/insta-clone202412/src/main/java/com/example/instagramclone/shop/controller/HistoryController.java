package com.example.instagramclone.shop.controller;

import com.example.instagramclone.shop.service.HistoryService;
import com.example.instagramclone.shop.user.GameHistory;
import com.example.instagramclone.shop.user.HistoryDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;
    @Autowired
    public HistoryController(HistoryService historyService) {this.historyService= historyService;}

    //전적 정보 전달
    @PostMapping("/saveHistory")
    public ResponseEntity<?> saveHistory(
            @RequestBody @Valid HistoryDto historyDto
            ) {
        historyService.addGameHistory(historyDto);

        return ResponseEntity
                .ok()
                .body("request!");
    }

}
