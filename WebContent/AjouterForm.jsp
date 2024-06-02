<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <LINK href="css/desi.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
 <h1>ajouter un nouvel carnet</h1>
        <form action="ajouter" method="post">
           <label>le nom</label>
           <input type="text" name="nom" > <br>
           <label>la ville</label>
           <input type="text" name="ville">  
           <label>le nom de Rue</label>          
           <input type="text" name="nomRue"> 
           <label>le numero de Rue</label>  
           <input type="number" name="numRue">
           <input type="submit" value="ajouter" name="b1" />
        </form>
</body>
</html>