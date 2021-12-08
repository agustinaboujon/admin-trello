package com.trello.admin.repository;

import org.springframework.http.ResponseEntity;

public interface TrelloRepository {
    ResponseEntity createCard();
    ResponseEntity getBoard();
}
