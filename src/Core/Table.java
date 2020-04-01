package Core;

import java.util.Scanner;

public class Table
{
    private int columns;
    private int rows;
    private int[][] tabelle;


    /**
     *
     * @param rows represent the Constraints
     * @param columns represent the variables
     *
     */
    public Table(int rows,int columns)
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

    public void createTable()
    {
        Scanner NBScanner = new Scanner(System.in);
        Scanner VBScanner = new Scanner(System.in);

        System.out.println("Geben Sie die Anzahl an Nebenbedingugnen an:");
        int constraint = NBScanner.nextInt();


        System.out.println("Geben Sie die Anzahl an Variabeln an:");
        int variabels = VBScanner.nextInt();

        Table table = new Table(constraint,variabels);
        tabelle = table.createTableArray(constraint,variabels);
        System.out.println("Es gibt " +(tabelle.length+1)+" Nebenbedingungen. Es gibt " + (tabelle[0].length+1) +" Variabeln.");
    }

    public void fillTable()
    {


    }





}
