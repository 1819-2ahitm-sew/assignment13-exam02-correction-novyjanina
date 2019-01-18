package at.htl.bank.business;

import at.htl.bank.model.BankKonto;
import at.htl.bank.model.GiroKonto;
import at.htl.bank.model.SparKonto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Legen Sie eine statische Liste "konten" an, in der Sie die einzelnen Konten speichern
 *
 */
public class Main {

  // die Konstanten sind package-scoped wegen der Unit-Tests
  static final double GEBUEHR = 0.02;
  static final double ZINSSATZ = 3.0;

  static final String KONTENDATEI = "erstellung.csv";
  static final String BUCHUNGSDATEI = "buchungen.csv";
  static final String ERGEBNISDATEI = "ergebnis.csv";

  static List<BankKonto> konten = new ArrayList<>();

  
  /**
   * Führen Sie die drei Methoden erstelleKonten, fuehreBuchungenDurch und
   * findKontoPerName aus
   *
   * @param args
   */
  public static void main(String[] args) {

  }

  /**
   * Lesen Sie aus der Datei (erstellung.csv) die Konten ein.
   * Je nach Kontentyp erstellen Sie ein Spar- oder Girokonto.
   * Gebühr und Zinsen sind als Konstanten angegeben.
   *
   * Nach dem Anlegen der Konten wird auf der Konsole folgendes ausgegeben:
   * Erstellung der Konten beendet
   *
   * @param datei KONTENDATEI
   */
  private static void erstelleKonten(String datei) {
    String firstLine;
    String kontotyp;
    String name;
    double anfangsbetrag;

    try(Scanner scanner = new Scanner(new FileReader(datei))){
      firstLine = scanner.nextLine();
      while (scanner.hasNextLine()){
        String [] elements = scanner.nextLine().split(";");

        kontotyp =elements[0];
        name = elements[1];
        anfangsbetrag = Integer.parseInt(elements[2]);

        if (kontotyp.equals("Sparkonto")){
          konten.add(new SparKonto(name,anfangsbetrag,ZINSSATZ));
        }else if(kontotyp.equals("Girokonto")){
          konten.add(new GiroKonto(name,anfangsbetrag,GEBUEHR));
        }
      }
    }catch (FileNotFoundException e){
      System.err.println(e.getMessage());
    }

        System.out.println("Erstellung der Konten beendet");
  }

  /**
   * Die einzelnen Buchungen werden aus der Datei eingelesen.
   * Es wird aus der Liste "konten" jeweils das Bankkonto für
   * kontoVon und kontoNach gesucht.
   * Anschließend wird der Betrag vom kontoVon abgebucht und
   * der Betrag auf das kontoNach eingezahlt
   *
   * Nach dem Durchführen der Buchungen wird auf der Konsole folgendes ausgegeben:
   * Buchung der Beträge beendet
   *
   * Tipp: Verwenden Sie hier die Methode 'findeKontoPerName(String name)'
   *
   * @param datei BUCHUNGSDATEI
   */
  private static void fuehreBuchungenDurch(String datei) {
    String kontoVon;
    String kontoNach;
    String firstLine;
    double betrag;


    try(Scanner scanner = new Scanner(new FileReader(datei))) {
      firstLine = scanner.nextLine();

      while (scanner.hasNextLine()){
        String elements [] = scanner.nextLine().split(";");
        kontoVon = elements[0];
        kontoNach = elements[1];
        betrag = Integer.parseInt(elements[2]);



      }


    }catch (FileNotFoundException e){
      System.err.println(e.getMessage());
    }

        System.out.println("Buchung der Beträge beendet");
  }

  /**
   * Es werden die Kontostände sämtlicher Konten in die ERGEBNISDATEI
   * geschrieben. Davor werden bei Sparkonten noch die Zinsen dem Konto
   * gutgeschrieben
   *
   * Die Datei sieht so aus:
   *
   * name;kontotyp;kontostand
   * Susi;SparKonto;875.5
   * Mimi;GiroKonto;949.96
   * Hans;GiroKonto;1199.96
   *
   * Vergessen Sie nicht die Überschriftenzeile
   *
   * Nach dem Schreiben der Datei wird auf der Konsole folgendes ausgegeben:
   * Ausgabe in Ergebnisdatei beendet
   *
   * @param datei ERGEBNISDATEI
   */
  private static void schreibeKontostandInDatei(String datei) {
        System.out.println("schreibeKontostandInDatei noch nicht implementiert");
  }

  /**
   */
  /**
   * Durchsuchen Sie die Liste "konten" nach dem ersten Konto mit dem als Parameter
   * übergebenen Namen
   * @param name
   * @return Bankkonto mit dem gewünschten Namen oder NULL, falls der Namen
   *         nicht gefunden wird
   */
  public static BankKonto findeKontoPerName(String name) {

    for (BankKonto konto :konten){
      if (konto.getName().equals(name)){
        return konto;
      }
    }
       return null;
  }

}
