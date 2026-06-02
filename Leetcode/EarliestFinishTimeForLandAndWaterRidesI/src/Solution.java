class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = Integer.MAX_VALUE, t;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                if (landStartTime[i] + landDuration[i] < waterStartTime[j]) {
                    t = waterStartTime[j] + waterDuration[j];
                } else t = landStartTime[i] + landDuration[i] + waterDuration[j];

                if (waterStartTime[j] + waterDuration[j] < landStartTime[i]) {
                    t = Math.min(t, landStartTime[i] + landDuration[i]);
                } else t = Math.min(t, waterStartTime[j] + waterDuration[j] + landDuration[i]);

                res = Math.min(res, t);
            }
        }

        return res;
    }
}