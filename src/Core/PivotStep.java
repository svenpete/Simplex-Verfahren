package Core;

public class PivotStep
{
    private double pivotColumn;
    private double pivotRow;
    private double pivotElement;
    private boolean isPivotElementTaken;

    public PivotStep(double pivotColumn, double pivotRow, double pivotElement, boolean isPivotElementTaken)
    {
        this.pivotColumn = pivotColumn;
        this.pivotRow = pivotRow;
        this.pivotElement = pivotElement;
        this.isPivotElementTaken = isPivotElementTaken;
    }



}
