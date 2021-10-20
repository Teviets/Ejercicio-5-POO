import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase organiza y organiza todas las acciones que el usuario y los enemigos pueden hacer
 * 
 * @author Sebastian Estrada
 * @since 28/09/2021
 * @version 1.0
 */
class CampoDeBatalla{
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>(); // Guarda a los posibles jugadores
    private ArrayList<EnemigosBas> enemigos = new ArrayList<EnemigosBas>(); // Este ArrayList de los enemigos que hay 
    private FinalBoss boss = new FinalBoss();// Este es el final Boss 
    private Random rand = new Random(); // Es el generador aleatorio

    /**
     * Este metodo es el constructor y crea al usuario
     * @param nomUs
     */
    public CampoDeBatalla(String nomUs, int eleccion){
        
    }

    /**
     * Este metodo genera los roles que pueden tener los usuarios
     * @param nomUs
     * @param eleccion
     */
    public void newUser(String nomUs, int eleccion){
        switch (eleccion) {
            case 1:
                jugadores.add(new Robocop(nomUs));
                break;
            case 2:
                jugadores.add(new CazaRecompensa(nomUs));
                /*
                for (int i = 0; i<jugadores.size(); i++){
                    if ((jugadores.get(i).getIdentificador().equals("Caza Recompensas")) == true){
                        jugadores.get(i).nuevaMascota();
                    }
                }*/
                break;
            case 3:
                jugadores.add(new Tecnico(nomUs));
            default:
                break;
        }
    }


