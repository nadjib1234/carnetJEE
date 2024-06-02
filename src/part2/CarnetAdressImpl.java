package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarnetAdressImpl implements ICarnetAdrsseDAO{
	Connection con = (Connection) DB.con();
	@Override
	public Carnet save(Carnet c,Adress adr) {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			PreparedStatement ps4=con.prepareStatement ("SELECT idCarnet FROM carnet WHERE nom LIKE ?");
			ps4.setNString(1, c.getNom());
			ResultSet rs2=ps4.executeQuery();
			if(rs2.next()) {
				int a=rs2.getInt("idCarnet");
				c.setId(a);
				//System.out.println(a);
			}
			else{
			PreparedStatement ps=con.prepareStatement ("INSERT INTO carnet (nom) VALUES (?)");
			ps.setNString(1, c.getNom());
			ps.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement ("SELECT MAX(idCarnet)as max_ID FROM carnet");
			ResultSet rs=ps2.executeQuery();
			 
			if(rs.next()) {
				int b=rs.getInt("max_ID");
				c.setId(b);
				//System.out.println(b);
			}
			ps.close();
			ps2.close();
			}
			ps4.close();
			adr.setIdC(c.getId());
			PreparedStatement ps3=con.prepareStatement ("INSERT INTO adresse (idCarnet,ville,rue,num) VALUES (?,?,?,?)");
			ps3.setInt(1, adr.getIdCar());
			ps3.setString(2, adr.getVille());
			ps3.setString(3, adr.getRue());
			ps3.setInt(4, adr.getNum());
			ps3.executeUpdate();
			ps3.close();
			
			PreparedStatement ps2=con.prepareStatement ("SELECT MAX(idAdresse)as max_ID FROM adresse");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
			int h=rs.getInt("max_ID");
				adr.setId(h);
				System.out.println(h);
			}
			ps2.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<Carnet> listCarnet() {
		Connection con=(Connection) DB.con();
		PreparedStatement ps;
		List <Carnet> list =new ArrayList<Carnet>();
		try {
			ps = con.prepareStatement ("SELECT * FROM carnet");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String n=rs.getString("nom");
				Carnet c=new Carnet(n);
				int i=rs.getInt("idCarnet");
				c.setId(i);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public List<Adress> listAdresse() {
		// TODO Auto-generated method stub
		Connection con=(Connection) DB.con();
		PreparedStatement ps;
		List <Adress> list =new ArrayList<Adress>();
		try {
			ps = con.prepareStatement ("SELECT * FROM adresse");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String v=rs.getString("ville"),r=rs.getString("rue");
				int n=rs.getInt("num"),C=rs.getInt("idCarnet"),Ad=rs.getInt("idAdresse");
				Adress c=new Adress(v,r,n);
				c.setIdC(C);
		    	c.setId(Ad);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public HashMap listAdresseParCarnet() {
		List <Adress> listadr=listAdresse();
		List <Carnet> listCar=listCarnet();
		HashMap<String, ArrayList<Adress>> list=new HashMap<String, ArrayList<Adress>>();
		for(int i=0;i<listCar.size();i++) {
			Carnet c=listCar.get(i);
			ArrayList<Adress> array=new ArrayList<Adress>();
			for(int j=0;j<listadr.size();j++) {
				Adress a=listadr.get(j);
				if(c.getId()==a.getIdCar()) array.add(a);
			}
			list.put(c.getNom(), array);
		}
		return list;
	}
    public void modifierCarnet(int id,String nom) {
    	PreparedStatement ps;
		try {
			PreparedStatement ps4=con.prepareStatement ("SELECT idCarnet FROM carnet WHERE nom LIKE ?");
			ps4.setNString(1, nom);
			ResultSet rs2=ps4.executeQuery();
			if(!rs2.next()) {	
			ps = con.prepareStatement ("update carnet set nom=? where idCarnet=?");
			ps.setString(1,nom);
			ps.setInt(2,id);
			ps.executeUpdate();
			ps.close();
			}
			ps4.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
public void modifierAdress(int id,String ville,String rue,int num) {
	PreparedStatement ps;
	try {
		ps = con.prepareStatement ("update adresse set ville=? , rue =? , num = ? where idAdresse=?");
		ps.setString(1,ville);
		ps.setString(2,rue);
		ps.setInt(3,num);
		ps.setInt(4,id);
		ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

public void suprimerC(int id) {
	PreparedStatement ps;
	PreparedStatement ps2;
	try {
		ps = con.prepareStatement ("DELETE FROM adresse WHERE idCarnet=?");
		ps.setInt(1,id);
		ps.executeUpdate();
		ps.close();
		ps2 = con.prepareStatement ("DELETE FROM carnet WHERE idCarnet=?");
		ps2.setInt(1,id);
		ps2.executeUpdate();
		ps2.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void suprimerAdr(int id) {
	PreparedStatement ps;
	try {
		ps = con.prepareStatement ("DELETE FROM adresse WHERE idAdresse=?");
		ps.setInt(1,id);
		ps.executeUpdate();
		ps.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
