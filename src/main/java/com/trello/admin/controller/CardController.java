package com.trello.admin.controller;

import com.trello.admin.entity.Card;
import com.trello.admin.service.ServiceCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(path = "/")
public class CardController {

    @Autowired
    ServiceCard serviceCard;

    @PostMapping
    public String createCard(@RequestBody Card card){
        log.info("creating a new card: {} in board", card);
        return serviceCard.createCard(card);
    }

    @GetMapping
    public String getBoard(){
        log.info("creating a new card: {} in board");
        Card card = new Card();
        return serviceCard.createCard(card);
    }

}
