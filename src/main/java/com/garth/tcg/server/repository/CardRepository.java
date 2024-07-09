package com.garth.tcg.server.repository;

import com.garth.tcg.server.model.CardRow;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends EntityRepository<CardRow> {
}