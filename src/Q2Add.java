import java.util.ArrayList;

public class Q2Add {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(0);
        ListNode t2 = new ListNode(2);
        t2.next = new ListNode(3);
        ListNode test = addTwoNumbers(t1,t2);
        System.out.println(lengthList(test));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> answer = new ArrayList<>();
        ListNode currentOne = l1;
        ListNode currentTwo = l2;
        int addOn = 0;
        //先把最简单的情况排除出去
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (lengthList(currentOne) > lengthList(currentTwo)) {
            //先循环处理l2最后一位之前的东西。
            while (currentTwo.next != null) {
                int thisDigit = currentOne.val + currentTwo.val + addOn;
                if (thisDigit >= 10) {
                    //进一位
                    addOn = 1;
                    //减去10
                    int thisNum = thisDigit - 10;
                    answer.add(thisNum);
                    currentOne = currentOne.next;
                    currentTwo = currentTwo.next;
                } else {
                    addOn = 0;
                    answer.add(thisDigit);
                    currentOne = currentOne.next;
                    currentTwo = currentTwo.next;
                }
            }
            //处理l2最后一位
            //rideOn是进位
            int rideOn = 0;
            int thisDigit = currentTwo.val + currentOne.val + addOn;
            if (thisDigit >= 10) {
                rideOn = 1;
                thisDigit -= 10;
                answer.add(thisDigit);
            } else {
                answer.add(thisDigit);
            }
            currentOne = currentOne.next;
            //安排完了进位，继续安排l1，直到l1最后一位。
            while (currentOne.next != null) {
                if (rideOn == 1) {
                    thisDigit = currentOne.val + rideOn;
                    if (thisDigit >= 10) {
                        thisDigit -= 10;
                        answer.add(thisDigit);
                        currentOne = currentOne.next;
                    } else {
                        rideOn = 0;
                        answer.add(thisDigit);
                        currentOne = currentOne.next;
                    }
                } else {
                    answer.add(currentOne.val);
                    currentOne = currentOne.next;
                }
            }
            //到了最后一位，随便处理一下即可。
            if (rideOn == 1) {
                thisDigit = rideOn + currentOne.val;
                if (thisDigit == 10) {
                    answer.add(0);
                    answer.add(1);
                }
            } else {
                answer.add(currentOne.val);
            }
        } else if (lengthList(currentTwo) > lengthList(currentOne)) {
            //先循环处理l1最后一位之前的东西。
            while (currentOne.next != null) {
                int thisDigit = currentOne.val + currentTwo.val + addOn;
                if (thisDigit >= 10) {
                    //进一位
                    addOn = 1;
                    //减去10
                    int thisNum = thisDigit - 10;
                    answer.add(thisNum);
                    currentOne = currentOne.next;
                    currentTwo = currentTwo.next;
                } else {
                    addOn = 0;
                    answer.add(thisDigit);
                    currentOne = currentOne.next;
                    currentTwo = currentTwo.next;
                }
            }
            //处理l1最后一位
            //rideOn是进位
            int rideOn = 0;
            int thisDigit = currentTwo.val + currentOne.val + addOn;
            if (thisDigit >= 10) {
                rideOn = 1;
                thisDigit -= 10;
                answer.add(thisDigit);
            } else {
                answer.add(thisDigit);
            }
            currentTwo = currentTwo.next;
            //安排完了进位，继续安排l1，直到l1最后一位。
            while (currentTwo.next != null) {
                if (rideOn == 1) {
                    thisDigit = currentTwo.val + rideOn;
                    if (thisDigit >= 10) {
                        thisDigit -= 10;
                        answer.add(thisDigit);
                        currentTwo = currentTwo.next;
                    } else {
                        rideOn = 0;
                        answer.add(thisDigit);
                        currentTwo = currentTwo.next;
                    }
                } else {
                    answer.add(currentTwo.val);
                    currentTwo = currentTwo.next;
                }
            }
            //到了最后一位，随便处理一下即可。
            if (rideOn == 1) {
                thisDigit = rideOn + currentTwo.val;
                if (thisDigit == 10) {
                    answer.add(0);
                    answer.add(1);
                }
            } else {
                answer.add(currentTwo.val);
            }
        } else {
            //l1 l2等长，那么随便搞搞就行了。
            //先把最后一位之前的都安排好了。
            while (currentOne.next != null) {
                int thisDigit = currentOne.val + currentTwo.val + addOn;
                if (thisDigit >= 10) {
                    addOn = 1;
                    thisDigit -= 10;
                    answer.add(thisDigit);
                } else {
                    addOn = 0;
                    answer.add(thisDigit);
                }
                currentOne = currentOne.next;
                currentTwo = currentTwo.next;
            }
            //来处理最后一位
            int lastDigit = currentOne.val + currentTwo.val + addOn;
            if (lastDigit >= 10) {
                int lastTwo = lastDigit - 10;
                answer.add(lastTwo);
                answer.add(1);
            } else {
                answer.add(lastDigit);
            }
        }
        return combine(answer);
    }

    public static int lengthList(ListNode listNode) {
        int length = 0;
        if (listNode == null) {
            return 0;
        }
        while (listNode.next != null) {
            length ++;
            listNode = listNode.next;
        }
        return length;
    }

    public static ListNode combine(ArrayList<Integer> input) {
        if (input.size() == 0) {
            return null;
        }
        ListNode answer = new ListNode(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            answer.next = new ListNode(input.get(i));
            answer = answer.next;
        }
        return answer;
    }
}
