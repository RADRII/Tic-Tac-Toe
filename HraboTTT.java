import java.util.Scanner;
import java.lang.String;
public class HraboTTT
{
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		String board[][] = {
				{"-","-","-"},
				{"-","-","-"},
				{"-","-","-"}};

		int i = welcome();


		boolean[] outcome = hasWon(board);
		while(outcome[0] == false && isFull(board) ==false)
		{

			printBoard(board);
			if(i%2 == 1)
			{
				System.out.println("Player ones turn!");
				int[] spot = getSpot(board);
				board[spot[0]][spot[1]] = "X";

			}
			else
			{
				System.out.println("Player twos turn!");
				int[] spot = getSpot(board);
				board[spot[0]][spot[1]] = "O";
			}
			i++;
			outcome = hasWon(board);
		}
		printBoard(board);
		printWinner(outcome);
		System.out.println("Bye");

	}
	public static void printWinner(boolean[] outcome)
	{
		if(outcome[0] == true && outcome[1] == true)
			System.out.println("Player 1 has won!");
		else if(outcome[0] == true)
			System.out.println("Player 2 has won!");
		else
			System.out.println("It's a draw!");
		
	}
	public static int[] getSpot(String[][]board)
	{

		int row = 0;
		int col = 0;
		int i = 0;
		int x = 0;
		while(x==0)
		{
			while(i ==0) //this while look gets their row
			{

				System.out.println("What row would you like to place in?(1-3)");
				row = sc.nextInt();
				row=row-1;
				if(row>2)
					System.out.println("Sorry you have entered an invalid number");
				else
					i++;

			}
			i = 0;
			while(i==0) //this while loop gets their col
			{
				System.out.println("What column would you like to place in?(1-3)");
				col = sc.nextInt();
				col=col-1;
				if(col>2)
					System.out.println("Sorry you have entered an invalid number");
				else
					i++;
			}
			i=0;
			if(board[row][col].equalsIgnoreCase("x") || board[row][col].equalsIgnoreCase("o"))
				System.out.println("Sorry you cannot put your chip in that spot, you will be brought back to the begining of the placing proces.");
			else
			{
				int[] spot = {row,col};
				return spot;
			}

		}
		return null; 


	}
	public static boolean isFull(String[][] grid)
	{

		int answer = 0;
		for (int row=0; row<grid.length; row++)
		{
			for (int col =0; col<grid[0].length; col++)
			{
				if(grid[row][col].equalsIgnoreCase("X") || grid[row][col].equalsIgnoreCase("O"))
					answer++;

			}
		}
		if(answer >= 9)
			return true;
		return false;
	}
	public static boolean[] hasWon(String[][] board)
	{
		String[] options = new String[9];
		options[0]= board[0][0] + board[0][1] + board[0][1];
		options[1]= board[0][0] + board[1][0] + board[2][0];
		options[2] = board[0][0] + board[0][1] + board[0][2];
		options[3] = board[0][0] + board[1][1] + board[2][2];
		options[4] = board[0][2] + board[1][1] + board[2][0];
		options[5] = board[0][1] + board[1][1] + board[2][1];
		options[6] = board[1][0] + board[1][1] + board[1][2];
		options[7] = board[0][2] + board[1][2] + board[2][2];
		options[8] = board[2][0] + board[2][1] + board[2][2];

		boolean[] whatHappened = new boolean[2];
		
		for(int i =0; i <9; i++)
		{
			if(options[i].equalsIgnoreCase("XXX"))
			{
				whatHappened[0] = true;
				whatHappened[1] = true;
				return whatHappened;
			}
			else if(options[i].equalsIgnoreCase("OOO"))
			{
				whatHappened[0] = true;
				whatHappened[1] = false;
				return whatHappened;
			}
		}
		whatHappened[0] = false;
		return whatHappened;


	}
	public static int welcome()
	{
		System.out.println("Welcome to two player Tic Tac Toe!");
		System.out.println("You each go one by one placing down your letters until someone wins, or neither of you win. What ever comes first.");
		System.out.println("The -'s represent blank spaces, you can put down your letters on them and only them");
		System.out.println("Player one is X, and player 2 is O");
		int ye = 0;
		while(ye == 0)
		{
			System.out.println("Who do you want to go first(enter 1 or 2)?");
			int i = sc.nextInt();
			if(i!=1 && i!=2)
				System.out.println("Please enter a valid number");
			else
				return i;
		}
		return ye; //never will get to this point just bc
	}
	public static void printBoard(String[][] grid)
	{
		System.out.println("     (1)   (2)   (3)");
		for (int row=0; row<grid.length; row++)
		{
			System.out.print("(" + (row+1) + ")");
			for (int col =0; col<grid[0].length; col++)
			{
				
				System.out.print((" | " + grid[row][col])+" |");
			}
			System.out.println();
		}

	}
}