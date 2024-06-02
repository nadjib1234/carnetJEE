package carnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Carnet {
	String nom;
	public static  HashMap<String,ArrayList> liste= new HashMap<String,ArrayList>();
    ArrayList<Adress> adresses=new ArrayList<Adress>();
    
	public Carnet(String nom,String nomRue,int numRue,String ville) {	
		this.nom=nom;
        adresses.add(new Adress(nomRue,numRue,ville));
		liste.put(nom,adresses);
	}
	public static void addAdresse(String nom,String nomRue,int numRue,String ville) {
		if(liste.get(nom)!=null)
		{
			ArrayList<Adress> adr=liste.get(nom);
			adr.add(new Adress(nomRue,numRue,ville));
		}
		else
		{
			new Carnet(nom,nomRue,numRue,ville);
		}
	}
	public static void deleteAdresse(String nom,int i) {
		ArrayList<Adress> adr=liste.get(nom);
		System.out.println(i);
		adr.remove(i);
	}
	public static void modifier(String nom,String nomRue,int numRue,String ville,int i) {
		ArrayList<Adress> adr=liste.get(nom);
		Adress adresse=adr.get(i);
		if(adresse!=null) {
		if(nomRue!="") {
			adresse.setNom(nomRue);
		}
		if(numRue!=0) {
			adresse.setNum(numRue);
		}
		if(ville!="") {
			adresse.setVille(ville);
		}
		}
	}
	Adress getAdresse(String nom,String nomRue,int numRue,String ville) {
		//adresses.add(new Adress(nomRue,numRue));
		ArrayList<Adress> adr=liste.get(nom);
		int i;
		for(i=0; i<adr.size();i++)
		{
			Adress adresse=adr.get(i);
			if(adresse.nomRue==nomRue && adresse.numRue==numRue)break;
			
		}
		if(i<adresses.size())return adresses.get(i);
		return null;
	}
	public static void listCarnet() {
		Iterator it = liste.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            System.out.println("nom : "+m.getKey());
            ArrayList<Adress> adr =(ArrayList<Adress>) m.getValue();
            int i;
    		for(i=0; i<adr.size();i++)
    		{
    			Adress adresse=adr.get(i);
    			System.out.println("la ville "+adresse.ville+" ,le nom de rue "+adresse.nomRue+" ,le num de rue "+adresse.numRue);
    			
    		}
    		System.out.println("________________________________");
        }
        
	}
        
}
