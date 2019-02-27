
package dao;

import entity.Score;
import entity.Username;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tariq Ali
 * 
    This class basically create Score Data Access Object. 
    Basically methods in this class helps Score logic to find user entered data
 */
public class ScoreDAO extends GenericDAO <Score> {
    
    
    // ScoreDAO Constructor that uses all SuperClass method and properties
    public ScoreDAO(){
        
        super(Score.class);
    }
    
    
    public List<Score> findAll(){
       return findResults("Score.findAll", null);
        
    }
    
    public Score findById(int id){
        Map <String, Object> map = new HashMap<>();
        map.put("id", id);
        return (Score) findResult ("Score.findById", map);
    }
    
    public List<Score> findByScore(int score){
        Map <String, Object > map = new HashMap<>();
        map.put("Score.findByScore", score);
        return findResults ("Score.findByScore", map);   
    }
    
    public List<Score> findBySubmission (Date submission){
        Map <String, Object> map = new HashMap<>();
        map.put("Score.findBySubmission", submission);
        return findResults ("Score.findBySubmission", map);
    }
    
    public List<Score> findByPlayerId(int playerId){
        Map <String, Object> map = new HashMap<>();
        map.put("Score.findByPlayerId", playerId);
        return findResults ("Score.findByPlayerId", map);
        
    }
    
    
    
}
