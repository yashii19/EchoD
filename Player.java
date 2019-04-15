public class Player{/*le joueur posséde un pseudonyme, un numero de joueur, un nombre de points des le debut du jeu, un niveau de pollution initialisé à 0 et
un statut qui indique si le joueur est éliminé ou non*/
	private String pseudo;
	private int number;
	private int points;
	private double pollutionMeter;
	private boolean status;

	public Player(String pseudo, int number){
		this.pseudo = pseudo;
		this.number = number;
		points = 50000;
		pollutionMeter = 0.;
		status = true;
	}

	public void depense(int d){/*depense les points du joueur*/
		points -= d;
	}

	public int getPoints(){/*donne les points actuels du joueur*/
		return points;
	}

	public void setPoints(int p){/*effectue une addation sur les points du joueur*/
		points += p;
	}

	public String getPseudo(){/*renvoi le pseudo choisi par le joueur*/
		return pseudo;
	}

	public void setPollutionMeter(double d){/*effectue une addition sur le niveau de pollution du joueur*/
		pollutionMeter += d;
		if (pollutionMeter > 100.){
			pollutionMeter = 100.;
		}
	}

	public double getPollutionMeter(){/*renvoi le niveau de pollution actuel du joueur (en %)*/
		return pollutionMeter;
	}

	public String toString(){/*affiche l etat actuel d'un joueur*/
		return "A vous de jouer joueur "+number+'\n'+"vous avez actuellement "+points+" points et votre taux de pollution est de "+pollutionMeter+" %";
	}

	public int getNumber(){/*renvoi le numero du joueur*/
		return number;
	}

	public boolean getStatus(){/*renvoi l'etat du joueur (si il est disqualifié on renvoi false*/
		return status;
	}

	public void setStatus(){/*fait perdre un joueur, action irreversible, la sentence est irrevocable*/
		status = false;
	}
}