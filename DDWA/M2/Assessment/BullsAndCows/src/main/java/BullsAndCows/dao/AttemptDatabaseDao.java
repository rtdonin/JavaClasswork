/*
Created by: Ma/garet Donin
Date created: 08/21/20
Date revised:
*/

package BullsAndCows.dao;

import BullsAndCows.dto.Attempt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AttemptDatabaseDao implements AttemptDao{

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    @Transactional
    public Attempt addAttempt (Attempt attempt) {        
        final String INSERT_ATTEMPT = "INSERT INTO Attempt(gameId, guess, score) VALUES(?,?,?);";
        jdbc.update(INSERT_ATTEMPT,
                attempt.getGameId(),
                attempt.getGuess(),
                attempt.getScore());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
        
        final String SELECT_ATTEMPT = "SELECT *"
                                    + "FROM Attempt "
                                    + "WHERE attemptId = ?;";
        attempt = jdbc.queryForObject(SELECT_ATTEMPT, new AttemptMapper(), newId);
        
        return attempt;
    }

    @Override
    public Attempt getAttemptByAttemptId (int id) {
        try {
            final String SELECT_ATTEMPT = "SELECT *"
                                        + "FROM Attempt "
                                        + "WHERE attemptId = ?;";
            Attempt attempt = jdbc.queryForObject(SELECT_ATTEMPT, new AttemptMapper(), id);

            return attempt;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Attempt> getAllAttempts () {
        final String SELECT_ALL_ATTEMPTS = "SELECT * FROM Attempt;";
        return jdbc.query(SELECT_ALL_ATTEMPTS, new AttemptMapper());
    }
    
    @Override
    public List<Attempt> getAllAttemptsByGameId (int id) {
                try {
            final String SELECT_ATTEMPTS = "SELECT *"
                                        + "FROM Attempt "
                                        + "WHERE gameId = ?";
            List<Attempt> attempts = jdbc.query(SELECT_ATTEMPTS, new AttemptMapper(), id);

            return attempts;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteAttempt(int id) {
        final String DELETE_ATTEMPT = "DELETE FROM Attempt "
                                    + "WHERE attemptId = ?;";
        jdbc.update(DELETE_ATTEMPT, id);
    }

    @Override
    public void updateAttempt(Attempt attempt) {
        final String UPDATE_ATTEMPT = "UPDATE Attempt "
                                    + "SET guess = ?, score = ? "
                                    + "WHERE attemptId = ?;";
        jdbc.update(UPDATE_ATTEMPT,
                attempt.getGuess(),
                attempt.getScore(),
                attempt.getAttemptId());
    }

    private static final class AttemptMapper implements RowMapper<Attempt> {
        
        @Override
        public Attempt mapRow(ResultSet rs, int index) throws SQLException {
            Attempt a = new Attempt();
            a.setAttemptId(rs.getInt("attemptId"));
            a.setGameId(rs.getInt("gameId"));
            a.setGuess(rs.getString("guess"));
            a.setScore(rs.getString("score"));
            a.setTimestamp(rs.getTime("time"));
            
            return a;
        }
    }
}
