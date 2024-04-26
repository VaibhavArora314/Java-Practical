public class PriorityDemo {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(new Task(), "HighPriorityThread");
        Thread lowPriorityThread1 = new Thread(new Task(), "LowPriorityThread 1");
        Thread lowPriorityThread2 = new Thread(new Task(), "LowPriorityThread 2");
        Thread lowPriorityThread3 = new Thread(new Task(), "LowPriorityThread 3");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY); 
        lowPriorityThread1.setPriority(Thread.MIN_PRIORITY);
        lowPriorityThread2.setPriority(Thread.MIN_PRIORITY);
        lowPriorityThread3.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread1.start();
        lowPriorityThread2.start();
        lowPriorityThread3.start();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long cycles = 0;

        // Perform CPU-intensive task
        for (int i = 0; i < 1000000000; i++) {
            cycles++;
        }

        long endTime = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName() + " executed " + cycles + " cycles in " + (endTime - startTime) + " ms");
    }
}