    /**
     * Este metodo settea los 3 robots en enemigos como azules
     */
    public void enfrentamiento1(){
        enemigos.add(new EnemigosBas("RAzul"));
        enemigos.add(new EnemigosBas("RAzul"));
        enemigos.add(new EnemigosBas("RAzul"));
    }
    /**
     * Este metodo settea los 3 robots en enemigos como rojos
     */
    public void enfrentamiento2(){
        enemigos.add(new EnemigosBas("RRojo"));
        enemigos.add(new EnemigosBas("RRojo"));
        enemigos.add(new EnemigosBas("RRojo"));
    }
    /**
     * Este metodo settea los 3 robots en enemigos como rojos
     */
    public void enfrentamiento3(){
        enemigos.add(new EnemigosBas("RGris"));
        enemigos.add(new EnemigosBas("RGris"));
        enemigos.add(new EnemigosBas("RGris"));
    }
    /**
     * Este metodo imprime la vida restante de los robots y la del usuario
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
     * Este metodo muestra la vida restante del boss y del usurio
     */
    public void mostrarVidaConBoss(){
        System.out.println("\nLa vida del Jefe es "+ boss.getVida()+"\n");
        System.out.println("\nTu vida es de " + user.getVidas());
    }
    /**
     * Este metodo establece que al azar el usuario le pega a uno de los robots en enemigos
     */
    public void opcion1User(){
        int x = rand.nextInt(enemigos.size());
         
    }
    /**
     * En este metodo permite al usuario escoger el item que va a utilizar el usuario, contra sus enemigos
     * o en si mismo
     * @param paInven
     */
    public void opcion2User(int paInven){
        if (user.getItems().get(paInven).getIntentos() == 0){
            System.out.println("\nEste item o habilidad se te acabo\n");
        }else{
            if(user.getItems().get(paInven).getNombre().equals("Granada") == true){
                // Granada
                if(enemigos.get(0) != null){
                    for (int i=0; i<enemigos.size()-1;i++){
                        double vid = enemigos.get(i).getVida();
                        enemigos.get(i).setVida(vid - user.getItems().get(paInven).getDamage());
        
                    }
                    user.getItems().get(paInven).setIntentos(user.getItems().get(paInven).getIntentos() - 1);
                    System.out.println("\nA dos de los robots les has hecho un daño de " + user.getItems().get(paInven).getDamage()+"\n");
                    
                }else if(enemigos.get(0) == null){
                    double vid = boss.getVida();
                    boss.setVida(vid - user.getItems().get(paInven).getDamage());
                }
                
            }else if (user.getItems().get(paInven).getNombre().equals("Manual") == true){
                // manual
                if(enemigos.get(0) != null){
                    double vida = user.getItems().get(paInven).getDamage();
                    double vidita = user.getVidas() + vida;
                    user.setVidas(vidita);
                }else if(enemigos.get(0) == null){
                    double vida = user.getItems().get(paInven).getDamage();
                    double vidita = user.getVidas() + vida;
                    user.setVidas(vidita);
                }
                user.getItems().get(paInven).setIntentos(user.getItems().get(paInven).getIntentos() - 1);
                System.out.println("\nTe has curado " + user.getItems().get(paInven).getDamage()+"\n");
            }else if (user.getItems().get(paInven).getNombre().equals("Virus") == true){
                // Virus
                if(enemigos.get(0)!= null){
                    int x = rand.nextInt(enemigos.size());
                    if (x == 0){
                        enemigos.get(0).setVirus(user.getItems().get(paInven));
                    }else if(x == 1){
                        enemigos.get(1).setVirus(user.getItems().get(paInven));
                    }else if (x == 2){
                        enemigos.get(2).setVirus(user.getItems().get(paInven));
                    }
                    user.getItems().get(paInven).setIntentos(user.getItems().get(paInven).getIntentos() - 1);
                    System.out.println("\nLe has aplicado un virus al " + x + " Robot\n");
                }else if(enemigos.get(0)==null){
                    System.out.println("\nNo funcionan los virus en MI JAJAJAJAJAJA\n");
                }
            }else if(user.getItems().get(paInven).getNombre().equals("Hack") == true){
                // Hack
                if (enemigos.get(0) != null){
                    int x = rand.nextInt(enemigos.size());
                    if (x == 0){
                        enemigos.get(0).setDamage(enemigos.get(0).getDamage()-(user.getItems().get(paInven).getDamage()));
                    }else if(x == 1){
                        enemigos.get(1).setDamage(enemigos.get(1).getDamage()-(user.getItems().get(paInven).getDamage()));
                    }else if (x == 2){
                        enemigos.get(1).setDamage(enemigos.get(1).getDamage()-(user.getItems().get(paInven).getDamage()));
                    }
                    user.getItems().get(paInven).setIntentos(user.getItems().get(paInven).getIntentos() - 1);
                    System.out.println("\nLe has reducido el daño a tu rival\n");
                }else if(enemigos.get(0)==null){
                    System.out.println("\nMi IA es muy fuerte y no puedes controlarla\n");
                }

            }else if(user.getItems().get(paInven).getNombre().equals("Misiles") == true){
                // Misiles
                if(enemigos.get(0) != null){
                    for (int i = 0; i<enemigos.size(); i++){
                        enemigos.get(i).setVida(enemigos.get(i).getVida() - user.getItems().get(paInven).getDamage());
                    }
                }else if(enemigos.get(0) == null){
                    boss.setVida(boss.getVida() - user.getItems().get(paInven).getDamage());
                }
            }
        }
        
    }
    /**
     * Este metodo le aplica daño al usuario por cada enemigo en enemigos
     */
    public void turnoRobot(){
        
        for (int i = 0; i<enemigos.size(); i++){
            user.setVidas((user.getVidas() -(((rand.nextInt(100))+1)/50)*enemigos.get(i).getDamage()));
            System.out.println("El Robot"+i+" te ha dañado");
        }
        
    }
    /**
     * Este metodo aplica daño al usuario con el daño del boss
     */
    public void turnoBoss(){
        user.setVidas(user.getVidas()-boss.getDamage());
    }
    /**
     * Este metodo actualiza y verifica si los enemigos tienen vida y si no tienen se eliminan del 
     * array list de enemigos
     */
    public void actualizarEnemigos(){
        for (int i = 0; i<enemigos.size();i++){
            if(enemigos.get(i).getVida()<=0){
                user.nuevoItemoHab(enemigos.get(i).getItemoHabilidad(0));
                System.out.println("\nHas obtenido un item llamado "+ enemigos.get(i).getItemoHabilidad(0).getNombre()+"\n");
                user.nuevoItemoHab(enemigos.get(i).getItemoHabilidad(1));
                System.out.println("\nHas obtenido un item llamado "+ enemigos.get(i).getItemoHabilidad(1).getNombre()+"\n");
                enemigos.get(i).pierde();
                enemigos.remove(i);
                user.gana();
            }else if(user.getVidas() <=0){
                enemigos.get(i).gana();
                user.pierde();
            }
        }
        if(boss !=null){
            if(boss.getVida() <=0){
                boss.pierde();
                user.gana();
            }else if(user.getVidas() <= 0){
                user.pierde();
                boss.gana();
            }
        }
        
    }
    /**
     * Este metodo cambia y aplica el daño de los items  que tenga el usuario a los robots 
     */
    public void cambioDeRonda(){
        try {
            for (int i = 0; i < enemigos.size(); i++){
                try {
                    enemigos.get(i).aplicarDamageVirus();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    /**
     * Este metodo es un getter de la vida de todos los enemigos 
     * @return retorna un double 
     */ 
    public double getVidaEnemies(){
        double x = 0;
        for (int i = 0; i<enemigos.size() ; i++){
            x = x + enemigos.get(i).getVida();
        }
        return x;
    }
    /**
     * Este es un metodo getter de la vida que le queda al usuario
     * @return retorna un double
     */
    public double getVidaUser(){
        return user.getVidas();
    }
    /**
     * Este metodo es un getter de la vida del boss
     * @return retorna un double
     */
    public double getVidaBoss(){
        return boss.getVida();
    }
    /**
     * Este metodo imprime todos los items que el usuario tiene
     */
    public boolean imprimirItems(){
        return user.inventario();
    }

    
    
}