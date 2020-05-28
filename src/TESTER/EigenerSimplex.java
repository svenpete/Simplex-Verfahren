package TESTER;

public class EigenerSimplex {
    private int rows, cols; // row and column
    private float[][] table; // simplex tableau
    private boolean solutionIsUnbounded = false;



    public EigenerSimplex(int numOfConstraints, int numOfUnknowns){
        rows = numOfConstraints+1; // row number + 1
        cols = numOfUnknowns+1;   // column number + 1
        table = new float[rows][]; // create a 2d array

        // initialize references to arrays
        for(int i = 0; i < rows; i++){
            table[i] = new float[cols];
        }
    }

    // prints out the simplex tableau
    public void print(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
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
}
