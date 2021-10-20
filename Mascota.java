/**
 * Esta clase establece la mascota que puede tener el caza recompenzas
 * 
 * @author Sebastian Estrada Tuch
 * @since 18/10/2021
 * @version 0.1
 */
class Mascota extends Jugador{

    /**
     * Este es el metodo constructor, como parametro utiliza un String que sera para colocarse un nombre y se establecen la vida
     * y el daño que realiza
     */
    public Mascota(){
        this.setVida(20);
        this.setDamage(15);
    }

    /**
     * Este metodo retorna un mensaje especifico
     * @return retorna un String
     */
    public void eliminasAlgo(){
        System.out.println(" Sii lo hemos logrado ");
    }
    /**
     * Este metodo retorna un mensaje especifico
     * @return retorna un String
     */
    public void teEliminaron (){
        System.out.println(" lo siento creador ");
    }
    
}