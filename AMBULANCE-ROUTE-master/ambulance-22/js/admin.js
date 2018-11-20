$("#guardarbtn").click(function(event){
	var administrador = {
		foto: $('#fototxt').val(),
		nombre: $('#nombretxt').val(),
		apellido: $('#apellidotxt').val(),
	 	identificacion: $('#identificaciontxt').val(),
	 	fechaN: $('#fechaNtxt').val(),
	 	genero: $('#generotxt').val(),
	 	email: $('#email').val(),
	 	perfil: $('#perfiltxt').val(),
	 	turno: $('#turnotxt').val(),
	 	usuario: $('#usuariotxt').val(),
	 	contraseña: $('#contraseña').val(),
	}

	firebase.database().ref().child("administrador")
	.push(administrador)

});
	//LEER LA BASE DE DATOS
$(document).ready(function(){
	//deshabilitar boton editar
	$("#editarbtn").attr('disabled','disabled');
	//conexion a la rama Persona de la base de datos
	firebase.database().ref().child("administrador")
	.on('value', function(snap){
		//obtener los datos que vienen de la base de datos y encapsular en la variable "persona"
		var administrador = snap.val();
			//recorrer la lista que nos trae persona
			for (var i in administrador) {
				//mostramos los datos de la lista en el html
				$('#cuerpo-tabla').append("<tr>" +

											"<td>" + administrador[i].foto + "</td>" +
											"<td>" + administrador[i].nombre + "</td>" +
											"<td>" + administrador[i].apellido + "</td>" +
											"<td>" + administrador[i].identificacion + "</td>" +
											"<td>" + administrador[i].fechaN + "</td>" +
											"<td>" + administrador[i].genero + "</td>" +
											"<td>" + administrador[i].email + "</td>" +
											"<td>" + administrador[i].turno + "</td>" +

											"<td>" +
												"<button class='editar btn btn-primary' data-administrador='"+i+"'>" +
													"<i class='zmdi zmdi-edit'></i>" +
												"</button>" +
											"</td>" +
											"<td>" +
												"<button class='borrar btn btn-danger' data-administrador='"+i+"'>" +
													"<i class='zmdi zmdi-delete'></i>" +
												"</button>" +
											"</td>" +
											"</tr>");
			}
			//BORRAR
			//funcion que permite dar click en el icono de eliminar y ejecuta la accion
			$('.borrar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-administrador");
				//obtenemos la estancia del objeto a borrar
				var borrador = firebase.database().ref().child("administrador/"+referencia);
				//borramos la estancia
				borrador.remove();
			});	

			//ACTUALIZAR
			//funcion que permite dar click en el icono de editar y ejecuta la accion
			$('.editar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-administrador");
				//deshabilitamos el boton de guardar cuando estamos editando.
				$('#guardarbtn').attr('disabled', 'disabled');
				//habilitamos el boton editar.
				$('#editarbtn').removeAttr('disabled');
				//guardamos la estancia en una variable.
				var editor = firebase.database().ref('administrador').child(referencia);
				//obtenemos los datos traidos de la base de datos.
				editor.once("value", function(snap){
					//obtenemos los datos y los mostramos en el formulario para ser editados.
					var datos = snap.val();
					$('#fotoxt').val(datos.foto);
					$('#nombretext').val(datos.nombre);
					$('#apellidotxt').val(datos.apellido);
					$('#identificaciontxt').val(datos.identificacion);
					$('#fechaNtxt').val(datos.fechaN);
					$('#generotxt').val(datos.genero);
					$('#email').val(datos.email);
					$('#perfiltxt').val(datos.perfil);
					$('#turnotxt').val(datos.turno);

					//funcion para guardar los datos actualizados.
					$('#editarbtn').click(function(event) {
						event.preventDefault();
						//establecemos los valores a cambiar
						var edicion = {
							foto: $('#fototxt').val(),
							nombre: $('#nombretxt').val(),
							apellido: $('#apellidotxt').val(),
							identificacion: $('#identificaciontxt').val(),
		 					fechaN: $('#fechaNtxt').val(),
		 					genero: $('#generotxt').val(),
		 					email: $('#email').val(),
		 					perfil: $('#perfiltxt').val(),
		 					turno: $('#turnotxt').val(),
						}
						//establecer conexion con firebase y actualizacion de los datos.
					firebase.database().ref('administrador').child(referencia)
					.update(edicion)
					});
				}); 				
			});	
	});
});