import java.util.ArrayList;
/**
 * Este es un metodo abstracto de los enemigos que saldran en el juego
 * @author Sebastian Estrada Tuch
 * @since 18/10/2021
 * @version 0.1
 */
abstract class Enemigos{
    public double vida;// Esta variable guarda la vida del enemgio
    public double damage;// Esta variable guarda el daño que hace el enemigo
    public ArrayList<ItemoHabilidad> dropeo = new ArrayList<ItemoHabilidad>(); // Este ArrayList guarda los items o habilidades a dropear
    public ItemoHabilidad virus;// Guarda el virus que puede tener el enemigo

    /**
     * Este es el metodo abstracto que variara dependiendo de enemigo que se elimine
     */
    public abstract void teEliminaron();
    
    /**
     * Este es un metodo abstracto que variara dependiendo de que enemigo elimine a un jugador
     */
    public abstract void hasEliminado();

    /**
     * Este metodo es para establecer el virus que el jugador le aplique a un robot
     * @param vir
     */
    public void setVirus(ItemoHabilidad vir){
        virus = vir;
    }
    /**
     * Este metodo setea la vida del enemigo
     * @param vid
     */
    public void setVida(double vid){
        vida = vid;
    }

    /**
     * Este metodo settea el damage del enemigo
     * @param dam
     */
    public void setDamage(double dam){
        damage = dam;
    }
    /**
     * Este metodo añad
     * @param nom
     * @param intent
     * @param rond
     * @param dam
     */
    public void nuevoItem(String nom,int intent, int rond, double dam){
        dropeo.add(new ItemoHabilidad(nom,"",intent,rond,dam));
    }
    /**
     * Este metodo retorna la vida del enemigo
     * @return retorna un double
     */
    public double getVida(){
        return vida;
    }

    /**
     * Este metodo retorna el daño del enemigo
     * @return retorna un double
     */
    public double getDamage(){
        return damage;
    }

    /**
     * Este metodo retorna el arraylist de items dropeados 
     * @return retorna un arrraylist de ItemoHabilidad
     */
    public ArrayList<ItemoHabilidad> getDropeo(){
        return dropeo;
    }

    /**
     * Este metodo aplica el daño del virus al enemigo
     */
    public void aplicarVirus(int i){
        if(virus != null){
            if (virus.getRondas()>0){
                vida = vida - virus.getDamage();
                System.out.println("El enemigo"+ i + "tiene virus");
            }else if (virus.getRondas() == 0){
                virus = null;
            }
        }
    }

    /**
     * Este metodo permite al final boss generar un clon
     * @param voss
     * @param nomb
     * @param vid
     * @param damg
     * @param copia
     */
    public void nuevoClonF(FinalBoss voss, String nomb, double vid, double damg, ItemoHabilidad copia){
        voss.nuevoClon(nomb, vid, damg, copia);
    }

    /**
     * Este metodo permite a un finalBoss retornar un ArrayList de clones 
     * @param voss
     * @return
     */
    public ArrayList<Clon> getClones(FinalBoss voss){
        return voss.getClones();
    }

}