package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new int[]{nums.get(i).get(j), i, j});
            }
        }

        Collections.sort(list, (a, b) -> {
            int result = Integer.compare(a[1] + a[2], b[1] + b[2]);
            if (result == 0) result = Integer.compare(b[1], a[1]);
            if (result == 0) result = Integer.compare(a[2], b[2]);
            return result;
        });

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i)[0];
        }
        return array;
    }
}