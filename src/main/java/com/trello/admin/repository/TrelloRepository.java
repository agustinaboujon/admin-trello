package com.trello.admin.repository;

import com.trello.admin.entity.Card;
import org.springframework.http.ResponseEntity;

public interface TrelloRepository {
    Object createCard(String params);
    ResponseEntity getBoard();
}
