package obiectConstructor;

import org.testng.annotations.Test;

public class ObiectTest {

    @Test

    public void testMethod(){

        Masina masinaAudi = new Masina("Audi", "A4", "8l/100km", "rosu", 220, 3580,"60.000");
        masinaAudi.prezentareComandaMasina();
        masinaAudi.taxaGreutate();

        System.out.println("");

        Masina masinaMercedes = new Masina("Mercedes", "W211", "11l/100km", "verde", 310, 2800,"75.000");
        masinaMercedes.prezentareComandaMasina();

        System.out.println("");

        masinaMercedes.culoare = "portocaliu";
        masinaMercedes.model = "S class";
        masinaMercedes.prezentareComandaMasina();

        System.out.println("");

        Masina masinaOpel = new Masina("Opel", "Corsa", "12l/100km", "Gri", 168, 3800,"115.000", 8000);
        masinaOpel.prezentareComandaMasina();

    }
}
