public class Lesson4 {
    volatile int status = 0;
    public static void main(String[] args) {
        Lesson4 monitor = new Lesson4();
        Thread t1 = new Thread(new MyThread("A", monitor, 1));
        Thread t2 = new Thread(new MyThread("B", monitor, 2));
        Thread t3 = new Thread(new MyThread("C", monitor, 3));
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread implements Runnable {

    private String text;
    private final Lesson4 monitor;
    private int count;
    private int cycleRange = 13;

    MyThread(String text, Lesson4 obj, int count) {
        this.text = text;
        this.monitor = obj;
        this.count = count;

    }

    @Override
    public void run() {

        while(monitor.status < cycleRange) {
            synchronized (monitor) {
                while(!((monitor.status % 3) == 0) && count == 1){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((monitor.status % 3) == 1) && count == 2){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((monitor.status % 3) == 2) && count == 3){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(text);
                monitor.status++;
                monitor.notifyAll();
            }
        }
    }
}
