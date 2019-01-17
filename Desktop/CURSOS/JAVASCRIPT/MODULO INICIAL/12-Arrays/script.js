function listarItens(){
var lista = document.getElementById("lista").innerHTML;
var x = ["arroz","feijao","carne"];
for (var i = x.length - 1; i >= 0; i--) {
	lista += "<li>"+x[i]+"</li>";
	}
document.getElementById("lista").innerHTML=lista;
}

