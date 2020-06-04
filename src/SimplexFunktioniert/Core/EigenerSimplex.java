package SimplexFunktioniert.Core;

import SimplexFunktioniert.Controller.tableController;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EigenerSimplex {
    private final int column, row; // row and column
    private int pivotColumn;
    private float[][] table; // simplex tableau



    private static int arrayCounter = 1;
    private float[][] zwischenschritte1;
    private static float[][] zwischenschritte2;
    private static float[][] zwischenschritte3;
    private static float[][] zwischenschritte4;
    // private boolean solutionIsUnbounded = false;


    /**
     * Constructor of Simplex
     * @param row Number of the needed row for the table, one row is added for the results
     * @param column Number of the needed columns for the table, one column is added for the later values
     */

    public EigenerSimplex(int row, int column) {
        this.row = row + 1; // row number + 1
        this.column = column + 1;   // column number + 1
        table = new float[this.row][]; // create a 2d array

        // initialize references to arrays
        for (int i = 0; i < this.row; i++) {
            table[i] = new float[this.column];
        }
    }


    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String value = String.format("%.2f", table[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public void fillTable(float[][] data) {
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(data[i], 0, this.table[i], 0, data[i].length);
        }
    }

    /**
     * Method calculate the highest abs Value in the last row, to find the PivotColumn
     * @return pivotColumn, this return represents the tablecolumn
     */
    public int highestValueInLastRow() {
        float highestValue = 0;
        for (int i = 0; i < column - row; i++) {
            if (Math.abs(table[row - 1][i]) > highestValue) {
                highestValue = Math.abs(table[row - 1][i]);
                pivotColumn = i;
            }
        }

        return pivotColumn;
    }


    /**
     * Method calculates the pivot row, dependent on the value of the pivotColumn
     * @return  pivotRow, this return represents the tablerow
     */
    public int pivotRow() {
        float[] pivotColumnValue = new float[row - 1];
        float[] lastColumn = new float[row - 1];
        float smallestValue = 0;
        float quotient;
        int pivotRow = 0;
        for (int i = 0; i < row - 1; i++) {

            pivotColumnValue[i] = table[i][pivotColumn];
            lastColumn[i] = table[i][column - 1];
            quotient = lastColumn[i] / pivotColumnValue[i];
            if (i == 0) {
                smallestValue = quotient;
                pivotRow = i;
            }
            if (quotient < smallestValue) {
                smallestValue = quotient;
                pivotRow = i;
            }

        }
        return pivotRow;
    }


    /**
     * This method determine the pivotElement for the current step, and calculates the values for the new Tableau
     * @param pivotRow tablerow
     * @param pivotColumn tablecolum
     */
    public void formNewTableau(int pivotRow, int pivotColumn)
    {
        float pivotElement = table[pivotRow][pivotColumn];
        float[] pivotColumnValue = new float[row];
        float[] pivotRowValue = new float[column];
        float[] newRowForPivotRow = new float[column];
        float[][] transfer  = new float[row][column];

        //Calculation for the pivot Row Start

        System.arraycopy(table[pivotRow],0, pivotRowValue,0, column);

        for (int i = 0; i< column; i++)
        {
            newRowForPivotRow[i] = pivotRowValue[i] /pivotElement;
        }
        //Calculation for the pivot Row End

        for (int i = 0; i< row; i++)
        {
            pivotColumnValue[i] = table[i][pivotColumn];
            for (int j = 0; j< column; j++)
            {
                transfer[i][j] = table[i][j]- pivotColumnValue[i]/pivotElement*pivotRowValue[j];
                table[i][j] = transfer[i][j];
            }
        }
        System.arraycopy(newRowForPivotRow,0,table[pivotRow],0, column);


    }


    /**
     * Method, which iterate for the duration until the Simplex is optimal
     * @return the enumeration String IS OPTIMAL or String NOT OPTIMAL
     */
    public Error calcSimplex()
    {
        //Überprüfung ob  Tabelle bereits optimal ist.
        if (checkIfOptimal())
        {
            //System.out.println(Error.STRING_IS_OPTIMAL);
            return Error.STRING_IS_OPTIMAL;
        }

        //Ermittlung der Pivotspalte
        int spalte = highestValueInLastRow();


        //Ermitllung des Pivotelements
        int zeile = pivotRow();
        System.out.println("Das Pivotelement ist:" +table[zeile][spalte]);
        //Erstellung der neuen Tabelle
        formNewTableau(zeile,spalte);
       // print();


       // System.out.println(Error.STRING_NOT_OPTIMAL);
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
        int counter = 0;
        for(int i = 0; i< column -1; i++)
        {
            float letzteZeileWert = table[row -1][i];
           if (letzteZeileWert >=0)
            {
                counter++;
            }
        }

        if (counter== column -1 )
        {
            isOptimal= true;
        }
        return isOptimal;
    }

    public float [][] getTable1() {
        return this.zwischenschritte1;

    }
    public  float[][] getTable2() {
        return this.zwischenschritte2;
    }
    public float[][] getTable3() {
        return zwischenschritte3;
    }
    public float[][] getTable4() {
        return zwischenschritte4;
    }
    public static int getArrayCounter(){
        return arrayCounter;
    }

}
