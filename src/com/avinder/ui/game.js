
let game = {
    canvas:$("#myCanvas"),
    initCanvas: function(){
       this.canvas.width = 300;
       this.canvas.height = 300;
       let ctx = this.canvas[0].getContext("2d");
       ctx.fillStyle = "#e1e1e1";
       ctx.fillRect(0, 0, 300, 300);
    },
    clear: function(){
        this.canvas.clearRect(0,0,this.canvas.width, this.canvas.height);
    },
    inputForm : $("#inputForm")

}
let boardSizeInput ;

function submitForm(){
    let form = game.inputForm;
    boardSizeInput = form.find("#boardSize");

    console.log(boardSizeInput.val());
}

function main(){
    game.initCanvas();
    game.canvas.hide();

}
