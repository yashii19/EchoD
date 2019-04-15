import java.util.ArrayList;
import java.util.Scanner;
public class Game{
/*3 constructeurs différents pour des parties à 1, 2 ou 4 joueurs. le temps en mois et en année est initialisée à 0*/
	private ArrayList <Player> players;
	private Map carte;
	private int month;
	private int years;
	private boolean run=false;

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
			if(carte.carte[5][5] instanceof Montagne){
				carte.carte[5][5].setBuilding(4);
				carte.carte[5][5].setPossession(1);
			}
			if(carte.carte[5][5] instanceof Littoral){
				carte.carte[5][5].setBuilding(3);
				carte.carte[5][5].setPossession(1);
			}
			if(carte.carte[5][5] instanceof Plaine){
				carte.carte[5][5].setBuilding(3);
				carte.carte[5][5].setPossession(1);
			}
			if(carte.carte[5][5] instanceof Desert){
				carte.carte[5][5].setBuilding(5);
				carte.carte[5][5].setPossession(1);
			}
		}
		if (players.size()==2){
			if(carte.carte[2][2] instanceof Montagne){
				carte.carte[2][2].setBuilding(4);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Littoral){
				carte.carte[2][2].setBuilding(3);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Plaine){
				carte.carte[2][2].setBuilding(3);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Desert){
				carte.carte[2][2].setBuilding(5);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[7][7] instanceof Montagne){
				carte.carte[7][7].setBuilding(4);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Littoral){
				carte.carte[7][7].setBuilding(3);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Plaine){
				carte.carte[7][7].setBuilding(3);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Desert){
				carte.carte[7][7].setBuilding(5);
				carte.carte[7][7].setPossession(2);
			}
		}
		if(players.size()==4){
			if(carte.carte[2][2] instanceof Montagne){
				carte.carte[2][2].setBuilding(4);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Littoral){
				carte.carte[2][2].setBuilding(3);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Plaine){
				carte.carte[2][2].setBuilding(3);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[2][2] instanceof Desert){
				carte.carte[2][2].setBuilding(5);
				carte.carte[2][2].setPossession(1);
			}
			if(carte.carte[7][7] instanceof Montagne){
				carte.carte[7][7].setBuilding(4);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Littoral){
				carte.carte[7][7].setBuilding(3);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Plaine){
				carte.carte[7][7].setBuilding(3);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][7] instanceof Desert){
				carte.carte[7][7].setBuilding(5);
				carte.carte[7][7].setPossession(2);
			}
			if(carte.carte[7][2] instanceof Montagne){
				carte.carte[7][2].setBuilding(4);
				carte.carte[7][2].setPossession(3);
			}
			if(carte.carte[7][2] instanceof Littoral){
				carte.carte[7][2].setBuilding(3);
				carte.carte[7][2].setPossession(3);
			}
			if(carte.carte[7][2] instanceof Plaine){
				carte.carte[7][2].setBuilding(3);
				carte.carte[7][2].setPossession(3);
			}
			if(carte.carte[7][2] instanceof Desert){
				carte.carte[7][2].setBuilding(5);
				carte.carte[7][2].setPossession(3);
			}
			if(carte.carte[2][7] instanceof Montagne){
				carte.carte[2][7].setBuilding(4);
				carte.carte[2][7].setPossession(4);
			}
			if(carte.carte[2][7] instanceof Littoral){
				carte.carte[2][7].setBuilding(3);
				carte.carte[2][7].setPossession(4);
			}
			if(carte.carte[2][7] instanceof Plaine){
				carte.carte[2][7].setBuilding(3);
				carte.carte[2][7].setPossession(4);
			}
			if(carte.carte[2][7] instanceof Desert){
				carte.carte[2][7].setBuilding(5);
				carte.carte[2][7].setPossession(4);
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
			int b = (int)(Math.random()*10);
			int c = (int)(Math.random()*10);
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

	public void repair(int a, int b){
	/*permet de reparer une structure qui à été détruite par un seisme*/
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

	public void build(int obj, int posA, int posB, Player p){
		/*construit un objet sur une case choisie à condition que ce soir une case adjacente au joueur 
		et que cette dernière n'est pas déja occupée (pas encore finie)*/
		if(carte.carte[posA-1][posB-1].building != null){
			System.out.println("erreur : Il y a déjà une structure sur ce terrain.");
			return;
		}

		if (carte.carte[posA-2][posB-1].getPossession()!=p.getNumber() && carte.carte[posA-1][posB-2].getPossession()!=p.getNumber() && carte.carte[posA][posB-1].getPossession()!= p.getNumber() && carte.carte[posA-1][posB].getPossession()!=p.getNumber()){
			System.out.println("erreur : ce n'est pas un terrain adjacent");
			return;
		}
		carte.carte[posA-1][posB-1].setBuilding(obj);
		carte.carte[posA-1][posB-1].setPossession(p.getNumber());
		run = true;
	}
		

	public void tourJoueur(Player p){
		/*Durant un tour, le joueur peut :
		-construire un nouvel objet energetique
		-améliorer un objet energétique en sa posséssion
		-reparer un objet energétique endommagé si cela est possible pour l'objet energetique en question
		-passer son tour au joueur suivant*/
		Scanner sc =  new Scanner(System.in);
		int x, y, i;
		do {
			System.out.println("Que voulez vous faire ?\n1 - Construire un nouvel objet energetique\n2 - Ameliorer un objet energetique\n3 - Reparer un objet energitique endommage\n4 - Passer son tour");
			i = sc.nextInt();
		}while (i <1 || i >4);
		if (i ==1){
			// on verifie que le joueur a le droit de construire sur la case (il faut que la case soit vide et adjacente à un de ces objets) sinon il redonne une nouvelle position
			do{
				//on demande ce que le joueur veut construire
				do{
					System.out.println("Que voulez vous construire ?\n1 - Mine de charbon\n2 - Centrale Geothermique\n3 - Eolienne\n4 - Barrage\n5 - Usine de petrole\n6 - Centrale nucleaire\n7 - Panneau solaire");
					i = sc.nextInt();
				}while (i<1 || i>7);
				// on demande la coordonne x
				do{
					System.out.println("Sur quel terrain voulez-vous construire ?\n position x :");
					x = sc.nextInt();
				}while (x<1 || x>10);
				//on demande la coordonnee y
				do{
					System.out.println("position y :");
					y = sc.nextInt();
				}while (y<1|| y>10);
				this.build(i, x, y, p);
			}while (carte.carte[x-2][y-1].getPossession()!=p.getNumber() && carte.carte[x-1][y-2].getPossession()!=p.getNumber() && carte.carte[x][y-1].getPossession()!= p.getNumber() && carte.carte[x-1][y].getPossession()!=p.getNumber());
		}
		if (i==2){
			do{
				//le joueur donne la coordonnee x
				do {
				System.out.println("Quel objet energetique voulez vous ameliorer ?\n position x : ");
				x = sc.nextInt();
				}while(x<1 || x>10);
				//le joueur donne la coordonnee y
				do {
					System.out.println("position y : ");
					y = sc.nextInt();
				}while(y<1 || y>10);
				//message d'erreur si le joueur essaye d'acceder à une case qui n'est pas à lui
				if (carte.carte[x-1][y-1].getPossession() != p.getNumber()){
					System.out.println("erreur : interdiction d'acceder a cette case.");
					return;
				}

				carte.carte[x-1][y-1].getEnergyO().upgrade(p);
			}while (carte.carte[x-1][y-1].getPossession() != p.getNumber());
		}
		if (i==3){
			//on verifie que le joueur a le droit de toucher à la case qu'il va rentrer, sinon il redonne une nouvelle position
			do{
				//le joueur donne la coordonnee x
				do {
				System.out.println("Quel objet energetique voulez vous reparer ?\n position x : ");
				x = sc.nextInt();
				}while(x<1 || x>10);
				//le joueur donne la coordonne y
				do {
					System.out.println("position y : ");
					y = sc.nextInt();
				}while(y<1 || y>10);
				//message d'erreur si le joueur essaye d'acceder à une case n'est pas à lui
				if (carte.carte[x-1][y-1].getPossession() != p.getNumber()){
					System.out.println("erreur : interdiction d'accéder à cette case.");
					return;
				}
				this.repair(x,y);
			}while (carte.carte[x-1][y-1].getPossession() != p.getNumber());
		}
		if (i==4){
			System.out.println("Vous avez decidé de passer au tour suivant.");
			return;
		}

	}




}