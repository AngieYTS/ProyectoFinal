$("#guardarbtn").click(function(event){
	var email = document.getElementById('email').value;
	var contraseña = document.getElementById('contraseña').value;

	firebase.auth().createUserWithEmailAndPassword(email, contraseña).catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  var errorMessage = error.message;
  console.log(error.code);
  console.log(error.message);
  // ...
	});
});
