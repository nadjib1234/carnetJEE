<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*"
    import="part2.Carnet"
    import="part2.Adress"
    import="part2.CarnetModel"
    import="java.util.ArrayList"
    import="java.util.List"
    import="java.util.HashMap"
    import="java.util.Iterator"
    import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>
     body,html
     {
        background-color: #F1F4FFFF;
     }
      *{
       font-family: cursive;
       font-size: 20px;
       margin: 5px;
    }
    form{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        position: absolute;
        top: 40%;
        left: 50%;
        transform: translate(-50%,-40%);
    }
    input{
        border-radius: 4px;
    }
    input[type='submit']
    {
        background-color: transparent;
        border: solid 2px;
        border-radius: 5px;
        width: 200px;
        margin: 10px;
        background-color: white;
    }
    input[type='submit']:hover{
        border: solid 2px rgb(0, 196, 121);
        color: rgb(0, 196, 121);
    } 
 </style>
</head>
<body>
<%
CarnetModel model=new  CarnetModel();
HashMap<Carnet, ArrayList<Adress>> list=model.getlistCarAdr();
List <Carnet> listCar=model.getlistcar();
for(int i=0; i<listCar.size();i++){
	String nom=listCar.get(i).getNom();
	   out.println("nom Carnet: "+nom);%>
	        <a href="/tp_1/modifierNomCarnet?id=<%= listCar.get(i).getId() %>&i=<%= i %>"> modifier</a>
		    <a href="/tp_1/deleteCarnet?id=<%=  listCar.get(i).getId() %>&i=<%= i %>"> delete</a>
	   <br><% 
	   List<Adress> Listadr=list.get(nom);
	for(int j=0;j<Listadr.size();j++){
		out.println("["+Listadr.get(j).toString()+"]");
		
		%>
		    <a href="/tp_1/modifierAdress?idAdr=<%= Listadr.get(j).getIdAdr() %>&i=<%= i %>"> modifier</a>
		    <a href="/tp_1/deleteAdress?idAdr=<%=  Listadr.get(j).getIdAdr() %>&i=<%= i %>"> delete</a>
		   <br><% 
	}
}
%>
</body>
</html>