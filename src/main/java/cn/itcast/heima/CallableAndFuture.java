package cn.itcast.heima;

import java.util.Random;
import java.util.concurrent.*;


public class CallableAndFuture {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(() -> {
                    Thread.sleep(2000);
                    return "hello";
                }
        );
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            completionService.submit(() -> {
                Thread.sleep(new Random().nextInt(5000));
                return seq;
            });
        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
