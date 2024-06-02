package part2;

import java.util.HashMap;
import java.util.List;

public interface ICarnetAdrsseDAO {
	public Carnet save(Carnet c,Adress adr);
	public List<Carnet> listCarnet();
	public List<Adress> listAdresse();
	public HashMap listAdresseParCarnet();
	public void modifierCarnet(int id,String nom);
	public void modifierAdress(int id,String ville,String rue,int num);
	public void suprimerC(int id);
	public void suprimerAdr(int id);
}
