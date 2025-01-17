package albano.alex;

public class EsercizioSei {
    public static void main(String[] args) {
        final int annoNascita= 2005;
        int annoAttuale = 2024;
        int eta = annoAttuale - annoNascita;

        if((eta+1)%2==0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

    }
}
