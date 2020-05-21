package TestEditableTable.Model.Core;

import Core.Table;

public class PivotStep {

    private Float[][] pivotTable;
    int columnSize;
    int rowSize;
    public static boolean solutionIsUnbounded = false;


    public PivotStep(Float[][] pivotTable) {
        this.pivotTable = pivotTable;
        this.columnSize = pivotTable[0].length;
        this.rowSize = pivotTable.length;
    }

    // should work fine
    public int findPivotColumn() {

        int largestValues = 0;
        int count = 0;

        // values stores
        Float[] values = new Float[(rowSize -1)];
        for (int i = 0; i < rowSize; i++)
        {
            values = pivotTable[i];
        }

        for (int pos = 0; pos < (columnSize - 1); pos++) {
            // welcher zweck?
            if (pivotTable[(rowSize - 1)][pos] < 0) {
                count++;
            }

            if (count > 1)
            {
                for (int i = 0; i < (columnSize - 1 ); i++) {
                    values[i] = Math.abs(pivotTable[(rowSize - 1)][i]); // weshalb runden?
                    largestValues = findLargestValue(values);
                }
            } else largestValues = (count - 1);  // WHY
        }

        return largestValues;
    }

    private int findLargestValue(Float[] value) {
        float maximum;
        int location = 0;
        maximum = value[0];
        // starts count with zero instead of 1
        for (int i = 0; i < value.length; i++) {
            if (value[i] > maximum) {
                maximum = value[i];
                location = i;
            }
        }

        return location;

    }

    public int findSmallestValue(Float[] value) {
        float minimum;
        int location = 0;
        minimum = value[0];
        // why starts countin at 1 ?
        for (int c = 0; c < value.length; c++) {
            if (value[c] < minimum) {
                minimum = value[c];
                location = c;
            }
        }

        return location;

    }

    public Float[] calculateRatio(int column) {

        Float[] positiveEntries = new Float[(rowSize - 1)];
        Float[] result = new Float[(rowSize - 1)];
        Integer allNegativeCount = 0;


        for (int i = 0; i < (rowSize - 1); i++) {

            if (pivotTable[i][column] > 0) {
                positiveEntries[i] = pivotTable[i][column];
            } else {
                positiveEntries[i] = Float.valueOf(0);
                allNegativeCount++;

            }
        }
            if (allNegativeCount == (columnSize - 1)) {
                solutionIsUnbounded = true;
            } else {
                for (int i = 0; i < (rowSize - 1); i++) {
                    float value = positiveEntries[i];
                    if (value > 0) {
                        result[i] = pivotTable[i][(columnSize - 1)] / value;
                    }
                }
            }
            return result;
        }

}
