package com.garth.tcg.server.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "GAME")
public class GameRow extends EntityRow {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<CardRow> cards = new ArrayList<>();

    public List<CardRow> getCards() {
        return cards;
    }

    public void setCards(List<CardRow> cards) {
        this.cards = cards;
    }
}
