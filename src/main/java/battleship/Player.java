package battleship;

import lombok.Data;

@Data
public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }
}
