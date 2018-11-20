$("#guardarbtn").click(function(event){
	var ambulancia = {
		placa: $('#placatxt').val(),
		serial: $('#serialtxt').val(),
		tipoAmbu: $('#tipoAmbutxt').val(),
	}

	firebase.database().ref().child("ambulancia")
	.push(ambulancia)

});
	//LEER LA BASE DE DATOS
$(document).ready(function(){
	//deshabilitar boton editar
	$("#editarbtn").attr('disabled','disabled');
	//conexion a la rama Persona de la base de datos
	firebase.database().ref().child("ambulancia")
	.on('value', function(snap){
		//obtener los datos que vienen de la base de datos y encapsular en la variable "persona"
		var ambulancia = snap.val();
			//recorrer la lista que nos trae persona
			for (var i in ambulancia) {
				//mostramos los datos de la lista en el html
				$('#cuerpo-tabla').append("<tr>" +

											"<td>" + ambulancia[i].placa + "</td>" +
											"<td>" + ambulancia[i].serial + "</td>" +
											"<td>" + ambulancia[i].tipoAmbu + "</td>" +
											"<td>" +
												"<button class='editar btn btn-primary data-ambulancia='"+i+"'>" +
													"<i class='zmdi zmdi-edit'></i>" +
												"</button>" +
											"</td>" +
											"<td>" +
												"<button class='borrar btn btn-danger' data-ambulancia='"+i+"'>" +
													"<i class='zmdi zmdi-delete'></i>" +
												"</button>" +
											"</td>" +
											"</tr>");			
			}
			//BORRAR
			//funcion que permite dar click en el icono de eliminar y ejecuta la accion
			$('.borrar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-ambulancia");
				//obtenemos la estancia del objeto a borrar
				var borrador = firebase.database().ref().child("ambulancia/"+referencia);
				//borramos la estancia
				borrador.remove();
			});	

			//ACTUALIZAR
			//funcion que permite dar click en el icono de editar y ejecuta la accion
			$('.editar').click(function(event) {
				//traemos la variable "data-persona" para saber la llave(key) en la base de datos
				var referencia = this.getAttribute("data-ambulancia");
				//deshabilitamos el boton de guardar cuando estamos editando.
				$('#guardarbtn').attr('disabled', 'disabled');
				//habilitamos el boton editar.
				$('#editarbtn').removeAttr('disabled');
				//guardamos la estancia en una variable.
				var editor = firebase.database().ref('ambulancia').child(referencia);
				//obtenemos los datos traidos de la base de datos.
				editor.once("value", function(snap){
					//obtenemos los datos y los mostramos en el formulario para ser editados.
					var datos = snap.val();
					$('#placatxt').val(datos.placa);
					$('#serialtxt').val(datos.serial);
					$('#tipoAmbutxt').val(datos.tipoAmbu);

					//funcion para guardar los datos actualizados.
					$('#editarbtn').click(function(event) {
						event.preventDefault();
						//establecemos los valores a cambiar
						var edicion = {
							placa: $('#placatxt').val(),
							serial: $('#serialtxt').val(),
							tipoAmbu: $('#tipoAmbutxt').val(),
						}
						//establecer conexion con firebase y actualizacion de los datos.
					firebase.database().ref('ambulancia').child(referencia)
					.update(edicion)
					});
				}); 				
			});	
	});
});