package SimplexFunktioniert.Core;

public class EigenerSimplexTester {


    public static void berechne(int zeile, int spalte, float[][] test)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(zeile,spalte);
        float[][] standardized =  {
                {1,1,1,1,0,0,4},
                {1,3,1,0,1,0,6},
                {1,3,4,0,0,1,10},
                {-3,-5,-4,0,0,0,0},

        };

        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        e.fillTable(test);
        e.print();
        System.out.println("-------------------------------------");
        while(!quit) {
            i++;


           Error error = e.berechneSimplex();
            System.out.println("-------------------------------------");

           if (error == Error.STRING_IS_OPTIMAL) {
               e.print();
               quit = true;
           }
       }
    }
}
