package albano.alex;

public class EsercizioDieci {
    public static void main(String[] args) {
        for(int ora=0; ora<24; ora++)
            for(int min=0; min<60; min++)
                for(int sec=0; sec<60; sec++)
                    System.out.println(ora + ":" + min + ":" + sec);
    }
}
