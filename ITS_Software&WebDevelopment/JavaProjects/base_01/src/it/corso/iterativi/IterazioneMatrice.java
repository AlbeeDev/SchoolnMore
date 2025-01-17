package it.corso.iterativi;

public class IterazioneMatrice {
    public static void main(String[] args) {
        int[][] tabelline = new int[10][10];

        for(int i=0; i<tabelline.length; i++){
            for(int j=0; j<tabelline[i].length; j++){
                tabelline[i][j] = (i+1)*(j+1);
            }
        }

        for(int[] riga : tabelline){
            for(int cella : riga){
                System.out.print(cella+" \t");
            }
            System.out.println();
        }
    }
}
