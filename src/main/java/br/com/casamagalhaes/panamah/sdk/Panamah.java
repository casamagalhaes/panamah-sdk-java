package br.com.casamagalhaes.panamah.sdk;

public class Panamah {

    private static Panamah instance;

    public synchronized static Panamah init() {
        if (instance == null) {
            instance = new Panamah();
        }
        return instance;
    }

}