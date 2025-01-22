package com.example.instagramclone.shop.repository;

import com.example.instagramclone.shop.user.GameHistory;
import com.example.instagramclone.shop.user.HistoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryRepository {

    //게임 결과 저장
    void insert(HistoryDto historyDto);

}
