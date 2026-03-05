import java.util.*;

// Main class for Tic Tac Toe game
class TicTacToe{

    // 3x3 game board initialized with empty spaces
    static char board[][]={{' ',' ',' '},
                        {' ',' ',' '},
                        {' ',' ',' '}};

    // Method to display the current board state
    public static void display(){
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        for(int i=1;i<3;i++){
            System.out.println("-----");
            System.out.println(board[i][0]+"|"+board[i][1]+"|"+board[i][2]);
        }
    }

    // Method to check if the current player has won
    public static boolean checkWin(int x,int y,char c){
        // x = row index of last move
        // y = column index of last move
        // c = current player's symbol ('X' or 'O')

        // Check the entire row of last move
        if(board[x][0]==c && board[x][1]==c && board[x][2]==c) return true;

        // Check the entire column of last move
        else if(board[0][y]==c && board[1][y]==c && board[2][y]==c) return true;
        
        // Check main diagonal (top-left to bottom-right)
        else if(x==y && board[0][0]==c && board[1][1]==c && board[2][2]==c) return true;
        
        // Check secondary diagonal (top-right to bottom-left)
        else if(x+y==2 && board[0][2]==c && board[1][1]==c && board[2][0]==c) return true;
        
        // If no condition matched, no win
        return false;
    }

    // Main method - program execution starts here
    public static void main(String [] arg){
        Scanner sc=new Scanner(System.in);
        int i=0;// Move counter (maximum 9 moves possible)
        char currentPlayer='X'; // First player starts with 'X'
        
        // Label for breaking the outer loop when game ends
        game:
        // Game runs until 9 valid moves
        while(9>i){

            // Loop until a valid position is entered
            while(true){
                display();// Show current board

                System.out.print("enter posion (0-8): ");
                int p=sc.nextInt();// Loop until a valid position is entered

                 // If user enters 999, exit the game
                if(p==999) break game;
                
                // Convert position (0–8) into row and column
                int x=p/3;
                int y=p%3;

                // Validate position
                // Check if input is within range and cell is empty
                if(p<0 || p>8 || board[x][y]!=' '){
                    System.out.println("enter write posion between 0 and 8");
                }
                else{
                    board[x][y]=currentPlayer;

                     // Check if current player wins
                    if(checkWin(x,y,currentPlayer)){
                        display();
                        System.out.print(currentPlayer);
                        System.out.println(" win ''''''");
                        break game; // End game
                    }
                    break;
                }
            }
            // Switch player using ternary operator
            currentPlayer=(currentPlayer=='X')? 'O':'X';

            i++; // Increment move counter
        }

        sc.close();

        // If all 9 moves completed and no winner, it's a draw
        if(i==9){
            display();
            System.out.println("match draw");
        }
    }
}