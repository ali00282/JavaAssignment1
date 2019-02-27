
package logic;

import dao.ScoreDAO;
import entity.Player;
import entity.Score;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import static logic.PlayerLogic.ID;

/**
 *
 * @author Tariq Ali
 * Score Logic class desribes that how Score Data will be stored in database. 
   For eg: Score attributes
 */
public class ScoreLogic extends GenericLogic<Score, ScoreDAO> {

    public static final String ID = "playerID";
    public static final String SCORE = "score";
    public static final String SUBMISSION = "submission";

    public ScoreLogic() {

        super(new ScoreDAO());
    }

    public List<Score> getAll() {

        return get(() -> dao().findAll());
    }

    public Score getById(int id) {

        return get(() -> dao().findById(id));
    }

    public List<Score> getScoresWith(int score) {

        return get(() -> dao().findByScore(score));
    }

    public List<Score> getScoreOnDate(Date submission) {

        return get(() -> dao().findBySubmission(submission));
    }

    public List<Score> getScoresForPlayerID(int playerid) {

        return get(() -> dao().findByPlayerId(playerid));
    }

    
   /*This is an Override method of SuperClass (GenericLogic).
    THis method describes the methology that how user entered data(parameterMap)
    will become the value of Score class properties
    By using score.set()method.*/  
    @Override
    public Score createEntity(Map<String, String[]> parameterMap) {

        Score score = new Score();
        Date date = Date.from(Instant.now(Clock.systemDefaultZone()));
        Player player = new PlayerLogic().getPlayersWithId(Integer.valueOf(parameterMap.get(ID)[0]));

//        if (player != null) {
            
            score.setPlayerid(player);
            score.setScore(Integer.valueOf(parameterMap.get(SCORE)[0]));
            score.setSubmission(date);
            add(score);
//        }
        

        return score;
    }

}
