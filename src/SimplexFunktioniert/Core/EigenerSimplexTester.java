package SimplexFunktioniert.Core;

import java.util.ArrayList;

public class EigenerSimplexTester {


    public static ArrayList<float[][]> berechne(int zeile, int spalte, float[][] test)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(zeile,spalte);



        System.out.println("Dies ist die Ausgangsmatrix");
        e.fillTable(test);


        System.out.println("-------------------------------------");
        ArrayList<float[][]> liste = new ArrayList<float[][]>();
        do {




            e.print();
            Error error = e.calcSimplex();



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
        while(!quit);


        float[][] trans1 = e.getTable2();
        liste.add(trans1);


        return liste;
    }
}
