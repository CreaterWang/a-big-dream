package javava.demo;

/**
 * volatile变量
 * <p>
 * java 提供了一种稍弱的同步机制，即volatile变量，用来确保将变量的更新操作通知到其他线程
 * <p>
 * java 线程内存模型中 每个线程都会将下面程序中的flag变量复制一份到自己的内存中
 * 因此，在flag的值在一个线程中改变时，在另一个线程中并未改变。
 * <p>
 * volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，因此在读取volatile类型的变量时，总会返回最新写入的值
 */

public class VolatileDemo {
    //    private static boolean flag = false;
    private static volatile boolean flag = false;

    /**
     * 如果不使用volatile变量，在第二个线程执行后，第一个线程中flag仍然是false，所以就会一直循环
     * 使用volatile变量后，第二个线程执行后，第一个线程也会flag的值发生变化而跳出循环
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while (!flag) {

            }
            System.out.println("success...");
        }).start();

        Thread.sleep(2000L);

        new Thread(() -> {
            System.out.println("prepareing data....");
            flag = true;
            System.out.println("prepareing data end....");
        }).start();
    }
}
