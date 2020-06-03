package SimplexFunktioniert.Core;

public class EigenerSimplexTester {


    public static void berechne(int zeile, int spalte, float[][] test)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(zeile,spalte);



        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        System.out.println("Test");
        e.fillTable(test);
        e.print();
        System.out.println("-------------------------------------");
        while(!quit) {
            i++;


           Error error = e.calcSimplex();
            System.out.println("-------------------------------------");

           if (error == Error.STRING_IS_OPTIMAL) {
               e.print();
               quit = true;
           }
       }
    }
}
