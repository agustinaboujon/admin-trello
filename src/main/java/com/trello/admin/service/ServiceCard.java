package com.trello.admin.service;

import com.trello.admin.entity.Card;
import org.springframework.stereotype.Component;

@Component
public interface ServiceCard {
    Card createCard(Card card);
}
