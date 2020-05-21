package TestEditableTable.Model.Core;

public class Calculation {
    private Float[][] calculationTable;
    private boolean tableIsNotSet;
    private int columnSize;
    private int rowSize;

    public Calculation(Float[][] calculationTable) {
        this.calculationTable = calculationTable;
        this.columnSize = calculationTable[0].length;
        this.rowSize = calculationTable.length;
        this.tableIsNotSet = true;
    }

    public void solve()
    {
        boolean quit = false;

        while (!quit) {
            ERROR err = compute();

            if (err == ERROR.STRING_IS_OPTIMAL) {
                quit = true;
            } else if (err == ERROR.STRING_UNBOUNDED) {
                System.out.println("---Solution is unbounded---");
                quit = true;
            }
        }

    }



    public ERROR compute() {

        //step 1
        //checking if solution is optimal
        if (checkIfOptimal())
        {
            return ERROR.STRING_IS_OPTIMAL;
        }
        tableIsNotSet = false; // but why

        //step 2
        //finding the pivot column from given Table
        PivotStep step = new PivotStep(calculationTable);
        int pivotColumn = step.findPivotColumn();


        //step3
        //finding the pivot element in the pivot column
        Float[] ratios = step.calculateRatio(pivotColumn);
        if (PivotStep.solutionIsUnbounded) {
            return ERROR.STRING_UNBOUNDED;
        }

        int pivotRow = step.findSmallestValue(ratios);
        System.out.println("Das PivotElement ist " + calculationTable[pivotRow][pivotColumn]);

        //step 4
        //next table
         formNextTableau(pivotRow, pivotColumn);


        return ERROR.STRING_NOT_OPTIMAL;
    }

    /** checks the input of tablecolumns but why is their a constraint?
     *  when is an input optimal?
     * @return boolean
     *
     * SHOULD BE BUG FREE
     */
    public boolean checkIfOptimal() {
        boolean inputCheck = false;
        int variableCounter = 0;

            //  column reduction because of functional value
            for (int i = 0; i < (columnSize - 1); i++) {
                float val = calculationTable[(rowSize - 1)][i];
                if (val >= 0) {
                    variableCounter++;
                }
            }


        if (variableCounter == rowSize) {
            inputCheck = true;
        }

        return inputCheck;
    }

    private void formNextTableau(int pivotRow, int pivotColumn)
    {
        Float pivotValue = calculationTable[pivotRow][pivotColumn];
        Float[] pivotRowValues = new Float[calculationTable[0].length];
        Float[] pivotColumnValues = new Float[calculationTable.length];
        Float[] rowNew = new Float[calculationTable.length];


        System.arraycopy(calculationTable[pivotRow], 0, pivotRowValues,
                0, calculationTable[0].length);

        //rows
        for (int i = 0; i < rowSize; i++) {
            pivotColumnValues[i] = calculationTable[i][pivotColumn];
        }

        //columns
        for (int i = 0; i < columnSize; i++) {
            rowNew[i] = pivotRowValues[i] / pivotValue;
        }

        for (int i = 0; i < rowSize; i++) {
            if (i != pivotRow) {
                for (int j = 0; j < calculationTable[0].length; j++) {
                    float pivotColumnValue = pivotColumnValues[i];
                    calculationTable[i][j] = calculationTable[i][j]
                            - (pivotColumnValue * rowNew[j]);
                }
            }
        }

        System.arraycopy(rowNew, 0, calculationTable[pivotRow], 0, rowNew.length);

        for (int i = 0; i < rowSize; i++)
        {
            for (int j = 0; j < columnSize; j++)
            {
                String value = String.format("%.2f", calculationTable[i][j]);
                System.out.print(value + "\t");
            }

            System.out.println();
        }
        System.out.println();

    }




}
