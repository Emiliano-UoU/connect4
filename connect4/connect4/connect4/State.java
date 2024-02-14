package connect4;

public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE2];
    public int getGameState(){
        return this.gameState;
    }

    public void setGameState (int gameState){
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return this.whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return this.xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return this.oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;

    }

    public boolean isWinner() {
        // for row
        int w=1; //x
        int z=2; //x
        int x=3; //x
        int y=4; //x

        int q=6;//y
        int r=5;//y
        int s=4;//y
        int t=3;//y

        int totalDL = getBoardCell(w, q) + getBoardCell(z, r) + getBoardCell(x, s)+ getBoardCell(y, t);
        for (int O = 0; O <(Constants.BOARD_SIZE2 -4); ++O){
            w++;
            z++;
            x++;
            y++;
            if(totalDL ==-4||totalDL == 4){
                return true;
            }
            return false;
        }
        q=q+1;
        r=r+1;
        s=s+1;
        t=t+1;
        for (int l = 0; l <(Constants.BOARD_SIZE2 -4); ++l){
            w=w-1;
            z=z-1;
            x=x-1;
            y=y-1;
            if(totalDL ==-4||totalDL == 4){
                return true;
            }
            return false;
        }
        
        return false;
    }

    public boolean isTie() {
        for(int r = 0 ; r<Constants.BOARD_SIZE; ++r) {
            for(int c=0; c<Constants.BOARD_SIZE; ++c){
                if (getBoardCell(r,c) == Constants.BLANK){
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        // Reset the board cells to BLANK
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                setBoardCell(row, col, Constants.BLANK);
            }
        }
    }
}

