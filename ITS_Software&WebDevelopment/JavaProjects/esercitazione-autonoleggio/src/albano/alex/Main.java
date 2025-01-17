package albano.alex;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Veicolo> veicoli = new ArrayList<Veicolo>();
    static List<Cliente> clienti = new ArrayList<>();
    static List<Noleggio> noleggi = new ArrayList<>();

    static final String DATEREGEX = "\\d{4}-\\d{2}-\\d{2}"; //gpt
    static final String TARGAREGEX = "^[A-Z]{2}\\s\\d{3}\\s[A-Z]{2}$"; //gpt

    public static void main(String[] args) {

        boolean temp1 = true;
        boolean temp2 = true;

        Veicolo auto1 = new Autovettura("lamborghini","huracan","r48724r8",1120,2,2);
        Veicolo auto2 = new Autovettura("porsche","911", "98fe83q8dj", 850, 2, 2);

        Veicolo furgone1 = new Furgone("Scania", "modello1", "89d2h92d", 450, 1400,1000,500,400);

        veicoli.add(auto1);
        veicoli.add(auto2);
        veicoli.add(furgone1);
        System.out.println(veicoli);

        Cliente cliente1 = new Cliente("Mario", "Rossi", "A123456");
        Cliente cliente2 = new Cliente("Luca", "Bianchi", "B987654");
        Cliente cliente3 = new Cliente("Giulia", "Verdi", "C456789");


        clienti.add(cliente1);
        clienti.add(cliente2);
        clienti.add(cliente3);

        System.out.println(clienti);


        // inizio operazioni

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("r - registra dati / v - visualizza dati / altro - uscire");
            String input = sc.nextLine();

            breaklabel:
            if (input.equals("r")) {
                while (true) {
                    System.out.println("1 - inserisci cliente / 2 - inserisci noleggio / 3 - inserisci autovettura / 4 - inserisci furgone / altro - torna indietro");
                    input = sc.nextLine();
                    switch (input) {
                        case "1":
                            insertCliente(sc);
                            System.out.println("inserito cliente");
                            break;
                        case "2":
                            insertNoleggio(sc);
                            System.out.println("inserito noleggio");
                            break;
                        case "3":
                            insertAutovettura(sc);
                            System.out.println("inserito autovettura");
                            break;
                        case "4":
                            insertFurgone(sc);
                            System.out.println("inserito furgone");
                            break;
                        default:
                            System.out.println("torno indietro");
                            break breaklabel;
                    }
                }

            } else if (input.equals("v")) {
                while (true) {
                    System.out.println("1 - visualizza clienti / 2 - visualizza noleggi / 3 - visualizza veicoli / altro - torna indietro");
                    input = sc.nextLine();
                    switch (input) {
                        case "1":
                            System.out.println(clienti);
                            break;
                        case "2":
                            System.out.println(noleggi);
                            break;
                        case "3":
                            System.out.println(veicoli);
                            break;
                        default:
                            System.out.println("torno indietro");
                            break breaklabel;
                    }
                }

            } else {
                System.exit(0);
            }
        }
    }

    private static void insertFurgone(Scanner sc) {
        System.out.println("inserisci marca");
        String marca = sc.nextLine();
        System.out.println("inserisci modello");
        String modello = sc.nextLine();
        System.out.println("inserisci targa");
        String targa = sc.nextLine();
        System.out.println("inserisci tariffa giornaliera");
        double tariffa = sc.nextDouble();

        System.out.println("inserisci portata in kg");
        double portata = sc.nextDouble();
        System.out.println("inserisci lunghezza");
        double lunghezza = sc.nextDouble();
        System.out.println("inserisci larghezza");
        double larghezza = sc.nextDouble();
        System.out.println("inserisci altezza");
        double altezza = sc.nextDouble();

        veicoli.add(new Furgone(marca,modello,targa,tariffa,portata,lunghezza,larghezza,altezza));
    }

    private static void insertAutovettura(Scanner sc) {
        boolean valid = false;
        System.out.println("inserisci marca");
        String marca = sc.nextLine();
        System.out.println("inserisci modello");
        String modello = sc.nextLine();
        String targa;
        do {
            System.out.println("inserisci targa");
            targa = sc.nextLine();
        } while (targa.matches(TARGAREGEX));
        double tariffa = 0;
        while (!valid){
            System.out.println("inserisci tariffa giornaliera");
            try {
                tariffa = sc.nextDouble();
                valid = true;
            } catch (NumberFormatException e) {}

        }

        valid = false;
        int porte = 0;
        while (!valid){
            System.out.println("inserisci numero porte");
            try {
                porte = sc.nextInt();
                sc.nextLine();
                valid = true;
            } catch (NumberFormatException e) {}
        }

        valid = false;
        int posti = 0;
        while (!valid){
            System.out.println("inserisci numero posti");
            try {
                posti = sc.nextInt();
                sc.nextLine();
                valid = true;
            } catch (NumberFormatException e) {}
        }

        veicoli.add(new Autovettura(marca, modello, targa, tariffa, porte, posti));
    }

    private static void insertNoleggio(Scanner sc) {

        String dataInizio;
        do {
            System.out.println("inserisci data inizio (YYYY-MM-DD)");
            dataInizio = sc.nextLine();
        } while (!dataInizio.matches(DATEREGEX));

        String dataFine;
        do {
            System.out.println("inserisci data fine (YYYY-MM-DD)");
            dataFine = sc.nextLine();
        } while (!dataFine.matches(DATEREGEX));

        int idx_veicolo;
        do {
            System.out.println("seleziona veicolo per indice (da 0)");
            System.out.println(veicoli);
            idx_veicolo = sc.nextInt();

        } while (idx_veicolo < 0 || idx_veicolo >= veicoli.size());

        int idx_cliente;
        do {
            System.out.println("seleziona cliente per indice (da 0)");
            System.out.println(clienti);
            idx_cliente = sc.nextInt();
        } while (idx_cliente < 0 || idx_cliente >= clienti.size());
        noleggi.add(new Noleggio(LocalDate.parse(dataInizio),LocalDate.parse(dataFine),veicoli.get(idx_veicolo),clienti.get(idx_cliente)));
    }

    private static void insertCliente(Scanner sc) {
        System.out.println("Inserisci nome");
        String nome = sc.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = sc.nextLine();
        System.out.println("Inserisci numero patente");
        String numeroPatente = sc.nextLine();
        clienti.add(new Cliente(nome, cognome, numeroPatente));
    }
}
