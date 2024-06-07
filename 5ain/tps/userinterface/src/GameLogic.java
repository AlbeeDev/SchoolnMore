import java.util.Random;

public class GameLogic {
    //void:0;player:1;obstacle:2;
    int[][] gamematrix = new int[3][10];

    boolean f_obstacles=true;
    int playerx;
    public GameLogic(){
        playerx=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0 && i==playerx){
                    gamematrix[i][j] = 1;
                }
                else {
                    gamematrix[i][j] = 0;
                }

            }
        }
        printmatrix();

    }
    public void moveup(){
        if(playerx!=0) {
            int oldpos=playerx;
            playerx-=1;
            updatematrixplayerpos(oldpos);
        }
    }
    public void movedown(){
        if(playerx!=2){
            int oldpos=playerx;
            playerx+=1;
            updatematrixplayerpos(oldpos);

        }
    }

    private void updatematrixplayerpos(int oldpos){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0 && i==playerx){
                    gamematrix[i][j] = 1;
                }
                if(j==0 && i==oldpos){
                    gamematrix[i][j] = 0;
                }
            }
        }
    }

    public void generatenewcols(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[] obstacles = new int[numRows];

        if (f_obstacles) {
            obstacles = getRandomCombination(); // Only get obstacles if needed
        }

        if(gamematrix[playerx][1]==2){
            System.exit(0); //todo this is the check for death. make it on the server
        }

        // Shift to the left by 1
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols - 1; j++) {  // shift everything to the left by 1
                matrix[i][j] = matrix[i][j + 1];
            }
        }

        // Update the last column based on the flag
        for (int i = 0; i < numRows; i++) {
            matrix[i][numCols - 1] = obstacles[i];
        }

        // Toggle the flag for the next call
        f_obstacles = !f_obstacles;

        matrix[playerx][0] = 1;  // Ensure 'playerx' is defined and within bounds
    }

    public static int[] getRandomCombination() {
        // Define the combinations
        int[][] combinations = {
                {2, 0, 2},
                {0, 2, 2},
                {2, 2, 0},
                {0, 2, 0},
                {0, 0, 2},
                {2, 0, 0}
        };

        // Randomly select one of the combinations
        Random random = new Random();
        int randomIndex = random.nextInt(combinations.length);

        return combinations[randomIndex];
    }
    public void printmatrix(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(gamematrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
