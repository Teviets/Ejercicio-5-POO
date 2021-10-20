class Robocop extends Jugador{
    public Robocop(String nom){
        super();
        
        this.setNombre(nom);
        this.setDamage(20.0);
        this.setVida(80.0);
    }

    public void eliminasAlgo(){
        System.out.println("\nLlego tu fin...\n");
    }
    public void teEliminaron(){
        System.out.println("\nLlego el final de mi mision\n");
    }
}