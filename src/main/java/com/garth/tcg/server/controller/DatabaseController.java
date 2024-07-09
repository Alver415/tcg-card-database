package com.garth.tcg.server.controller;

import com.garth.tcg.server.DatabaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    private final DatabaseClient databaseClient;

    @Autowired
    public DatabaseController(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @GetMapping("/execute")
    public List<Map<String, Object>> execute(@RequestBody String sql) throws SQLException {
        return databaseClient.execute(sql);
    }
}
