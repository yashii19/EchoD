public class LetsPlay{/*le main, utilisé actuellement pour vérifier que toutes les fonctions marchent*/
	public static void main(String[] args) {
		Map carte = new Map ();		
		Player p1 = new Player ("Philippe", 1);
		Player p2 = new Player ("Jonathan", 2);
		Player p3 = new Player ("Olivier", 3);
		Player p4 = new Player ("Thomas", 4);
		Game g = new Game (p1, p2, p3, p4, carte);
		g.start();
		g.gameStatus();
		carte.countBiomes();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.seisme();
		g.repair(5,5);
		g.repair(15,15);
		g.repair(5,15);
		g.repair(15,5);

	}
}