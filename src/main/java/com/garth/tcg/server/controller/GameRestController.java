package com.garth.tcg.server.controller;


import com.garth.tcg.server.model.GameRow;
import com.garth.tcg.server.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameRestController extends EntityRestController<GameRow> {

	@Autowired
	public GameRestController(EntityService<GameRow> service) {
		super(service);
	}

}
