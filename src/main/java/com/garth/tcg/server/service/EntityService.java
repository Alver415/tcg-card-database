package com.garth.tcg.server.service;

import com.garth.tcg.server.model.EntityRow;
import com.garth.tcg.server.repository.EntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class EntityService<T extends EntityRow> {

	private final Logger log = LoggerFactory.getLogger(getClass());
	protected final EntityRepository<T> repository;

	@Autowired
	public EntityService(EntityRepository<T> repository) {
		this.repository = repository;
	}

	public List<T> getAll() {
		log.info("getAll");
		return repository.findAll();
	}

	public Optional<T> getById(Long id) {
		log.info("getById: {}", id);
		return repository.findById(id);
	}

	public T create(T entity) {
		log.info("create: {}", entity);
		if (entity.getId() != null){
			String message = "Already exists: %s".formatted(entity.getId());
			throw new IllegalStateException(message);
		}
		return repository.save(entity);
	}

	public T update(Long id, T entity) {
		log.info("update: {}, {}", id, entity);
		if (!Objects.equals(id, entity.getId())){
			String message = "Ids don't match: %s and %s".formatted(id, entity.getId());
			throw new IllegalArgumentException(message);
		}
		if (repository.findById(id).isEmpty()) {
			String message = "Not found: %s".formatted(id);
			throw new EntityNotFoundException(message);
		}
		return repository.save(entity);
	}

	public void delete(Long id) {
		log.info("delete: {}", id);
		if (repository.findById(id).isEmpty()) {
			String message = "Not found: %s".formatted(id);
			throw new EntityNotFoundException(message);
		}
		repository.deleteById(id);
	}

}
