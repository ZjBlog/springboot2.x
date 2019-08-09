package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-8-7 下午5:18
 */
public class MyLinkedList {

    ListNode head;
    ListNode last;
    int all = 0;

    public MyLinkedList() {
        //初始化
        this.head = null;
        this.last = head;
        this.all = 0;
    }

    class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public int get(int index) {
        if (index > all || index < 0) {
            return -1;
        }

        ListNode temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            last = node;
            head = node;
        } else {
            node.next = head;
        }
        all++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            last = node;
            head = node;
        } else {
            last.next = node;
        }

        all++;
    }

    public void addAtIndex(Integer index, Integer val) {
        if (index == all) {
            addAtTail(val);
        }
        if (index < 0) {
            addAtHead(val);
        }
    }

    public void deleteAtIndex(int index) {

        if (index == 0) {
            head = head.next;
            all--;
        }

        if (0 < index && index <= all) {
            ListNode prev = head;
            ListNode nex = null;
            ListNode curr = null;
            for (int i = 1; i <= index; i++) {
                curr = prev.next;
                if (index == all) {
                    nex = null;
                } else {
                    nex = curr.next;
                }
            }
            prev.next = nex;
            all--;
        }
    }
}
