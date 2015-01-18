package tools;

/*
 * La classe Nuage modelise un nuage de points.
 * Les points sont lus a partir d'un fichier texte
 * comportant des tabulations. 
 */
public class Nuage {
    protected Point[] liste;

    public Nuage(String filename) {
        FileHandler fh = new FileHandler();
        String[] lines = fh.extract(filename);
        liste = new Point[lines.length];
        for (int i = 0; i < lines.length; i++)
            liste[i] = new Point(lines[i]);
    }

    public static void main(String[] args) {
        Nuage nuage = new Nuage("src/data/points.txt");
        nuage.affiche();
        String nom = "P3";
        Point p = nuage.getFromName(nom);
        System.out.println("Le point " + nom + " a pour coordonnees : " + p.getX() + ", " + p.getY());
        //System.out.println(nuage.getClass().getResource("../"));
    }

    public void affiche() {
        for (int i = 0; i < liste.length; i++)
            System.out.println(liste[i]);
    }

    /*
     * Recherche d'une instance de Point a partir
     * de son nom.
     */
    public Point getFromName(String name) {
        for (int i = 0; i < liste.length; i++)
            if (name.equals(liste[i].getName()))
                return liste[i];
        return null;
    }
}