package java.concurrency;

public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while(!flag){

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
