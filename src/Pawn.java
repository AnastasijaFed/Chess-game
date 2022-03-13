public class Pawn extends ChessPiece{

    public Pawn(String color){
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
      if(checkPosition(line)&&checkPosition(column)&&checkPosition(toLine)&&checkPosition(toColumn)&& chessBoard.board[line][column]!=null){
         int to, from;
          if(color.equals("Black")){
               from = 6;
               to = -1;
          }
          else {
               from = 1;
               to = 1;
          }
          if(to + line == toLine){
              return chessBoard.board[toLine][toColumn] == null;

          }

          if (line == from && line + 2 * to == toLine) {
              return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + to][column] == null;
          }

      } else {

          if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) &&
                  chessBoard.board[toLine][toColumn] != null) {
              return !chessBoard.board[toLine][toColumn].getColor().equals(color);
          } else return false;
      }return false;
    }




    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean checkPosition(int p) {
        if (p >= 0 && p <= 7) return true;
        else return false;
    }
}
