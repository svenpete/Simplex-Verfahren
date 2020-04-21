package Core;

public class PivotStep
{
    private int pivotColumn;
    private int pivotRow;
    private float[][] pivotTable;

    public PivotStep(){}

    public int findPivotColumn()
    {
        float[] values = new float[Table.getColumns()];
        int column = 0;
        int pos,count = 0;
        pivotTable = Table.getTabelle();

        for(pos = 0; pos < Table.getColumns(); pos++)
        {
            if(pivotTable[Table.getRows()][pos]<0)
            {
                count++;
            }
            if (count > 1)
            {
                for (int i=0; i<Table.getColumns();i++) {
                    values[i] = Math.abs(pivotTable[Table.getRows()][i]);
                   column = findLargestValue(values);
                }
            }else column = count-1;
        }

        return column;
    }


    private int findLargestValue(float[] data)
    {
        float maximum;
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


    public int findLowestValue(float[] data)
    {
        float minimum;
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


    public float[] calculateRatio(int column)
    {

        float [] positiveEntries = new float[pivotTable[1].length];
        float [] result = new float[pivotTable[1].length];
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
            Table.setSolutionIsUnbounded(true);
        }else
            {
                for (int i =0; i<pivotTable[1].length;i++)
                {
                    float value = positiveEntries[i];
                    if (value>0)
                    {
                        result[i] =pivotTable[i][Table.getColumns()-1] / value;
                    }
                }
            }


        return result;

    }


}
