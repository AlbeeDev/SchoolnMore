package albano.alex.es1;

public class Cerchio {

    double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public double getArea() {
        return 3.14 * (raggio*raggio);
    }

    public double getCirconferenza() {
        return 2*3.14*raggio;
    }
}
