package com.garth.tcg.server.controller;

import com.garth.tcg.server.model.EntityRow;
import com.garth.tcg.server.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class EntityRestController<T extends EntityRow> {

	private final EntityService<T> service;

	public EntityRestController(EntityService<T> service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<T>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getById(
			@PathVariable("id") Long id) {
		return ResponseEntity.of(service.getById(id));
	}

	@PostMapping()
	public ResponseEntity<T> create(
			@RequestBody T entity) {
		return ResponseEntity.ok(service.create(entity));
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(
			@PathVariable("id") Long id,
			@RequestBody T updated) {
		return ResponseEntity.ok(service.update(id, updated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(
			@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
