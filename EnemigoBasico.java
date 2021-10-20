import java.util.Random;
/**
 * Esta clase hereda de enemigos y establece lo necesario para un enemigo basico
 * 
 * @author Sebastian Estrada
 * @since 18/10/2021
 * @version 0.1
 */
class EnemigoBasico extends Enemigos{
    private Random rand = new Random();// Esta variable sirve para generar numeros aleatorios
    /**
     * Este es el metodo constructor de un enemigo basico
     */
    public EnemigoBasico(){
        vida = 40;
        damage = 15;
        
        int x = rand.nextInt(2);

        switch (x) {
            case 1:
                int y = rand.nextInt(5);
                int z = rand.nextInt(5);
                dropeo.add(new ItemoHabilidad("Virus","Veneno",y,z,5));
                break;
            case 2:
                int w = rand.nextInt(5);
                dropeo.add(new ItemoHabilidad("Granada De Plasma","daño explosivo",w,1,20));
                break;
        
            default:
                break;
        }
    }

    /**
     * Este metodo es el metodo overideado del metodo abstracto de enemigos
     */
    public void teEliminaron(){
        System.out.println("\nMe venciste pero nunca a mi jefe\n");
    }
    /**
     * Este metodo es el metodo overideado del metodo abstracto de enemigos
     */
    public void hasEliminado(){
        System.out.println("\nSabia que no podias contra la Matrix");
    }
}