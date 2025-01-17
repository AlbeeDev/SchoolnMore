package it.corso.dimostrazioni.banca;

import java.util.Random;

public class ContoCorrente {

    String intestatario;
    String numeroConto;
    String iban;
    double saldo;

    static final String IBAN_FISSO = "IT 07 K 02008 13000";

    public ContoCorrente(String intestatario) {
        this.intestatario = intestatario;
        this.saldo = 0.0;
        this.numeroConto = "";
        for(int i=0;i<7;i++){
            this.numeroConto += new Random().nextInt(10);
        }

        this.iban = IBAN_FISSO + this.numeroConto;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(String intestatario) {
        this.intestatario = intestatario;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(String importo) {
        this.saldo += Double.parseDouble(importo.trim().replace(',','.'));
    }

    public static boolean validaImporto(String importo){
        return importo.trim().replace(',','.').matches("[\\d.-]+");
    }

    @Override
    public String toString() {
        return intestatario + "\nil tuo iban è "+iban+"\nil tuo saldo è "+saldo;
    }
}
