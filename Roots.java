import java.text.DecimalFormat;
import static java.lang.System.*;

class Roots {
    public static String squareRootFinder(int number, int iterations)
    {
        int i = 0;
        double start = 0.0, end = number, mid = (start + end) / 2; //initializing variables
        if (i < iterations) do
        {
            mid = (start + end) / 2;
            if (mid * mid < number) start = mid;
            else end = mid;
            i++;
        } while (i < iterations);
        DecimalFormat decimalFive = new DecimalFormat("#0.00000");// Decimal Format for 5 places
        return decimalFive.format(mid);
    }

    public static String nthRootFinder(int num, int iterations, int n)
    {
        int i = 0;
        double start = 0.0, end = num, mid = (start + end) / 2; //initializing variables
        if (i < iterations)
        {
            mid = (start + end) / 2;
            double temp = mid;
            //loop for the nth power of the number
            {
                int j = 1;
                while (j < n) {
                    temp = temp * mid;
                    j++;
                }
            }
            if (temp < num) start = mid;
            else end = mid;
            i++;
            while (i < iterations)
            {
                mid = (start + end) / 2;
                temp = mid;
                //loop for the nth power of the number
                int j = 1;
                while (j < n) {
                    temp = temp * mid;
                    j++;
                }
                if (temp < num) start = mid;
                else end = mid;
                i++;
            }
        }
        DecimalFormat decimalFive = new DecimalFormat("#0.00000");// Decimal Format for 5 places
        return decimalFive.format(mid);
    }

    public static void main(String[] args)
    {
        String squareRootFinder = squareRootFinder(41, 5);//Passing values to the function
        out.println(squareRootFinder);
        String nthRootFinder = nthRootFinder(41, 3, 3);//Passing values to the function
        out.println(nthRootFinder);
    }
}