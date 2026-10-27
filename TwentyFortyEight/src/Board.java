public class Board {
    
    private Square[][] board = new Square[4][4];
    
    public void displayBoard(){
        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[0].length; j++){
                
                if(board[i][j] == null){
                    System.out.print("[ ]");
                }else{
                    System.out.print("[" + board[i][j].getNum() + "]");
                }
            }
            System.out.print("\n");
        }
    }
    
    public void setBoard(){
        int count = 0;
        while(count < 2){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    int random = (int) (Math.random() * 101);
                    if(random < 11 && count < 2){
                        board[i][j] = new Square(2);
                        count++;
                    }else if(random == 11 && count < 2){
                        board[i][j] = new Square(4);
                        count++;
                    }else if(random == 1 || count > 1){
                        if(board[i][j] != null){
                            
                        }else{
                            board[i][j] = null;
                        }
                    }
                }
            }
        }
    }
    
    public void setSquare(int y, int x, int value){
        board[y][x] = new Square(value);
        
    }

    public void emptySquare(int y, int x){
        board[y][x] = null;
    }
    public Square[][] getBoard(){
        return board;
    }
    public void clear(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = null;
            }
        }
    }
}