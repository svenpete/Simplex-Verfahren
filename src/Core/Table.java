package Core;

import java.util.Scanner;

public class Table
{
    private int columns;
    private int rows;


    private Table(int rows,int columns)
    {
        this.columns = columns;
        this.rows = rows;

    }

    private int[][] createTableArray(int rows,int columns)
    {
        int[][] table;
        table = new int[rows-1][columns-1];
        return table;
    }

    public static void createTable()
    {
        Scanner NBScanner = new Scanner(System.in);
        Scanner VBScanner = new Scanner(System.in);

        System.out.println("Geben Sie die Anzahl an Nebenbedingugnen an:");
        int constraint = NBScanner.nextInt();


        System.out.println("Geben Sie die Anzahl an Variabeln an:");
        int variabels = VBScanner.nextInt();

        Table table = new Table(constraint,variabels);
        int[][] table1 = table.createTableArray(constraint,variabels);
        System.out.println("Es gibt " +(table1.length+1)+" Nebenbedingungen. Es gibt " + (table1[0].length+1) +" Variabeln.");
    }



}
