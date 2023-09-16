package vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(2);
        Vector vector2 = new Vector(2);

        vector.setComp(3, 0);
        vector.setComp(2, 1);

        vector2.setComp(3, 0);
        vector2.setComp(2, 1);

        vector.multPorEscalar(2);
        vector.suma(vector2);
        System.out.println(vector);
        System.out.println(vector2);


    }
}