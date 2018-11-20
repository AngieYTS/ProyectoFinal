$("#guardarbtn").click(function(event){
	var empresa = {
		nit: $('#nittxt').val(),
		nombre: $('#nombretxt').val(),
		telefono: $('#telefonotxt').val(),
	 	direccion: $('#direcciontxt').val(),
	 	email: $('#emailtxt').val(),
	}

	firebase.database().ref().child("empresa")
	.push(empresa)

});
	//LEER LA BASE DE DATOS
$(document).ready(function(){
	//deshabilitar boton editar
	$("#editarbtn").attr('disabled','disabled');
	//conexion a la rama Persona de la base de datos
	firebase.database().ref().child("empresa")
	.on('value', function(snap){
		//obtener los datos que vienen de la base de datos y encapsular en la variable "persona"
		var empresa = snap.val();
			//recorrer la lista que nos trae persona
			for (var i in empresa) {
				//mostramos los datos de la lista en el html
				$('#cuerpo-tabla').append("<tr>" +

											"<td>" + empresa[i].nit + "</td>" +
											"<td>" + empresa[i].nombre + "</td>" +
											"<td>" + empresa[i].telefono + "</td>" +
											"<td>" + empresa[i].direccion + "</td>" +
											"<td>" + empresa[i].email + "</td>" +

											"<td>" +
												"<button class='editar btn btn-primary' data-empresa='"+i+"'>" +
													"<i class='zmdi zmdi-edit'></i>" +
												"</button>" +
											"</td>" +
											"<td>" +
												"<button class='borrar btn btn-danger' data-empresa='"+i+"'>" +
													"<i class='zmdi zmdi-delete'></i>" +
												"</button>" +
											"</td>" +
											"</tr>");
			}
			//BORRAR
			//funcion que permite dar click en el icono de eliminar y ejecuta la accion
			$('.borrar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-empresa");
				//obtenemos la estancia del objeto a borrar
				var borrador = firebase.database().ref().child("empresa/"+referencia);
				//borramos la estancia
				borrador.remove();
			});	

			//ACTUALIZAR
			//funcion que permite dar click en el icono de editar y ejecuta la accion
			$('.editar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-empresa");
				//deshabilitamos el boton de guardar cuando estamos editando.
				$('#guardarbtn').attr('disabled', 'disabled');
				//habilitamos el boton editar.
				$('#editarbtn').removeAttr('disabled');
				//guardamos la estancia en una variable.
				var editor = firebase.database().ref('empresa').child(referencia);
				//obtenemos los datos traidos de la base de datos.
				editor.once("value", function(snap){
					//obtenemos los datos y los mostramos en el formulario para ser editados.
					var datos = snap.val();
					$('#nittxt').val(datos.nit);
					$('#nombretxt').val(datos.nombre);
					$('#telefonotxt').val(datos.telefono);
					$('#direcciontxt').val(datos.direccion);
					$('#emailtxt').val(datos.email);

					//funcion para guardar los datos actualizados.
					$('#editarbtn').click(function(event) {
						event.preventDefault();
						//establecemos los valores a cambiar
						var edicion = {
							nit: $('#nittxt').val(),
							nombre: $('#nombretxt').val(),
							telefono: $('#telefonotxt').val(),
							direccion: $('#direcciontxt').val(),
		 					email: $('#emailtxt').val(),
						}
						//establecer conexion con firebase y actualizacion de los datos.
					firebase.database().ref('empresa').child(referencia)
					.update(edicion)
					});
				}); 				
			});	
	});
});
