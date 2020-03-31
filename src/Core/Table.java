package Core;

public class Table
{
    private int columns;
    private int rows;
    private int[][] table;

    public Table(int rows, int columns)
    {
        this.columns = columns;
        this.rows = rows;
        createTable(rows,columns);
    }


    private int[][] createTable(int rows,int columns)
    {
         table = new int[rows-1][columns-1];
        System.out.println("Die Tabelle besteht aus "+rows+ " Zeilen und "+ columns+ " Spalten");

        return table;
    }


    public static void main(String[] args)
    {
        Table table = new Table(3,2);
    }
}
