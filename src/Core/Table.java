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
        tabelle = table.createTableArray(constraint+1,variabels+1);
        System.out.println("Es gibt " +(tabelle.length)+" Nebenbedingungen. Es gibt " + (tabelle[0].length) +" Variabeln.");

    }

    public void fillTable()
    {
        for (int i=0;i<tabelle.length;i++)
        {
            for (int j = 0; j <tabelle[i].length; j++)
            {
                System.out.println("Geben Sie den Wert in der Tabelle für ["+ i+"]["+j+"] ein ");

                Scanner scanner = new Scanner(System.in);

                tabelle[i][j] = scanner.nextInt();

                System.out.println("Der Wert in Tabelle["+i+"]["+j+"] ist:"+tabelle[i][j]);
            }
        }
    }


    public void printTable()
    {
        for (int i=0;i<tabelle.length;i++)
        {
            for( int j = 0; j<tabelle[i].length;j++)
            {
                System.out.print(tabelle[i][j]+"|");
                if (tabelle[i].length-1==j)
                {
                    System.out.print("\n");
                }
            }
        }
    }





}
