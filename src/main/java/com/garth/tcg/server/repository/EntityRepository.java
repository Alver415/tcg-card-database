package com.garth.tcg.server.repository;

import com.garth.tcg.server.model.EntityRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T extends EntityRow> extends JpaRepository<T, Long> {
}