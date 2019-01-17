function soma(){

	var campo1 = parseInt(document.getElementById("campo1").value);
	var campo2 = parseInt(document.getElementById("campo2").value);
	document.getElementById("resp").innerText = campo1 + campo2;

}
function diminuir(){

	var campo1 = parseInt(document.getElementById("campo1").value);
	var campo2 = parseInt(document.getElementById("campo2").value);
	document.getElementById("resp").innerText = campo1 - campo2;

}
function multiplicar(){

	var campo1 = parseInt(document.getElementById("campo1").value);
	var campo2 = parseInt(document.getElementById("campo2").value);
	document.getElementById("resp").innerText = campo1 * campo2;

}
function dividir(){

	var campo1 = parseInt(document.getElementById("campo1").value);
	var campo2 = parseInt(document.getElementById("campo2").value);
	document.getElementById("resp").innerText = campo1 / campo2;

}