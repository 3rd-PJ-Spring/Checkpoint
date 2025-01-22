<%-- src/main/webapp/WEB-INF/views/index.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Health Mentor | 미니게임</title>
    <link rel="icon" href="/images/bjimg/favicon.ico" sizes="32x32">
    <link rel="stylesheet" href="/css/bjcss/reset.css" />
    <link rel="stylesheet" href="/css/bjcss/blackjack.css" />
    <script src="/js/bjjs/blackjack.js" defer></script>
    <script src="/js/bjjs/blackjack-update-chip.js" defer></script>
    <script src="/js/bjjs/blackjack-save-result.js" defer></script>
  </head>
  <body>
    <header class="top">
      <div class="logo">
        <h1 class="title"><a href="../index.html">Blackjack</a></h1>

        <div class="logo-img">
          <img src="/images/bjimg/blackjack/favicon.ico" alt="" />
        </div>
      </div>
      <div class="exit-button"></div>
    </header>

    <section class="game-board">
      <div class="row1">
        <div class="row1-left">
          <span class="game-player">Dealer</span>
          <div class="row1-card-box setCard-box">
            <div class="hidden-card card">
              <img src="/images/bjimg/blackjack/card_back.png" alt="" />
            </div>
            <div class="dealer-card card spreadCard">
              <!-- <img src="img/Clubs-7.png" alt=""> -->
            </div>
          </div>
        </div>

        <div class="row1-right">
          <div class="betting-box">
            <div class="betting-chip-img">
              <img src="/images/bjimg/blackjack/blank-chip.png" alt="" />
            </div>
            <p class="betting-chip"></p>
          </div>

          <div class="gamechip-box">
            <div class="gamechip-img">
              <img src="/images/bjimg/blackjack/pile-chip.png" alt="" />
            </div>
            <p class="mygamechip"></p>
          </div>
        </div>
      </div>

      <div class="row2">
        <div class="row2-left">
          <span class="game-player">Player</span>
          <div class="row2-card-box setCard-box">
            <div class="player-card card spreadCard">
              <!-- <img src="img/Clubs-7.png" alt=""> -->
            </div>
          </div>
        </div>

        <div class="row2-right">
          <div class="button-box">
            <div class="hit-button playbtn"><p>Hit</p></div>
            <div class="double-button playbtn"><p>Double</p></div>
            <div class="stand-button playbtn"><p>Stand</p></div>
            <div class="split-button playbtn"><p>Split</p></div>
          </div>
        </div>
      </div>

      <div class="chipimg">
        <img src="/images/bjimg/blackjack/betting-chip-removebg.png" alt="" />
      </div>
      <div class="player-left-hand hand">
        <img src="/images/bjimg/blackjack/player-left-hand.png" alt="" />
      </div>
      <div class="dealer-left-hand hand">
        <img src="/images/bjimg/blackjack/dealer-right-hand.png" alt="" />
      </div>
      <div class="dealer-right-hand hand">
        <img src="/images/bjimg/blackjack/dealer-left-hand.png" alt="" />
      </div>
    </section>

    <!-- 모달 창 구조 -->
    <div class="modal-overlay" id="modalOverlay">
      <div class="modal-content">
        <h2>게임 종료</h2>
        <p class="modal-text"></p>
        <button class="close-btn">닫기</button>
      </div>
    </div>

    <div class="player-right-hand" id="handToMouse">
      <!-- <img src="/images/bjimg/blackjack/player-right-hand.png" alt=""> -->
    </div>
  </body>
</html>
