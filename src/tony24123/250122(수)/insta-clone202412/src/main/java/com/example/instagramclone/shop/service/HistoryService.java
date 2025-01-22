package com.example.instagramclone.shop.service;

import com.example.instagramclone.shop.repository.HistoryRepository;
import com.example.instagramclone.shop.user.GameHistory;
import com.example.instagramclone.shop.user.HistoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HistoryService {

    //주입
    private final HistoryRepository historyRepository;

    //전적 기록
    public void addGameHistory(HistoryDto historyDto) {
        historyRepository.insert(historyDto); // Mapper의 insert 메서드 호출
    }
}
