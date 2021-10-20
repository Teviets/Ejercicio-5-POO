import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

class CampoDeBatalla{
    private FinalBoss boss = new FinalBoss();
    private Robocop cop;
    private Tecnico tc;
    private CazaRecompensa cazR;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>(); // Guarda a los posibles jugadores
    private ArrayList<EnemigoBasico> enemigos = new ArrayList<EnemigoBasico>(); // Guarda los enemigos a los que se tienen que 
    private Random rand = new Random();

    /**
     * Este metodo genera un nuevo usuario 
     * @param nomUs
     * @param eleccion
     */
    public void newUser(String nomUs, int eleccion){
        switch (eleccion) {
            case 1:
                cop = new Robocop(nomUs);
                jugadores.add(cop);
                break;
            case 2:
                cazR = new CazaRecompensa(nomUs);
                jugadores.add(cazR);
                break;
            case 3:
                tc = new Tecnico(nomUs);
                jugadores.add(tc);
            default:
                break;
        }
    }

    /**
     * Crea 3 enemigos basicos para pele
     */
    public void establecerRivales(){
        for (int i = 0; i<3; i++){
            enemigos.add(new EnemigoBasico());
        }
    }

    /**
     * Este metodo imprime la vida de los jugadores y de los enemigos
     */
    public void mostrarTodasLasVidasConEne(){
        for (int i = 0; i<enemigos.size(); i++){
            System.out.println("\nLa vida del Robot "+ enemigos.get(i).getVida() + "\n");
        }
        for (int i = 0; i<jugadores.size(); i++){
            System.out.println("\nLa vida de " + jugadores.get(i).getIdentificador()+ " " + jugadores.get(i).getNombre()+ " es "+ jugadores.get(i).getVida());
        }
    }

    /**
     * Este metodo establece un enemigo
     */
    public void establecerFinal(){
        boss = new FinalBoss();
    }

    /**
     * Este metodo hace que un jugador pueda aplicar daño a un enemigo
     * @param turno
     */
    
    public void opcion1(int turno){
        int x = rand.nextInt(enemigos.size());
        if (boss == null){
            if(x==0 ){
                enemigos.get(0).setVida(enemigos.get(0).getVida() - (Math.random()*1)*jugadores.get(turno).getDamage());
            }else if(x == 1){
                enemigos.get(1).setVida(enemigos.get(1).getVida() - (Math.random()*1)*jugadores.get(turno).getDamage());
            }else if(x ==2){
                enemigos.get(2).setVida(enemigos.get(2).getVida() - (Math.random()*1)*jugadores.get(turno).getDamage());
                }
        }else{
            if (boss.getClones().get(0) != null){
                if (boss.getClones().get(0).getHabilidad().getNombre().equals("Absorsion") == true){
                    for (int i = 0; i<boss.getClones().size(); i++){
                        boss.getClones().get(i).setVida(boss.getVida() - jugadores.get(turno).getDamage()*0.8);
                    }
                }else{
                    for (int i = 0; i<boss.getClones().size(); i++){
                        boss.getClones().get(i).setVida(boss.getVida() - jugadores.get(turno).getDamage()*0.8);
                    }
                }
                
            }else{
                boss.setVida(boss.getVida() - jugadores.get(turno).getDamage());
            }
        }
    }

    /**
     * Este metodo permite que el jugador pueda utilizar un virus y una granada de plasma
     * @param turno
     * @param paInven
     */
    public void opcion2(int turno, int paInven){
        if(enemigos.get(0) != null){
            if (jugadores.get(turno).getInventario().get(paInven).getIntentos() == 0){
                System.out.println("\nEste item o habilidad se te acabo\n");
            }else{
                if(jugadores.get(turno).getInventario().get(paInven).getNombre().equals("GranadaDePlasma") == true){
                    // Granada
                    if(enemigos.get(0) != null){
                        for (int i=0; i<enemigos.size(); i++){
                            double vid = enemigos.get(i).getVida();
                            double damag = jugadores.get(turno).getInventario().get(paInven).getDamage();
                            enemigos.get(i).setVida(vid - damag);
                        }
                        jugadores.get(turno).getInventario().get(paInven).setIntentos(jugadores.get(turno).getInventario().get(paInven).getIntentos() - 1);
                        System.out.println("\nA dos de los robots les has hecho un daño de " + jugadores.get(turno).getInventario().get(paInven).getDamage()+"\n");
                    
                    }else if(enemigos.get(0) == null){
                        System.out.println("\nYa no quedan enemigos a quien tirar una granada\n");
                    }
                }else if (jugadores.get(turno).getInventario().get(paInven).getNombre().equals("Virus") == true){
                    // Virus
                    if(enemigos.get(0)!= null){
                        int x = rand.nextInt(enemigos.size());
                        if (x == 0){
                            enemigos.get(0).setVirus(jugadores.get(turno).getInventario().get(paInven));
                        }else if(x == 1){
                            enemigos.get(1).setVirus(jugadores.get(turno).getInventario().get(paInven));
                        }else if (x == 2){
                            enemigos.get(2).setVirus(jugadores.get(turno).getInventario().get(paInven));
                        }
                        jugadores.get(turno).getInventario().get(paInven).setIntentos(jugadores.get(turno).getInventario().get(paInven).getIntentos() - 1);
                        System.out.println("\nLe has aplicado un virus al " + x + " Robot\n");
                    }
                }
            }
        }else{
            System.out.println("\nNo se puede aplicar ningun al Final Boss");
        }
    }

