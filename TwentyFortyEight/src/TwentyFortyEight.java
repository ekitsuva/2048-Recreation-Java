public class TwentyFortyEight{
    
    private Board board;
    
    public TwentyFortyEight(){
        board = new Board();
        board.setBoard();
        board.displayBoard();
        
    }
    
    public void displayBoard(){
        board.displayBoard();
    }
    public Board getBoard(){
        return board;
    }
    
    public void keyPressed(String key){
        if(key.equals("w")){
            moveUp();
        }else if(key.equals("a")){
            moveLeft();
        }else if(key.equals("d")){
            moveRight();
        }else if(key.equals("s")){
            moveDown();
        }else if(key.equals("w")){
            moveUp();
        }else if(key.equals("a")){
            moveLeft();
        }else if(key.equals("d")){
            moveRight();
        }else if(key.equals("s")){
            moveDown();
        }else{
            System.out.println("You have inputted an invalid value, please try again.");
        }
    }
    public void clear(){
        board.clear();
    }
    public void moveUp(){
        boolean movePos = false;
        boolean combinePos = false;

                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = 0; j < board.getBoard().length - 1; j++){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j+1][i] != null){
                            movePos = true;
                        }else if(board.getBoard()[j][i] != null && board.getBoard()[j+1][i] != null){
                            if(board.getBoard()[j][i].getNum() == board.getBoard()[j+1][i].getNum()){
                                combinePos = true;
                            }
                        }
                    }
                }

        System.out.println(movePos || combinePos);
        if(movePos || combinePos ){
            
            boolean move = true;
            while(move){
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = 0; j < board.getBoard().length - 1; j++){
                        if((board.getBoard()[j][i] == null) && board.getBoard()[j+1][i] != null){
                            board.setSquare(j, i, board.getBoard()[j+1][i].getNum());
                            board.emptySquare(j + 1, i);
                    
                        }
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = 0; j < board.getBoard().length - 1; j++){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j+1][i] != null){
                            move = true;
                        }
                    }
                }
            
            }
            for(int i = 0; i < board.getBoard()[0].length; i++){
                for(int j = 0; j < board.getBoard().length - 1; j++){
                    if(board.getBoard()[j][i] != null && board.getBoard()[j+1][i] != null){
                        if(board.getBoard()[j][i].getNum() == board.getBoard()[j+1][i].getNum()){
                            board.setSquare(j, i, board.getBoard()[j][i].getNum() + board.getBoard()[j+1][i].getNum());
                            board.emptySquare(j+1, i);
                        }
                
                    }
                }
            }
            move = true;
            while(move){
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = 0; j < board.getBoard().length - 1; j++){
                        if((board.getBoard()[j][i] == null) && board.getBoard()[j+1][i] != null){
                            board.setSquare(j, i, board.getBoard()[j+1][i].getNum());
                            board.emptySquare(j + 1, i);
                    
                        }      
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = 0; j < board.getBoard().length - 1; j++){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j+1][i] != null){
                            move = true;
                        }
                    }
                }
            }
    
            newSquare();
        }
    }
    public void moveDown(){
        boolean movePos = false;
        boolean combinePos = false;

                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = board.getBoard().length - 1; j > 0; j--){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j-1][i] != null){
                            movePos = true;
                        }else if(board.getBoard()[j][i] != null && board.getBoard()[j-1][i] != null){
                            if(board.getBoard()[j][i].getNum() == board.getBoard()[j-1][i].getNum()){
                                combinePos = true;
                            }
                        }
                    }
                }

        System.out.println(movePos || combinePos);
        if(movePos || combinePos ){
            
            boolean move = true;
            while(move){
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = board.getBoard().length - 1; j > 0; j--){
                        if((board.getBoard()[j][i] == null) && board.getBoard()[j-1][i] != null){
                            board.setSquare(j, i, board.getBoard()[j-1][i].getNum());
                            board.emptySquare(j - 1, i);
                    
                        }
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = board.getBoard().length - 1; j > 0; j--){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j-1][i] != null){
                            move = true;
                        }
                    }
                }
            
            }
            for(int i = 0; i < board.getBoard()[0].length; i++){
                for(int j = board.getBoard().length - 1; j > 0; j--){
                    if(board.getBoard()[j][i] != null && board.getBoard()[j-1][i] != null){
                        if(board.getBoard()[j][i].getNum() == board.getBoard()[j-1][i].getNum()){
                            board.setSquare(j, i, board.getBoard()[j][i].getNum() + board.getBoard()[j-1][i].getNum());
                            board.emptySquare(j-1, i);
                        }
                
                    }
                }
            }
            move = true;
            while(move){
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = board.getBoard().length - 1; j > 0; j--){
                        if((board.getBoard()[j][i] == null) && board.getBoard()[j-1][i] != null){
                            board.setSquare(j, i, board.getBoard()[j-1][i].getNum());
                            board.emptySquare(j - 1, i);
                    
                        }      
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard()[0].length; i++){
                    for(int j = board.getBoard().length - 1; j > 0; j--){
                        if(board.getBoard()[j][i] == null && board.getBoard()[j-1][i] != null){
                            move = true;
                        }
                    }
                }
            }
    
            newSquare();
        }
    }
    public void moveLeft(){
        boolean movePos = false;
        boolean combinePos = false;

                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j+1] != null){
                            movePos = true;
                        }else if(board.getBoard()[i][j] != null && board.getBoard()[i][j+1] != null){
                            if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j+1].getNum()){
                                combinePos = true;
                            }
                        }
                    }
                }

        System.out.println(movePos || combinePos);
        if(movePos || combinePos ){
            
            boolean move = true;
            while(move){
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                        if((board.getBoard()[i][j] == null) && board.getBoard()[i][j+1] != null){
                            board.setSquare(i, j, board.getBoard()[i][j+1].getNum());
                            board.emptySquare(i, j+1);
                    
                        }
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j+1] != null){
                            move = true;
                        }
                    }
                }
            
            }
            for(int i = 0; i < board.getBoard().length; i++){
                for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                    if(board.getBoard()[i][j] != null && board.getBoard()[i][j+1] != null){
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j+1].getNum()){
                            board.setSquare(i, j, board.getBoard()[i][j].getNum() + board.getBoard()[i][j+1].getNum());
                            board.emptySquare(i, j+1);
                        }
                
                    }
                }
            }
            move = true;
            while(move){
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                        if((board.getBoard()[i][j] == null) && board.getBoard()[i][j+1] != null){
                            board.setSquare(i, j, board.getBoard()[i][j+1].getNum());
                            board.emptySquare(i, j+1);
                    
                        }      
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = 0; j < board.getBoard()[0].length - 1; j++){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j+1] != null){
                            move = true;
                        }
                    }
                }
            }
    
            newSquare();
        }
    }
    public void moveRight(){
boolean movePos = false;
        boolean combinePos = false;

                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j-1] != null){
                            movePos = true;
                        }else if(board.getBoard()[i][j] != null && board.getBoard()[i][j-1] != null){
                            if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j-1].getNum()){
                                combinePos = true;
                            }
                        }
                    }
                }

        System.out.println(movePos || combinePos);
        if(movePos || combinePos ){
            
            boolean move = true;
            while(move){
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                        if((board.getBoard()[i][j] == null) && board.getBoard()[i][j-1] != null){
                            board.setSquare(i, j, board.getBoard()[i][j-1].getNum());
                            board.emptySquare(i, j-1);
                    
                        }
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j-1] != null){
                            move = true;
                        }
                    }
                }
            
            }
            for(int i = 0; i < board.getBoard().length; i++){
                for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                    if(board.getBoard()[i][j] != null && board.getBoard()[i][j-1] != null){
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j-1].getNum()){
                            board.setSquare(i, j, board.getBoard()[i][j].getNum() + board.getBoard()[i][j-1].getNum());
                            board.emptySquare(i, j-1);
                        }
                
                    }
                }
            }
            move = true;
            while(move){
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                        if((board.getBoard()[i][j] == null) && board.getBoard()[i][j-1] != null){
                            board.setSquare(i, j, board.getBoard()[i][j-1].getNum());
                            board.emptySquare(i, j-1);
                    
                        }      
                    }
                }
                move = false;
                for(int i = 0; i < board.getBoard().length; i++){
                    for(int j = board.getBoard()[0].length - 1; j > 0; j--){
                        if(board.getBoard()[i][j] == null && board.getBoard()[i][j-1] != null){
                            move = true;
                        }
                    }
                }
            }
    
            newSquare();
        }
    }
    public void newSquare(){
        int count = 0;
        while(count < 1){
            for(int i = 0; i < board.getBoard().length; i++){
                for(int j = 0; j < board.getBoard()[0].length; j++){
                    int random = (int) (Math.random() * 101);
                    if(random < 11 && count < 1 && (board.getBoard()[i][j] == null)){
                        board.setSquare(i, j, 2);
                        count++;
                    }else if(random == 11 && count < 1 && (board.getBoard()[i][j] == null)){
                        board.setSquare(i, j, 4);
                        count++;
                    }
                }
            }
        }
    }
    public boolean checkGameOver(){
        boolean gameOver = true;
        
        if(!winner()){
        
            for(int i = 0; i < board.getBoard().length; i++){
                for(int j = 0; j < board.getBoard()[0].length; j++){
                    if(board.getBoard()[i][j] == null){
                        gameOver = false;
                    }
                    try{
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i-1][j].getNum()){
                            gameOver = false;
                        }
                    }catch(Exception e){
                    
                    }
                    try{
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i+1][j].getNum()){
                            gameOver = false;
                        }
                    }catch(Exception e){
                    
                    }
                    try{
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j - 1].getNum()){
                            gameOver = false;
                        }
                    }catch(Exception e){
                    
                    }
                    try{
                        if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j+1].getNum()){
                            gameOver = false;
                        }
                    }catch(Exception e){
                    
                    }
                
                }
            }
        }else{
            System.out.println("You've Won!");
        }
        return gameOver;
    }
    public boolean checkWinnerGameOver(){
        boolean gameOver = true;
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[0].length; j++){
                if(board.getBoard()[i][j] == null){
                    gameOver = false;
                }
                try{
                    if(board.getBoard()[i][j].getNum() == board.getBoard()[i-1][j].getNum()){
                        gameOver = false;
                    }
                }catch(Exception e){
                
                }
                try{
                    if(board.getBoard()[i][j].getNum() == board.getBoard()[i+1][j].getNum()){
                        gameOver = false;
                    }
                }catch(Exception e){
                
                }
                try{
                    if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j - 1].getNum()){
                        gameOver = false;
                    }
                }catch(Exception e){
                
                }
                try{
                    if(board.getBoard()[i][j].getNum() == board.getBoard()[i][j+1].getNum()){
                        gameOver = false;
                    }
                }catch(Exception e){
                
                }
            
            }
        }
        return gameOver;
    }
    public boolean winner(){
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[0].length; j++){
                if(board.getBoard()[i][j] != null){
                    if(board.getBoard()[i][j].getNum() == 2048){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}