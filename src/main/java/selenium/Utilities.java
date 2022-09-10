package selenium;

public class Utilities {

    public static void treadWaiter(int seconds){
        try{
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
