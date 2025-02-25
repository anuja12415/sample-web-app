package battleship;

public class BattleShipGameMain {

    private  static  BattleFieldDao battleFieldDao = new BattleFieldDao();
    private static  BattleShipService battleShipService =  new BattleShipService(battleFieldDao);

    BattleShipGameMain(BattleShipService battleShipService) {
        this.battleShipService = battleShipService;
    }

    public static void main(String[] args) {
        int battleFieldSize  = 4;

        BattleField battleField = battleShipService.initGame(battleFieldSize);
        System.out.println("Initialized BattleField");
        printBattleGrid(battleField);

        //Adding ship 1 to 0,1 and

        /*
        + SH1   -   -
        +  +    -   -
        + SH2   SH1 -
        + +     SH2 -
         */
        //Adding
        System.out.println();
        System.out.println("Adding SH1");
        battleShipService.addShip(battleField, "SH1", 0, 0, 1, 2, 2);
        printBattleGrid(battleField);

        System.out.println();
        System.out.println("Adding SH2");
        battleShipService.addShip(battleField, "SH2", 0, 2, 1, 3, 2);
        printBattleGrid(battleField);

        System.out.println();
        System.out.println("Start Game");
        battleShipService.startGame(battleField);
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
