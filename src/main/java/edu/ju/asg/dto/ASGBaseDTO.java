package edu.ju.asg.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import edu.ju.asg.exception.ASGException;

@Component
public abstract class ASGBaseDTO {
	/**
	 * The Write Operation
	 */
	public void write(final JdbcTemplate jdbcTemplate) {
		write(jdbcTemplate, null);
	}

	public void write(final JdbcTemplate jdbcTemplate, final KeyHolder holder) {
		if (holder != null) {
			jdbcTemplate.update(createPrepareStatement(), holder);
		} else {
			jdbcTemplate.update(createPrepareStatement());
		}
	}

	private PreparedStatementCreator createPrepareStatement() {
		return new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(
						getSQL(), Statement.RETURN_GENERATED_KEYS);
				try {
					writeImpl(ps);
				} catch (ASGException | SQLException e) {
					e.printStackTrace();
				}
				return ps;
			}
		};
	}

	protected abstract void writeImpl(final PreparedStatement ps)
			throws SQLException, ASGException;

	protected abstract String getSQL();
}
