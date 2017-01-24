package app.Models;

import java.sql.Date;

/**
 * Created by Piotr Urban on 13.01.2017.
 */
public class Patient {

    private String imie;
    private String nazwisko;
    private String plec;
    private String email;
    private String numerKomorkowy;
    private String numerStacjonarny;
    private String ulica;
    private String numerDomu;
    private String haslo;
    private String kodPocztowy;
    private String miejscowosc;
    private String pesel;
    private Date dataUrodzenia;
    private String osobaKontaktowa;
    private String osobaKontaktowa_no;

    public Patient() {}

    public Patient(String imie, String nazwisko, String plec, String email, String numerKomorkowy, String numerStacjonarny, String ulica,
                   String numerDomu, String haslo, String kodPocztowy, String miejscowosc, String pesel, Date dataUrodzenia, String osobaKontaktowa, String osobaKontaktowa_no) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
        this.numerKomorkowy = numerKomorkowy;
        this.numerStacjonarny = numerStacjonarny;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.haslo = haslo;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.osobaKontaktowa = osobaKontaktowa;
        this.osobaKontaktowa_no = osobaKontaktowa_no;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerKomorkowy() {
        return numerKomorkowy;
    }

    public void setNumerKomorkowy(String numerKomorkowy) {
        this.numerKomorkowy = numerKomorkowy;
    }

    public String getNumerStacjonarny() {
        return numerStacjonarny;
    }

    public void setNumerStacjonarny(String numerStacjonarny) {
        this.numerStacjonarny = numerStacjonarny;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getOsobaKontaktowa() {
        return osobaKontaktowa;
    }

    public void setOsobaKontaktowa(String osobaKontaktowa) {
        this.osobaKontaktowa = osobaKontaktowa;
    }

    public String getOsobaKontaktowa_no() {
        return osobaKontaktowa_no;
    }

    public void setOsobaKontaktowa_no(String osobaKontaktowa_no) {
        this.osobaKontaktowa_no = osobaKontaktowa_no;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", email='" + email + '\'' +
                ", numerKomorkowy='" + numerKomorkowy + '\'' +
                ", numerStacjonarny='" + numerStacjonarny + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numerDomu='" + numerDomu + '\'' +
                ", haslo='" + haslo + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", osobaKontaktowa='" + osobaKontaktowa + '\'' +
                ", osobaKontaktowa_no='" + osobaKontaktowa_no + '\'' +
                '}';
    }
}
