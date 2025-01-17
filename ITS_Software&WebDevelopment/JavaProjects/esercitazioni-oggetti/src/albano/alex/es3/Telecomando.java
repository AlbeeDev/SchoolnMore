package albano.alex.es3;

public class Telecomando {

    String lastPressed;

    public Telecomando() {
        lastPressed = "";
    }

    public void stampaTelecomando(){
        if(lastPressed.isEmpty()){
            for (int i = 1; i < 10; i++) {
                System.out.print(i+"\t");

                if(i%3==0) {
                    System.out.println();
                }

            }
        } else {
            for (int i = 1; i < 10; i++) {
                if(i==Integer.parseInt(lastPressed)){
                    System.out.print("P\t");
                } else {
                    System.out.print(i+"\t");
                }

                if(i%3==0) {
                    System.out.println();
                }
            }
        }


    }

    public String getLastPressed() {
        return lastPressed;
    }

    public void setLastPressed(String lastPressed) {
        this.lastPressed = lastPressed;
    }
}
