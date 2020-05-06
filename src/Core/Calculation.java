package Core;

public class Calculation {
    private float[][] calculationTable;
    private boolean tableIsNotSet = true;

    public void setCalculationTable(float[][] calculationTable) {
        this.calculationTable = calculationTable;
    }

    public Calculation() {
        Table.createTable();
    }


    public ERROR compute() {

        //step 1
        //checking if solution is optimal
        if (checkIfOptimal()) {
            return ERROR.STRING_IS_OPTIMAL;
        }
        tableIsNotSet = false;

        //step 2
        //finding the pivot column

        PivotStep step = new PivotStep();
        int pivotColumn = step.findPivotColumn();

        //step3
        //finding the pivot element in the pivot column
        float[] ratios = step.calculateRatio(pivotColumn);
        if (Table.isSolutionIsUnbounded()) {
            return ERROR.STRING_UNBOUNDED;
        }
        int pivotRow = step.findSmallestValue(ratios);
        System.out.println("Das PivotElement ist" + calculationTable[pivotRow][pivotColumn]);

        //step 4
        //next table
        setCalculationTable(formNextTableau(pivotRow, pivotColumn));


        return ERROR.STRING_NOT_OPTIMAL;
    }


    public boolean checkIfOptimal() {
        boolean isOptimal = false;
        int vCount = 0;

        if (tableIsNotSet) {

            calculationTable = Table.getTabelle();

            for (int i = 0; i < Table.getColumns() - 1; i++) {
                float val = calculationTable[Table.getRows() - 1][i];
                if (val >= 0) {
                    vCount++;
                }
            }
        } else {

            for (int i = 0; i < Table.getColumns() - 1; i++) {
                float val = calculationTable[Table.getRows() - 1][i];
                if (val >= 0) {
                    vCount++;
                }
            }

        }
        if (vCount == Table.getColumns() - 1) {
            isOptimal = true;
        }

        return isOptimal;
    }

    private float[][] formNextTableau(int pivotRow, int pivotColumn) {
        float pivotValue = calculationTable[pivotRow][pivotColumn];
        float[] pivotRowValues = new float[Table.getColumns()];
        float[] pivotColumnValues = new float[Table.getColumns()];
        float[] rowNew = new float[Table.getColumns()];

        System.arraycopy(calculationTable[pivotRow], 0, pivotRowValues, 0, Table.getColumns());

        for (int i = 0; i < Table.getRows(); i++) {
            pivotColumnValues[i] = calculationTable[i][pivotColumn];
        }

        for (int i = 0; i < Table.getColumns(); i++) {
            rowNew[i] = pivotRowValues[i] / pivotValue;
        }

        for (int i = 0; i < Table.getRows(); i++) {
            if (i != pivotRow) {
                for (int j = 0; j < Table.getColumns(); j++) {
                    float c = pivotColumnValues[i];
                    calculationTable[i][j] = calculationTable[i][j] - (c * rowNew[j]);
                }
            }
        }
        System.arraycopy(rowNew, 0, calculationTable[pivotRow], 0, rowNew.length);
        for (int i = 0; i < Table.getRows(); i++) {
            for (int j = 0; j < Table.getColumns(); j++) {
                String value = String.format("%.2f", calculationTable[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();

        return calculationTable;
    }


}
