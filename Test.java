
public class Test{
	public static void main(String[] args) {
		Player p = new Player("Lyna", 1);
		Map m = new Map ();
		Game g = new Game(p, m);

		g.start();
		g.gameStatus();
		g.tourJoueur(p);
		System.out.println()
		m.afficherCarte();
	}
}