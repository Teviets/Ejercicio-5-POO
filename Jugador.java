import java.util.ArrayList;
/**
 * Esta es la clase abstracta para los jugadores que sera heredada en la clase tecnico, CazaRecompensa y robocop.
 * En esta clase se definen ciertos metodos concretos y abstractos importantes para el desarrollo del juego
 * 
 * @author Sebastian Estrada Tuch
 * @since 18/10/2021
 * @version 0.1
 */
abstract class Jugador{
    private String nombre;// Esta variable guarda el nombre del jugador
    private String identificador;// Esta variable guarda la
    private double vida; // Esta variable guarda el double de la vida
    private double damage; // Esta variable guarda el daño basico que puede hacer el usuario
    private ArrayList<ItemoHabilidad> inventario = new ArrayList<ItemoHabilidad>();// Este arraylist guarda todos los items de los jugadores
    

    public abstract void eliminasAlgo();// Esta clase abstracta que mostrara dialogos especificos para cada jugador

    public abstract void teEliminaron();// Esta clase abstracta que mostrara dialogos especificos para cada jugador

    /**
     * Este metodo permite modificar el nombre del jugador
     * @param nom
     */
    public void setNombre(String nom){
        nombre = nom;
    }

    /**
     * Este metodo settea el identificador del personaje
     * @param x
     */
    public void setIdentificador(String x){
        identificador = x;
    }

    /**
     * Este metodo permite modificar el daño que hace el jugador
     * @param vid
     */
    public void setDamage(double dam){
        damage = dam;
    }

    /**
     * Este metodo permite modificar la vida que tienen los jugadores
     * @param vid
     */
    public void setVida(double vid){
        vida = vid;
    }

    /**
     * Este metodo muestra los inventarios que tienen los usuarios
     */
    public void mostrarInv(){
        for (int i = 0; i<inventario.size(); i++){
            System.out.println("["+i+"] " + inventario.get(i).getNombre()+"\n");
        }
    }
    
    /**
     * Este metodo agrega un nuevo item o habilidad al inventario
     * @param paraUsar
     */
    public void nuevoItem(ItemoHabilidad paraUsar){
        inventario.add(paraUsar);
    }

    /**
     * Este metodo getter retorna el nombre del jugador
     * @return retorna un String
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Este metodo getter retorna el damage que hace el jugador
     * @return retorna un double
     */
    public double getDamage(){
        return damage;
    }

    /**
     * Este metodo getter retorna la vida que tiene el jugador
     * @return retorna un double
     */
    public double getVida(){
        return vida;
    }

    /**
     * Este metodo retorna un item o habilidad especifico
     * @return retorna un ItemoHabilidad
     */
    public ArrayList<ItemoHabilidad> getInventario(){
        return inventario;
    }

    /**
     * Este metodo retorna el identificador del jugador
     * @return retorna un String
     */
    public String getIdentificador(){
        return identificador;
    }
}