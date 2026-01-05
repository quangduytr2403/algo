class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minAbs = Integer.MAX_VALUE;
        int countNeg = 0;
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(matrix[i][j]);
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
                if (matrix[i][j] <= 0) countNeg++;
            }
        }

        if (countNeg % 2 == 0) return sum;
        else return sum - 2L * minAbs;
    }
}