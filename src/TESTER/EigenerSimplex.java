package TESTER;

public class EigenerSimplex {
    private int spalte, zeile; // row and column
    private float[][] table; // simplex tableau
    private boolean solutionIsUnbounded = false;



    public EigenerSimplex(int zeile, int spalte){
        this.zeile = zeile+1; // row number + 1
        this.spalte = spalte+1;   // column number + 1
        table = new float[this.zeile][]; // create a 2d array

        // initialize references to arrays
        for(int i = 0; i < this.zeile; i++){
            table[i] = new float[this.spalte];
        }
    }

    // prints out the simplex tableau
    public void print(){
        for(int i = 0; i < zeile; i++){
            for(int j = 0; j < spalte; j++){
                String value = String.format("%.2f", table[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // fills the simplex tableau with coefficients
    public void fillTable(float[][] data){
        for(int i = 0; i < table.length; i++){
            System.arraycopy(data[i], 0, this.table[i], 0, data[i].length);
        }
    }
    public float highestValueInLastColumn(float[][] table)
    {
        // nicht relevant da hier nur letzte spalte nicht betrachtet werden muss
        for (int i = 0; i < spalte - 1; i++) {
            System.out.println(table[zeile][i]);
        }
        return (float) 0.00;
    }
}
