package me.ffulauh.javalang.concurrent.future;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable sumCallable=() -> sum(2, 3);
        FutureTask<Integer> task= new FutureTask<>(sumCallable);
        //new Thread(task).start();

        ExecutorService executorService=Executors.newCachedThreadPool();
        Future<Integer> result = executorService.submit(sumCallable);
        //Future result = executorService.submit(task);

        while (true){
            if(result.isDone()){
                System.out.println(result.get());
                break;
            }
        }
        executorService.shutdown();
    }

    private static Integer sum(Integer a,Integer b) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return a+b;
    }



}
