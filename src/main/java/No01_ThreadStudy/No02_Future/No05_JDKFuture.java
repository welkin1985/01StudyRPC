package No01_ThreadStudy.No02_Future;

import java.util.concurrent.*;

/**
 *
 */
public class No05_JDKFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);
        Object o = futureTask.get();

    }
}
