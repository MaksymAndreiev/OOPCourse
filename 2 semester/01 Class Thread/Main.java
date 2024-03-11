public class Main {

    public static void main(String[] args) {
        Thread thread1 = new T("THREAD");
        Thread thread2 = new T("thread");
        Thread thread3 = new T("12345");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
    }
}
class T extends Thread{
    String string;
    T(String s){
        this.string = s;
    }
    public void run() {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                T.sleep(5);
            }
            catch (InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
    }
}