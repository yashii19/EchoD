import java.util.ArrayList;
public class Game{
/*3 constructeurs différents pour des parties à 1, 2 ou 4 joueurs. le temps en mois et en année est initialisée à 0*/
	private ArrayList <Player> players;
	private Map carte;
	private int month;
	private int years;

	public Game(Player p1, Map m){
		players = new ArrayList <Player> ();
		players.add(p1);
		carte = m;
		month = 0;
		years = 0;
	}

	public Game(Player p1, Player p2, Map m){
		players = new ArrayList <Player> ();
		players.add(p1);
		players.add(p2);
		carte = m;
		month = 0;
		years = 0;
	}

	public Game(Player p1, Player p2, Player p3, Player p4, Map m){
		players = new ArrayList <Player> ();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		carte = m;
		month = 0;
		years = 0;
	}

	public void start(){
	/*Debut de la partie avec positionnement de base des joueurs : le positionnement varie en fonction du nombre de joueurs dans la partie*/
		if (players.size()==1){
			if(carte.carte[10][10] instanceof Montagne){
				carte.carte[10][10].setBuilding(4);
				carte.carte[10][10].setPossession(1);
			}
			if(carte.carte[10][10] instanceof Littoral){
				carte.carte[10][10].setBuilding(3);
				carte.carte[10][10].setPossession(1);
			}
			if(carte.carte[10][10] instanceof Plaine){
				carte.carte[10][10].setBuilding(3);
				carte.carte[10][10].setPossession(1);
			}
			if(carte.carte[10][10] instanceof Desert){
				carte.carte[10][10].setBuilding(5);
				carte.carte[10][10].setPossession(1);
			}
		}
		if (players.size()==2){
			if(carte.carte[4][4] instanceof Montagne){
				carte.carte[4][4].setBuilding(4);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Littoral){
				carte.carte[4][4].setBuilding(3);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Plaine){
				carte.carte[4][4].setBuilding(3);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Desert){
				carte.carte[4][4].setBuilding(5);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[14][14] instanceof Montagne){
				carte.carte[14][14].setBuilding(4);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Littoral){
				carte.carte[14][14].setBuilding(3);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Plaine){
				carte.carte[14][14].setBuilding(3);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Desert){
				carte.carte[14][14].setBuilding(5);
				carte.carte[14][14].setPossession(2);
			}
		}
		if(players.size()==4){
			if(carte.carte[4][4] instanceof Montagne){
				carte.carte[4][4].setBuilding(4);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Littoral){
				carte.carte[4][4].setBuilding(3);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Plaine){
				carte.carte[4][4].setBuilding(3);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[4][4] instanceof Desert){
				carte.carte[4][4].setBuilding(5);
				carte.carte[4][4].setPossession(1);
			}
			if(carte.carte[14][14] instanceof Montagne){
				carte.carte[14][14].setBuilding(4);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Littoral){
				carte.carte[14][14].setBuilding(3);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Plaine){
				carte.carte[14][14].setBuilding(3);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][14] instanceof Desert){
				carte.carte[14][14].setBuilding(5);
				carte.carte[14][14].setPossession(2);
			}
			if(carte.carte[14][4] instanceof Montagne){
				carte.carte[14][4].setBuilding(4);
				carte.carte[14][4].setPossession(3);
			}
			if(carte.carte[14][4] instanceof Littoral){
				carte.carte[14][4].setBuilding(3);
				carte.carte[14][4].setPossession(3);
			}
			if(carte.carte[14][4] instanceof Plaine){
				carte.carte[14][4].setBuilding(3);
				carte.carte[14][4].setPossession(3);
			}
			if(carte.carte[14][4] instanceof Desert){
				carte.carte[14][4].setBuilding(5);
				carte.carte[14][4].setPossession(3);
			}
			if(carte.carte[4][14] instanceof Montagne){
				carte.carte[4][14].setBuilding(4);
				carte.carte[4][14].setPossession(4);
			}
			if(carte.carte[4][14] instanceof Littoral){
				carte.carte[4][14].setBuilding(3);
				carte.carte[4][14].setPossession(4);
			}
			if(carte.carte[4][14] instanceof Plaine){
				carte.carte[4][14].setBuilding(3);
				carte.carte[4][14].setPossession(4);
			}
			if(carte.carte[4][14] instanceof Desert){
				carte.carte[4][14].setBuilding(5);
				carte.carte[4][14].setPossession(4);
			}
		}
	}

	public void gameStatus(){/*affiche la carte et indique le temps de jeu actuel*/
		carte.afficherCarte();
		System.out.println("Nous sommes au mois "+month+" de la "+years+"ème année");
	}

	public void seisme(){/*un seisme qui arrive de manière aléatoire et qui frappe aléatoirement une case du tableau de jeu. Si une structure y est présente,
	elle est détruite avec toutes les consequences que cela implique (augmentation du niveau de pollution dans ceratints cas)*/ 
		if((int)(Math.random()*101)< 101){
			System.out.println("Un seisme a lieu!");
			int b = (int)(Math.random()*20);
			int c = (int)(Math.random()*20);
			if(carte.carte[b][c].building != null){
				System.out.println("Le joueur "+carte.carte[b][c].possession+" a été touché! ("+players.get(carte.carte[b][c].possession-1).getPseudo()+")");
				System.out.println("La zone affectée est "+carte.carte[b][c].toString()+"(position "+(b+1)+" "+(c+1)+")");
				System.out.println("Cet objet energetique est maintenant cassé");
				carte.carte[b][c].building.casse();
				players.get(carte.carte[b][c].possession-1).setPollutionMeter(carte.carte[b][c].building.damage());
				System.out.println("Le niveau de pollution monte a "+players.get(carte.carte[b][c].possession-1).getPollutionMeter());
			}
			else{
				System.out.println("Mais personne n'est touché!");
			}
		}
		else{
			System.out.println("Un nouveau mois sans emcombres...");
		}
	}

	public void repair(int a, int b){/*permet de reparer une structure qui à été détruite par un seisme*/
		if (carte.carte[a-1][b-1].building.getStatus()){
			System.out.println("Vous n'avez pas besoin de reparer cette structure, elle est en parfait état");
		}
		else{
			int joueur = carte.carte[a-1][b-1].getPossession();
			if(carte.carte[a-1][b-1].building.getRepareCost() > players.get(joueur-1).getPoints()){
				System.out.println("erreur : vous n'avez pas assez de points pour reparer votre structure");
			}
			else{
				players.get(joueur).setPoints((carte.carte[a-1][b-1].building.getRepareCost())*-1);
				carte.carte[a-1][b-1].building.reparation();
				System.out.println("Structure reparee avec succes:");
			}
		}
	}

	public void build(int obj, int posA, int posB, Player p){*/
		/*construit un objet sur une case choisie à condition que ce soir une case adjacente au joueur 
		et que cette dernière n'est pas déja occupée (pas encore finie)*/
		if(carte.carte[posA-1][posB-1].building != null){
			System.out.println("Il y a déjà une structure sur ce terrain.");
			return;
		}
		if (carte.carte[posA-2][posB-2].getPossession()==p.getNumber || )
	}
		

	/*public void tourJoueur(Player p){
		Durant un tour, le joueur peut :
		-construire un nouvel objet energetique
		-améliorer un objet enegétique en sa posséssion
		-reparer un objet energétique endommagé si cela est possible pour l'objet energetique en question
		-passer son tour au joueur suivant
	}*/




}