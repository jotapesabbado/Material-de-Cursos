function contarWhile(){
	var final = parseInt(document.getElementById("texto").value);
	var valor = document.getElementById("cont").innerHTML;
	var x = 0;
		while(x<final){
			
			valor+=" "+x;
			x++;
		}
	document.getElementById("cont").innerHTML=valor;		
}

function contarFor(){
	var final = parseInt(document.getElementById("texto").value);
	var valor = document.getElementById("cont").innerHTML;

	for (var x = 0; x < final; x++){
			valor+=" "+x;
		}
	document.getElementById("cont").innerHTML=valor;		
}
