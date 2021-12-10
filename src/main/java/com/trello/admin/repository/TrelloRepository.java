package com.trello.admin.repository;

import com.trello.admin.entity.Card;
import com.trello.admin.entity.Label;
import com.trello.admin.entity.Membership;

import java.util.List;

public interface TrelloRepository {
    Card createCard(String params);
    List<Membership> getMembersBoard();
    List<Label> getLabelList();
}
