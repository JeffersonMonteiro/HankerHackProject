package dayscode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip_percent_calc = (meal_cost/100)*tip_percent;
        double transformTax = Double.valueOf(tax_percent);
        double tax_percent_calc = (transformTax/100)*tip_percent_calc;
        double total_cost = meal_cost+tip_percent_calc+tax_percent_calc;

        BigDecimal bigDecimal = new BigDecimal(Double.toString(total_cost));
        bigDecimal = bigDecimal.setScale(0, RoundingMode.CEILING );

        System.out.println("Total Cost: "+ bigDecimal.toString());

    }

}

public class Operators {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}
