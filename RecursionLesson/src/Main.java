import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int sum=0;
        int termNum = 5;
        while (termNum>=0) {
            sum+=getSumFibonacci(termNum);
            termNum--;
        }
        System.out.println(sum);
    }

    public static int getSumFibonacci(int termNum) {
        if (termNum <=1) {
            return termNum;
        }
        return getSumFibonacci(termNum - 1) + getSumFibonacci(termNum - 2);
    }
}
