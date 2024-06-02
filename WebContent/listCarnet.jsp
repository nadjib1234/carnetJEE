
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="carnet.Carnet"
    import="carnet.Adress"
    import="java.util.ArrayList"
    import="java.util.HashMap"
    import="java.util.Iterator"
    import="java.util.Map"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HashMap list=Carnet.liste;
Iterator it = list.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry m = (Map.Entry) it.next();
   out.println("nom : "+m.getKey());%>
   <br><% 
    ArrayList<Adress> adr =(ArrayList<Adress>) m.getValue();
    int i;
	for(i=0; i<adr.size();i++)
	{
		Adress adresse=adr.get(i);
		out.println("la ville :" +adresse.ville+ " ,le nom de rue :" +adresse.nomRue+ " ,le num de rue :" +adresse.numRue +"    ");
		%>
		    <a href="/tp_1/modifierPage.jsp?nom=<%= m.getKey() %>&i=<%= i %>"> modifier</a>
		    <a href="/tp_1/delete?nom=<%= m.getKey() %>&i=<%= i %>"> delete</a>
		    <a href="/tp_1/AjouterForm.jsp">Add</a>
		   <br><% 
		
	} 
	out.println("________________________________"); 
	%>
	   <br><% 
}
%>
</body>
</html>