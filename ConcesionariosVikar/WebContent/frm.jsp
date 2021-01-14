<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Reservar coche</title>
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
        <h3 class="text-muted">Coches Disponibles</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="homepage">Inicio</a></li>            
            <li><a href="admin?action=login">Administración</a></li>                        
          </ul>
        </nav>
      </div>
      <br>

      <h4><font color="red">${message}</font></h4>
      
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Solicitar reserva de coche: ${coche.marca}</b></h3>
        </div>
        <div class="panel-body">

          <form action="solicitud" method="post">
             <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" name="nombre" required id="nombre">
            </div>                   
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" name="email" required id="email">
            </div>                   
            <div class="form-group">
              <label for="telefono">Teléfono</label>
              <input type="text" class="form-control" name="telefono" required id="telefono">
            </div>                   
            <div class="form-group">
              <label for="direccion">Dirección</label>
              <input type="text" class="form-control" name="direccion" required id="direccion">
            </div>   
            <div class="form-group">
              <label for="dni">DNI</label>
              <input type="text" class="form-control" name="dni" required id="dni">
            </div>                                                   
            <input type="hidden" value="${coche.id}" name="idCoche">
            <button type="submit" class="btn btn-default" >Solicitar Reserva</button>
          </form>

        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2021 VIKAR</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
