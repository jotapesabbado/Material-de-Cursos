function validar() {
	 var valor = document.getElementById("numero").value;

	 if(valor.length > 2 || valor.length==0){
	 	
	 	alert("valor digitado tem 0 ou mais de 2 algarismos");
	 	return false;
	 } else {
	 	return true;
	 }

}