package lesson7.runners;

import lesson7.entities.Body;
import lesson7.entities.Head;
import lesson7.entities.Robot;

public class Factory {

    protected void createAllRobots() {
        Head[] heads = Head.values();
        Body[] bodies = Body.values();
        Robot[] robots = new Robot[heads.length * bodies.length];
        int count = 0;

        for (int i = 0; i < heads.length; i++) {
            for (int j = 0; j < bodies.length; j++) {
                robots[count] = new Robot(heads[i], bodies[j]);
                System.out.println(Integer.toString(count + 1) + robots[count]);
                count++;
            }
        }
    }
}
