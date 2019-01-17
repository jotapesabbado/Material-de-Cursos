function addIngrediente(){

	var lista = document.getElementById("lista").innerHTML;
	var ingrediente = document.getElementById("ingrediente").value;

	lista += "<li>"+ingrediente+"</li>";
	
	document.getElementById("lista").innerHTML = lista;	



}