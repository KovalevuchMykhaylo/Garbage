package Version9.grabage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GetLucky {

    public static void main(String[] args) {
        Random rand = new Random();
        int lucky = 0;
        for (int i = 0; i < 1000000; i++) {
            if (rand.nextInt(10) == 0) {
                lucky++;
            }
        }
        System.out.println(lucky); // you'll get a number close to 100000

        lucky = 0;
        for (int i = 0; i < 1000000; i++) {
            if (ThreadLocalRandom.current().nextInt(10) == 0) {
                lucky++;
            }
        }
        System.out.println(lucky); // you'll get a number close to 100000
    }
}
