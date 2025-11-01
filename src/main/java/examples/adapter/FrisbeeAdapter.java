package examples.adapter;

public class FrisbeeAdapter implements Ball {
    Frisbee frisbee;
    FrisbeeAdapter(Frisbee frisbee) {
        this.frisbee = frisbee;
    }
    @Override
    public void pitch() {
        this.frisbee.fling();
    }
}
