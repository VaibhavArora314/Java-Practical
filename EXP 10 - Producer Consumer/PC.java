class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
        
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
        
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    int limit;

    Producer(Q q, int limit) {
        this.q = q;
        this.limit = limit;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (i <= limit) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    int limit;

    Consumer(Q q, int limit) {
        this.q = q;
        this.limit = limit;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int lastRead = 0;
        while (lastRead != limit) {
            lastRead = q.get();
        }
    }
}

class PC {
    public static void main(String args[]) {
        Q q = new Q();
        int limit = 10;
        new Producer(q, limit);
        new Consumer(q, limit);
    }
}