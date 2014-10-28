package mazeMania;

import java.util.Random;

public class mainRunner {
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	public static final int NUM_OF_EXITS = 10;
	public static void main(String[] args) {
		char[][] Maze = createMaze();
		int[] Position = getPosition(Maze);
		Maze[Position[0]][Position[1]] = 'X';
		printMaze(Maze);
	}
	public static int[] getPosition(char[][] Maze){
		Random Rand = new Random();
		int[] pos = new int[2];
		boolean end = false;
		while(!end){
			pos[0] = Rand.nextInt(HEIGHT);
			pos[1] = Rand.nextInt(WIDTH);
			if(Maze[pos[0]][pos[1]] == ' ')
				end = true;
		}
		return pos;
		
	}
	public static char[][] createMaze(){
		char[][] Maze = new char[HEIGHT][WIDTH];
		for(int i = 0; i < HEIGHT; i++){
			for(int j = 0; j < WIDTH; j++)
				Maze[i][j] = ' ';
		}
		for(int i = 0; i < HEIGHT; i++){
			Maze[i][0] = '*';
			Maze[i][WIDTH - 1] = '*';
		}
		for(int i = 0; i < WIDTH; i++){
			Maze[0][i] = '*';
			Maze[HEIGHT - 1][i] = '*';
			Maze[2][i] = '*';
			Maze[4][i] = '*';
			Maze[6][i] = '*';
		}
		Maze[0][1] = ' ';
		Maze[1][6] = '*';
		Maze[2][1] = ' ';
		Maze[2][7] = ' ';
		Maze[3][2] = '*';
		Maze[3][4] = '*';
		Maze[4][1] = ' ';
		Maze[4][3] = ' ';
		Maze[4][7] = ' ';
		Maze[5][4] = '*';
		Maze[6][3] = ' ';
		Maze[6][5] = ' ';
		Maze[6][7] = ' ';
		Maze[7][6] = '*';
		Maze[8][7] = ' ';

		return Maze;
	}
	public static void printMaze(char[][] Maze){
		for(int i = 0; i < HEIGHT; i++){
			for(char element : Maze[i])
				System.out.print(element + " ");
			System.out.println();
		}
				
	}
//	public static void createRandomMaze(){
//		char[][] Maze = new char[HEIGHT][WIDTH];
//		for(int i = 0; i < HEIGHT; i++){
//			for(int j = 0; j < WIDTH; j++)
//				Maze[i][j] = '*';
//		}
//		
//		Random Rand = new Random();
//		int exitNum = Rand.nextInt(NUM_OF_EXITS);
//		for(int i = 0; i < exitNum; i++){
//			int type = Rand.nextInt(1);
//			int row, col;
//			if(type == 0){
//				row = Rand.nextInt(HEIGHT);
//				col = Rand.nextInt(1);
//				if(col == 1)
//					col = WIDTH - 1;
//			}
//			else{
//				col = Rand.nextInt(WIDTH);
//				row = Rand.nextInt(1);
//				if(row == 1)
//					row = HEIGHT - 1;
//			}
//			Maze[row][col] = ' ';
//		}
//		
//	}
	//To randomize a maze
	//1. Fill with walls
	//2. Generate number of exits
	//3. Generate position of exit for each exit (Must be at the bounds)
	//4. Starting at each exit pick a direction that is not its previous direction (Must not be a bound)
	//5. Check if its a wall (It its a space, stop)
	//6. Create space at that direction (1 space)
	//7. Keep repeating 4 & 5 & 6 until stop
	//8. Do this for each exit
	
	
	
}
