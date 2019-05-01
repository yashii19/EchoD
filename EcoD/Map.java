public class Map{
/*la carte du jeu est un tableau de biomes en 10*10*/
	public Biome [][] carte;

	public Map(){
	/*la carte est générée au debut de la partie de manière aléatoire, en affectant un biome à chaque case*/
		carte = new Biome[10][10];
		double rand;
		for(int i = 0; i < 10; i++){
			for (int j =0; j < 10; j++){
				rand = (int)(Math.random()*4+1);
				if (rand == 1){
					carte[i][j] = new Montagne();
				}
				if (rand == 2){
					carte[i][j] = new Littoral();
				}
				if (rand == 3){
					carte[i][j] = new Plaine();
				}
				if (rand == 4){
					carte[i][j] = new Desert();
				}
			}
		}
	}

	public void afficherCarte(){
	/*affiche la carte sur le terminal. l affichage se fait avec un tuple de 3 char :
	une lettre majuscule indiquant le biome, un chiffre	indiquant a quel joueur appartient le biome
	et une lettre minuscule qui indique la structure qui y est placée */
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
					System.out.print(""+carte[i][j].getName()+carte[i][j].getPossession()+carte[i][j].getBuilding()+'\t');
			}
			System.out.print('\n');
			System.out.print('\n');
		}
	}

	public void countBiomes(){
	/*rend le compte du nombre de biomes generées de la carte*/
		int m = 0, l = 0, p =0, d = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(carte[i][j] instanceof Montagne){
					m++;
				}
				if(carte[i][j] instanceof Littoral){
					l++;
				}
				if(carte[i][j] instanceof Plaine){
					p++;
				}
				if(carte[i][j] instanceof Desert){
					d++;
				}
			}
		}
		System.out.print("La carte est composée de "+m+" biomes montagnes, "+l+" biomes littauraux, "+p+" biomes plaines et "+d+" biomes deserts"+'\n');
	}
}