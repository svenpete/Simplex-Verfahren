package SimplexFunktioniert.Core;

import java.util.ArrayList;

public class EigenerSimplexTester {


    public static ArrayList<float[][]> berechne(int zeile, int spalte, float[][] test)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(zeile,spalte);



        System.out.println("Dies ist die Ausgangsmatrix");
        System.out.println("-------------------------------------");
        e.fillTable(test);
        e.print();


        System.out.println("-------------------------------------");
        ArrayList<float[][]> liste = new ArrayList<float[][]>();
        while(!quit) {





           Error error = e.calcSimplex();
           e.print();


            System.out.println("-------------------------------------");
            if (error == Error.STRING_IS_OPTIMAL) {
                quit = true;
            }
           if(i==0)
           {
               float[][] trans = e.getTable1();
               liste.add(trans);
           }



       }

        float[][] trans1 = e.getTable2();
        liste.add(trans1);


        return liste;
    }
}
