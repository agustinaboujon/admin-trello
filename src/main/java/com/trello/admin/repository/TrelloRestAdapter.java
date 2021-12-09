package com.trello.admin.repository;


import com.trello.admin.OperationPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Component
public class TrelloRestAdapter implements TrelloRepository {

    @Value("${trello.uri}")
    private String uri;

    @Value("${trello.key}")
    private String key;

    @Value("${trello.token}")
    private String token;

    @Value("${trello.list.id}")
    private String list;

    //String uri = "https://api.trello.com/1/members/me/boards?key=689159bd0e318b3c0fd313fe057d0527&token=9ae2b24361ab04d8209b6657f2474efc445700c0be6349026215ce19506f33b9";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object createCard(String params) {
        String createCardPath = OperationPaths.CARD_PATH + "?key=" + key + "&token=" + token;
        String idList = "&idList=" + list;

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        Object resp = restTemplate.postForEntity(uri + createCardPath + params + idList, parts, String.class);

        return resp;
    }

    @Override
    public ResponseEntity getBoard() {

        ResponseEntity resp = restTemplate.getForEntity(uri, Object.class);

        return resp;
    }

}
