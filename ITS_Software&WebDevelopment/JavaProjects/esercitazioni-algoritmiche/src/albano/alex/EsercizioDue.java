package albano.alex;

public class EsercizioDue {
    public static void main(String[] args) {
        char[] array = {'J', 'a', 'v', 'a'};
        String stringa = "";

        StringBuilder sb = new StringBuilder(stringa);
        for(char c : array){
             sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
