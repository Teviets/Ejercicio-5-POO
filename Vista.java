import java.util.Scanner;
/**
 * Este clase imprime ciertos menus para el juego
 * 
 * @author Sebastian Estrada
 * @since 19/10/2021
 * @version 1.0
 */
public class Vista{
    private Scanner scan;
    private String txt;
    private int num;

    public Vista(){
        scan = new Scanner(System.in);
    }

    public String escogerNombre(){
        System.out.println("\nEscoja su nombre: \n");
        txt = scan.nextLine();
        return txt;
    }

    public int escoger(){
        System.out.println("Escoger tu rol\n"+
                           "1. Robocop\n"+
                           "2. Caza Recompensas\n"+
                           "3. Tecnico\n");
        num = scan.nextInt();
        return num;
    }
        
}