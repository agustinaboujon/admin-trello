package com.trello.admin.service.impl;

import com.trello.admin.entity.Card;
import com.trello.admin.entity.Label;
import com.trello.admin.entity.Membership;
import com.trello.admin.repository.TrelloRepository;
import com.trello.admin.service.ServiceCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class ServiceCardImpl implements ServiceCard {

    final int WORD_LENGTH = 3;
    final String BUG_LABEL = "Bug";
    final String ISSUE_TYPE = "issue";
    final String BUG_TYPE = "bug";
    final String TASK_TYPE = "task";

    @Autowired
    TrelloRepository trelloRepository;


    @Override
    public Card createCard(Card card) {
        String params = buildParams(card);
        log.info("has been created request-params: {}", params);
        return trelloRepository.createCard(params);
    }

    private String buildParams(Card card) {
        String params = "";

        switch (card.getType()) {
            case ISSUE_TYPE:
                params = "&name=" + URLEncoder.encode(generateRandomTitle(), StandardCharsets.UTF_8)
                        + "&desc=" + URLEncoder.encode(card.getDescription(), StandardCharsets.UTF_8);
                break;
            case BUG_TYPE:
                params = "&desc=" + URLEncoder.encode(card.getDescription(), StandardCharsets.UTF_8)
                        + "&idMembers=" + getRandomMember().getIdMember()
                        + "&name=" + URLEncoder.encode(generateRandomTitle(), StandardCharsets.UTF_8)
                        + "&idLabels=" + getIdLabel(BUG_LABEL);
                break;
            case TASK_TYPE:
                params = "&name=" + URLEncoder.encode(generateRandomTitle(), StandardCharsets.UTF_8)
                        + "&idLabels=" + getIdLabel(card.getCategory());

        }

        return params;

    }

    private String getIdLabel(String labelName) {
        Optional<Label> label =
                trelloRepository.getLabelList()
                        .stream()
                        .filter(
                                item -> item.getName().equals(labelName)
                        )
                        .findAny();

        return label.get().getId();
    }

    private Membership getRandomMember() {
        List<Membership> memberList = trelloRepository.getMembersBoard();
        Optional<Membership> member = memberList.stream().findAny();
        return member.get();
    }

    private String generateRandomTitle() {
        Random random = new Random();
        String title = "bug-" + randomWord(WORD_LENGTH) + "-" + random.nextInt();
        return title;
    }

    public String randomWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            word.append((char) ('a' + random.nextInt(26)));
        }

        return word.toString();
    }
}


