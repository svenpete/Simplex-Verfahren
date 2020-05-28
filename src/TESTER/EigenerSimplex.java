package TESTER;

public class EigenerSimplex {
    private int spalte, zeile; // row and column
    private int pivotSpalte;
    private float[][] table; // simplex tableau
    private boolean solutionIsUnbounded = false;


    public EigenerSimplex(int zeile, int spalte) {
        this.zeile = zeile + 1; // row number + 1
        this.spalte = spalte + 1;   // column number + 1
        table = new float[this.zeile][]; // create a 2d array

        // initialize references to arrays
        for (int i = 0; i < this.zeile; i++) {
            table[i] = new float[this.spalte];
        }
    }

    // prints out the simplex tableau
    public void print() {
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                String value = String.format("%.2f", table[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // fills the simplex tableau with coefficients
    public void fillTable(float[][] data) {
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(data[i], 0, this.table[i], 0, data[i].length);
        }
    }

    public int highestValueInLastZEILE() {
        float highestValue = 0;
        // nicht relevant da hier nur letzte spalte nicht betrachtet werden muss
        for (int i = 0; i < spalte - 1; i++) {
            if (Math.abs(table[zeile - 1][i]) > highestValue) {
                highestValue = Math.abs(table[zeile - 1][i]);
                pivotSpalte = i;


            }

        }

        return pivotSpalte;
    }


    public int pivotZeile() {
        float[] pivotSpalteWerte = new float[zeile - 1];
        float[] letztSpalte = new float[zeile - 1];
        float kleinsterWert = 0;
        float quotient;
        int pivotZeile = 0;
        int d = highestValueInLastZEILE();
        for (int i = 0; i < zeile - 1; i++) {

            pivotSpalteWerte[i] = table[i][d];
            letztSpalte[i] = table[i][spalte - 1];
            quotient = letztSpalte[i] / pivotSpalteWerte[i];
            if (i == 0) {
                kleinsterWert = quotient;
                pivotZeile = i;
            }
            if (quotient < kleinsterWert) {
                kleinsterWert = quotient;
                pivotZeile = i;
            }

        }
        return pivotZeile;
    }
    public void berechneTableau(int pivotZeile, int pivotSpalte)
    {
        float pivotElement = table[pivotZeile][pivotSpalte];
    }
    // Forms a new tableau from precomuted values.
    public void formNextTableau(int pivotZeile, int pivotSpalte) {
        float pivotValue = table[pivotZeile][pivotSpalte];
        float[] pivotZeilenValues = new float[spalte];
        float[] pivotSpaltenValues = new float[spalte];
        float[] rowNew = new float[spalte];

        // divide all entries in pivot row by entry in pivot column
        // get entry in pivot row
        System.arraycopy(table[pivotZeile], 0, pivotZeilenValues, 0, spalte);

        // get entry in pivot colum
        for (int i = 0; i < zeile; i++)
            pivotSpaltenValues[i] = table[i][pivotSpalte];

        // divide values in pivot row by pivot value
        for (int i = 0; i < spalte; i++)
            rowNew[i] = pivotZeilenValues[i] / pivotValue;

        // subtract from each of the other rows
        for (int i = 0; i < zeile; i++) {
            if (i != pivotZeile) {
                for (int j = 0; j < spalte; j++) {
                    float c = pivotSpaltenValues[i];
                    table[i][j] = table[i][j] - (c * rowNew[j]);
                }
            }
        }
    }
}
