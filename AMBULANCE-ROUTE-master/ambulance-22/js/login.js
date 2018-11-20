window.onload = inicializar;
var formLogin;

function inicializar(){
	formLogin = document.getElementById("form-login");
	formLogin.addEventListener("submit",autentificar,false);
}

function autentificar(event){

	event.preventDefault();
	var usuario = event.target.email.value;
	var contrasena = event.target.password.value;

	firebase.auth().signInWithEmailAndPassword(usuario,contrasena)

	.then(function(result){
		window.location.href = "inicio.html";
	})
	.catch(function(error){
		$("#errorModal").modal();
	
	});		
} 