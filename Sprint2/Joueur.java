package Sprint2;
public class Joueur {
    // Attributs

    public String name;
    public int HP;
    public Attaque attaque1;
    public Attaque attaque2;
    public Attaque heal;
    public Attaque analyse;
    public Attaque fuir;

    // Construction

    public Joueur(String name, int HP, Attaque attaque1, Attaque attaque2, Attaque heal) {
        this.name = name;
        this.HP = HP;
        this.attaque1 = attaque1;
        this.attaque2 = attaque2;
        this.heal = heal;
    }

    // Méthodes

    public int attack(Attaque attaque){
        return (int)((Math.random() + 0.5)*attaque.DGT);
    }

    public int heal(){
        return (int)((Math.random() + 0.5)*this.heal.DGT);
    }
    
    public String toString(){
        return "\nCombattant : " + name + "\nHP : " + HP + "\nAttaques : " + "\n" + attaque1 + "\n" + attaque2 + "\n" + heal;
    }

    public void status(){
        System.out.println("\nCombattant : " + name + "\nHP : " + HP);
    }
}
