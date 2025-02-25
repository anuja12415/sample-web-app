package battleship;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BattleField {
    private String [][] battleFieldGrid;
    private List<Player> playerList;

    public BattleField(String[][] battleFieldGrid){
        this.battleFieldGrid = battleFieldGrid;
        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B");
        List<Player> players = new ArrayList<Player>();
        players.add(playerA);
        players.add(playerB);
        this.playerList = players;
    }
}
