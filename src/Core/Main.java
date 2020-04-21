package Core;
public class Main
{
    public static void main(String[] args)
    {
        Calculation calculation = new Calculation();
        ERROR error =calculation.compute();
        System.out.println(error);

    }
}
