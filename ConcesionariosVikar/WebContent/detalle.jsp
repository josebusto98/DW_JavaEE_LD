<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Detalles del coche - ${coche.marca}</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Coches</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="homepage">Inicio</a></li>            
            <li><a href="admin?action=login">Administración</a></li>                        
          </ul>
        </nav>
      </div>
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar coche..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
      <br><br><br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">ID: ${coche.id}</h3>
        </div>
        <div class="panel-body">
          <h5><b>Fecha publicación</b>: ${coche.fechaPublicacion}</h5>                             
          <b>Marca:</b><br>
          <p class="text-justify">${coche.marca}</p>
          <b>Modelo:</b>:<br>
          ${coche.modelo}<br>
          <b>Color:</b>:<br>
          ${coche.color}<br>
          <b>Precio:</b>:<br>
          ${coche.precio}<br>
                 
          <p><a class="btn btn-default btn-success" title="Reservar" href="coche?action=enviar&id=${coche.id}" role="button">Reservar</a></p>
        </div>
        
      </div>      
      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2021 VIKAR</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
