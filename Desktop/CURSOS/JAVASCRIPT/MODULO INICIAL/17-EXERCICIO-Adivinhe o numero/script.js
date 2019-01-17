function verificarNumero(){
	resetar();
	var numdig = parseInt(document.getElementById("texto").value);
	var num = parseInt(document.getElementById("numero").innerHTML);
	
	if(numdig==num){
		alert("ACERTO MIZERAVI");
	}else{
		alert("NÃO FOI DESSA VEZ");
	}

	
}

function resetar(){
	document.getElementById("numero").value="";

	var r = Math.floor(Math.random()*10);
	document.getElementById("numero").innerHTML= r;

}