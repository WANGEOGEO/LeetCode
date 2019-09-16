public class Q10RegularExp {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("mississippi","mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        int pointerToString = 0;
        int pointerToPatern = 0;
        char previousChar = ' ';
        while (pointerToPatern < p.length() && pointerToString < s.length()) {
            if (p.charAt(pointerToPatern) == '.') {
                if (p.charAt(pointerToPatern + 1) == '*') {
                    return true;
                }
                if (s.charAt(pointerToString) < 'a' || s.charAt(pointerToString) > 'z') {
                    return false;
                }
                previousChar = s.charAt(pointerToString);
                pointerToString ++;
                pointerToPatern ++;
            } else {
                if (p.charAt(pointerToPatern) == '*') {
                    for (int i = pointerToString; i < s.length(); i++) {
                        if (s.charAt(i) == previousChar) {
                            pointerToString ++;
                        } else {
                            pointerToPatern ++;
                            break;
                        }
                    }
                } else {
                    if (pointerToPatern == p.length() - 1) {
                        if (p.charAt(pointerToPatern) != s.charAt(pointerToString)) {
                            return false;
                        }
                        pointerToPatern ++;
                        pointerToString ++;
                    } else {
                        if (p.charAt(pointerToPatern + 1) == '*') {
                            previousChar = p.charAt(pointerToPatern);
                            pointerToPatern ++;
                        } else {
                            if (p.charAt(pointerToPatern) != s.charAt(pointerToString)) {
                                return false;
                            }
                            pointerToPatern ++;
                            pointerToString ++;
                        }
                    }
                }
            }
        }
        if (pointerToPatern != p.length() || pointerToString != s.length()) {
            return false;
        }
        return true;
    }
}
