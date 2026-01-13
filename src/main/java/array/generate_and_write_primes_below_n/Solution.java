package array.generate_and_write_primes_below_n;

import common.PrintHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i < Math.floor(Math.sqrt(n) + 1); i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public List<Integer> generatePrimesBelowN(int n, String filePath) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        try {
            Files.writeString(Path.of(filePath), primes.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can not write on file:" + filePath.toString());
        }

        return primes;
    }

}
