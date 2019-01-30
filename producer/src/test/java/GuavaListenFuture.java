import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
@Slf4j
public class GuavaListenFuture {
    protected static ListeningExecutorService executors = MoreExecutors
            .listeningDecorator(Executors.newCachedThreadPool());

    public static void main(String[] args){
        List<ListenableFuture<List<String>>> futures = Lists.newArrayList();
        futures.add(executors.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() {
                System.out.println("call0 execute..");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                }catch (InterruptedException e){
                    return null;
                }
                return Lists.newArrayList(new String[]{"0"});
            }
        }));

        futures.add(executors.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() {
                System.out.println("call1 execute..");
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
                return Lists.newArrayList(new String[]{"7"});
            }
        }));


        futures.add(executors.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() {
                System.out.println("call2 execute..");
                try{
                    Thread.currentThread().wait();
                }catch (Exception e) {

                    return null;
                }
                return Lists.newArrayList(new String[]{"1"});
            }
        }));



        try {
            ListenableFuture<List<List<String>>> listenableFuture = Futures.successfulAsList(futures);
            List<List<String>> result = null;
            result = listenableFuture.get(200, TimeUnit.MILLISECONDS);
            System.out.println(result.toString());
            System.out.println(result == null);
            if(result != null ) {
                for (List<String> part : result) {
                    if (part != null) {
                        System.out.println(part.get(0));
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.info("timeout");
        }



    }

}
