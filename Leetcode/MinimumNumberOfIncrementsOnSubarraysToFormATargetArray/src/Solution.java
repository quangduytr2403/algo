import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    SegmentTree st;
    int res = 0;

    public int minNumberOperations(int[] target) {
        st = new SegmentTree(target);
        split(target, 0, target.length - 1, 0);
        return res;
    }

    void split(int[] target, int l, int r, int base) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{l, r, base});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int left = cur[0], right = cur[1], level = cur[2];
            if (left > right) continue;

            // Get min value and its index
            int[] q = st.query(left, right);
            int minVal = q[0];
            int minIdx = q[1];

            res += minVal - level;

            // Push right and left parts
            stack.push(new int[]{minIdx + 1, right, minVal});
            stack.push(new int[]{left, minIdx - 1, minVal});
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOperations(new int[]{1, 2, 3, 2, 1})); // 3
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 5, 4, 2})); // 7
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 1, 2}));     // 4
    }
}

class SegmentTree {
    int[] treeVal, treeIdx;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        treeVal = new int[4 * n];
        treeIdx = new int[4 * n];
        build(arr, 0, n - 1, 1);
    }

    void build(int[] arr, int l, int r, int node) {
        if (l == r) {
            treeVal[node] = arr[l];
            treeIdx[node] = l;
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, node * 2);
        build(arr, mid + 1, r, node * 2 + 1);

        // store both min value and its index
        if (treeVal[node * 2] <= treeVal[node * 2 + 1]) {
            treeVal[node] = treeVal[node * 2];
            treeIdx[node] = treeIdx[node * 2];
        } else {
            treeVal[node] = treeVal[node * 2 + 1];
            treeIdx[node] = treeIdx[node * 2 + 1];
        }
    }

    // return [minVal, indexOfMin]
    int[] query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 1);
    }

    int[] queryUtil(int start, int end, int l, int r, int node) {
        if (r < start || end < l) return new int[]{Integer.MAX_VALUE, -1};
        if (l <= start && end <= r) return new int[]{treeVal[node], treeIdx[node]};
        int mid = (start + end) / 2;

        int[] left = queryUtil(start, mid, l, r, node * 2);
        int[] right = queryUtil(mid + 1, end, l, r, node * 2 + 1);

        if (left[0] <= right[0]) return left;
        else return right;
    }
}