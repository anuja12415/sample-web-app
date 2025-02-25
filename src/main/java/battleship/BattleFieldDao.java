package battleship;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BattleFieldDao {
    //Map to track the coordinates that have been visited
    private Map<Coordinate, Boolean> coordinateMap;

    //Map to keep track of player score
    private Map<Player, Integer> playerScore;

    int maxScore = 2;

    /*
    BattleField Table
    id, {players}
     */

    /*
    Player Scores
     */

    /*
    BattleField visited
     */


    public void intializeScore(BattleField battleField) {
        playerScore = new HashMap<Player, Integer>();
        List<Player> playerList = battleField.getPlayerList();
        playerScore.put(playerList.get(0), 0);
        playerScore.put(playerList.get(1), 0);
    }

    public String getWinner(){
        for(Map.Entry<Player, Integer> entry : playerScore.entrySet()){
            if(entry.getValue() >= maxScore){
                return entry.getKey().getPlayerName();
            }
        }
        return null;
    }
}
