package wangyingjie.datastructure.stack;

/**
 * 循环队列实现
 */
public class MyCircularQueue {
    //头
    private int front = 0;
    //尾
    private int tail = 0;

    //数组的大小
    private int size = 0;
    //队列长度
    private int length = 0;
    int[] array = null;

    /**
     * 初始化大小为k的循环队列
     */
    public MyCircularQueue(int k) {
        array = new int[k];
        size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        //如果队列长度与数组大小相等，返回false
        if (size == length) {
            return false;
        }
        //队尾插入元素，并+1
        array[tail] = value;
        tail = (tail + 1) % size;
        length ++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        //如果队列长度为0 返回false
        if (length == 0) {
            return false;
        }
        //删除队头元素，并+1
        front = (front + 1) % size;
        length --;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (length == 0) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (length == 0) {
            return -1;
        }
        return array[(tail + size - 1) % size];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if(length==0){
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if(size == length){
            return true;
        }
        return false;
    }
}
