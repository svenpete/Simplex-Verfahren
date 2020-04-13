package Core;

public class PivotStep
{
    private int pivotColumn;
    private int pivotRow;
    private int[][] pivotTable;
    /* private double pivotElement;
    private boolean isPivotElementTaken;

    public PivotStep(double pivotColumn, double pivotRow, double pivotElement, boolean isPivotElementTaken)
    {
        this.pivotColumn = pivotColumn;
        this.pivotRow = pivotRow;
        this.pivotElement = pivotElement;
        this.isPivotElementTaken = isPivotElementTaken;
    }*/

    public void findPivotElement(Table table)
    {

        pivotColumn = findPivotColumn(table);
        pivotRow = findLowestValue();
    }


    private int findPivotColumn(Table table)
    {
        int[] values = new int[table.getColumns()];
        int location = 0;
        int pos,count = 0;
        pivotTable = table.getTabelle();

        for(pos = 0; pos < table.getColumns()-1;pos++)
        {
            if(pivotTable[table.getRows()-1][pos]<0)
            {
                count++;
            }


            if (count > 1)
            {
                for (int i=0; i<table.getColumns()-1;i++) {
                    values[i] = Math.abs(pivotTable[table.getRows() - 1][i]):
                   location = findLargestValue(values);
                }
            }else location = count-1;
        }

        return location;
    }


    private int findLargestValue(int[] data)
    {
        int maximum;
        int location = 0;
        maximum = data[0];

        for (int c=1; c < data.length; c++)
        {
            if(data[c] > maximum)
            {
                maximum = data[c];
                location =c;
            }
        }

        return  location;

    }


    private int findLowestValue(int[] data)
    {
        int minimum;
        int location = 0;
        minimum = data[0];

        for (int c=1; c < data.length; c++)
        {
            if(data[c] < minimum)
            {
                minimum = data[c];
                location =c;
            }
        }

        return  location;

    }



}
