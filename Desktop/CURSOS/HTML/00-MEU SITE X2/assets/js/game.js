/*

QUANDO O CURSOR ENTRAR NO CEU ESTRELADO
VIRAR UMA NAVE!!!

*/

		
var canvas = document.getElementById('game'),
c = canvas.getContext('2d');
canvas.width = innerWidth;
canvas.height = innerHeight;
	


// KEYS EVENT LISTENERS
var map = {
	37: false, // Left Arrow Key
	39: false, // Right Arrow Key
	38: false, // Top Arrow Key
	40: false, // Bottom Arrow Key
	32: false, // Space Key
}

addEventListener('keydown', function(event){
	if(event.keyCode in map){
		map[event.keyCode] = true;
		
		if(map[37]){
		   player.x += -10;
		   
		}else if(map[39]){
		   player.x += 10;
		   
		}
		if(map[32]){
		   fire();
		   
		}
	
	}
});

addEventListener('keyup', function(event){
	if(event.keyCode in map){
		map[event.keyCode] = false;
	}
});
	
// PLAYER SETUP
var player = {},
    player_width = 90,
	player_height = 95,
	player_img = new Image();
	player_img.src = 'assets/img/nave.png';

// CREATE PLAYER
player = {
	width : player_width,
	height: player_height,
	x : innerWidth/2 - player_width/2,
	y : innerHeight - (player_height+10),
	
	draw: function(){
	   if(this.x <= 0){
	     this.x = 0;
	   }else if(this.x >= (innerWidth - this.width)){
	     this.x = (innerWidth -this.width);
	   }
	   
	   if(this.y <= 0){
	     this.y = 0;
	   }else if(this.y >= (innerHeight - this.height)){
	     this.y = (innerHeight - this.height);
	   }
	
	   c.drawImage(player_img, this.x, this.y, this.width, this.height);
	}

};

// ENEMY SETUP
var enemyArray = [],
	enemyIndex = 0,
	enemy_width = 100,
	enemy_height = 200,
	enemy_timer = 1000,
	enemy_img = new Image();
	enemy_img.src = '';
	
// CREATE ENEMY OBJECT
function enemy(x, y, enemy_img, enemy_width, enemy_height){
	this.x = x;
	this.y = y;
	this.img = enemy_img;
	this.width = enemy_width;
	this.height = enemy_height;
	enemyArray[enemyIndex] = this;
	this.id = enemyIndex;
	
	this.update = function(){
				
		if(this.y > innerHeight + this.height){
			this.delete();
		}
		
		this.draw();
	}
	
	this.delete = function(){
		delete enemyArray[this.id];
	}
	
	this.draw = function(){
		c.drawImage(this.img, this.x, this.y, this.width, this.height);
	}
}

// CREATE ENEMY FUNCTION
function create_enemy(){
	var x = innerWidth/5;
	var y = 50;
	new enemy(x, y, enemy_img, enemy_width, enemy_height);
}








// ENEMY SETUP
var alvoArray = [],
	alvoIndex = 0,
	alvo_width = 100,
	alvo_height = 200,
	alvo_timer = 1000,
	alvo_img = new Image();
	alvo_img.src = '';
	
// CREATE ENEMY OBJECT
function alvo(x, y, alvo_img, alvo_width, alvo_height){
	this.x = x;
	this.y = y;
	this.img = alvo_img;
	this.width = alvo_width;
	this.height = alvo_height;
	alvoArray[alvoIndex] = this;
	this.id = alvoIndex;
	
	this.update = function(){
				
		if(this.y > innerHeight + this.height){
			this.delete();
		}
		
		this.draw();
	}
	
	this.delete = function(){
		delete alvoArray[this.id];
	}
	
	this.draw = function(){
		c.drawImage(this.img, this.x, this.y, this.width, this.height);
	}
}

// CREATE ENEMY FUNCTION
function create_alvo(){
	var x = (innerWidth)-innerWidth/3+innerWidth/25;
	var y = 50;	
	new alvo(x, y, alvo_img, alvo_width, alvo_height);
}









//BULLET SETUP
var bulletArray = [],
	bulletIndex = 0,
	bullet_width = 8,
	bullet_height = 10,
	speed =10;


function bullet(x,y,width,height,speed){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.speed=speed;

	bulletIndex++;
	bulletArray[bulletIndex] = this;
	this.id = bulletIndex;

	this.update = function(){
		this.y += -this.speed;
		if(this.y<-this.height){
			delete this.delete();
		}
		this.draw();
	}

	this.delete = function(){
		delete bulletArray[this.id];
	}

	this.draw = function(){
		c.beginPath();
		c.rect(this.x,this.y,this.width,this.height);
		c.fillStyle = '#fff';
		c.fill();
		c.stroke();
	}
}	
	
//FIRE BULLET
function fire(){
	var x = (player.x+player.width/2)- bullet_width/2;
	var y = player.y;

	new bullet(x,y,bullet_width,bullet_height,speed);

}



//COLLISION FUNCTION
function collides(a,b){

	return a.x < b.x + b.width &&
		   a.x + a.width > b.x &&
		   a.y < b.y + b.height &&
		   a.y + a.height > b.y;	
}


//DETECT COLLISION
function handleCollision(){

	bulletArray.forEach(function(bullet){
		enemyArray.forEach(function(enemy){
			if(collides(bullet,enemy)){
				bullet.delete();
				enemy.delete();
				window.location.href = 'index.html';
			}
		});
	});

	bulletArray.forEach(function(bullet){
		alvoArray.forEach(function(alvo){
			if(collides(bullet,alvo)){
				bullet.delete();
				alvo.delete();
				window.location.href = 'index.html';
			}
		});
	});

}

var unico =0;
// ANIMATION LOOP
function animate(currentTime){
    requestAnimationFrame(animate);
	c.clearRect(0,0, canvas.width, canvas.height);
	
	//ENEMY DRAW
	

	if(unico==0){
		create_alvo();
		create_enemy();
	}
	unico++;
	
	// UPDATE ENEMY POSITIONS
	enemyArray.forEach(function(enemy){
		enemy.update();
	
	});

	alvoArray.forEach(function(alvo){
		alvo.update();
	
	});



	// DRAW PLAYER
	player.draw();	

	
	//update position
	bulletArray.forEach(function(bullet){
		bullet.update();
	});

	//Detect collisio
	handleCollision();
	
}
animate();








/////////////////////////////////////////////////////////////////////////////

