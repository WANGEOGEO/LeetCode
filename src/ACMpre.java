import java.util.ArrayList;
import java.util.Scanner;

public class ACMpre {
    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int inp;
        while ((inp = Integer.parseInt(in.next())) != 0) {
            inputs.add(inp);
        }
        int n = 0;
        int m = 1;
        ArrayList<String> outputs = new ArrayList<>();
        for (Object a : inputs) {
            int numZero = (Integer) a;
            int numOne = numZero * 3;
            boolean even = (numOne % 2 == 0);
            int numTwo;
            if (even) {
                numTwo = numOne / 2;
            } else {
                numTwo = (numOne + 1) / 2;
            }
            int numThree = numTwo * 3;
            int numFour = numThree / 9;
            if (even) {
                String thisString = m + "." + " " + "even " + numFour;
                outputs.add(thisString);
            } else {
                String thisString = m + "." + " " + "odd " + numFour;
                outputs.add(thisString);
            }
            m++;
        }
        for (String a : outputs) {
            System.out.println(a);
        }
    }
}
