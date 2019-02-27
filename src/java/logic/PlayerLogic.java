
package logic;

import dao.PlayerDAO;
import entity.Player;
import entity.Username;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static logic.UsernameLogic.PLAYER_ID;
import static logic.UsernameLogic.USERNAME;

/**
 *
 * @author Tariq Ali
 * 
   Player Logic class desribes that how Player Data will be stored in database. 
   For eg: Player attribues
 */
public class PlayerLogic extends GenericLogic<Player, PlayerDAO> {
    
    public static final String ID  = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String JOINED ="joined";
    public static final String EMAIL = "email";
   
    
    public PlayerLogic(){
        super(new PlayerDAO());
    }
    
    public List<Player> getAllPlayers(){
        
        return get(()-> dao().findAll());
    }
    
    
    public Player getPlayersWithId(int id){
        
        return get(()-> dao().findById(id));
    }
    
    public List<Player> getPlayerWithFirstName(String firstName){
        
        return get (()-> dao().findByFirstName(firstName));
    }

    public List<Player> getPlayerWithLastName(String lastName){
        
        return get (()-> dao().findByLastName(lastName));
    }

    public List<Player> getPlayerJoinedOn(Date date){
        
        return get(()->dao().findByJoined(date));
        
    }
    
    public Player getPlayerWithEmail(String email){
        
        return get(()-> dao().findByEmail(email));
        
    }
    
    /*This is an Override method of SuperClass (GenericLogic).
    THis method describes the methology that how user entered data
    will become the value of Player class properties
    By using player.set()method.*/       
    @Override
    public Player createEntity(Map<String,String[]> parameterMap){
        
         Player player = new Player();
         
         Date date = Date.from(Instant.now(Clock.systemDefaultZone()));
         player.setId(Integer.valueOf(parameterMap.get(ID)[0]));
         player.setFirstName(parameterMap.get(FIRST_NAME)[0]);
         player.setLastName(parameterMap.get(LAST_NAME)[0]);
         player.setJoined(date);
         player.setEmail(parameterMap.get(EMAIL)[0]);
         
        add(player);
        UsernameLogic logic = new UsernameLogic();
        Username username = logic.createEntity(parameterMap);
        logic.add(username);
        return player;
    }
}

