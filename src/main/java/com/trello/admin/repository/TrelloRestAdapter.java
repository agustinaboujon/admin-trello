package com.trello.admin.repository;


import com.trello.admin.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TrelloRestAdapter implements TrelloRepository {

    String uri = "https://api.trello.com/1/members/me/boards?key=689159bd0e318b3c0fd313fe057d0527&token=9ae2b24361ab04d8209b6657f2474efc445700c0be6349026215ce19506f33b9";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity createCard() {
        return null;
    }

    @Override
    public ResponseEntity getBoard() {

        ResponseEntity resp = restTemplate.getForEntity(uri, Object.class);

        return resp;
    }
}
