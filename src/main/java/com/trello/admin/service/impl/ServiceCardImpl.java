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
    public Object createCard(Card card) {
        String params = buildParams(card);
        return  trelloRepository.createCard(params);
    }

    @Override
    public String getBoard() {
        String resp = trelloRepository.getBoard().getBody().toString();
        return resp;
    }


    private String buildParams(Card card) {

        String params = "";

        if(card.getTitle() != null && card.getDescription() != null){
            params = "&name=" + card.getTitle() + "&desc=" + card.getDescription();
        }else if(card.getDescription() != null && card.getTitle().isEmpty()){
            //TODO: add random member and a "BUG" label

            params = "&desc=" + card.getDescription() + "&title=randomtitle";
        }else if(card.getTitle() != null && card.getLabel() != null){
            //TODO: add labels
            params = "&name=" + card.getTitle();
        }
        return params;
    }
}
