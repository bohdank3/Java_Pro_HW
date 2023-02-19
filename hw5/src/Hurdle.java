
public abstract class Hurdle {
    public int param;

   public Hurdle(int param) {
        this.param = param;
    }

    public abstract boolean overcome(Participant member);
}
