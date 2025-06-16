package obiectConstructor;

import java.sql.SQLOutput;

public class Masina {

    // un constructor are ca rol sa initializeze atributele unei clase
    // recunoastem un constructor intr-o clasa dupa numele clasei care este la fel cu constructorul
    // un constructor poate sa fie public, private, protected urmat de acelasi nume cu clasa
    // intr-o clasa putem sa avem mai multi constructori diferentiati prin numarul sau tipul de parametrii
    // un obiect este o instanta a unei clase care contine proprietarile si metodele acesteia
    // dintr-o clasa putem sa creem o multime de obiecte diferentiate prin numele acestora
    // in momentul cand se initializeaza un obiect folosim cuvantul "new" urmat de apelarea constructorului din clasa
    // exemplu:       masina FasoleAudi = new masina ("Audi", "A4");  -> asa faci un obiect de tipu, masina care are numele FasoleAudi si are prop Audi si A4
    // in momentul cand am initializat un obiect pe baza lui putem sa accesam proprietarile si metodele din clasa respectiva( in cazul asta clasa e masina )
    // in momentul cand creem un obiect se aloca spatiu in memorie special pentru aceasta reprezentare

    public String marca;
    public String model;
    public String consum;
    public String culoare;
    public int caiPutere;
    public int greutate;
    public String nrkm;
    public int pret;

    public Masina(String marca, String model, String consum, String culoare, int caiPutere, int greutate, String nrkm) {
        this.marca = marca;
        this.model = model;
        this.consum = consum;
        this.culoare = culoare;
        this.caiPutere = caiPutere;
        this.greutate = greutate;
        this.nrkm = nrkm;
    }

    public Masina(String marca, String model, String consum, String culoare, int caiPutere, int greutate, String nrkm, int pret) {
        this.marca = marca;
        this.model = model;
        this.consum = consum;
        this.culoare = culoare;
        this.caiPutere = caiPutere;
        this.greutate = greutate;
        this.nrkm = nrkm;
        this.pret = pret;
    }

    //facem o metoda
    public void prezentareComandaMasina() {

        System.out.println("Marca masinii este: " + marca);
        System.out.println("Modelul masinii este: " + model);
        System.out.println("Consumul masinii este: " + consum);
        System.out.println("Culoarea masinii este: " + culoare);
        System.out.println("Puterea masinii este: " + caiPutere);
        System.out.println("Greutatea masinii este: " + greutate);
        System.out.println("Numarul de km sunt:  " + nrkm);
        if (pret > 0) {
            System.out.println("Pretul unei masinii este " + pret);
        }
    }
        //daca greutatea este pana in 2000. avem de plata 5 lei impozit
        //daca greutatea este cuprinsa intre 2000 si 4000 platim 10 lei impozit
        //daca greutatea este peste 4000 platim 15 lei impozit

        public void taxaGreutate(){

        if (greutate <= 2000) {
            System.out.println("Taxa pe greutate este de: " + pret);
        }
        if (greutate >= 2000 && greutate <= 4000){
            System.out.println("Taxa pe greutate este de: " + pret);
            }
        if (greutate > 4000){
            System.out.println("Taxa pe greutate este de: " + pret);
        }
        }
    }
