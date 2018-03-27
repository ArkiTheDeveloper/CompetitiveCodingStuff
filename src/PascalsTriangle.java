import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class PascalsTriangle {

    public static ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> pascalValue = new ArrayList<>();
        ArrayList<Integer> preList;
        for (int i=0; i<A; i++) {
            preList = new ArrayList<>();
            BigDecimal rowFactorial = computeFactorial(new BigDecimal(i));
            for (int j=0; j<=i; j++) {
                BigDecimal colFactorial = computeFactorial(new BigDecimal(j));
                BigDecimal diffFactorial = computeFactorial(new BigDecimal(i).subtract(new BigDecimal(j)));
                try {
                    preList.add((rowFactorial.divide(colFactorial.multiply( diffFactorial), MathContext.DECIMAL64)).intValue());
                } catch (Exception e) {
                    System.out.println(i + " " + j + " " + colFactorial + " " + diffFactorial);
                }
            }
            pascalValue.add(preList);
        }
        return pascalValue;
    }

    private static BigDecimal computeFactorial(BigDecimal x) {
        if (x.equals(BigDecimal.ZERO) || x.equals(BigDecimal.ONE)) {
            return BigDecimal.ONE;
        }
        return x.multiply(computeFactorial(x.subtract(BigDecimal.ONE)));
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> generate = generate(100);
        for (ArrayList<Integer> generated : generate) {
            generated.forEach(System.out::print);
        }
    }
}
