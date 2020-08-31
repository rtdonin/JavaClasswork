/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.dao;

import BullsAndCows.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GameDatabaseDao implements GameDao{
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    @Transactional
    public Game addGame(String answer) {
        final String INSERT_GAME = "INSERT INTO Game (answer) VALUES(?);";
        jdbc.update(INSERT_GAME, answer);
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
        Game game = new Game(newId, answer, false);
        
        return game;
    }

    @Override
    public Game getGameByGameId(int id) {
        try {
            final String SELECT_GAME = "SELECT *"
                                        + "FROM Game "
                                        + "WHERE gameId = ?;";
            Game game = jdbc.queryForObject(SELECT_GAME, new GameMapper(), id);

            return game;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_GAMES = "SELECT * FROM Game;";
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    @Transactional
    public void deleteGame(int id) {
        // First: delete the Attempts associated with the Game
        final String DELETE_ATTEMPT = "DELETE FROM Attempt WHERE gameId = ?;";
        jdbc.update(DELETE_ATTEMPT, id);
        
        // Second: delete the Game.
        final String DELETE_GAME = "DELETE FROM Game "
                                + "WHERE gameId = ?;";
        jdbc.update(DELETE_GAME, id);
    }

    @Override
    public void updateGame(int id) {
        final String UPDATE_GAME = "UPDATE Game "
                                + "SET isFinished = ? WHERE gameId = ?;";
        jdbc.update(UPDATE_GAME, true, id);
    }

    private static final class GameMapper implements RowMapper<Game> {
        
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game g = new Game();
            g.setGameId(rs.getInt("gameId"));
            g.setAnswer(rs.getString("answer"));
            g.setIsFinished(rs.getBoolean("isFinished"));
            
            return g;
        }
    }
}
