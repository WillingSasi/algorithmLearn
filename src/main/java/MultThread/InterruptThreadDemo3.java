package MultThread;

public class InterruptThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("Starting thread...");
        myThread.start();
        Thread.sleep(3000);
        System.out.println("Interrupt thread..." + myThread.getName());
        myThread.stop = true;
        myThread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
