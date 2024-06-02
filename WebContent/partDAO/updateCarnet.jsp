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
    import="java.util.Map"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<%
CarnetModel model=new  CarnetModel();
String j=(String)request.getParameter("id");
HashMap<Carnet, ArrayList<Adress>> list=model.getlistCarAdr();
List <Carnet> listCar=model.getlistcar();
for(int i=0; i<listCar.size();i++){
	  if(listCar.get(i).getId()==Integer.parseInt(j)){
		  out.println("nom Carnet: "+listCar.get(i).getNom());
		  break;
		  }%>
	    <br><% }%>
	<body>
<form action="modifierNomCarnet" method="post">
           <label>Nom Carnet</label>
           <input type="text" name="nom">
           <input type="text" name="id" value="<%=j%>" hidden="true">
           <input type="submit" value="modifier" name="b1" />
        </form>
</body>
</html>