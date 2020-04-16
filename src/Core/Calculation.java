package Core;

public class Calculation {
    private int[][] calculationTable;


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



        return ERROR.STRING_NOT_OPTIMAL;
    }


    public  boolean checkIfOptimal(Table table) {
        boolean isOptimal = false;
        int vCount = 0;
        calculationTable = table.getTabelle();

        for (int i = 0; i < table.getColumns() - 1; i++) {
            int val = calculationTable[table.getRows() - 1][i];
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
}
