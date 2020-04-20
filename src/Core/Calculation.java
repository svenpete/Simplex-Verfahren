package Core;

public class Calculation {
    private float[][] calculationTable;


    public Calculation()
    {


    }

    public ERROR compute(Table table)
    {
        //step 1
        //checking if solution is optimal
        if (checkIfOptimal(table))
        {
            return ERROR.STRING_IS_OPTIMAL;
        }

        //step 2
        //finding the pivot column
        PivotStep step = new PivotStep();
        int pivotColumn =  step.findPivotColumn(table);
        System.out.println("Pivot Column:   "+pivotColumn);

        //step3
        //finding the pivot element in the pivot column
        float[] ratios = step.calculateRatio(table, pivotColumn);
        if (table.isSolutionIsUnbounded())
        {
            return ERROR.STRING_UNBOUNDED;
        }
        int pivotRow = step.findLowestValue(ratios);

        //step 4
        //next table
        formNextTableau(pivotRow,pivotColumn, table);



        return ERROR.STRING_NOT_OPTIMAL;
    }


    public  boolean checkIfOptimal(Table table) {
        boolean isOptimal = false;
        int vCount = 0;
        calculationTable = table.getTabelle();

        for (int i = 0; i < table.getColumns() - 1; i++) {
            float val = calculationTable[table.getRows() - 1][i];
            if (val >= 0) {
                vCount++;
            }
        }

        if(vCount == table.getColumns()-1)
        {
            isOptimal = true;
        }

        return isOptimal;
    }
    private void formNextTableau(int pivotRow, int pivotColumn, Table table)
    {
        float pivotValue = calculationTable[pivotRow][pivotColumn];
        float[] pivotRowVals = new float[table.getColumns()];
        float[] pivotColumnVals = new float[table.getColumns()];
        float[] rowNew = new float[table.getColumns()];

        System.arraycopy(calculationTable[pivotRow],0,pivotRowVals,0,table.getColumns());

        for (int i=0;i<table.getRows();i++) {
            pivotColumnVals[i] = calculationTable[i][pivotColumn];
        }

        for (int i=0;i<table.getColumns();i++)
        {
            rowNew[i] = pivotRowVals[i]/ pivotValue;
        }

        for (int i=0;i<table.getRows();i++){
            if (i!= pivotRow)
            {
                for (int j = 0; j< table.getColumns();j++)
                {
                float c = pivotColumnVals[i];
                calculationTable[i][j] = calculationTable[i][j]-(c*rowNew[j]);
                }
            }
        }

        System.arraycopy(rowNew,0,calculationTable[pivotRow],0,rowNew.length);

    }
}
