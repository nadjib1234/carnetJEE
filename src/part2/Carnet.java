package part2;

import java.io.Serializable;

public class Carnet implements Serializable {
	private int idCarnet;
	private String nom;
	public Carnet() {
		// TODO Auto-generated constructor stub
	}
	public Carnet(String nom) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
	}
	public int getId() {
		return idCarnet;
	}
	public String getNom() {
		return nom;
	}
	public void setId(int id) {
		this.idCarnet=id;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public String toString() {
		return "Id : "+idCarnet+",lo nom : "+nom ;
	}
}
