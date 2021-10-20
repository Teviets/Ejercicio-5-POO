import java.lang.Math;
/**
 * En esta clase se establece probabilidades de daño, nombre, lo que hace y las rondas que dura un item o
 * una habilidad
 * 
 * @author Sebastian Estrada
 * @since 27/09/2021
 * @version 0.1
 */
class ItemoHabilidad{
    private String nombre;// Guarda el nombre del item o habilidad
    private String hace;// Guarda una palabra que hace referencia a lo que hace
    private int rondas;// Guarda la cantidad de rondas que tarda este objetos 
    private int intentos; // Guarda la cantidad de beses que se puede utilizar este item
    private double damage;// Guarda la cantidad de daño o regeneracion que puede hacer
    
    /**
     * Este es el metodo constructor establece todo las propiedades de un item o habilidad
     * @param nom
     * @param hac
     * @param intent
     * @param rond
     * @param damag
     */
    public ItemoHabilidad(String nom, String hac, int intent, int rond, double damag){
        nombre = nom;
        hace = hac;
        intentos = intent;
        rondas = rond;
        damage = damag;
    }
    /**
     * Este metodo establece la cantidad de rondas restantes que esta activo el item o habilidad
     * @param rnd
     */
    public void setRondas(int rnd){
        rondas = rnd;
    }
    /**
     * Este metodo reestablece la cantidad de intentos que le quedan a una habilidad o item
     * @param inte
     */
    public void setIntentos(int inte){
        intentos = inte;
    }
    /**
     * Este metodo retorn el nombre
     * @return retorna un String
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Este metodo retorna las rondas restantes
     * @return retorna un int
     */
    public int getRondas(){
        return rondas;
    }
    /**
     * Este es un metodo getter de los intentos
     * @return retorna un int
     */
    public int getIntentos(){
        return intentos;
    }
    /**
     * Este metodo retorna el daño que hace el item o habilidad
     * @return retorna un int
     */
    public double getDamage(){
        return damage;
    }
    /**
     * Este metodo es un getter de lo que hace el item o habilidad
     * @return retorna un String
     */
    public String getHace(){
        return hace;
    }

}