package imageupload;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskExecutor {


    public void executeTask() {
        ExecutorService executorService  = Executors.newFixedThreadPool(5);

        executorService.execute(() -> System.out.println("This is a runnable" + Thread.currentThread()));
        Future future = executorService.submit(() -> System.out.println("This is a runnable" + Thread.currentThread()));
        executorService.shutdown();
    }

    public static void main(String[] args) {
        TaskExecutor te = new TaskExecutor();
        te.executeTask();
    }

}
