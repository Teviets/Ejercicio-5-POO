/**
 * Esta clase estable los clones que van a tener el final boss
 * 
 * @author Sebastian Estrada Tuch
 * @since 18/10/2021
 * @version 0.1
 */
class Clon extends Enemigos{
    private String nombre; // Guarda el nombre de la persona que clona
    private ItemoHabilidad habHeredada;// guarda la habilidad copiada de finalBoss

    /**
     * Este metodo constructor clona la informacion ya sea del jugador o del final boss
     * @param nom
     * @param vid
     * @param dam
     * @param herencia
     */
    public Clon(String nom, double vid, double dam, ItemoHabilidad herencia){
        nombre = "clon de: " + nom;
        vida = vid*0.5;
        damage = dam*0.5;
        habHeredada = herencia;
    }
    
    /**
     * Este metodo es un overrideo que hace que el metodo este vacia
     */
    public void teEliminaron(){
        // No sucede nada
    }
    /**
     * El metodo overrideado se establece como vacio
     */
    public void hasEliminado(){
        // No sucede nada
    }

    /**
     * Este metodo setea la vida del clon
     * @param vid
     */
    public void setVida(double vid){
        vida = vid;
    }
    /**
     * Este metodo retorna el nombre clonado
     * @return retorna un String
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Este metodo retorna la vida del clon
     * @return retorna un double
     */
    public double getVida(){
        return vida;
    }
    /**
     * Este metodo retorna el damage que hace el clon
     * @return retorna un double
     */
    public double getDamage(){
        return damage;
    }
    /**
     * Este metodo retorna la habilidad heredada por el final Boss
     * @return retorna un ItemoHabilidad
     */
    public ItemoHabilidad getHabilidad(){
        return habHeredada;
    }
}