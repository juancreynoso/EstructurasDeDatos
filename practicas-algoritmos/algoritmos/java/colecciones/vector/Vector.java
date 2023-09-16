package vector;

public class Vector {
    private double[] vector;


    public Vector(int capacidad) {
        vector =  new double[capacidad];
    }

    public double getComp(int i) {
        if (i > vector.length || i < 0) {
            throw new IllegalArgumentException("Indice fuera de rango");
        }
        return vector[i];
    }

    public void setComp(double valor, int i) {
        if (i > vector.length || i < 0) {
            throw new IllegalArgumentException("Indice fuera de rango");
        }
        this.vector[i] = valor;
    }

    @Override
    public String toString() {
        String result = "(";
        for (int i = 0; i<this.vector.length; i++) {
            result = result + vector[i];
            if (!(i == this.vector.length-1))
                result = result + ", ";
        }
        return result + ")";
    }

    public void multPorEscalar(double escalar) {
        for (int i = 0; i<vector.length; i++) {
            vector[i] *=escalar;
        }
    }

    public void suma(Vector otro) {
        if (!(validarTam(otro))) {
            throw new IllegalArgumentException("Los vectores son de diferentes tamaños.");
        }
        for (int i = 0; i < vector.length; i++) {
            otro.vector[i] += vector[i];
        }
    }

    public boolean validarTam(Vector otro) {
        return this.vector.length == otro.vector.length;
    }
}
