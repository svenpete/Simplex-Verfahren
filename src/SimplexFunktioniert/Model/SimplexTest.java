package SimplexFunktioniert.Model;

public class SimplexTest {


    public static void calculate(Simplex simplex, float[][] tableValues) {
        boolean quit = false;


        // Example problem:
        // maximize 3x + 5y
        // subject to x +  y = 4 and
        //            x + 3y = 6
        float[][] standardized =  {
                { 1,   1,    1,  0,   4},
                { 1,   3,    0,  1,   6},
                {-3,  -5,    0,  0,   0}
        };



        simplex.fillTable(tableValues);

        // print tableau out
        System.out.println("---Starting set---");
        simplex.print();

        // if table is not optimal re-iterate
        while(!quit){
            ERROR err = simplex.compute();
            simplex.print();
            if(err == ERROR.STRING_IS_OPTIMAL){
                simplex.print();
                quit = true;
            }
            else if(err == ERROR.STRING_UNBOUNDED){
                System.out.println("---Solution is unbounded---");
                quit = true;
            }
        }
    }
}



