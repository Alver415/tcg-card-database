package com.garth.tcg.server.service;

import com.garth.tcg.server.model.CardRow;
import com.garth.tcg.server.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardService extends EntityService<CardRow> {

	@Autowired
	public CardService(CardRepository cardRepository) {
		super(cardRepository);
	}
}
