package algo.fun.algofun_prep.month.week3.waiter;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        final ArrayList<Integer> answers = new ArrayList<>();
        
        final List<Integer> primeNumbers = getPrimeNumbers(q);
        
        ArrayList<Integer> reversedNumbers = new ArrayList<>(number);
        Collections.reverse(reversedNumbers);

        int primeInd = 0;
        final ArrayList<Integer> A = new ArrayList<>();
        final ArrayList<Integer> B = new ArrayList<>();

        while (primeInd < q && !reversedNumbers.isEmpty()) {
            for (Integer currentNumber : reversedNumbers) {
                final Integer primeNumber = primeNumbers.get(primeInd);

                if (currentNumber % primeNumber != 0) {
                    A.add(currentNumber);
                } else {
                    B.add(currentNumber);
                }
            }

            Collections.reverse(B);
            answers.addAll(B);
            B.clear();

            reversedNumbers.clear();
            Collections.reverse(A);
            reversedNumbers.addAll(A);
            A.clear();
            
            primeInd++;
        }
        
        answers.addAll(reversedNumbers);
        
        return answers;
    }

    private static List<Integer> getPrimeNumbers(final int q) {
        final ArrayList<Integer> primeNumbers = new ArrayList<>();
        int number = 2;
        
        while (primeNumbers.size() < q) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
            
            number++;
        }
        
        return primeNumbers;
    }

    private static boolean isPrime(final int number) {
        return IntStream
                .rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
