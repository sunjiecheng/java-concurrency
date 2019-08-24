package cn.itcast.heima;

public class TraditionalThread {
    public static void main(String[] args) {

        // 执行子类的run方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable :" + Thread.currentThread().getName());
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread :" + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}
