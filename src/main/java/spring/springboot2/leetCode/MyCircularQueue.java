package spring.springboot2.leetCode;

/**
 * @author : ZJ
 * @date : 19-7-15 下午5:12
 */
public class MyCircularQueue {

    private Integer len;


    private Integer[] data;

    private Integer start;

    private Integer end;

    public MyCircularQueue(int k) {
        this.len = k;
        this.data = new Integer[k];
        this.start = -1;
        this.end = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            start = 0;
        }

        end = (end + 1) % len;
        data[end] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (end.equals(start)) {
            end = -1;
            start = -1;
            return true;
        }
        start = (start + 1) % len;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[start];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {

        return start == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {

        return ((end + 1) % len) == start;
    }


}
