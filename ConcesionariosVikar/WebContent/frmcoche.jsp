<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <link rel="icon" href="favicon.ico">
    <title>Coches disponibles</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">
    <script src='tinymce/tinymce.min.js'></script>
    
  </head>

  <body>
      
    <div class="container">
      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Administración</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="admin?action=crear">Dar de alta nuevo coche</a></li>            
            <li><a href="coche?action=lista">Visualizar coches</a></li> 
            <li><a href="solicitud?action=solicitudes">Solicitudes</a></li> 
            <li><a href="admin?action=logout">Desconectarse</a></li>                 
          </ul>
        </nav>
      </div>

      <br>    
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Dar de alta nuevo coche</h3>
        </div>
        <div class="panel-body">
         <form action="coche" method="post">
            <div class="form-group">
              <label for="marca">Marca</label>
              <input type="text" class="form-control" name="marca" required id="marca" value="" placeholder="Escriba la marca del coche">
            </div>                   
            <div class="form-group">
              <label for="modelo">Modelo</label>
              <input type="text" class="form-control" name="modelo" id="color" required rows="3" placeholder="Escribe el modelo del coche"></input>
            </div>
            <div class="form-group">
              <label for="color">Color</label>
              <input type="text" class="form-control" name="color" rows="10" placeholder="Escriba el color del coche"></input>
            </div>
            <div class="form-group">
              <label for="precio">Precio</label>
              <input type="text" class="form-control" id="precio" name="precio" rows="10" placeholder="Escriba el precio del coche"></input>
            </div>
            <button type="submit" class="btn btn-default" >Guardar</button>
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
