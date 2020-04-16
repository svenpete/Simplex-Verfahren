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

    public PivotStep(){}




    public int findPivotColumn(Table table)
    {
        int[] values = new int[table.getColumns()];
        int column = 0;
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
                    values[i] = Math.abs(pivotTable[table.getRows() - 1][i]);
                   column = findLargestValue(values);
                }
            }else column = count-1;
        }

        return column;
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


    private double[] calculateRatio(Table table, int column)
    {

        double [] positiveEntries = new double[pivotTable[1].length];
        double [] result = new double[pivotTable[1].length];
        int allNegativeCount = 0;

        for(int i=0; i<pivotTable[i].length;i++)
        {
            if (pivotTable[i][column]>0)
            {
                positiveEntries[i] = pivotTable[i][column];
            } else
                {
                    positiveEntries[i] = 0;
                    allNegativeCount++;

                }
        }


        if (allNegativeCount ==pivotTable[1].length )
        {
            table.setSolutionIsUnbounded(true);
        }else
            {
                for (int i =0; i<pivotTable[1].length;i++)
                {
                    double value = positiveEntries[i];
                    if (value>0)
                    {
                        result[i] =pivotTable[i][table.getColumns()-1] / value;
                    }
                }
            }


        return result;

    }


}
