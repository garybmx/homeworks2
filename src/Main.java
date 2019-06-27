import java.util.Random;

public class Main {

    public static void main(String[] args) {
            CustomArray arr = new CustomArray();
        for(int i = 0; i<1000000; i++){
          arr.add(new Random().nextInt(1000));
      }
        long startTime = System.currentTimeMillis();
        arr.quickSort();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }




}
