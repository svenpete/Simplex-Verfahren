package TESTER;

public class EigenerSimplex {
    private int spalte, zeile; // row and column
    private int pivotSpalte;
    private float[][] table; // simplex tableau
    private boolean solutionIsUnbounded = false;


    /**
     * Konstruktor der Simplex Klasse
     * @param zeile Zahl der benötigten Zeilen für die Tabelle, eine Zeile wird als Ergebniszeile
     *              hinzugefügt
     * @param spalte ZAhl der benötigten Spalten für die Tabelle, eine Spalte wird ergänzt für
     *               die späteren xyz Werte
     */

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
    }

    // fills the simplex tableau with coefficients
    public void fillTable(float[][] data) {
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(data[i], 0, this.table[i], 0, data[i].length);
        }
    }

    public int höchsterWertDerLetztenZeile() {
        float highestValue = 0;
        // nicht relevant da hier nur letzte spalte nicht betrachtet werden muss
        for (int i = 0; i < spalte-zeile; i++) {
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
        for (int i = 0; i < zeile - 1; i++) {

            pivotSpalteWerte[i] = table[i][pivotSpalte];
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
        System.out.println("Das Element ist:"+ table[pivotZeile][pivotSpalte]);
        return pivotZeile;
    }
    // Forms a new tableau from precomuted values.
    public void erstelleNeueTabelle(int pivotZeile, int pivotSpalte)
    {
        float pivotElement = table[pivotZeile][pivotSpalte];
        float[] pivotZeilenWerte = new float[spalte];
        float[] neueZeile = new float[spalte];
        float[] neueZeilefuePivotZeile = new float[spalte];

        //Pivotzeile wird berechnet Anfang

        System.arraycopy(table[pivotZeile],0, pivotZeilenWerte,0,spalte);

        for (int i=0;i<spalte;i++)
        {
            neueZeilefuePivotZeile[i] = pivotZeilenWerte[i] /pivotElement;
        }
        System.arraycopy(neueZeilefuePivotZeile,0,pivotZeilenWerte,0,spalte);

        //PivotZeile wird berechnet Ende

        //TODO
        //für andere Elemente muss es noch ergänzt werden
    }



    public Error berechneSimplex()
    {
        //Überprüfung ob  Tabelle bereits optimal ist.
        if (checkIfOptimal())
        {
            System.out.println(Error.STRING_IS_OPTIMAL);
            return Error.STRING_IS_OPTIMAL;
        }

        //Ermittlung der Pivotspalte
        int spalte = höchsterWertDerLetztenZeile();

        //Ermitllung des Pivotelements
        int zeile = pivotZeile();

        //Erstellung der neuen Tabelle
        erstelleNeueTabelle(zeile,spalte);


        System.out.println(Error.STRING_NOT_OPTIMAL);
        return Error.STRING_NOT_OPTIMAL;
    }

    /**
     * method to check if the last row of the table contains some negative values, if it contains
     * negative values, the method gives back the information that the table is not optimal and the
     * algorithm is not finished yet
     * @return boolean value, table is optimal or not
     */
    public boolean checkIfOptimal()
    {
        boolean isOptimal = false;
        int zähler = 0;
        for(int i=0;i<spalte-1;i++)
        {
            float letzteZeileWert = table[zeile-1][i];
           if (letzteZeileWert >=0)
            {
                zähler++;
            }
        }

        if (zähler== spalte-1 )
        {
            isOptimal= true;
        }
        return isOptimal;
    }
}
