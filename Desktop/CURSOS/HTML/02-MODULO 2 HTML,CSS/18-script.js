var c = document.getElementById("canvas");
var ctx = c.getContext("2d");
ctx.moveTo(50, 50);
ctx.lineTo(50, 100);

ctx.moveTo(50, 100);
ctx.lineTo(200, 100);

ctx.moveTo(200, 100);
ctx.lineTo(200, 50);

ctx.moveTo(200, 50);
ctx.lineTo(50, 50);


ctx.moveTo(50, 50);
ctx.lineTo(200, 100);

ctx.moveTo(200, 50);
ctx.lineTo(50, 100);


ctx.stroke();