package com.garth.tcg.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DatabaseClient {

	private final DataSource dataSource;

	@Autowired
	public DatabaseClient(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Map<String, Object>> execute(String sql) throws SQLException {
		return execute(sql, ResultSetTransformer.DEFAULT_TRANSFORMER);
	}

	public <T> List<T>  execute(String sql, ResultSetTransformer<T> transformer) throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			if (resultSet == null){
				return null;
			}
			List<T> response = new ArrayList<>();
			while (resultSet.next()) {
				response.add(transformer.apply(resultSet));
			}
			return response;
		}
	}

	public interface ResultSetTransformer<T> {

		T apply(ResultSet resultSet) throws SQLException;

		ResultSetTransformer<Map<String, Object>> DEFAULT_TRANSFORMER = (resultSet -> {
			ResultSetMetaData metaData = resultSet.getMetaData();
			Map<String, Object> row = new HashMap<>(metaData.getColumnCount());
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String columnName = metaData.getColumnName(i);
				Object value = resultSet.getObject(i);
				row.put(columnName, value);
			}
			return row;
		});
	}
}
