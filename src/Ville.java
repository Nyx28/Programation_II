import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

//Class to represent a vertex
class Vertex implements Comparable<Vertex> {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other) { return Double.compare(minDistance, other.minDistance); }
}
//Méthode qui permet de faire une liaison orientée d'un noeud vers un autre avec un certain poids
class Edge {
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget; weight = argWeight;
    }
}
//Classe principale, implémente les méthodes de Stationnement
public class Ville extends Stationnement {
    //Méthode qui met en en ordre le chemin entre les noeuds
    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }
    //Méthode qui permet de créer le trafic en augmantant le poids d'un chemin de + 0-100%
    public static int ran(int weight) {
       double valeur = Math.floor((Math.random()+1)*weight);
       int VFinale = (int)valeur;
       return VFinale;
    }
    //Nous donne le chemin le plus cours
    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
    //Méthode qui est appelé dans JFrame afin de calculer le chemin le plus court vers un stationnement selon le point de départ initial
    public static String Djikstra(int x) {
        //Création d'une instance d'un stationnement, False = Occupé
        boolean Stationnement_A[];
        boolean Stationnement_B[];
        boolean Stationnement_C[];
        boolean Stationnement_D[];
        Stationnement_A =new boolean[10];
        Stationnement_B =new boolean[10];
        Stationnement_C =new boolean[10];
        Stationnement_D =new boolean[10];

        //Occupation d'un stationnement
        for(int j = 0; j<Stationnement_A.length;j++ ) {
            Stationnement_A[j] = Rand_Stat();
        }
        for(int j = 0; j<Stationnement_B.length;j++ ) {
            Stationnement_B[j] = Rand_Stat();
        }
        for(int j = 0; j<Stationnement_C.length;j++ ) {
            Stationnement_C[j] = Rand_Stat();
        }
        for(int j = 0; j<Stationnement_D.length;j++ ) {
            Stationnement_D[j] = Rand_Stat();
        }

        //Création des différents noeuds
        Vertex v0 = new Vertex("Intersection 1");
        Vertex v1 = new Vertex("Intersection 2");
        Vertex v2 = new Vertex("Intersection 3");
        Vertex v3 = new Vertex("Parking A");
        Vertex v4 = new Vertex("Intersection 5");
        Vertex v5 = new Vertex("Intersection 6");
        Vertex v6 = new Vertex("Parking B");
        Vertex v7 = new Vertex("Intersection 8");
        Vertex v8 = new Vertex("Intersection 9");
        Vertex v9 = new Vertex("Intersection 10");
        Vertex v10 = new Vertex("Intersection 11");
        Vertex v11 = new Vertex("Parking C");
        Vertex v12 = new Vertex("Intersection 13");
        Vertex v13 = new Vertex("Parking D");
        Vertex v14 = new Vertex("Intersection 15");
        Vertex v15 = new Vertex("Intersection 16");
        Vertex v16 = new Vertex("Intersection 17");
        Vertex v17 = new Vertex("Intersection 18");
        Vertex v18 = new Vertex("Intersection 19");
        Vertex v19 = new Vertex("Intersection 20");

        //Création des routes entre les noeuds
        //intersec 1
        v0.adjacencies = new Edge[]{ new Edge(v1, ran(4)),
                new Edge(v2, ran(3)) };
        //intersec 2
        v1.adjacencies = new Edge[]{ new Edge(v0, ran(4)),
                new Edge(v2, ran(5)),
                new Edge(v7, ran(7)) };
        //intersec 3
        v2.adjacencies = new Edge[]{ new Edge(v0, ran(3)),
                new Edge(v1, ran(5)),
                new Edge(v3, ran(4)),
                new Edge(v8, ran(4)) };
        //parking 1
        v3.adjacencies = new Edge[]{ new Edge(v2, ran(4)),
                new Edge(v4, ran(6)) };
        //intersec 5
        v4.adjacencies = new Edge[]{ new Edge(v3, ran(6)),
                new Edge(v5, ran(2)) };
        //intersec 6
        v5.adjacencies = new Edge[]{ new Edge(v4, ran(2)),
                new Edge(v6, ran(7)),
                new Edge(v10, ran(2)) };
        //parking 2
        v6.adjacencies = new Edge[]{ new Edge(v5, ran(7)),
                new Edge(v7, ran(4)) };
        //intersec 8
        v7.adjacencies = new Edge[]{ new Edge(v1, ran(7)),
                new Edge(v6, ran(4)),
                new Edge(v8, ran(6)),
                new Edge(v11, ran(6)) };
        //intersec 9
        v8.adjacencies = new Edge[]{ new Edge(v2, ran(4)),
                new Edge(v7, ran(6)),
                new Edge(v9, ran(4)),
                new Edge(v12, ran(4)) };
        //intersec 10
        v9.adjacencies = new Edge[]{ new Edge(v8, ran(4)),
                new Edge(v10, ran(4)),
                new Edge(v14, ran(7)) };
        //intersec 11
        v10.adjacencies = new Edge[]{ new Edge(v5, ran(2)),
                new Edge(v9, ran(4)),
                new Edge(v15, ran(4)) };
        //parking 3
        v11.adjacencies = new Edge[]{ new Edge(v7, ran(6)),
                new Edge(v12, ran(4)) };
        //intersec 13
        v12.adjacencies = new Edge[]{ new Edge(v8, ran(6)),
                new Edge(v11, ran(4)),
                new Edge(v13, ran(6)),
                new Edge(v18, ran(2)) };
        //parking 4
        v13.adjacencies = new Edge[]{ new Edge(v12, ran(6)),
                new Edge(v14, ran(7)) };
        //intersec 15
        v14.adjacencies = new Edge[]{ new Edge(v13, ran(7)),
                new Edge(v15, ran(4)),
                new Edge(v19, ran(4)) };
        //intersec 16
        v15.adjacencies = new Edge[]{ new Edge(v10, ran(4)),
                new Edge(v14, ran(4)) };
        //intersec 17
        v16.adjacencies = new Edge[]{ new Edge(v17, ran(4)) };
        //parking 4
        v17.adjacencies = new Edge[]{ new Edge(v16, ran(4)),
                new Edge(v18, ran(6)) };
        //intersec 19
        v18.adjacencies = new Edge[]{ new Edge(v12, ran(2)),
                new Edge(v17, ran(6)),
                new Edge(v19, ran(6)) };
        //intersec 20
        v19.adjacencies = new Edge[]{ new Edge(v14, ran(4)),
                new Edge(v18, ran(6)) };
        //Toutes les intersections sont mises dans le même array de Vertex
        Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19 };
        String location;
        Vertex source = null;
        //Selon le nombre (x) entré dans la méthode Djikstra (int x), changement de la source qui est le point de départ de l'algorithme
        int intersection = x;

        if (intersection == 1)
            source = v0;
        else if (intersection == 3)
            source = v2;
        else if (intersection == 5)
            source = v4;
        else if (intersection == 8)
            source = v7;
        else if (intersection == 10)
            source = v9;
        else if (intersection == 13)
            source = v12;
        else if (intersection == 15)
            source = v14;
        else if (intersection == 17)
            source = v16;
        else if (intersection == 19)
            source = v18;
        else
            source = v19;
        //Création des variables nécessaires pour voir quel stationnement libre est le plus proche
        Vertex target = null;
        char goal = '0';
        double minimum = 1000;
        /*Si un stationnement est libre, alors le programme calcul le poids du chemin le plus court vers celui-ci
            Si le poids est inférieur au double minimum, la valeur de minimum est remplacé par celle du stationnement et le goal
            est changé pour le stationnement analysé, ceci est reproduit pour chaque stationnement */
        if(EstLibre(Stationnement_A)) {
            target = v3;
            computePaths(source);
            List<Vertex> path = getShortestPathTo(target);
            if (target.minDistance<minimum) {
                minimum = target.minDistance;
                goal = 'A';
            }
        }
        if(EstLibre(Stationnement_B)) {
            target = v6;
            computePaths(source);
            List<Vertex> path = getShortestPathTo(target);
            if (target.minDistance<minimum) {
                minimum = target.minDistance;
                goal = 'B';
            }
        }if(EstLibre(Stationnement_C)) {
            target = v11;
            computePaths(source);
            List<Vertex> path = getShortestPathTo(target);
            if (target.minDistance<minimum) {
                minimum = target.minDistance;
                goal = 'C';
            }
        }if(EstLibre(Stationnement_D)) {
            target = v13;
            computePaths(source);
            List<Vertex> path = getShortestPathTo(target);
            if (target.minDistance<minimum) {
                minimum = target.minDistance;
                goal = 'D';
            }
        }
        //Selon le but assigné, le bon stationnement est choisis
        if (goal=='A') {target= v3;}
        if (goal=='B') {target= v6;}
        if (goal=='C') {target= v11;}
        if (goal=='D') {target= v13;}


        // La méthode Djikstra(int x) retourne un String comprennant le chemin le plus court noeud par noeud et le poids de ce chemin (Distance)
        computePaths(source);
        List<Vertex> path = getShortestPathTo(target);
        String retour = "Path: ";
        retour+= path;
        retour += "\nDistance: ";
        retour += target.minDistance;

        return retour;}

}




