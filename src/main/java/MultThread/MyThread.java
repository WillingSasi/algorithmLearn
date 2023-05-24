package MultThread;

public class MyThread extends Thread{
    volatile boolean stop = false;

    public void run () {
        while (!stop) {
            System.out.println(getName() + "is running");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("week up from  block...");
                stop = true;
            }
        }

        System.out.println(getName() + "is exiting...");
    }
}
