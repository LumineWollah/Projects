package Sprint2;
import java.util.Scanner;
public class sprint2 {
    public static void main(String[] args) {

        int tour = 0;
        int blessure = 0;
        Attaque attaque11 = new Attaque("1. Master Sword", 30, 0);
        Attaque attaque12 = new Attaque("2. HIYAH!", 15, 0);
        Attaque attaque21 = new Attaque("Kick", 15, 0);
        Attaque attaque22 = new Attaque("Warlock Punch", 45, 2);
        Attaque heal1 = new Attaque("3. Mipha's Grace", 25, 3);
        Attaque heal2 = new Attaque("Patience", 50, 3);
        Joueur joueur1 = new Joueur("Link", 100, attaque11, attaque12, heal1 );
        Joueur joueur2 = new Joueur("Ganondorf", 150, attaque21, attaque22, heal2);
        Joueur loser = null;
        Joueur winner = null;
        Scanner myObj = new Scanner(System.in);
        boolean turn = true;
        boolean usable22 = true;
        boolean usable1 = true;
        boolean usable2 = true;
        
        System.out.println("COMBAT ENTRE " + joueur1.name + " ET " + joueur2.name);

        System.out.println(joueur1); System.out.println("\n***************************\n"); System.out.println(joueur2);

        while (joueur1.HP > 0 && joueur2.HP > 0) {
            tour++;
            System.out.println("\n ########## TOUR " + tour + " ##########");
            System.out.println('\n'); joueur1.status(); System.out.println('\n'); joueur2.status();
            if (Math.random() >= 0.5) {

                // Action Joueur 1

                while (turn == true) {

                    System.out.println("\nQuelle Action voulez-vous performer ?"
                    + "\nAttaques : " + joueur1.attaque1 + joueur1.attaque2 + "\nSoin : " + joueur1.heal + "\n4. Fuir" + "\n5. Analyser" + "\n\n*****************\n");

                    int Action = myObj.nextInt();

                    if (Action == 1) {
                        turn = false;
                        blessure = joueur1.attack(attaque11);
                        joueur2.HP -= blessure;
                        System.out.println('\n' + joueur1.name + " ATTAQUE " + joueur2.name + " AVEC " + joueur1.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                        if (joueur2.HP <= 0) {
                            loser = joueur2;
                            winner = joueur1;
                            break;
                        }
                    } else if (Action == 2) {
                        turn = false;
                        blessure = joueur1.attack(attaque12);
                        joueur2.HP -= blessure;
                        joueur1.attaque1.DGT += 10;
                        System.out.println('\n' + joueur1.name + " ATTAQUE " + joueur2.name + " AVEC " + joueur1.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT ET AUGMENTE SON ATTAQUE!");
                        if (joueur2.HP <= 0) {
                            loser = joueur2;
                            winner = joueur1;
                            break;
                        }
                    } else if (Action == 3) {
                        if (usable1 == true) {
                        turn = false;
                        blessure = joueur1.attack(heal1);
                        joueur1.HP += blessure;
                        usable2 = false;
                        System.out.println('\n' + joueur1.name + " SE SOIGNE AVEC " + joueur1.heal.name + " POUR " + blessure + " POINTS DE VIE");
                        } else {
                            System.out.println("ON COOLDOWN");
                        }
                    } else if (Action == 4) {
                        turn = false;
                        if (Math.random()>0.5) {
                            loser  = joueur1;
                            winner = joueur2;
                            joueur1.HP = 0;
                            System.out.println('\n' + joueur1.name + " S'ENFUIT !");
                        } else {
                            System.out.println('\n' + joueur1.name + " TENTE DE S'ENFUIR, MAIS ÉCHOUE !");
                        }
                    } else if (Action == 5) {
                        System.out.println(joueur1); System.out.println(joueur2);
                    } else {
                        System.out.println("\nAction invalide. Veuillez réessayer:\n");
                    }
                }
                
                if (joueur2.HP <= 0) break;

                // Action Joueur 2

                if (joueur2.HP == 0) {
                    if (Math.random()>0.5) {
                        loser  = joueur2;
                        winner = joueur1;
                        joueur2.HP = 0;
                        System.out.println('\n' + joueur2.name + " S'ENFUIT !");
                    } else {
                        System.out.println('\n' + joueur2.name + " TENTE DE S'ENFUIR, MAIS ÉCHOUE !");
                    }
                }
                if (joueur2.HP > 100) {
                    if (usable22 == true) {
                        blessure = joueur2.attack(attaque22);
                        joueur1.HP -= blessure;
                        usable22 = false;
                        System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT");
                        if (joueur1.HP <= 0) {
                            loser = joueur1;
                            winner = joueur2;
                            break;
                        }
                    } else {
                        blessure = joueur2.attack(attaque21);
                        joueur1.HP -= blessure;
                        System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                        if (joueur1.HP <= 0) {
                            loser = joueur1;
                            winner = joueur2;
                            break;
                        }
                    }
                } else {
                    if (Math.random() < 0.25 && usable2 == true) {
                        blessure = joueur2.attack(heal2);
                        joueur2.HP += blessure;
                        usable2 = false;
                        System.out.println('\n' + joueur2.name + " SE SOIGNE AVEC " + joueur2.heal.name + " POUR " + blessure + " POINTS DE VIE");
                    } else {
                        if (usable22 == true) {
                            blessure = joueur2.attack(attaque22);
                            joueur1.HP -= blessure;
                            usable22 = false;
                            System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT");
                            if (joueur1.HP <= 0) {
                                loser = joueur1;
                                winner = joueur2;
                                break;
                            }
                        } else {
                            blessure = joueur2.attack(attaque21);
                            joueur1.HP -= blessure;
                            System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                            if (joueur1.HP <= 0) {
                                loser = joueur1;
                                winner = joueur2;
                                break;
                            }
                        }
                    }
                }

            } else {

            // Action Joueur 2

            if (joueur2.HP > 100) {
                if (usable22 == true) {
                    blessure = joueur2.attack(attaque22);
                    joueur1.HP -= blessure;
                    usable22 = false;
                    System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT");
                    if (joueur1.HP <= 0) {
                        loser = joueur1;
                        winner = joueur2;
                        break;
                    }
                } else {
                    blessure = joueur2.attack(attaque21);
                    joueur1.HP -= blessure;
                    System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                    if (joueur1.HP <= 0) {
                        loser = joueur1;
                        winner = joueur2;
                        break;
                    }
                }
            } else {
                if (Math.random() < 0.25) {
                    blessure = joueur2.attack(heal2);
                    joueur2.HP += blessure;
                    usable2 = false;
                    System.out.println('\n' + joueur2.name + " SE SOIGNE AVEC " + joueur2.heal.name + " POUR " + blessure + " POINTS DE VIE");
                } else {
                    if (usable22 == true) {
                        blessure = joueur2.attack(attaque22);
                        joueur1.HP -= blessure;
                        usable22 = false;
                        System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT");
                        if (joueur1.HP <= 0) {
                            loser = joueur1;
                            winner = joueur2;
                            break;
                        }
                    } else {
                        blessure = joueur2.attack(attaque21);
                        joueur1.HP -= blessure;
                        System.out.println('\n' + joueur2.name + " ATTAQUE " + joueur1.name + " AVEC " + joueur2.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                        if (joueur1.HP <= 0) {
                            loser = joueur1;
                            winner = joueur2;
                            break;
                        }
                    }
                }
            }

            // Action Joueur 1

            while (turn == true) {

                System.out.println("\nQuelle Action voulez-vous performer ?"
                + "\nAttaques : " +joueur1.attaque1 + joueur1.attaque2 + "\nSoin : " + joueur1.heal + "\n4. Fuir" + "\n5. Analyser : " + "\n\n*****************\n");

                int Action = myObj.nextInt();

                if (Action == 1) {
                    turn = false;
                    blessure = joueur1.attack(attaque11);
                    joueur2.HP -= blessure;
                    System.out.println('\n' + joueur1.name + " ATTAQUE " + joueur2.name + " AVEC " + joueur1.attaque1.name + " POUR " + blessure + " POINTS DE DÉGAT");
                    if (joueur2.HP <= 0) {
                        loser = joueur2;
                        winner = joueur1;
                        break;
                    }
                } else if (Action == 2) {
                    turn = false;
                    blessure = joueur1.attack(attaque12);
                    joueur2.HP -= blessure;
                    joueur1.attaque1.DGT += 10;
                    System.out.println('\n' + joueur1.name + " ATTAQUE " + joueur2.name + " AVEC " + joueur1.attaque2.name + " POUR " + blessure + " POINTS DE DÉGAT ET AUGMENTE SON ATTAQUE!");
                    if (joueur2.HP <= 0) {
                        loser = joueur2;
                        winner = joueur1;
                        break;
                    }
                } else if (Action == 3) {
                    if (usable1 == true) {
                    turn = false;
                    blessure = joueur1.attack(heal1);
                    joueur1.HP += blessure;
                    usable1 = false;
                    System.out.println('\n' + joueur1.name + " SE SOIGNE AVEC " + joueur1.heal.name + " POUR " + blessure + " POINTS DE VIE");
                    } else {
                        System.out.println("ON COOLDOWN");
                    }
                } else if (Action == 4) {
                    turn = false;
                    if (Math.random()>0.5) {
                        loser  = joueur1;
                        winner = joueur2;
                        joueur1.HP = 0;
                        System.out.println('\n' + joueur1.name + " S'ENFUIT !");
                    } else {
                        System.out.println('\n' + joueur1.name + " TENTE DE S'ENFUIR, MAIS ÉCHOUE !");
                    }
                } else if (Action == 5) {
                    System.out.println(joueur1); System.out.println(joueur2);
                } else {
                    System.out.println("\nAction invalide. Veuillez réessayer:\n");
                }
            }
        
        }
        
        if (usable22 == false) {attaque22.cool(attaque22);}
        if (usable1 == false) {heal1.cool(heal1);}
        if (usable2 == false) {heal2.cool(heal2);}
        if(attaque22.cooldown == 2) {
            usable22 = true;
        }
        if(heal1.cooldown == 3) {
            usable1 = true;
        }
        if(heal2.cooldown == 3) {
            usable2 = true;
        }
        turn = true;

    }
        System.out.println("\n*************************************************************" + 
         "\n \n" + winner.name + " A BATTU " + loser.name + " AU BOUT DE " + tour + " TOURS\n");
    
}
}