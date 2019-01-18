package at.htl.bank.model;

public class GiroKonto extends BankKonto {
    private double gebuehr;

    public GiroKonto(String name, double gebuehr){
        super(name);
    }
    public GiroKonto(String name, double anfangsBestand, double gebuehr){
        super(name, anfangsBestand);
        this.gebuehr = gebuehr;
    }
}
