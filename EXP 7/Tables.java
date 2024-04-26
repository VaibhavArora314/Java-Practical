public class Tables {
    public static void main(String[] args) {
        // Create a shared lock object
        Object lock = new Object();

        // Create two instances of the Runnable objects
        TableRunnable table5 = new TableRunnable(5, lock);
        TableRunnable table7 = new TableRunnable(7, lock);

        // Create threads for each table
        Thread thread5 = new Thread(table5);
        Thread thread7 = new Thread(table7);

        // Start the threads
        thread5.start();
        thread7.start();
    }

    // Runnable class to print the table of a number
    static class TableRunnable implements Runnable {
        private int number;
        private Object lock;

        public TableRunnable(int number, Object lock) {
            this.number = number;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) { // Synchronize on the shared lock object
                for (int i = 1; i <= 10; i++) {
                    System.out.println(number + " * " + i + " = " + (number * i));
                }
                System.out.println("");
            }
        }
    }
}
