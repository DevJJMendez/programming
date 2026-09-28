package interfaces.runnable;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    System.out.println("thread failed");
                }
            }
        };
        runnable.run();
    }
}
