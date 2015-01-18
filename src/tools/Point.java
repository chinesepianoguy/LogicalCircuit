package tools;

/*
 * Un point est defini par un nom et ses coordonnees.
 */
public class Point {
    protected String name;
    protected int x, y;

    public Point(String nom, int abs, int ord) {
        name = nom;
        x = abs;
        y = ord;
    }

    /*
     * Constructeur acceptant une chaine au format suivant :
     * <nom>tab<x>tab<y>
     * tab signifie une tabulation.
     * Exemple de chaine : P1	2	3
     */
    public Point(String line) {
        String[] tokens = line.split("\t");
        name = tokens[0];
        x = Integer.parseInt(tokens[1]);
        y = Integer.parseInt(tokens[2]);
    }

    @Override
    public String toString() {
        return name + " = (" + x + ", " + y + ")";
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
