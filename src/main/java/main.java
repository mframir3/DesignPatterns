import Mediator.Mediator;

public class main {

    public static void main(String[] args) {
        Mediator rules = new Mediator();
        rules.populate();
        System.out.println(rules.run() + " WINS");

    }

}