    /**
     * Este metodo aplica el daño de los enemigos 
     */
    public void turnoEnemgios(){
        int x = rand.nextInt(jugadores.size());
        if(enemigos.get(0) != null){
            for (int i = 0; i<enemigos.size(); i++){
                jugadores.get(x).setVida((jugadores.get(x).getVida() -(((rand.nextInt(100))+1)/50)*enemigos.get(i).getDamage()));
                System.out.println("El Robot"+i+" te ha dañado");
            }
        }else{
            if (boss.getClones().get(0) != null){
                for (int i = 0; i<boss.getClones().size(); i++){
                    jugadores.get(x).setVida(jugadores.get(x).getVida() - boss.getClones().get(i).getDamage());
                }
            }else{
                jugadores.get(x).setVida(jugadores.get(x).getVida() - boss.getDamage());
            }
        }
    }

    /**
     * Este metodo imprime la vida de cada uno de los enemigos y jugadores en el campo
     */
    public void mostrarVida(){
        if (enemigos.size()>0){
            for (int i = 0; i<enemigos.size(); i++){
                System.out.println("\nLa vida del enemigo " + i + enemigos.get(i).getVida() + "\n");
            }
        }
        if ( boss != null){
            System.out.println("\nLa vida del Final Boss "+ boss.getVida() + "\n");
        }
        if (jugadores.size()>0){
            for (int i = 0; i<jugadores.size(); i++){
                System.out.println("\nLa vida del jugador "+ jugadores.get(i).getNombre() + " es " + jugadores.get(i).getVida() + "\n");
            }
        }
    }

    /**
     * Este metodo actualiza todos los npc´s y a los jugadores que estan en el campo de batalla
     */
    public void actualizarCampo(){
        if (enemigos.size() > 0 ){
            for (int i = 0; i<enemigos.size(); i++){
                if (enemigos.get(i).getVida() <= 0){
                    System.out.println("\nSe elimino el robot "+i+"\n");
                    enemigos.remove(i);
                }
            }
        }else if(boss != null){
            if (boss.getVida() <= 0){
                System.out.println("\n Eliminaste al final boss");
                boss = null;
            }
        }
        if (jugadores.size()>0){
            for (int i=0; i<jugadores.size(); i++){
                if (jugadores.get(i).getVida() <= 0){
                    System.out.println("\nEl jugador "+ jugadores.get(i).getNombre() + " ha sido eliminado");
                    jugadores.remove(i);
                }
            }
        }else{
            System.out.println("\nGame Over ...\n");
        }
    }

    /**
     * Este metodo cambia y aplica el daño de los items  que tenga el usuario a los robots 
     */
    public void cambioDeRonda(){
        try {
            for (int i = 0; i < enemigos.size(); i++){
                try {
                    enemigos.get(i).aplicarVirus(i);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    /**
     * Este es un metodo Getter de los enemigos basicos
     * @return retorna un arrayList de enemigos
     */
    public ArrayList<EnemigoBasico> getEnemigos(){
        return enemigos;
    }
    /**
     * Este es un metodo getter de los jugadores
     * @return retorna un arraylist de jugador
     */
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    /**
     * Este metodo es un getter del FinalBoss
     * @return retorna un FinalBoss
     */
    public FinalBoss getVidaBoss(){
        return boss;
    }
}