package examples.adapter;

public class DieAdapter implements Ball{
    Die die;
    DieAdapter(Die die) {
        this.die = die;
    }

    @Override
    public void pitch() {
        this.die.roll();
    }
}
