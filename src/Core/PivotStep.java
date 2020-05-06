package Core;

public class PivotStep {
   
    private float[][] pivotTable;

    public PivotStep() {
    }

    public int findPivotColumn() {
        float[] values = new float[Table.getColumns()];
        int column = 0;
        int count = 0;
        pivotTable = Table.getTabelle();

        for (int pos = 0; pos < Table.getColumns() - 1; pos++) {
            if (pivotTable[Table.getRows() - 1][pos] < 0) {
                count++;

            }
            if (count > 1) {
                for (int i = 0; i < Table.getColumns(); i++) {
                    values[i] = Math.abs(pivotTable[Table.getRows() - 1][i]);
                    column = findLargestValue(values);
                }
            } else column = count - 1;
        }

        return column;
    }

    private int findLargestValue(float[] data) {
        float maximum;
        int location = 0;
        maximum = data[0];

        for (int c = 1; c < data.length; c++) {
            if (data[c] > maximum) {
                maximum = data[c];
                location = c;
            }
        }

        return location;

    }

    public int findSmallestValue(float[] data) {
        float minimum;
        int location = 0;
        minimum = data[0];

        for (int c = 1; c < data.length; c++) {
            if (data[c] < minimum) {
                minimum = data[c];
                location = c;
            }
        }

        return location;

    }

    public float[] calculateRatio(int column) {

        float[] positiveEntries = new float[Table.getRows() - 1];
        float[] result = new float[Table.getRows() - 1];
        int allNegativeCount = 0;

        for (int i = 0; i < Table.getRows() - 1; i++)
            if (pivotTable[i][column] > 0) {
                positiveEntries[i] = pivotTable[i][column];
            } else {
                positiveEntries[i] = 0;
                allNegativeCount++;

            }


        if (allNegativeCount == Table.getRows() - 1) {
            Table.setSolutionIsUnbounded(true);
        } else {
            for (int i = 0; i < Table.getRows() - 1; i++) {
                float value = positiveEntries[i];
                if (value > 0) {
                    result[i] = pivotTable[i][Table.getColumns() - 1] / value;
                }
            }
        }


        return result;

    }


}
