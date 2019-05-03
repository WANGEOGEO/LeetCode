import java.util.ArrayList;

public class Q7Reverse {
    public int reverse(int x) {
        //我来动动脑子
        //首先要先确认有没有负号, 同时我们要避免reverse到一半发现越界，所以可以先来个long来存。
        if (x == 0) {
            return x;
        }
        boolean isNegative = x < 0;
        //转换成绝对值形式。
        x = Math.abs(x);
        long answer = 0;
        //我已完全掌控了局势，其实不用ArrayList就可以把这道题做出来，要多动脑筋。
        //我们总体算法的构想应该是：拿出来x现在的个位数，塞到answer的个位上。
        //然后呢，x除以十，便可以自然地挪掉个位；answer乘以10，就可以自然空出一位来给这次的数字塞。
        while (x > 0) {
            // 我除以十，剩下的就是个位数了。thisTimeNum就是这次要塞的数字了。
            int thisTimeNum = x % 10;
            // x除以十
            x /= 10;
            // answer被塞入新的数字。
            answer = answer * 10 + thisTimeNum;
            if (answer > Integer.MAX_VALUE && !isNegative) return 0;
            if (-answer < Integer.MIN_VALUE && isNegative) return 0;
        }
        if (isNegative) {
            return -1 * (int) answer;
        }
        return (int)answer;
    }
}
