package com.garth.tcg.server.repository;

import com.garth.tcg.server.model.GameRow;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends EntityRepository<GameRow> {
}