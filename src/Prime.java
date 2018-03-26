import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    public List<Integer> factors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; number > 1; divisor++) {
            for (;number % divisor == 0; number /= divisor) {
                factors.add(divisor);
            }
        }
        return factors;
    }
}
