class Solution {
    public int largestRectangleArea(int[] arr){
        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackR = new Stack<>();
        int[] leftSmall = new int[arr.length];
        int[] rightSmall = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - i - 1;
            while(!stackL.empty() && arr[stackL.peek()] >= arr[i]){
                stackL.pop();
            }
            while(!stackR.empty() && arr[stackR.peek()] >= arr[j]){
                stackR.pop();
            }
            leftSmall[i] = stackL.empty() ? 0 : stackL.peek() + 1;
            stackL.push(i);
            rightSmall[j] = stackR.empty() ? arr.length - 1 : stackR.peek() - 1;
            stackR.push(j);
        }
        int maxArea = -1;
        for (int i = 0; i < arr.length; i++) {
            int w = rightSmall[i] - leftSmall[i] + 1;
            maxArea = Math.max(maxArea, w*arr[i]);
        }
        return maxArea;
    }
}