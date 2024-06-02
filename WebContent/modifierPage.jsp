<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="carnet.Carnet"
    import="carnet.Adress"
    import="java.util.ArrayList"
    import="java.util.HashMap"
    import="java.util.Iterator"
    import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>modifier l'adresse suivant</h3>
<%
String p=(String)request.getParameter("i");
int i=Integer.parseInt(p);
String nom =(String)request.getParameter("nom");
ArrayList<Adress> list = Carnet.liste.get(nom);
Adress adresse=(Adress)list.get(i);
%>
<p>
<% out.println("Le nom de l'utilisatuer de carnet :" +nom);%>
<br>
<%

out.println("la ville :" +adresse.ville+ " ,le nom de rue :" +adresse.nomRue+ " ,le num de rue :" +adresse.numRue +"    ");
%>
</p>


<form action="modifier" method="post">
           <label>la ville</label>
           <input type="text" name="ville">  
           <label>le nom de Rue</label>          
           <input type="text" name="nomRue"> 
           <label>le numero de Rue</label>  
           <input type="number" name="numRue">
           <input type="text" name="nom" value="<%=nom%>" hidden="true">
           <input type="text" name="i" value="<%=i%>" hidden="true">
           <input type="submit" value="modifier" name="b1" />
           
        </form>
</body>
</html>