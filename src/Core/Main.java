package Core;
public class Main
{
    public static void main(String[] args)
    {
        Table table = new Table(2,3);
        Calculation calculation = new Calculation();
        table.createTable();
        table.fillTable();
        table.printTable();
        calculation.compute(table);

    }
}
