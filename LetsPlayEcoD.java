import java.util.Scanner;
public class LetsPlayEcoD{/*le main, utilisé pour lancer une partie*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indiquez le nombre de joueurs (1, 2 ou 4)");/*le jeu peut se jouer à 1, 2 ou 4 joueurs. on indique le nombre de joueurs en debut de partie*/
		int nbJ;
		int inputI;
		String pseudo1;
		String pseudo2;
		String pseudo3;
		String pseudo4;
		Game g;
		boolean endGame = false;
		do{
			nbJ = sc.nextInt();
			if (nbJ != 1 && nbJ != 2 && nbJ != 4){
				System.out.println("Nombre de joueurs invalide : ce jeu se joue a 1, 2 ou 4 joueurs");
			}
		}while (nbJ != 1 && nbJ != 2 && nbJ != 4);
		Map carte = new Map ();

		if (nbJ == 1){/*on cree les entites players dependament de leut nombre total. puis la game est cree*/
			System.out.println("Indiquez votre nom/pseudo");
			pseudo1 = sc.nextLine();
			pseudo1 = sc.nextLine();
			Player p1 = new Player (pseudo1, 1);
			g = new Game(p1, carte);
		}else{
			if (nbJ == 2){
				System.out.println("Indiquez le nom/pseudo du joueur 1");
				pseudo1 = sc.nextLine();
				pseudo1 = sc.nextLine();
				System.out.println("Indiquez le nom/pseudo du joueur 2");
				pseudo2 = sc.nextLine();
				Player p1 = new Player (pseudo1, 1);
				Player p2 = new Player (pseudo2, 2);
				g = new Game(p1, p2, carte);
			}else{
				System.out.println("Indiquez le nom/pseudo du joueur 1");
				pseudo1 = sc.nextLine();
				pseudo1 = sc.nextLine();
				System.out.println("Indiquez le nom/pseudo du joueur 2");
				pseudo2 = sc.nextLine();
				System.out.println("Indiquez le nom/pseudo du joueur 3");
				pseudo3 = sc.nextLine();
				System.out.println("Indiquez le nom/pseudo du joueur 4");
				pseudo4 = sc.nextLine();
				Player p1 = new Player (pseudo1, 1);
				Player p2 = new Player (pseudo2, 2);
				Player p3 = new Player (pseudo3, 3);
				Player p4 = new Player (pseudo4, 4);
				g = new Game(p1, p2, p3, p4, carte);
			}
		}
		g.start();/*la partie commence avec un biome et une structure energetique par joueur*/
		g.gameStatus();/*donne le temps de jeu et affiche la carte*/
		carte.countBiomes();/*donne le nombre de biomes en jeu*/
		g.rules();/*affiche la presentation du jeu ainsi que ses regles*/
		do{
			System.out.println("un nouveau mois va commencer, souhaitez vous continuer à jouer? Tapez 1 pour oui et 0 pour non");/*a chaque tour on a la possibilité de mettre
			fin a la partie. un tour se decompose en autant de tour de joueurs qu'il y a de joueurs dans la partie*/
			inputI = sc.nextInt();
			if (inputI == 1){
				g.gameStatus();/*au debut d'un tour on effectue un affichage de la carte, de la date et on lance un seisme qui peut casser les structures*/
				g.seisme();
				for (int tourJ = 0; tourJ < g.getPlayers().size(); tourJ ++){/*chaque joueur joue son tour*/
					
					g.getCarte().afficherCarte();/*on affiche la carte a chaque tour de joueur*/
					System.out.println(g.getPlayers().get(tourJ).toString());/*on annonce quel joueur joue son tour et on donne ses points et son taux de pollution*/
					g.rappelStruct();
					g.tourJoueur(g.getPlayers().get(tourJ));/*le tour du joueur commence*/
				}
				g.endTurn();/*mecanisme de fin de tour : on ajoute les gains de chaque joueur ainsi que le taux de pollution*/
				endGame = g.check();/*verification de chaque joueur pour verifier si il est toujours en jeu ou alors si il a gagné ou perdu*/
				g.setTimeMonth();/*incrementation du temps de jeu*/
			}else{
				endGame = true;
				System.out.println("Vous avez mis fin à la partie");/*si on choisit de mettre fin à la partie, le jeuse termine et les crédits se lancent*/
			}
		}while (endGame == false);/*le jeu s'arrête quand un gagnant est déclaré*/
		System.out.println("Merci d'avoir joué à notre jeu! Developpé par :"+'\n'+"KSNATKIN Philippe"+'\n'+"SAOUCHA Lyna"+'\n'+"ps : pensez à trier vous dechets!");/*credits du jeu*/
	}
}