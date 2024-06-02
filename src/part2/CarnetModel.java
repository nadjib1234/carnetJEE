package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarnetModel {
	private static List <Adress> listAdr;
	private static List <Carnet> listCar;
	private static HashMap<Carnet, ArrayList<Adress>> list;
	public void list(List <Adress> listAdr,List <Carnet> listCar,HashMap<Carnet, ArrayList<Adress>> list) {
		// TODO Auto-generated constructor stub
		this.listAdr=listAdr;
		this.listCar=listCar;
		this.list=list;
	}
	public List <Adress> getlistAdr(){
		return listAdr;
	}
	public List <Carnet> getlistcar(){
		return listCar;
	}
	public HashMap <Carnet, ArrayList<Adress>>getlistCarAdr(){
		return list;
	}
	
}
