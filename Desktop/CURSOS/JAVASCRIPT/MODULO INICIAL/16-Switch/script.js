function testeSwitch(){
	var num = parseInt(document.getElementById("texto").value);

	switch(num){
		case 0:
			alert("Numero 0");
		break;
		case 1:
			alert("Numero 1");
		break;
		case 2:
			alert("Numero 2");
		break;
		default:
			alert("NAO SEI CONTAR MAIS QUE 2");
		break;
	}

}