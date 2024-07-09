package com.garth.tcg.server.controller;

import com.garth.tcg.server.model.CardRow;
import com.garth.tcg.server.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardRestController extends EntityRestController<CardRow> {

	@Autowired
	public CardRestController(EntityService<CardRow> cardService) {
		super(cardService);
	}
}
