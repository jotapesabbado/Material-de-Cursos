function listarItens(){
var lista = document.getElementById("lista").innerHTML;
var x = ["arroz","feijao","carne"];

for (var i = x.length - 1; i >= 0; i--) {
	lista += "<li>"+x[i]+"</li>";
	}
document.getElementById("lista").innerHTML=lista;




//busca no meu array o item e retorna a posição se não achar nada retorna -1
//OBS: indexOf no if se retornar 0(porem zero é valido) não entra no if entao tem que verificar se form maior que -1
alert(x.indexOf("feijao"));

//transformar todos os valores em uma unica string, e possibilita por um divisor 

alert(x.join("/"));

//remover o ultimo elemento e retorna o valor que removeu

alert(x.pop());

//remover o primeiro elemento e retorna o valor que removeu

alert(x.shift());

//adicionar elemento na lista

x.push("batata");


}

