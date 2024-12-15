import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue to maximize the gain
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );

        // Add all classes to the heap with initial values
        for (int[] c : classes) {
            pq.add(new double[]{c[0], c[1]});
        }

        // Assign extra students
        while (extraStudents > 0) {
            double[] c = pq.poll(); // Get the class with the maximum gain
            c[0] += 1; // Increment pass count
            c[1] += 1; // Increment total count
            pq.add(c); // Recalculate and push back to the heap
            extraStudents--;
        }

        // Calculate the final average pass ratio
        double total = 0.0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            total += c[0] / c[1];
        }

        return total / classes.length;
    }

    // Helper function to calculate the gain of adding one student
    private double gain(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}
