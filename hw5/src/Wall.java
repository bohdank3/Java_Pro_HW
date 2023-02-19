public class Wall extends Hurdle{
    String type = "Стенку Высотой";

    public Wall(int param) {
        super(param);
        this.param = param;
    }

    @Override
    public boolean overcome(Participant member) {

        if (member.maxJump >= param) {
            System.out.println(member.member+" "+member.name+ " одолел "+type+param);
            return true;
        } else {
            System.out.println(member.member+" "+member.name+ " не смог одалеть "+type+param);
            return false;
        }

    }
}
