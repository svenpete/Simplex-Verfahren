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
        float es =e.highestValueInLastColumn(standardized);
    }
}
