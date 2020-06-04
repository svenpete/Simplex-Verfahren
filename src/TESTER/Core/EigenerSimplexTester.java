package TESTER.Core;

public class EigenerSimplexTester {

    public static void main(String[] args)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(2,4);
        float[][] standardized =  {
                {1,1,1,0,4},
                {1,3,0,1,6},
                {-3,-5,0,0,0},


        };

        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        e.fillTable(standardized);
        e.print();


        do {


            Error error = e.berechneSimplex();
            System.out.println("-------------------------------------");

            if (error == Error.STRING_IS_OPTIMAL) {
                quit = true;
            }

        }
        while(!quit);
    }
}
