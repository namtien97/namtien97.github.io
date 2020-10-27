public class HeightChecker_1051 {
    public static int heightChecker(int[] heights) {
        int result = 0;
        int[] originalHeights = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            originalHeights[i] = heights[i];
        }

        for (int i = 0; i < heights.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < heights.length; j++) {
                //Tim min[i,n]
                if (heights[j] < heights[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int t = heights[i];
                heights[i] = heights[indexMin];
                heights[indexMin] = t;
            }
        }
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != originalHeights[i]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,2,1,1,2};
        System.out.println(heightChecker(heights));
    }
}
