package battleship;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BattleShipService {

    private BattleFieldDao battleFieldDao;
    private static String plus = "+";
    private static String minus = "-";

    BattleShipService(BattleFieldDao battleFieldDao) {
        this.battleFieldDao = battleFieldDao;
    }

    public BattleField initGame(int n) {
        String [][] battleFieldGrid = new String [n][n];
        //Assigning First vertical section to PlayerA denoted with + sign
        //Assigning First vertical section to PlayerB  denoted with - sign
        int separaterCounter = n/2;
        for (int i = 0; i <n ; i++) {

            for(int j=0;j<separaterCounter;j++) {
                battleFieldGrid[i][j] = plus;
            }
        }

        for (int i = 0; i <n ; i++) {

            for(int j=separaterCounter;j<n;j++) {
                battleFieldGrid[i][j] = minus;
            }
        }

        BattleField battleField = new BattleField(battleFieldGrid);
        return battleField;
    }

    void addShip(BattleField battleField, String id, int size, int PlayerARowNo, int PlayerAColNo,
                   int PlayerBRowNo,
                 int PlayerBColNo){
        String [][] battleGrid = battleField.getBattleFieldGrid();
        battleGrid[PlayerARowNo][PlayerAColNo] = id;
        battleGrid[PlayerBRowNo][PlayerBColNo] = id;
    }

    void startGame(BattleField battleField){
        String [][] battleGrid = battleField.getBattleFieldGrid();
        battleFieldDao.intializeScore(battleField);

        while(battleFieldDao.getWinner() == null) {
                //Player A 's turn
                attack(battleField.getPlayerList().get(0), battleGrid, battleField);
                if(battleFieldDao.getWinner() != null){
                    break;
                }
                //Player B's turn
                attack(battleField.getPlayerList().get(1), battleGrid, battleField);

                printBattleGrid(battleField);
        }
        System.out.println(battleFieldDao.getWinner() + " has won the game");
    }


    void attack(Player player, String[][] battleGrid, BattleField battleField){
        int attackCoordinateX = getRandomNumber();
        int attackCoordianteY = getRandomNumber();

        if (battleGrid[attackCoordinateX][attackCoordianteY] != plus && battleGrid[attackCoordinateX][attackCoordianteY] != minus) {
            Player playerToTakeHit;
            if (attackCoordianteY < (battleGrid.length / 2)) {
                playerToTakeHit = battleField.getPlayerList().get(0);
            } else {
                playerToTakeHit = battleField.getPlayerList().get(1);
            }

            String shipId = battleGrid[attackCoordinateX][attackCoordianteY];

            System.out.println("Missile fired at (" + attackCoordinateX + "," + attackCoordianteY + ")" +
                    "Hit" + playerToTakeHit.getPlayerName() + "'s ship with id " + shipId);
            battleFieldDao.getPlayerScore().put(player,
                    battleFieldDao.getPlayerScore().get(player) + 1);
        } else {
            System.out.println("PlayerB’s turn: Missile fired at (" + attackCoordinateX +
                    + attackCoordianteY + " Miss");
        }
    }
    int getRandomNumber(){
        Random rand = new Random();
        int max=3,min=0;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    static void printBattleGrid(BattleField battleField){
        String [][] grid = battleField.getBattleFieldGrid();
        int size = grid.length;
        for(int i=0; i<size; i++ ){
            for(int j=0; j<size; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
