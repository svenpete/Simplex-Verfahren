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
        float[][] test1 = null;
        while(!quit) {
            i++;

           Error error = e.calcSimplex();
           if(i==1) {
               test1 = e.getTable1();
           }
            steps.getStep(zeile,spalte,test);
            System.out.println("-------------------------------------");

           if (error == Error.STRING_IS_OPTIMAL) {
               e.print();
               quit = true;
           }
       }
        return test1;

    }
}
