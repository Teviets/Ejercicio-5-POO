/**
 * Esta clase crea las interacciones que puede tener el caza recompensas y las interacciones de su mascota
 * 
 * @author Sebastian Estrada Tuch
 * @since 19/10/2021
 * @version 0.1
 */
class CazaRecompensa extends Jugador{
    private Mascota mascotita; // Guarda la mascota del Caza Recompensas
    
    /**
     * Este es el metodo constructor y establece todas las propiedades de este
     * @param nom
     */
    public CazaRecompensa(String nom){
        super();
        mascotita = new Mascota();
        this.setNombre(nom);
        this.setDamage(5.0);
        this.setVida(10.0);
        this.setIdentificador("Caza Recompensas");
        
    }

    /**
     * Este es el overrideo del metodo eliminasAlgo de la clase Jugador
     */
    public void eliminasAlgo(){
        System.out.println("\nSi, si sigo asi me volvere millonario sigue asi " );
        mascotita.eliminasAlgo();
    }

    /**
     * Este es el overrideo del metodo teEliminaron de la clase Jugador
     */
    public void teEliminaron(){
        System.out.println("\nSi hubiera vivido como queria, en mi mansion\n");
        mascotita.teEliminaron();
    }

    /**
     * Este es un metodo getter de la mascota
     * @return retorna una mascota
     */
    public Mascota getMascota(){
        return mascotita;
    }
    

    
}