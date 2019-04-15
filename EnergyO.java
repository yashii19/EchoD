public abstract class EnergyO{
/*un objet energetique est composé d'un cout d achat,
une production de points par mois,
une augmentation du taux de pollution pour le joueur chaque mois,
un cout de reparation,
un statut indiquant si l'objet est en etat de marche ou non,
des degats qui augmentent grandement le taux de pollution en cas de destruction de l objet par un seisme,
un cout d amélioration,
un statut indiquant si l objet est amélioré ou non et enfin d'un nom */
	protected int cost;
	protected int pointMonth;
	protected double pollutionMonth;
	protected int repareCost;
	protected boolean status;
	protected double damage;
	protected int upgradeCost;
	protected boolean upgradeStatus;
	protected String name;

	public EnergyO(int cost, int pointMonth, double pollutionMonth, int repareCost, double damage, int upgradeCost, String name){
	/*les valeurs sont initialisée dans les différentes classes filles*/
		this.upgradeStatus = false;
		this.status = true; 
		this.cost = cost;
		this.pointMonth = pointMonth;
		this.repareCost = repareCost;
		this.damage = damage;
		this.name = name;

		/*
		1 : Mine de Charbon
		2 : Centrale géothermique
		3: Eolienne
		4 : Barrage
		5 : Usine de pétrole
		6 : Centrale nucléaire
		7 : Panneau solaire*/
	}

	public void upgrade(Player p){
	/*ameliore un objet au detriment de points du joueur, un objet ne peut etre amélioré qu'une seule fois*/
		if (upgradeStatus == true){
			System.out.println("erreur : votre objet est déja amélioré ; chaque objet dispose d'une seule amélioration");
			return;
		}
		else{
			if (p.getPoints() < upgradeCost){
				System.out.println("erreur : votre nombre de points actuel ne vous permet pas d'améliorer votre objet");
				return;
			}
			else{
				p.depense(upgradeCost);
				upgradeStatus = true;
				pollutionMonth = (pollutionMonth*75)/100;
				pointMonth += (pointMonth*50)/100;
				System.out.println("votre objet a ete ameliore avec succes");
			}
		}
	}

	public String toString(){
	/*renvoi une chaine de caractère indiquant le nom de l'objet en question*/
		return ("objet energetique de type "+name);
	}

	public void casse(){
	/*casse un objet*/
			status = false;
	}

	public void reparation(){
	/*repare un objet*/
			status = true;
	}

	public boolean getStatus(){
	/*renvoi le statut d'un objet (actif ou inactif)*/
		return status;
	}

	public double damage(){
	/* inflige les degats à la pollution en cas de destruction de l objet*/
		return damage;
	}

	public int getCost(){
		return cost;
	}

	public int getRepareCost(){
	/*renvoi le cout de reparation de l 'objet*/
		return repareCost;
	}

	public int getPointMonth(){
		return pointMonth;
	}
}

/*		do {
			system.out.println ("erreur : le type entré est non valide, veuillez recommencer");
		} while (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7)
		if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7){

		}*/