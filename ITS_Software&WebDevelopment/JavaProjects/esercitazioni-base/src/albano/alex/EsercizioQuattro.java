package albano.alex;

public class EsercizioQuattro {
    public static void main(String[] args) {
        final int annoNascita= 2005;
        int annoAttuale = 2024;

        int eta = annoAttuale - annoNascita;
        System.out.println(eta);
        if(eta>18){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
