package TESTER.Core;

public class EigenerSimplexTester {

    public static void main(String[] args)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(4,7);
        float[][] standardized =  {
                {3,2,1,1,0,0,0,15},
                {2,3,1,0,1,0,0,16},
                {4,2,1,0,0,1,0,17},
                {1,2,3,0,0,0,1,200},
                {-3,-5,-6,0,0,0,0,0}

        };

        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        e.fillTable(standardized);
        //e.print();
        System.out.println(String.valueOf(standardized[0][0]));
        /*System.out.println("Test");
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
    }*/
}}
