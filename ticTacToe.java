
import java.util.Scanner;

public class ticTacToe{
	
	public static int checkRows(char[][] array) //finish this
	{
		int countX = 0;
		int countY = 0;
		int countDiagonalX = 0;
		int countDiagonalY = 0;
		for(int i = 0; i < 11; i ++)
		{
			for(int x = 0; x < 17; x++)
			{
				if(array[i][x] == 'X')
				{
					countX++;
				}
				else if(array[i][x] == 'O')
				{
					countY++;
				}
				
				
			}
			if(countX == 3 )
			{
				//System.out.println("3 in a row!!");
				return 1;
				
			}
			else if(countY == 3)
			{
				return 2;
			}
			else
			{
				countX = countY = 0;
			}
		}
		if(array[1][2] =='X' && array[5][8] == 'X' && array[9][14] == 'X')
		{
			return 1;
		}
		else if(array[1][14] =='X' && array[5][8] == 'X' && array[9][2] == 'X')
		{
			return 1;
		}
		else if(array[1][14] =='O' && array[5][8] == 'O' && array[9][2] == 'O')
		{
			return 2;
		}
		else if(array[1][2] =='O' && array[5][8] == 'O' && array[9][14] == 'O')
		{
			return 2;
		}
		else
		{
			return 3;
		}
		
		
	}
	
	public static void main(String[] args){
		Scanner keyboy = new Scanner(System.in);
		String userInput = "";
		int gameInput = 0;
		System.out.println("Do you want to play a game?? [y/n] -> ");
		userInput = keyboy.next();
		boolean start;
		boolean select = true;
		int three = 3;
		//char[] choice = new char[9];
		char[] choice = {'1', '2', '3', '4','5','6','7','8','9'};
		char[][] gameBoard = new char[12][17];
		int roundCount = 0;
		
		if(userInput.equals("y") || userInput.equals("Y"))
		{
			start = true;
		}
		else if(userInput.equals("n") || userInput.equals("N"))
		{
			System.out.print("bye");
			start = false;
		}
		else
		{
			System.out.println("bruh i told you to type y/n");
			start = false;
		}
		
		while(start == true && three == 3)
		{
			//three = checkRows(gameBoard);
			for(int i = 0; i < 11; i++)
			{
				for(int x = 0; x < 17; x++)
				{
					if(i==3 || i == 7 || x == 5 || x == 11)
					{
						gameBoard[i][x] = '*';
					}
					else if(i==1)
					{
						if(x == 2)
						{
							gameBoard[i][x] = choice[0];
						}
						else if(x == 8)
						{
							gameBoard[i][x] = choice[1];
						}
						else if(x == 14)
						{
							gameBoard[i][x] = choice[2];
						}
					}
					else if(i== 5)
					{
						if(x == 2)
						{
							gameBoard[i][x] = choice[3];
						}
						else if(x == 8)
						{
							gameBoard[i][x] = choice[4];
						}
						else if(x == 14)
						{
							gameBoard[i][x] = choice[5];
						}
					}
					else if(i== 9)
					{
						if(x == 2)
						{
							gameBoard[i][x] = choice[6];
						}
						else if(x == 8)
						{
							gameBoard[i][x] = choice[7];
						}
						else if(x == 14)
						{
							gameBoard[i][x] = choice[8];
						}
					}
					else
					{
						gameBoard[i][x] = ' ';
					}
					
					System.out.print(gameBoard[i][x]);
				}
				System.out.println();
				select = true;
			}
			three = checkRows(gameBoard);
			while(select == true && three == 3)
			{
				for(int z = 0;  z < 10; z++)
				{
					System.out.println();
				}
				if(roundCount %2 == 0)
				{
					System.out.print("X turn select a spot 1 - 9 -> ");
				}
				else
				{
					System.out.print("O turn select a spot 1 - 9 -> ");
				}
				gameInput = keyboy.nextInt();	
				
				if((gameInput >= 1 && gameInput <= 9) && (roundCount %2 == 0 ) && (choice[gameInput-1] != 'O') &&(choice[gameInput-1] != 'X'))
				{
					choice[gameInput-1] = 'X';
					roundCount++;
					select = false;
				}
				else if((gameInput >= 1 && gameInput <= 9) && (roundCount %2 != 0 )&& (choice[gameInput-1] != 'X') && (choice[gameInput-1] != 'O' ))
				{
					choice[gameInput-1] = 'O';
					roundCount++;
					select = false;
				}
				else
				{
					System.out.println("invalidselection");
					select = false;
				}
				for(int z = 0;  z < 10; z++)
				{
					System.out.println();
				}
				
			}
			if(roundCount == 9)
			{
				start = false;
			}

		}
		
		if(three == 1)
		{
			System.out.println("X wins!");
		}
		else if(three == 2)
		{
			System.out.println("O wins!");
		}
		
		
	}	
}