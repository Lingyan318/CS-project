var error = 0
var name1
var name2
var birthone
var birth1
var birthtwo
var birth2
var month1
var month2 
var d1
var d2
var name
run()
function run(){
if (error==0) {
 name1=prompt('what is the name of player one?')
 birth1=prompt('what is your birthday of player one?')
 birthone=(/(\d|0\d|1[012]|Jan|Feb|Mar|Apr|May|Jun|July|Aug|Sep|Oct|Nov|Dec|January|February|March|April|May|June|July|August|September|October|November|December)(?:\/|\-|\. | )(\d|[012]\d|3[01])(?:\/|\-|, )(\d{4}|\d{2})/igm).exec(birth1)

name2=prompt('what is the name of player Two?')
 birth2=prompt('what is your birthday of player Two?')
 birthtwo=(/(\d|0\d|1[012]|Jan|Feb|Mar|Apr|May|Jun|July|Aug|Sep|Oct|Nov|Dec|January|February|March|April|May|June|July|August|September|October|November|December)(?:\/|\-|\. | )(\d|[012]\d|3[01])(?:\/|\-|, )(\d{4}|\d{2})/igm).exec(birth2)
monthtable={'jan':0,'feb':1,'mar':2,'apr':3,'may':4,'jun':5,'july':6,'aug':7,'sep':8,'oct':9,'nov':10,'dev':11,'january':0,'february':1,'march':2,'april':3,'may':4,'june':5,'july':6,'august':7,'september':8,'october':9,'november':10,'december':11}


console.log(name1)
if (birthone == null) {
	alert('please enter correct bithday form')
	alert('For Example :' +' '
		+ 'MM/DD/YYYY - i.e. 01/01/2019 ' + 'M/D/YYYY - i.e. 1/1/2019 ' 
		+ 'MM-DD-YYYY - i.e. 01-01-2019 '+ 'M-D-YYYY - i.e. 1-1-2019 '
		+ 'MMM. DD, YYYY - i.e. Jan. 01, 2019 ' +'MMM. D, YYYY - i.e. Jan. 1, 2019 '
		+ 'MMMMMM DD, YYYY - i.e. January 01, 2019 '+' MMMMMM D, YYYY - i.e. January 1, 2019 ')
	run()
}
if(birthtwo == null){
	alert('please enter correct bithday form')
	alert('For Example : ' +' '
		+ 'MM/DD/YYYY - i.e. 01/01/2019 ' + 'M/D/YYYY - i.e. 1/1/2019 '  
		+ 'MM-DD-YYYY - i.e. 01-01-2019 '+ 'M-D-YYYY - i.e. 1-1-2019 '
		+ 'MMM. DD, YYYY - i.e. Jan. 01, 2019 ' +'MMM. D, YYYY - i.e. Jan. 1, 2019 '
		+ 'MMMMMM DD, YYYY - i.e. January 01, 2019 '+' MMMMMM D, YYYY - i.e. January 1, 2019 ')
    run()
}

}
}

if(birthone[1]==1||birthone[1]==2||birthone[1]==3||birthone[1]==4||birthone[1]==5||birthone[1]==6||birthone[1]==7||birthone[1]==8||birthone[1]==9||birthone[1]==10||birthone[1]==11||birthone[1]==12){
	month1 = birthone[1]-1
}else{month1=monthtable[birthone[1].toLowerCase()]}
if(birthtwo[1]==1||birthtwo[1]==2||birthtwo[1]==3||birthtwo[1]==4||birthtwo[1]==5||birthtwo[1]==6||birthtwo[1]==7||birthtwo[1]==8||birthtwo[1]==9||birthtwo[1]==10||birthtwo[1]==11||birthtwo[1]==12){
	month2 = birthtwo[1]-1
    }else{month2=monthtable[birthtwo[1].toLowerCase()]}



 d1=new Date(birthone[3],month1,birthone[2])
 d2=new Date(birthtwo[3],month2,birthtwo[2])
document.getElementById('playerOne').innerHTML += '<p>'+name1+'</p>'+'<p>'+d1.getFullYear()+'/'+(d1.getMonth()+1)+'/'+d1.getDate()
document.getElementById('playerTwo').innerHTML += '<p>'+name2+'</p>'+'<p>'+d2.getFullYear()+'/'+(d2.getMonth()+1)+'/'+d2.getDate()

var table = []

for (var i = 1; i < 9; i++) {
    table.push([0, 0, 0, 0, 0, 0, 0, 0])
}

name = [name1, name2]
var game_start = 0

var token=[21,21]
document.getElementById('playerOne_take').innerHTML='remaind :'+ token[0]
document.getElementById('playerTwo_take').innerHTML='remaind :'+ token[1]

document.getElementById('start').addEventListener('click',function(){start()})
document.getElementById('re_start').addEventListener('click',function(){re_start()})
document.getElementById('timer').innerHTML='00:00'


if (d1<d2) {
   alert('Click start to begin'+' ' + name1 + ' ' + 'turn' +' with black')
    turn = 0
}else{
   alert('Click start to begin'+ ' ' + name2 + ' ' + 'turn'+ ' with red' )
   turn =1
}

turn = 0
var c=0
setTable()
function start(){

	game_start = 1
	
timerstop=setInterval(timer,1000)
 
}
var table_check

var counts=[6,6,6,6,6,6,6]

