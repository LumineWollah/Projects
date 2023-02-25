package Sprint2;
public class Attaque {

    public String name;
    public int DGT;
    public int cooldown;

    public Attaque (String name, int DGT, int cooldown) {
    this.name = name;
    this.DGT = DGT;
    this.cooldown = cooldown;
    }

    public void cool(Attaque attaque){
        if (attaque.cooldown != 0) {
            attaque.cooldown--;
        } else {
            if (attaque.name == "Mipha's Grace" || attaque.name == "Patience") {
                attaque.cooldown = 3;
            } else {
                attaque.cooldown = 2;
            }
        } 
    }

    public String toString(){
        return "\nAttaque : " + name + ((name == "Mipha's Grace" || name == "Patience")? "\nSoins : ":"\nDégats : ") + DGT + "\nCooldown : " + ((cooldown == 0)? "Aucun":cooldown);
    }
}
