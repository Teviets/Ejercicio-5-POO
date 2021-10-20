import java.util.ArrayList;
/**
 * Esta clase establece las cosas importantes del final boss
 */
class FinalBoss extends Enemigos{
    public double vidaIncial;// Guarda la vida inical que tenia el FinalBoss
    private ArrayList<Clon> clones = new ArrayList<Clon>();// Guarda los clones que tiene el boss
    
    /**
     * Este es el metodo constructor de FinalBoss
     */
    public FinalBoss(){
        super();
        
        vida = 150;
        damage = 25;

        vidaIncial = 150;

        dropeo.add(new ItemoHabilidad("Absorcion","reduce Damage",0,0,0.2));
        dropeo.add(new ItemoHabilidad("Carga","Aumenta su Damage",0,0,0.5));

    }

    /**
     * Este metodo genera nuevos clones
     * @param nom
     * @param vid
     * @param dama
     * @param hab
     */
    public void nuevoClon(String nom, double vid, double dama, ItemoHabilidad hab){
        clones.add(new Clon(nom,vid,dama,hab));
    }

    /**
     * Este metodo imprime el mensaje tras ser eliminado
     */
    public void teEliminaron(){
        System.out.println("\nYo estaba en busca de la paz no lo ENTIENDEEEEEE\n");
    }
    /**
     * Este metodo imprime el mensaje tras eliminar a alguien
     */
    public void hasEliminado(){
        System.out.println("\nPerdieron al fin podre exterminarlos a todos para lograr mi PAZ jajajajaja\n");
    }

    /**
     * Este es un metodo getter de la vida inicial
     * @return retorna un double
     */
    public double getVidaInicial(){
        return vidaIncial;
    }

    /**
     * Este es un metodo getter para los clones obtenidos 
     * @return retorna un arrayList de clon
     */
    public ArrayList<Clon> getClones(){
        return clones;
    }
}