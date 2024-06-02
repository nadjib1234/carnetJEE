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
String j=(String)request.getParameter("idAdr");
HashMap<Carnet, ArrayList<Adress>> list=model.getlistCarAdr();
List <Adress> listAdr=model.getlistAdr();
for(int i=0; i<listAdr.size();i++){
	  if(listAdr.get(i).getIdAdr()==Integer.parseInt(j)){
		  out.println("l'adresse: "+listAdr.get(i).toString());
		  break;
		  }%>

	 <br><% }%>
	
<body>

<form action="modifierAdress" method="post">
           <label>la ville</label>
           <input type="text" name="ville">  
           <label>le nom de Rue</label>          
           <input type="text" name="rue"> 
           <label>le numero de Rue</label>  
           <input type="number" name="num">
           <input type="text" name="id" value="<%=j%>" hidden="true">
           <input type="submit" value="modifier" name="b1" />
           
        </form>
</body>
</html>