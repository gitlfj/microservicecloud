import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {

//          byte[] b = new byte[1024 * 1024 * 1024];
//        String a = new String("A");
//        String b = new String("B");
//        operat(a, b);
//
//
//        for (int i = 0; i < 1000000 ; i++) {
//            ArrayList list = new ArrayList(1000000);
//
//            Date date = new Date();
//            date.getTime();
//        }
////        System.out.println(a);
//        System.out.print(b);


        ExecutorService executorService = Executors.newFixedThreadPool(10000);

        for (int i = 0 ; i < 10000 ; i++) {
            executorService.execute(() -> {
                System.out.println("当前线程为: " + Thread.currentThread().getName() );
            });
        }

//        main(args);
    }

    private static void operat(String x, String y) {
        x = y;
    }

}
