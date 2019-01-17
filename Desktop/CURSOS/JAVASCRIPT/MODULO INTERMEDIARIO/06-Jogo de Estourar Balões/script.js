function addBola(){
	var bola = document.createElement("div");
	bola.setAttribute("class", "bola");

	var p1 = Math.floor(Math.random()*500);
	var p2 = Math.floor(Math.random()*400);
	

	bola.setAttribute("style", "left:"+p1+"px;top:"+p2+"px;background-color:"+corAleatoria()+";" );

	bola.setAttribute("onclick", "estourar(this)");

	document.body.appendChild(bola);
}

function estourar(elemento){
	document.body.removeChild(elemento);

}

function iniciar(){
	setInterval(addBola, 1000);

}

function corAleatoria(){
var letters = '0123456789ABCDEF'.split('');
    var cor = '#';
    for (var i = 0; i < 6; i++ ) {
        cor += letters[Math.floor(Math.random() * 16)];
    }
	return cor;	
}