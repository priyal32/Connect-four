import java.util.Scanner;
public class ConnectFour {
    // Comment for GitHub change

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be?");
        int rows = scnr.nextInt();
        System.out.print("What would you like the length of the board to be?");
        int columns = scnr.nextInt();
        char[][] array = new char[rows][columns];

        initializeBoard(array);
        printBoard(array);
        char player1Chip = 'x';
        char player2Chip = 'o';
        System.out.println("Player 1: " + player1Chip);
        System.out.println("Player 2: " + player2Chip +"\n");
        int col;
        int row;


        while(true){
            System.out.print("Player 1: Which column would you like to choose?");
            col = scnr.nextInt();
            row = insertChip(array,col,player1Chip);
            printBoard(array);
            if(checkIfWinner(array,col,row,player1Chip)){
                System.out.println("Player 1 won the game!");
                break;
            }
            System.out.print("Player 2: Which column would you like to choose?");
            col = scnr.nextInt();
            row = insertChip(array,col,player2Chip);
            printBoard(array);
            if(checkIfWinner(array,col,row,player2Chip)){
                System.out.println("Player 2 won the game!");
                break;
            }
            int countNullSpaces = 0;
            for(int i = 0; i < array[col].length - 1; i++){
                for(int j = 0; j<=i; j++ ) {
                    if (array[j][col] == '-') {
                        ++countNullSpaces;
                    }
                }
                if(array[row][i] == '-'){
                    ++countNullSpaces;
                }
            }
            if(countNullSpaces == 0){
                System.out.println("Draw. Nobody wins.");
                break;
            }

        }

    }

    public static void printBoard(char[][] array) {
        for (char[] holder : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(holder[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initializeBoard (char[][] array){
        for (char[] holder : array) {
            for (int j = 0; j < array[0].length; j++) {
                holder[j] = '-';
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType){
        int i;
        for(i = array.length - 1; i >= 0; i--){

            if (array[i][col] == '-')
            {
                array[i][col] = chipType;
                break;
            }
        }
        return i;
    }

    public static boolean checkIfWinner (char[][] array, int col, int row, char chipType){
        boolean win = false;
        int countColumn = 0;
        int countRow = 0;
        for(int i = 0; i <= array.length - 1; i++){
            for(int j = 0; j <= i; j++) {
                if(array[j][col] == chipType){
                    ++countColumn;
                } else {
                    countColumn = 0;
                }

            }
            if(array[row][i] == chipType){
                ++countRow;
            } else {
                countRow = 0;
            }
            if(countColumn >= 4 || countRow >= 4){
                win = true;
                break;
            } else {
                win = false;
            }
        }

        return win;
    }
}





