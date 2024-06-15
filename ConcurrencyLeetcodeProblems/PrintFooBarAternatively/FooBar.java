//import lombok.SneakyThrows;
//
//import java.util.concurrent.Semaphore;
//
//class FooBar implements Runnable{
//    static  Semaphore foo;
//    static Semaphore bar;
//
//    public FooBar(){
//        this.foo= new Semaphore(1);
//        this.bar= new Semaphore(0);
//    }
//
//    public static  void foo() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            foo.acquire();
//            System.out.println("foo");
//            bar.release();
//        }
//    }
//
//    public static void bar() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            bar.acquire();
//            System.out.println("bar");
//            foo.release();
//        }
//    }
//
//
//    @Override
//    public void run() {
//        try {
//
//                foo();
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//
//                bar();
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}