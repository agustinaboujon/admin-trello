package com.trello.admin.service.impl;

import com.trello.admin.entity.Card;
import com.trello.admin.repository.TrelloRepository;
import com.trello.admin.service.ServiceCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceCardImpl implements ServiceCard {

    @Autowired
    TrelloRepository trelloRepository;

    @Override
    public String createCard(Card card) {
        return trelloRepository.getBoard().toString();
    }
}
