package com.trello.admin.controller;

import com.trello.admin.entity.Card;
import com.trello.admin.service.ServiceCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/trello")
public class CardController {

    @Autowired
    ServiceCard serviceCard;

    @PostMapping(path = "/card")
    public String createCard(@RequestBody Card card){
        log.info("call create card service with params: {} ", card);
        return serviceCard.createCard(card).getId();
    }

}
