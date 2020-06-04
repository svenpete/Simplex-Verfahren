package SimplexFunktioniert.Core;

public class EigenerSimplexTester {


    public static float[][] berechne(int zeile, int spalte, float[][] test)
    {
        boolean quit = false;
        int i=0;
        EigenerSimplex e = new EigenerSimplex(zeile,spalte);



       // System.out.println("Dies ist die Ausgangsmatrix");
        //System.out.println("-------------------------------------");
        e.fillTable(test);
        //e.print();
        //System.out.println("-------------------------------------");
        while(!quit) {

            float[][] trans;

           Error error = e.calcSimplex();
            trans = e.getTable1();

            System.out.println("-------------------------------------");
            System.out.println("Hier kommt der getTableTest");

            for (int i1=0;i1<trans.length;i1++)
            {
                for (int i2=0;i2<trans[0].length;i2++)
                {
                    String value = String.format("%.2f", trans[i1][i2]);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }



            if (error == Error.STRING_IS_OPTIMAL) {
               e.print();
               quit = true;
           }
           return trans;
       }

        return null;
    }
}
