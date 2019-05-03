public class Q8StringToInt {
    public int myAtoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        // nowIndex起了一个指针的作用
        int nowIndex = 0;
        // 开始过滤空格
        while (nowIndex < str.length()) {
            if (str.charAt(nowIndex) == ' ') {
                // 是空格就过。
                nowIndex++;
            } else {
                //不是空格就停
                break;
            }
        }
        //如果没找到任何不是空格的东西，就直接return 0.
        if (nowIndex >= str.length()) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(nowIndex) == '-') {
            negative = true;
            nowIndex++;
        } else if (str.charAt(nowIndex) == '+') {
            nowIndex++;
        } else {
            //抛却了正负号，现在来研究是否合法。如果开头不是正负号，也不是数字，那么就是非法的。
            if (str.charAt(nowIndex) > '9' || str.charAt(nowIndex) < '0') {
                return 0;
            }
        }
        //那么现在nowIndex存了数字的起点。
        //先看一下是否会越界。不越界的话就可以return了。
        long answer = 0;
        while (nowIndex < str.length() && str.charAt(nowIndex) >= '0' && str.charAt(nowIndex) <= '9') {
            //邪道算值法，和Q7有点像。这个ascii相减是我的绝学。
            answer = answer * 10 + (str.charAt(nowIndex) - '0');
            //去搞下一位
            nowIndex++;
            //如果发现十分不幸已经越界，就直接return。
            if (negative && -answer < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!negative && answer > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (negative) {
            return (int) (- answer);
        }
        return (int) answer;
    }
}
