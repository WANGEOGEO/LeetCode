public class Q5Palindrom {
    // 试一下Approach 4.
    // 完全照搬答案
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        //start和end只是用来表示起始index和结束index。
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 我一次性开始两个回文字串测试。
            // len1是“以我现在i指向的char作为回文字串中心”
            // len2是“以我现在i指向的char和i+1指向的char之间的缝作为回文字串的中心”
            // 这样写巧妙地解决了一个问题：怎么用循环来走一遍总共2n+1个可能的回文字串中心。
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            // 挑挑这次哪个最长。
            int len = Math.max(len1, len2);
            // 如果这次的回文字串是目前找到过的最长的，那就更新一下。
            // 我在这里坚定的认为参考答案是错的。算length就应该是end - start + 1。
            if (len > end - start + 1) {
                /*
                    我不得不承认我使用了很长时间才终于明白这里更新的方法是什么。
                    i这个东西一共可能处于两个位置：
                    1. 它就是centre
                    2. 它就是左centre
                    第一种情况：start和end都应该向自己那个方向走(len - 1)/2的距离。
                    第二种情况：start往左走(len-2)/2，end往右走len/2.
                    那么最后为什么可以写成这种邪道写法呢？那就是因为单数除法问题。
                    在第一种情况，len必定为单数，因此，(len - 1)/2 和 len/2不会有任何区别
                    在第二种情况，len必定为双数，那么(len - 1)/2 和 (len - 2)/2就不会有任何区别
                    所以最后就是这样了
                    太神奇了
                */
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // 取的是start到end的substring。
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // 这个是一个很有意思的方法，start和end分别代表着“我现在顺着方向（左或者右）走到哪里了。
        int start = left, end = right;
        // start >= 0代表着我这循环总归不能一直往左，左到出界吧，所以它得大于等于0。
        // end < s.length原因也很简单，总不能一直往右走走到出界吧。
        // 如果start或者end已经卡在输入进来的s的边界了，肯定没法再动了。所以就该停下来了。
        // 如果此时start这里的char和right这里的char不一样，那么说明上一步的回文子串已经是这波能找到的最长的了。
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            // 只要这波成了，就往左右两边同时延伸一步，看看是不是还是回文字串。
            start--;
            end++;
        }
        // 简单的计算长度的方法。
        // 因为跳脱出循环的时候，start和end其实都并不是回文字串的起和末了。
        // 他们分别都往自己的方向多走了一个。而我们在计算一共有几个char的时候要回退一下。
        // 实际上应该是return ((end - 1) - (start + 1) +1)
        // +1的原因和种树问题一样，我们单纯(end - 1) - (start + 1)算出来的是“一共有几个空格”
        // 必须+1之后才是“一共有几棵树”，也就是一共有几个char，string的length。
        return end - start - 1;
    }

    public static void main(String[] args) {

    }
}
