package com.trello.admin.repository;


import com.trello.admin.entity.Card;
import com.trello.admin.entity.Label;
import com.trello.admin.entity.Membership;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.trello.admin.OperationPaths.BOARD_PATH;
import static com.trello.admin.OperationPaths.CARD_PATH;
import static com.trello.admin.OperationPaths.LABEL_PATH;
import static com.trello.admin.OperationPaths.MEMBER_PATH;
import static com.trello.admin.OperationPaths.TRELLO_PATH;


@Slf4j
@Component
public class TrelloRestAdapter implements TrelloRepository {

    @Value("${trello.key}")
    private String key;

    @Value("${trello.token}")
    private String token;

    @Value("${trello.board.id}")
    private String idBoard;

    @Value("${trello.list.id}")
    private String list;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Card createCard(String params) {
        log.info("building path for create a new card");
        String createCardPath = CARD_PATH
                + "?key=" + key
                + "&token=" + token;
        String idList = "&idList=" + list;

        log.info("path created: {}", TRELLO_PATH + createCardPath + params + idList);
        ResponseEntity<Card> resp = restTemplate.postForEntity(TRELLO_PATH + createCardPath + params + idList, null, Card.class);

        log.info("card response: {}", resp.getBody());
        return resp.getBody();

    }

    @Override
    public List<Membership> getMembersBoard() {
        log.info("building path for get current members list");
        String getMembersBoardPath = BOARD_PATH
                + "/" + idBoard
                + MEMBER_PATH
                + "?key=" + key
                + "&token=" + token;

        log.info("path created: {}", TRELLO_PATH + getMembersBoardPath);
        ResponseEntity<Membership[]> resp = restTemplate.getForEntity(TRELLO_PATH + getMembersBoardPath, Membership[].class);

        log.info("members list response: {}", resp);
        return Arrays.asList(resp.getBody());
    }

    @Override
    public List<Label> getLabelList() {
        log.info("building path for get labels list");
        String getLabelPath = BOARD_PATH + "/"
                + idBoard + LABEL_PATH
                + "?key=" + key
                + "&token=" + token;

        log.info("path created: {}", TRELLO_PATH + getLabelPath);
        ResponseEntity<Label[]> resp = restTemplate.getForEntity(TRELLO_PATH + getLabelPath, Label[].class);

        log.info("board response: {}", resp.getBody());
        return Arrays.asList(resp.getBody());
    }

}
