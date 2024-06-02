package carnet;

public class Adress {
	public String nomRue;
	public int numRue;
	public String ville;
	
	public Adress(String nom,int num,String ville) {
		nomRue=nom;
		numRue=num;
		this.ville=ville;
	}
	public void setNom(String nom) {
		this.nomRue=nom;
	}
    public void setNum(int num) {
    	this.numRue=num;
	}
    public void setVille(String ville) {
		this.ville=ville;
	}
}
