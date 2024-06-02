package part2;

import java.io.Serializable;

public class Adress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAdresse;
	private int idCarnet;
	private String ville;
	private String rue;
	private int num;
	public Adress() {
		// TODO Auto-generated constructor stub
	}
	public Adress(String ville,String rue ,int num) {
		// TODO Auto-generated constructor stub
		this.ville=ville;
		this.num=num;
		this.rue=rue;
	}
	public int getIdAdr() {
		return idAdresse;
	}
	public int getIdCar() {
		return idCarnet;
	}
	public int getNum() {
		return num;
	}
	public String getVille() {
		return ville;
	}
	public String getRue() {
		return rue;
	}
	public void setId(int id) {
		this.idAdresse=id;
	}
	public void setVille(String v) {
		this.ville=v;
	}
	public void setRue(String rue) {
		this.rue=rue;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public void setIdC(int id) {
		this.idCarnet=id;
	}
	public String toString() {
		return "Id : "+idAdresse+",la ville : "+ville+", la rue :"+rue+", le numero :"+num ;
	}
}