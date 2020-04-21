package Core;

public class Calculation {
    private float[][] calculationTable;


    public Calculation()
    {
        Table.createTable();
    }

    public ERROR compute()
    {
        //step 1
        //checking if solution is optimal
        if (checkIfOptimal())
        {
            return ERROR.STRING_IS_OPTIMAL;
        }

        //step 2
        //finding the pivot column

        PivotStep step = new PivotStep();
        int pivotColumn =  step.findPivotColumn();
        System.out.println("Pivot Column:   "+pivotColumn);

        //step3
        //finding the pivot element in the pivot column
        float[] ratios = step.calculateRatio(pivotColumn);
        if (Table.isSolutionIsUnbounded())
        {
            return ERROR.STRING_UNBOUNDED;
        }
        int pivotRow = step.findLowestValue(ratios);

        //step 4
        //next table
        formNextTableau(pivotRow,pivotColumn);



        return ERROR.STRING_NOT_OPTIMAL;
    }


    public  boolean checkIfOptimal(){
        boolean isOptimal = false;
        int vCount = 0;
        calculationTable = Table.getTabelle();

        for (int i = 0; i < Table.getColumns() - 1; i++) {
            float val = calculationTable[Table.getRows() - 1][i];
            if (val >= 0) {
                vCount++;
            }
        }

        if(vCount == Table.getColumns()-1)
        {
            isOptimal = true;
        }

        return isOptimal;
    }
    private void formNextTableau(int pivotRow, int pivotColumn )
    {
        float pivotValue = calculationTable[pivotRow][pivotColumn];
        float[] pivotRowVals = new float[Table.getColumns()];
        float[] pivotColumnVals = new float[Table.getColumns()];
        float[] rowNew = new float[Table.getColumns()];

        System.arraycopy(calculationTable[pivotRow],0,pivotRowVals,0,Table.getColumns());

        for (int i=0;i<Table.getRows();i++) {
            pivotColumnVals[i] = calculationTable[i][pivotColumn];
        }

        for (int i=0;i<Table.getColumns();i++)
        {
            rowNew[i] = pivotRowVals[i]/ pivotValue;
        }

        for (int i=0;i<Table.getRows();i++){
            if (i!= pivotRow)
            {
                for (int j = 0; j< Table.getColumns();j++)
                {
                float c = pivotColumnVals[i];
                calculationTable[i][j] = calculationTable[i][j]-(c*rowNew[j]);
                }
            }
        }

        System.arraycopy(rowNew,0,calculationTable[pivotRow],0,rowNew.length);

    }
}
