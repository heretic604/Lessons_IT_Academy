package additional_tasks.task_1_variables;

import java.util.Random;

public class Petrov {

    public static void main(String[] args) {

        Random random = new Random();
        int n = random.nextInt(0, 28800);
        int hours = n / 3600;
        System.out.println(n);
        if (hours < 1){
            System.out.println("less one hour");
        } else {
            System.out.println(hours + " hours");
        }
    }

}
