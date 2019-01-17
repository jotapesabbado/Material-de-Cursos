function seuNome(){
	var nome = document.getElementById("texto").value;
	if (nome=="") {
		alert("nome invalido");
	}else{
		alert("Olá "+nome);

	}

}