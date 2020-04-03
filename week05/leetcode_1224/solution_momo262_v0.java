//package leetcode_1224;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.*;
//
//public class solution_momo262_v0 {
//
//    public static void main(String[] args) {
//        Callable<String> task = new Callable<String>() {
//            @Override
//            public String call() throws Exception{
//                //执行耗时代码
//                Thread.sleep(5000);
//                System.out.println("555");
//                return "success";
//            }
//        };
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(task);
//        try {
//            //设置超时时间
//            String rst = future.get(2, TimeUnit.SECONDS);
//            System.out.println(rst);
//        } catch (TimeoutException e) {
//            future.cancel(true);
//            System.out.println("执行超时");
//        } catch(Exception e){
//            System.out.println("获取数据异常," + e.getMessage());
//        }finally {
//            executorService.shutdown();
//        }
//        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("xxx")));
//    }
//
//}
