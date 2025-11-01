package examples.adapter;

import java.util.List;

public class BallProcessor {
    static void process() {
        for (Ball ball : List.of(new Baseball(), new CricketBall(), new Softball())) {
            ball.pitch();
        }
        new Frisbee().fling();
        new Die().roll();
    }
}
