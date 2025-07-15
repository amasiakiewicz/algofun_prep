package algo.fun.algofun_prep.threemonth.week10.largestrectangle;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

class Result {
    
    private static class Rectangle {
        int start;
        int height;

        Rectangle(final int start, final int height) {
            this.start = start;
            this.height = height;
        }

        long size(final int end) {
            return (long) (end - start) * height;
        }
    }

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
        final Deque<Rectangle> rectangles = new ArrayDeque<>();
        long maxSize = 0;
        final int hSize = h.size();
        
        for (int i = 0; i < hSize; i++) {
            final Integer height = h.get(i);
            final Rectangle rectangle = new Rectangle(i, height);
            if (rectIsHigherThanLast(rectangles, rectangle)) {
                rectangles.add(rectangle);
                continue;
            }
            
            while (!rectIsHigherThanLast(rectangles, rectangle)) {
                final Rectangle lastRectangle = rectangles.pollLast();
                final long size = lastRectangle.size(i);
                maxSize = Math.max(maxSize, size);
                
                rectangle.start = lastRectangle.start;
            }
            
            rectangles.add(rectangle);
        }
        
        while (!rectangles.isEmpty()) {
            final Rectangle lastRectangle = rectangles.pollLast();
            final long size = lastRectangle.size(hSize);
            maxSize = Math.max(maxSize, size); 
        }
        
        return maxSize;
    }

    private static boolean rectIsHigherThanLast(final Deque<Rectangle> rectangles, final Rectangle rectangle) {
        if (rectangles.isEmpty()) {
            return true;
        }
        
        final Rectangle lastRectangle = rectangles.peekLast();
        return rectangle.height > lastRectangle.height;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
