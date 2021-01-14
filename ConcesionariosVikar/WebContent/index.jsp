<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Concesionarios VIKAR</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>
  
  <div class="container">
  
  	<!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->    
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar coche..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
      
      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Concesionarios VIKAR</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="homepage">Inicio</a></li>            
            <li><a href="admin?action=login">Entrar como admin</a></li>                        
          </ul>
        </nav>
      </div>
      
      
          
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>Compre cualquier coche que esté disponible...</h2>
        <!--
        <h4>ESTAMOS CONTRATANDO</h4>
        -->
        <p class="lead text-justify">Bienvenido a Concesionarios VIKAR, aquí podrá 
        mirar todos los coches que tenemos disponibles en el sistema y si le gusta alguno podrá solicitar su compra.
        Contactaremos con usted cuando su solicitud se haya aprobado.<br><br>

        <p><a class="btn btn-lg btn-success" href="coche?action=lista" role="button">Ver todos los Coches Disponibles</a></p>                
      </div>

      <h1>Coches creados recientemente</h1>

      <!-- Example row of columns -->
      <div class="row">

        <c:forEach items="${ultimos}" var="coche" varStatus="status">

          <div class="col-lg-4">
            <h3>Coche: [${coche.id}]</h3> 
            <p class="text-danger">${coche.marca}</p>          
            <p class="text-justify">${coche.modelo}</p>
            <p><a class="btn btn-primary" href="coche?action=ver&id=${coche.id}" role="button">Ver Detalles del coche&raquo;</a></p>
          </div>

        </c:forEach> 

       
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2021 VIKAR</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
