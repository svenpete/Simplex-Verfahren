package TESTER;

public class EigenerSimplexTester {

    public static void main(String[] args)
    {
        EigenerSimplex e = new EigenerSimplex(2,4);

        float[][] standardized =  {
                { 1,   1,    1,  0,   4},
                { 1,   3,    0,  1,   6},
                {-3,  -5,    0,  0,   0}
        };
        e.fillTable(standardized);
        e.print();
        int zeile = e.pivotZeile();
        int spalte = e.highestValueInLastZEILE();
        System.out.println("Pivotzeile: " + zeile);
        System.out.println("Pivotspalte: " + spalte);
        e.formNextTableau(zeile,spalte);
        e.print();
         zeile = e.pivotZeile();
         spalte = e.highestValueInLastZEILE();
        System.out.println("Pivotzeile: " + zeile);
        System.out.println("Pivotspalte: " + spalte);
        e.formNextTableau(zeile,spalte);
        e.print();

    }
}
