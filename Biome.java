public abstract class Biome{
/*un biome a un nom,
un booleen qui indique si une construction est présente sur lui,
une possession qui correspond au numero du joueur qui le possede (initialisé à 0),
la structure energetique qui y est posée (initiallement null)
et d'une caractéristique qui indique quelle structure est la plus efficace sur ce type de terrain*/
	protected String name;
	protected boolean construct;
	protected int possession;
	protected EnergyO building;
	protected String carac;

	public Biome (String name, String carac){
		/*tous les biomes ont un numero qui reste fixe pour toutes les fonctions*/
		this.construct = false; // Lyna : est ce que construct est faux par défaut ?
		this.building = null;
		this.possession = 0;
		this.name = name;
		this.carac = carac;
		/* 1 : Montagne
		2 : Littoral
		3 : Plaine
		4 : Desert*/
	}

	public int getPossession(){/*renvoi le numero du joueur qui possede ce biome*/
		return possession;
	}

	public char getBuilding(){
		/*renvoit un char correspondant a la structure placée sur le biome*/
		char r = '0';
		if (building == null){
			r = 'n';
		}
		if (building instanceof MineDeCharbon){
			r = 'c';
		}
		if (building instanceof CentraleGeothermique){
			r = 'g';
		}
		if (building instanceof Eolienne){
			r = 'e';
		}
		if (building instanceof Barrage){
			r = 'b';
		}
		if (building instanceof UsineDePetrole){
			r = 'p';
		}
		if (building instanceof CentraleNucleaire){
			r = 'u';
		}
		if (building instanceof SolarPanel){
			r = 's';
		}
		return r;
	}

	public char getName(){
	/*renvoit un char correspondant au nom d'un biome*/
		char r = '0';
		if(name == "Montagne"){
			r = 'M';
		}
		if(name == "Littoral"){
			r = 'L';
		}
		if(name == "Plaine"){
			r = 'P';
		}
		if(name == "Desert"){
			r = 'D';
		}
		return r;
	}

	public void setBuilding(int b){
	/*permet de créer une structure sur un point donné de la carte*/
		if(b == 1){
			building = new MineDeCharbon();
		}
		if(b == 2){
			building = new CentraleGeothermique();
		}
		if(b == 3){
			building = new Eolienne();
		}
		if(b == 4){
			building = new Barrage();
		}
		if(b == 5){
			building = new UsineDePetrole();
		}
		if(b == 6){
			building = new CentraleNucleaire();
		}
		if(b == 7){
			building = new SolarPanel();
		}
	}

	public void setPossession(int p){
	/*permet a un joueur d'acquerir le biome en indiquant son numero de joueur*/
		possession = p;
	}

	public String toString(){
	/*renvoit une chaine de caractère qui presente le biome*/
		return "biome de type "+name+" en possession du joueur "+possession+ " contenant un "+ building;
	}

	public EnergyO getEnergyO(){
		return building;
	}

}