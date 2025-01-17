package albano.alex;

public class EsercizioSei {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(j%2==0){
                    System.out.print("X \t");
                }else {
                    System.out.print("O \t");
                }
            }
            System.out.println();
        }
    }
}
