class Solution {
    public double angleClock(int hour, int minutes) {
        double addHour = (double) minutes / 60 * 5;
        addHour += (hour % 12) * 5;

        double angle =  Math.abs(addHour - minutes) / 60 * 360;

        return Math.min(angle, 360 - angle);
    }
}