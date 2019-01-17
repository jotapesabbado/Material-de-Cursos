


/****************************************************/
//Stars

// Init
var canvas = document.querySelector('#galaxy');
var ctx = canvas.getContext('2d');
canvas.width = innerWidth;
canvas.height = innerHeight;


// Fix resize canvas
window.onresize = function () {
  canvas.width = innerWidth;
  canvas.height = innerHeight;
};

function clearScreen() {
  ctx.fillStyle = '#000';
  ctx.fillRect(0, 0, canvas.width, canvas.height);
}

var stars = [];
for (var i = 0; i < 500; i++) {
  // star(x, y, speed)
  stars.push({
    x: ~~(Math.random() * canvas.width),
    y: ~~(Math.random() * canvas.height),
    speed: ~~(1 + Math.random() * 4),
    color: ~~(Math.random() * 3) });

}

// Main loop
function loop() {
  requestAnimationFrame(loop, canvas);
  update();
  render();
}

// Update
function update() {

  // Stars
  for (var _i = 0; _i < 500; _i++) {
    stars[_i].x -= stars[_i].speed;
    if (stars[_i].x < 0)
    stars[_i].x = canvas.width;
  }

}

// Render
function render() {

  clearScreen();
  for (var _i2 = 0; _i2 < 500; _i2++) {
    var s = stars[_i2];
    ctx.lineWidth = 1;
    ctx.strokeStyle = ['#444', '#888', '#FFF'][stars[_i2].color];
    ctx.strokeRect(s.x, s.y, 1, 1);
  }

}

loop();




/************************************************************/

//Game

var game = document.getElementById('game');
var c = game.getContext('2d');



