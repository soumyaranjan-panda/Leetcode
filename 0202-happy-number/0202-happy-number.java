class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
            if(fast == 1){
                return true;
            }
        }while(slow != fast);
        return false;
    }
    public static int sumOfSquare(int n){
        int rem;
        int sum = 0;
        while(n > 0){
            rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}