
//sem parameteo seta a data atual
var dt =  new Date();

//normalmente a data vem em milisegundos
//essa é a forma de passar uma data real em milisegundos(formato americano)
var dtnormal = new Date(Date.parse("March 10, 2001"));

//mais 60 dias adicionados a data informada(obs essa é a mesma forma pra addicionar qualquer coisa em data)
dtnormal.setDate(dt.getDate()+60);


//dia do mes
dt.getDate();
//dia da semana
dt.getDay();
//ano
dt.getFullYear();
//os meses no java script começãm no 0 ate o 11 entaão para ajustar precisa somar mais 1
dt.getMonth();
dt.getHours();
dt.getMinutes();
dt.getSeconds();


dt.getDate()+"/"+(dt.getMonth()+1)+"/"+dt.getFullYear();


//Exemplo:
var dias = ["DOMINGO","SEGUNDA","TERÇA", "QUARTA", "QUINTA", "SEXTA", "SABBADO"];

dias[dt.getDay];
