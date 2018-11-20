window.onload = inicializar;
var fichero;
var storageRef;
var imagenesFBRef;

function inicializar(){
  fichero = document.getElementById("fichero");
  fichero.addEventListener("change", subirImagenAFirebase, false);

  storageRef = firebase.storage().ref();

  imagenesFBRef = firebase.database().ref();

  mostrarImagenesDeFirebase();
}

function mostrarImagenesDeFirebase(){
  imagenesFBRef.on("value", function(snapshot){
    var datos = snapshot.val();
    var result = "";
    for(var key in datos){
      result += '<img width="200" class="img-thumbnail" src="' + datos[key].url + '"/>'; 
    }
    document.getElementById("imagenes-de-firebase").innerHTML = result;
  })

}

function subirImagenAFirebase(){
  var imagenASubir = fichero.files[0];

  var uploadTask = storageRef.child('imagenes/' + imagenASubir.name).put(imagenASubir);

  uploadTask.on('state_changed',
  function(snapshot){
 
}, function(error) {

  alert("hubo un error");
}, function() {
  alert("exito")
  
  });
 }
