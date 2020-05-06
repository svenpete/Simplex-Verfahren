package Core;

public class Main {
    public static void main(String[] args) {
        boolean quit = false;

        Calculation calculation = new Calculation();

        while (!quit) {
            ERROR err = calculation.compute();

            if (err == ERROR.STRING_IS_OPTIMAL) {
                quit = true;
            } else if (err == ERROR.STRING_UNBOUNDED) {
                System.out.println("---Solution is unbounded---");
                quit = true;
            }
        }


    }
}