function drop() {
   
    if (game_start == 0) {

        alert('please start game first')
        return
    }
    var ele = event.target.id
    var index = ele.charAt(1)
    if (counts[index-1] == 0) {
        alert('column is full')
    } else {
        if (turn == 0) {
            document.getElementById(counts[index-1] + ',' + index).setAttribute('src', 'images/black-circle.png')
            document.getElementById(counts[index-1] + ',' + index).setAttribute('id',counts[index-1] + ',' + index)
            table[counts[index-1]][index] = 1
            //console.log(table)
        } else if (turn == 1) {
            document.getElementById(counts[index-1] + ',' + index).setAttribute('src', 'images/red-circle.png')
            document.getElementById(counts[index-1] + ',' + index).setAttribute('id',counts[index-1] + ',' + index)
            table[counts[index-1]][index] = 2
        }
        token[turn]-- 
        var change
        counts[index-1]--
        if (turn == 0) {

            change = document.getElementById("playerOne_take")
        } else {
            change = document.getElementById("playerTwo_take")
        }
        change.innerHTML = 'token left: ' + token[turn]
        //console.log(turn)
        if(turn == 0)
        {
        	turn =1
        }else if(turn ==1){
        	turn =0
        }
        //console.log(table)
        var winner = checkwin(table)
        if(winner ==0){
        	 //alert('winner is' + name[winner])
        	 gameover(winner)
        	 game_start =0
        	}else if (winner == 1) {
        		//alert('winner is' + ' ' + name[winner])
        	 gameover(winner)

        	}
       
    }
}

function re_start(){
counts=[6,6,6,6,6,6,6]
//location.reload()
    token[0] =21
	token[1] =21
document.getElementById("playerOne_take").innerHTML = 'token left: ' + 21
document.getElementById("playerTwo_take").innerHTML = 'token left: ' + 21
clearInterval(timerstop)
document.getElementById('timer').innerHTML='00:00'
var base = document.getElementById('table')
base.parentElement.removeChild(base);
setTable()
start()
}

function setTable(){
	var b =document.getElementById('table_div')
    var base=document.createElement('table')
    base.setAttribute('id','table')
     b.appendChild(base)
    var label={1:'A',2:'B',3:'C',4:'D',5:'E',6:'F',7:'G'}
    for(var i=0;i<8;i++){
        var row=document.createElement('tr');
        for(var j=0;j<8;j++){
            var a=document.createElement('td')
            if((i==0||i==7)&&j==0){
                a.appendChild(document.createTextNode(' '))
            }else if(i==0){
                var button=document.createElement('button')
                button.setAttribute('id','b'+j)
                button.appendChild(document.createTextNode('drop'))
                button.addEventListener('click',function(){drop()})
                a.appendChild(button)
            }else if(j==0&&i!=7){
                a.appendChild(document.createTextNode(i))
            }else if(i==7&&j>0){
                a.appendChild(document.createTextNode(label[j]))
            }else{
                var cell=document.createElement('img')
                cell.setAttribute('id',i+','+j)
                cell.setAttribute('src', 'images/white-circle.png')
                cell.setAttribute('height', '60px')
                cell.setAttribute('width', '60px')
                a.appendChild(cell)
            }
            row.appendChild(a)
        }
        base.appendChild(row)
        base.setAttribute('bgcolor','yellow')
    }
    
}

function gameover(){
	c++
	clearInterval(timerstop)
	var result=document.getElementById('timer').innerHTML
	alert('Congratulations! '+name[turn]+' won in '+ result)
	var counter = 0
	var players = {name:name[turn],time:result}
	var top = []
	console.log(players)
	if(c<10){
		var pp=document.createElement('p')
    	pp.innerHTML = players['name','time']
    	document.getElementById('t').appendChild(pp)
		}
}
function checkwin(k){
	for(var i=1;i<7;i++){
		for(var j=1;j<8;j++){
        if (k[i][j] == 1 && k[i][j+1] == 1 && k[i][j+2] ==1 && k[i][j+3]==1)
        {
        	return 0
        }
        else if(k[i][j] == 1 && k[i+1][j] == 1 && k[i+2][j] ==1 && k[i+3][j]==1)
        {
            return 0
        }else if (k[i][j] == 1 && k[i+1][j+1] == 1 && k[i+2][j+2] ==1 && k[i+3][j+3]==1) 
        {

            return 0
        }else if (k[i][j] == 1 && k[i-1][j+1] == 1 && k[i-2][j+2] ==1 && k[i-3][j+3]==1) 
        {

            return 0
        }else if (k[i][j] == 2 && k[i][j+1] == 2 && k[i][j+2] ==2 && k[i][j+3]==2)
        {
        	return 1
        }
        else if(k[i][j] == 2 && k[i+1][j] == 2 && k[i+2][j] ==2 && k[i+3][j]==2)
        {
            return 1
        }else if (k[i][j] == 2 && k[i+1][j+1] == 2 && k[i+2][j+2] ==2 && k[i+3][j+3]==2) 
        {

            return 1
        }else if (k[i][j] == 2 && k[i-1][j+1] == 2 && k[i-2][j+2] ==2 && k[i-3][j+3]==2) 
        {

            return 1
        }       
        	
       }
	}

}

function timer() {
	var times=document.getElementById('timer')
    var time=/(\d{1,2}):(\d{1,2})/gm.exec(times.innerHTML)
    var min=parseInt(time[1])
    var sec=parseInt(time[2])
    if(sec==59){
        sec=00
        min+=1
    }else{
        sec+=1
    }
    times.innerHTML=min+':'+sec
}

