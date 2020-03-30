let game = {};
game.map = [];
game.gamestatus = {
    player_1_id:1,
    player_2_id:2,
    player_1_name:'a',
    player_2_name:'b',
    player_1_birth:'11',
    player_2_birth:'22',
    player_1_remain:21,
    player_2_remain:21,
    nextturn:1,
    over:false,

    user_id:0,
};
game.initTable = function(){
    let self = this;
    for(let i=0; i<9; i++){
        self.map.push([0,0,0,0,0,0,0,0,0,0])
    }
    console.log(game.gamestatus);
    document.getElementById('playerOne').innerHTML += '<p>'+self.gamestatus.player_1_name+'</p>'+'<p>'+self.gamestatus.player_1_birth+'</p>' +
        '<p id="remain">remain token:'+self.gamestatus.player_1_remain+'</p>';
    document.getElementById('playerTwo').innerHTML += '<p>'+self.gamestatus.player_2_name+'</p>'+'<p>'+self.gamestatus.player_2_birth+'</p>' +
        '<p id="remain">remain token:'+self.gamestatus.player_2_remain+'</p>';;
    let b =document.getElementById('table_div');
    let base=document.createElement('table');
    base.setAttribute('id','table');
    b.appendChild(base);
    var label={1:'A',2:'B',3:'C',4:'D',5:'E',6:'F',7:'G'};
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
                button.addEventListener('click',function(){self.drop()})
                a.appendChild(button)
            }else if(j==0&&i!=7){
                a.appendChild(document.createTextNode(i))
            }else if(i==7&&j>0){
                a.appendChild(document.createTextNode(label[j]))
            }else{
                var cell=document.createElement('img')
                cell.setAttribute('id','x'+i+'y'+j)
                cell.setAttribute('src', '/static/images/white-circle.png')
                cell.setAttribute('height', '60px')
                cell.setAttribute('width', '60px')
                a.appendChild(cell)
            }
            row.appendChild(a)
        }
        base.appendChild(row)
        base.setAttribute('bgcolor','yellow')
    }
    for (let turn of self.gamestatus.turns){
        self.advance(turn[0], turn[1], self.gamestatus.nextturn)
    }
}
game.advance = function(x, y, turn){
    let self = this;
    let name = 'img#x'+x+'y'+y;
    let tds = $(name)[0];
    if(turn % 2===1){
        self.map[x-1][y-1]=1;
        self.gamestatus.player_1_remain--;
        let p=$('#playerOne #remain');
        p.text('remain token:'+self.gamestatus.player_1_remain);
        tds.setAttribute('src', '/static/images/black-circle.png')
    }else if(turn % 2 ===0){
        self.map[x-1][y-1]=2;
        self.gamestatus.player_2_remain--;
        let p=$('#playerTwo #remain');
        p.text('remain token:'+self.gamestatus.player_2_remain);
        tds.setAttribute('src', '/static/images/red-circle.png')
    }
    self.gamestatus.nextturn++;
};
game.drop = function() {
    let self = this;
    if(self.gamestatus.over){
        alert('you can\'t drop!');
        return
    }
    if((!((self.gamestatus.player_1_id === self.gamestatus.user_id) && (self.gamestatus.nextturn % 2 === 1)))&&(!((self.gamestatus.player_2_id === self.gamestatus.user_id) && (self.gamestatus.nextturn % 2 === 0)))){
        alert('you can\'t drop!');
        return
    }
    let ele = event.target.id[1];
    let y = parseInt(ele, 10);
    if(self.map[0][y-1] !== 0){
        alert('full!')
    }
    else {
        let x = 1;
        for (;x<=6; x++){
            if(self.map[x-1][y-1] !== 0){
                x--;
                break;
            }
            if(x===6){
                break;
            }
        }
        let xhr=new XMLHttpRequest();
        xhr.open('POST','/game/'+self.gamestatus.game_id+'/');
        send_data = {
            method:'submit',
            pos:[x, y]
        };
        console.log(JSON.stringify(send_data));
        xhr.send(JSON.stringify(send_data));
        xhr.onreadystatechange=function (){
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    console.log('success')
                }
            }
        }
        self.gamestatus.turns.push([x, y]);
        self.advance(x, y, self.gamestatus.nextturn);
        let winner = self.checkwin(self.map);
        if(winner !== 0){
            self.gamestatus.over = true;
            let xhr=new XMLHttpRequest();
            xhr.open('POST','/game/'+self.gamestatus.game_id+'/');
            send_data = {
                method:'over',
                winner:winner
            };
            console.log(JSON.stringify(send_data));
            xhr.send(JSON.stringify(send_data));
            xhr.onreadystatechange=function (){
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        console.log('over success')
                    }
                }
            }
            if(winner === 1){
                if(self.gamestatus.user_id === self.gamestatus.player_1_id){
                    alert('You win!')
                }
                else if(self.gamestatus.user_id === self.gamestatus.player_2_id){
                    alert(self.gamestatus.player_1_name+' win!')
                }
            }
            else if(winner === 2){
                if(self.gamestatus.user_id === self.gamestatus.player_2_id){
                    alert('You win!')
                }
                else if(self.gamestatus.user_id === self.gamestatus.player_1_id){
                    alert(self.gamestatus.player_2_name+' win!')
                }
            }
            console.log('win');
        }
    }
}
game.checkwin = function(k){
    for(let i=0;i<6;i++){
        for(let j=0;j<7;j++){
            if (k[i][j] == 1 && k[i][j+1] == 1 && k[i][j+2] ==1 && k[i][j+3]==1)
            {
                return 1
            }
            else if(k[i][j] == 1 && k[i+1][j] == 1 && k[i+2][j] ==1 && k[i+3][j]==1)
            {
                return 1
            }else if (k[i][j] == 1 && k[i+1][j+1] == 1 && k[i+2][j+2] ==1 && k[i+3][j+3]==1)
            {

                return 1
            }else if (k[i][j] == 1 && k[i-1][j+1] == 1 && k[i-2][j+2] ==1 && k[i-3][j+3]==1)
            {

                return 1
            }else if (k[i][j] == 2 && k[i][j+1] == 2 && k[i][j+2] ==2 && k[i][j+3]==2)
            {
                return 2
            }
            else if(k[i][j] == 2 && k[i+1][j] == 2 && k[i+2][j] ==2 && k[i+3][j]==2)
            {
                return 2
            }else if (k[i][j] == 2 && k[i+1][j+1] == 2 && k[i+2][j+2] ==2 && k[i+3][j+3]==2)
            {

                return 2
            }else if (k[i][j] == 2 && k[i-1][j+1] == 2 && k[i-2][j+2] ==2 && k[i-3][j+3]==2)
            {

                return 2
            }

        }
    }
    return 0
}