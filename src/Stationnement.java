import java.util.*;

public class Stationnement {
    //Création d'une instance d'un stationnement, False = Occupé

    public static boolean Rand_Stat() {
        Random ran = new Random();
        int x;
        x= ran.nextInt(10);
        if (x == 9){return true;}
        else return false;
    }
    //Vérification si un stationnement est disponible
    public static boolean EstLibre(boolean arr[]) {
        int x = 0;
        for(int j = 0; j<arr.length;j++){
            if(arr[j]==true){x=1;}
        }
        if (x==1) {return true;}
        else return false;
    }

    public static String CmbLibre(boolean arr[]) {
        int x = 0;
        for(int j = 0; j<arr.length;j++){
            if(arr[j]==true){x+=1;}
        }
        if (x==1) {return "Une seule place est disponible";}
        else if (x>=2) {return x + " places sont disponibles";}
        else return "Aucune place n'est disponible";
    }
}
