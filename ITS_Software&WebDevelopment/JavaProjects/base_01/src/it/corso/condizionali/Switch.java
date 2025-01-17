package it.corso.condizionali;

public class Switch {
    public static void main(String[] args) {
        String linguapredef = "it";

        switch (linguapredef) {
            case "it","IT":
                System.out.println("lingua italiana");
                break;
            case "fr":
                System.out.println("lingua francese");
                break;
            default:
                System.out.println("lingua inglese");
                break;
        }
    }
}
