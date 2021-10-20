class Tecnico extends Jugador{
    public Tecnico(String nom){
        super();
        
        this.setNombre(nom);
        this.setDamage(15.0);
        this.setVida(50.0);
        this.setIdentificador("Tecnico");
    }

    public void eliminasAlgo(){
        System.out.println("\nTus conecciones no fueron bien instaladas\n");
    }
    public void teEliminaron(){
        System.out.println("\nNOOOOO por que no llegue a establecer las conexiones de la nave\n");
    }
}