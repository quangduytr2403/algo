class Solution {
    public double largestTriangleArea(int[][] points) {
        double a, b, c, p;
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    a = calcLength(points[i][0], points[i][1], points[j][0], points[j][1]);
                    b = calcLength(points[j][0], points[j][1], points[k][0], points[k][1]);
                    c = calcLength(points[k][0], points[k][1], points[i][0], points[i][1]);
                    p = (a + b + c) / 2;
                    if (p > a && p > b && p > c) {
                        res = Math.max(res, Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                    }
                }
            }
        }

        return res;
    }

    double calcLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}