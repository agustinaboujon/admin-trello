package com.trello.admin.controller;

import com.trello.admin.entity.Card;
import com.trello.admin.service.ServiceCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping
    public Object createCard(@RequestBody Card card){
        log.info("creating a new card: {} in board", card);
        return serviceCard.createCard(card);
    }

    @GetMapping(path = "/board")
    public String getBoard(){
        String resp = serviceCard.getBoard();
        return resp;
    }

}
