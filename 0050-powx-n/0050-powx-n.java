class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        long num = (long)n;
        if(n < 0){
            return 1/power(x, -num);
        }else{
            return power(x, num);
        }
    }
    public double power(double x, long n){
        if(n == 1){
            return x;
        }
        if(n % 2 == 0){
            return power(x*x, n/2);
        }else{
            return x * power(x*x, n/2);
        }
    }
}