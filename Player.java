import java.util.ArrayList;
public class Player{
/*le joueur posséde un pseudonyme,
un numero de joueur,
un nombre de points des le debut du jeu,
un niveau de pollution,
un statut qui indique si le joueur est éliminé ou non,
et une liste de la totalité des objets energetiques de ce dernier*/
	private String pseudo;
	private int number;
	private int points;
	private double pollutionMeter;
	private boolean status;
	private ArrayList <EnergyO> hdv;

	public Player(String pseudo, int number){
		this.pseudo = pseudo;
		this.number = number;
		points = 100000;
		pollutionMeter = 0.0;
		status = true;
		hdv = new ArrayList <EnergyO> ();
		System.out.println("Joueur numéro "+number+" : "+pseudo);
	}
	public void depense(int d){
	/*depense les points du joueur*/
			points -= d;
	}

	public int getNumber(){
		return number;
	}

	public int getPoints(){
	/*donne les points actuels du joueur*/
		return points;
	}

	public void setPoints(int p){
	/*effectue une addition sur les points du joueur*/
		points += p;
	}

	public String getPseudo(){
	/*renvoit le pseudo choisi par le joueur*/
		return pseudo;
	}

	public void setPollutionMeter(double d){
	/*effectue une addition sur le niveau de pollution du joueur*/
		pollutionMeter += d;
	}

	public double getPollutionMeter(){
	/*renvoit le niveau de pollution actuel du joueur (en %)*/
		return pollutionMeter;
	}

	public String toString(){
		return "A vous de jouer, joueur "+number+"\nVous avez actuellement "+points+" points et votre taux de polution est de "+pollutionMeter+" %";
	}


}
