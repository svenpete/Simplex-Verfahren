package Core;

import java.util.Scanner;

public class Table {

    private static int rows, cols;
    private static boolean solutionIsUnbounded = false;
    private static float[][] tabelle;


    /**
     * @param numOfConstraints   represent the Constraints
     * @param numOfUnknowns represent the variables
     */
    public Table(int numOfConstraints, int numOfUnknowns) {
        rows = numOfConstraints + 1;
        cols = numOfUnknowns + numOfConstraints + 1;
        tabelle = new float[rows][];

        for (int i = 0; i < rows; i++) {
            tabelle[i] = new float[cols];
        }
    }


    public static void createTable() {
        Scanner NBScanner = new Scanner(System.in);
        Scanner VBScanner = new Scanner(System.in);

        System.out.println("Geben Sie die Anzahl an Nebenbedingugnen an:");
        int constraint = NBScanner.nextInt();

        System.out.println("Geben Sie die Anzahl an Variabeln an:");
        int variabels = VBScanner.nextInt();

        Table table = new Table(constraint, variabels);
        //Table table = new Table(3,2);
        float[][] transmit = table.enterTableValues();
        table.fillTable(transmit);
        table.print();
    }

    private float[][] enterTableValues() {
        float[][] data = new float[rows][cols];
        for (int i = 0; i < tabelle.length; i++) {
            for (int j = 0; j < tabelle[i].length; j++) {
                System.out.println("Geben Sie den Wert in der Tabelle für [" + i + "][" + j + "] ein ");

                Scanner scanner = new Scanner(System.in);

                data[i][j] = scanner.nextInt();

                System.out.println("Der Wert in Tabelle[" + i + "][" + j + "] ist:" + data[i][j]);

            }
        }
        return data;
    }

    public void fillTable(float[][] data) {
        for (int i = 0; i < tabelle.length; i++) {
            System.arraycopy(data[i], 0, tabelle[i], 0, data[i].length);
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = String.format("%.2f", tabelle[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSolutionIsUnbounded() {
        return solutionIsUnbounded;
    }

    public static void setSolutionIsUnbounded(boolean solutionIsUnbounded) {
        Table.solutionIsUnbounded = solutionIsUnbounded;
    }

    public static float[][] getTabelle() {
        return tabelle;
    }

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return cols;
    }

}


