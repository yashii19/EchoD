import java.util.ArrayList;
import java.util.Scanner;
public class Game{/*3 constructeurs différents pour des parties à 1, 2 ou 4 joueurs. le temps en mois et en année est initialisée à 0*/
	private ArrayList <Player> players;
	private Map carte;
	private int month;
	private int years;
	private boolean run = false;
	public final int COSTS = 200000;
	public final int COSTU = 100000;
	public final int COSTB = 80000;
	public final int COSTE = 75000;
	public final int COSTP = 70000;
	public final int COSTG = 40000;
	public final int COSTC = 30000;

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

	public void start(){/*Debut de la partie avec positionnement de base des joueurs : le positionnement varie en fonction du nombre de joueurs dans la partie. chaque joueur
	commence avec un biome et un objet energetique sur son biome qui correspond a l objet optimal*/
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
		System.out.println("Il reste "+carte.carte[0][0].libres+" biomes disponibles");
	}

	public void seisme(){/*un seisme arrive a chaque debut de tour de manière aléatoire et frappe aléatoirement une case du tableau de jeu. Si une structure y est présente,
	elle est détruite avec toutes les consequences que cela implique (augmentation du niveau de pollution dans certaints cas)*/ 
		if((int)(Math.random()*101)< 101){/*ici le seisme arrivera forcement car le if est toujours satisfait. ce choix est pour des parties rapides; pour des partie plus longue
			il est possible de diminuer cette probabilité en modifiant le < 101*/
			System.out.println("Un seisme a lieu!");
			int b = (int)(Math.random()*10);
			int c = (int)(Math.random()*10);
			if(carte.carte[b][c].building != null){
				System.out.println("Le joueur "+carte.carte[b][c].possession+" a été touché! ("+players.get(carte.carte[b][c].possession-1).getPseudo()+")");
				System.out.println("La zone afféctée est "+carte.carte[b][c].toString()+"(position "+(b+1)+" "+(c+1)+")");
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

	public void build(int obj, int posA, int posB, Player p){
		/*construit un objet sur une case choisie à condition que ce soir une case adjacente au joueur 
		et que cette dernière n'est pas déja occupée*/
		if(carte.carte[posA-1][posB-1].building != null){
			System.out.println("erreur : Il y a déjà une structure sur ce terrain.");
			return;
		}

		if (carte.carte[posA-2][posB-1].getPossession()!=p.getNumber() && carte.carte[posA-1][posB-2].getPossession()!=p.getNumber() && carte.carte[posA][posB-1].getPossession()!= p.getNumber() && carte.carte[posA-1][posB].getPossession()!=p.getNumber()){
			System.out.println("erreur : ce n'est pas un terrain adjacent");
			return;
		}
		if (obj == 1) {
			if (p.getPoints()<COSTC) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		
		if (obj == 2) {
			if (p.getPoints()<COSTG) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		if (obj == 3) {
			if (p.getPoints()<COSTE) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		if (obj == 4) {
			if (p.getPoints()<COSTB) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		if (obj == 5) {
			if (p.getPoints()<COSTP) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		if (obj == 6) {
			if (p.getPoints()<COSTU) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		if (obj == 7) {
			if (p.getPoints()<COSTS) {
				System.out.println("erreur : vous n'avez pas assez de points pour acheter cela");
				return;
			}
		}
		carte.carte[posA-1][posB-1].setBuilding(obj);
		carte.carte[posA-1][posB-1].setPossession(p.getNumber());
		if (obj == 1) {
			p.setPoints(-COSTC);
		}
		if (obj == 2) {
			p.setPoints(-COSTG);
		}
		if (obj == 3) {
			p.setPoints(-COSTE);
		}
		if (obj == 4) {
			p.setPoints(-COSTB);
		}
		if (obj == 5) {
			p.setPoints(-COSTP);
		}
		if (obj == 6) {
			p.setPoints(-COSTU);
		}
		if (obj == 7) {
			p.setPoints(-COSTS);
		}
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

	public Map getCarte(){/*renvoi la carte du jeu*/
		return carte;
	}

	public ArrayList <Player> getPlayers(){/*renvoi la liste de joueurs*/
		return players;
	}

	public void endTurn(){/*cette methode est appellee a chaque fin de tour. elle permet de donner a chaque joueur ses gains et d'augmenter si besoin le niveau de pollution*/
		int gainsPts;
		double gainsPol;
		for(int i = 0; i<players.size(); i++){
			gainsPol = 0.;
			gainsPts = 0;
			for(int j = 0; j<10; j++){
				for (int k = 0; k<10; k++){
					if(carte.carte[j][k].getPossession() == players.get(i).getNumber()){
						gainsPol += carte.carte[j][k].getEnergyO().getPollutionMonth();
						if (carte.carte[j][k].getCarac() == carte.carte[j][k].getEnergyO().getNom()) {
							gainsPts += ((carte.carte[j][k].getEnergyO().getPointMonth())*1.2);
						}else{
							gainsPts += carte.carte[j][k].getEnergyO().getPointMonth();
						}
					}
				}

			}
			players.get(i).setPoints(gainsPts);
			players.get(i).setPollutionMeter(gainsPol);
		}
	}

	public boolean check(){
	/*on verfifie l etat de tous les joueurs :
	on commence par verifier que des joueurs sont toujours en jeu, si tout le monde a perdu le jeu s arrete*/
		boolean win = false;
		if (players.size() == 0) {
			win = true;
			return win;
		}
		for(int i = 0; i<players.size(); i++){/*on regarde le taux de pollution de chaque joueur. si celui ci atteint les 100%, il a perdu. il n'est alors plus parcouru deans la liste*/
			if(players.get(i).getStatus()){
				if(players.get(i).getPollutionMeter() == 100.){
					System.out.println("Le joueur "+(i+1)+" a perdu! Son taux de pollution a atteint les 100%! Pas très ecologique tout ça :(");
					players.get(i).setStatus();
				}

			}
		}
		for(int j = 0; j<players.size(); j++){/*on verifie la condition de victoire pour tous les joueurs. si un joueurs atteint les 1 million de points la partie est gagnée et est arretée*/
			if(players.get(j).getStatus()){
				if(players.get(j).getPoints() >= 1000000){
					System.out.println("Nous avons un vaiqueur! Le joueur "+(j+1)+" ("+players.get(j).getPseudo()+") a atteint les 1 millions de points! Vous êtes vraiment ecolo :)");
					win = true;
				}

			}
		}
		return win;
	}

	public void setTimeMonth(){/*gere le temps de jeu*/
		month ++;
		if (month == 12){
			month = 0;
			years++;
		}
	}

	public void rappelStruct(){/*rappel sur les caractéristiques des structures*/
		System.out.println("Rappel sur les structures :");
		System.out.println("Les mines de charbon coutent 30k pts, generent 15k pts par mois, ont un taux de pollution de 5% par mois, leur cout de reparation est de 30k pts, ont des degats sur la pollution en cas de panne de 20% et leur cout d amelioration est de 25k");
		System.out.println("Les centrales geothermiques coutent 40k pts, generent 15k pts par mois, ont un taux de pollution de 0% par mois, leur cout de reparation est de 30k pts, ont des degats sur la pollution en cas de panne de 0% et leur cout d amelioration est de 30k");
		System.out.println("Les usines de petrol coutent 70k pts, generent 40k pts par mois, ont un taux de pollution de 5% par mois, leur cout de reparation est de 60k pts, ont des degats sur la pollution en cas de panne de 20% et leur cout d amelioration est de 60k");
		System.out.println("Les eoliennes coutent 75k pts, generent 40k pts par mois, ont un taux de pollution de 0% par mois, leur cout de reparation est de 60k pts, ont des degats sur la pollution en cas de panne de 0% et leur cout d amelioration est de 65k");
		System.out.println("Les barrages coutent 80k pts, generent 45k pts par mois, ont un taux de pollution de 0% par mois, leur cout de reparation est de 65k pts, ont des degats sur la pollution en cas de panne de 0% et leur cout d amelioration est de 70k");
		System.out.println("Les centrales nucleaires coutent 100000k pts, generent 50k pts par mois, ont un taux de pollution de 5% par mois, ne peuvent pas etres reparees, ont des degats sur la pollution en cas de panne de 95% et leur cout d amelioration est de 75k");
		System.out.println("Les panneaux solaires coutent 200k pts, generent 50000k pts par mois, ont un taux de pollution de 0% par mois, sont indestructibles et leur cout d amelioration est de 100k");
	}

	public void rules(){/*evoque les regles du jeu */
		System.out.println("");
		System.out.println("Rappel sur les regles du jeu:");
		System.out.println("Ceci est un jeu se jouant sur une carte sur laquelle vous devez construire des structures pour vous developper energetiquement et polluer le moins possible");
		System.out.println("L affichage de la carte se fait via une suite de caracteres");
		System.out.println("En majuscule est indiqué le type de biome de la case");
		System.out.println("Le chiffre correspond au numero de joueur qui possede ce biome, si il est a 0 personne n en est le propriétaire");
		System.out.println("Et enfin la lettre minuscule indique quelle structure energetique y est placée, si elle vaut n, c'est que rien n'est encore construit");
		System.out.println("Chaque joueur commence avec un biome et une structure");
		System.out.println("Les structures generent de points a chaque mois");
		System.out.println("Cependant attention : certaines generent egalement de la pollution");
		System.out.println("Si votre jauge de pollution atteint 100%, vous avez perdu");
		System.out.println("Le premier joueur a avoir atteint 1 million de points gagne la partie et arrete le jeu");
		System.out.println("Les joueurs jouent chaqun leur tour");
		System.out.println("Chaque joueur est limité à une action par tour");
		System.out.println("A chaque debut de tour est affiché le statut de chaque joueur pour permettre un suivi de vos poiints et de votre jauge de pollution");
		System.out.println("Seront egalement affiché les differentes caracteristiques des structures achetables");
		System.out.println("ATTENTION à ne pas faire d'erreur en selectionnant vos actions");
		System.out.println("La moindre erreur et vous serez penalisé : votre tour sera terminé de force");
		System.out.println("Vous aurez une liste d'action possibles à effectuer à chaque tour");
		System.out.println("Vous pouvez construire une nouvelle structure energetique");
		System.out.println("Ces structures peuvent etre construite qu'a proximité d'une structure alliée");
		System.out.println("Evidemment il est impossible de construire sur une case deja occupée par une structure");
		System.out.println("Sachez cependant que vos structures peuvent etre détruites par des catastrophes naturelles (ici un seisme)");
		System.out.println("Certaines structures augmentent grandement le taux de pollution lorsqu elle sont detruites");
		System.out.println("Les structures detruites ne generent plus de points mais continuent de polluer");
		System.out.println("Vous pouvez reparer les structures mais cela vous coutera des points");
		System.out.println("Vous pouvez egalement ameliorer vos structures");
		System.out.println("Enfin si vous le souhaitez, vous pouvez passer votre tour");
		System.out.println("Le jeu presente en tout 7 structures");
		System.out.println("Les 2 structures de base sont la mine de charbon et la centrale geothermique");
		System.out.println("Elles sont peu couteuses et sont disponibles à l achat des le debut de partie");
		System.out.println("Il y a 3 structures intermediaires : le barrage, l eolienne et l usine de petrol ");
		System.out.println("Ces structures se demarquent par le fait qu'elle sont plus efficaces sur certaints types de biomes");
		System.out.println("Faites donc attention a votre positionnement!");
		System.out.println("Enfin il y a 2 structures superieures :");
		System.out.println("La centrale nucleaire est la moins couteuse, est tres efficace mais est tres dangeureuse de par ses degats sur la pollution de 95% en cas de seisme");
		System.out.println("Le panneau solaire lui est le plus cher, mais ne pollue pas et surtout est indestructible quoi qu'il arrive");
		System.out.println("Experimentez vos stratégies, adaptez vous et atteignez le million le plus rapidement possible");
		System.out.println("Bon jeu et amusez vous bien");
		System.out.println("");
	}
}