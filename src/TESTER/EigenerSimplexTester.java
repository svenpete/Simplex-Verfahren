package TESTER;

import SimplexFunktioniert.Model.Simplex;

public class EigenerSimplexTester {

    public static void main(String[] args)
    {
        boolean quit = false;
        EigenerSimplex e = new EigenerSimplex(2,4);
        float[][] standardized =  {
                { 1,   1,    1,  0,   4},
                { 1,   3,    0,  1,   6},
                {-3,  -5,    0,  0,   0}
        };

        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        e.fillTable(standardized);
        e.print();
        System.out.println("-------------------------------------");
//        while(!quit)

        Error error = e.berechneSimplex();


            if (error == Error.STRING_IS_OPTIMAL)
            {
                e.print();
                quit= true;
            }

    }
}
