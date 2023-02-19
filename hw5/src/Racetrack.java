public class Racetrack extends Hurdle {
    String type = "беговую дорожку длинной";

    public Racetrack(int param) {
        super(param);
        this.param = param;
    }


    public boolean overcome(Participant member) {



        if (member.maxRun >= param) {
            System.out.println(member.member+" "+member.name+ " одолел "+type+param);
            return true;
        } else {
            System.out.println(member.member+" "+member.name+ " не смог одалеть "+type+param);
            return false;
        }

    }
}
