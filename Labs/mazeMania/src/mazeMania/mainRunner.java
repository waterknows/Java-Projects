package mazeMania;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class mainRunner {
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	public static final int NUM_OF_EXITS = 10;
	
	
	public static void main(String[] args) {
		char[][] Maze = createMaze();
		int[] Position = getPosition(Maze);
		ArrayList<Point> truePath = new ArrayList<Point>();
//		Maze[Position[0]][Position[1]] = 'X';
		int start_r = Position[0];
		int start_c = Position[1];

//		printMaze(Maze);
		printMazeAt(Maze, start_r, start_c);
		System.out.println("-------------------------");
		boolean isComplete = false;
		recursiveWalk(Maze,-1, -1, start_r,start_c, truePath, isComplete);
		for (Point point : truePath) {
			printMazeAt(Maze, point.x, point.y);
		}
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
	
	public static void printMazeAt(char[][] Maze, int r, int c){
		for(int i = 0; i < HEIGHT; i++){
			for (int j = 0; j < Maze[i].length; j++) {
				if( i == r && j == c)
					System.out.print( "O" + " ");
				else
					System.out.print(Maze[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
//	public static void createRandomMaze(){
//		char[][] Maze = new char[HEIGHT][WIDTH];
//		//Fill Maze with walls
//		for(int i = 0; i < HEIGHT; i++){
//			for(int j = 0; j < WIDTH; j++)
//				Maze[i][j] = '*';
//		}
//		//Gets number of exits
//		Random Rand = new Random();
//		int exitNum = Rand.nextInt(NUM_OF_EXITS);
//		//Adds the exits to the maze
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
//		//
//		for(int i = 0; i < HEIGHT; i++){
//			if(Maze[i][0])
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
	
	
	static boolean recursiveWalk(char[][] array, 
			int prev_r, int prev_c,
			int current_r, int current_c, ArrayList<Point> truePath, boolean isComplete) {

//		System.out.println("Printing position of path : ");
//		System.out.println("(" + current_r + "," +  current_c + ")" );
		printMazeAt(array, current_r, current_c);
		
		if(checkExit(current_r, current_c)) {
			System.out.println("Exit coordinate : " + current_r + "," + current_c);
			isComplete = true;
			return true;
		}

		boolean[] holdPath = new boolean[4];
		
		if(checkIfNotWall(array, current_r, current_c - 1) 
				&& 
				(current_r != prev_r && (current_c - 1) != prev_c) )
				holdPath[0] = recursiveWalk(array, 
						current_r, current_c,  
						current_r, current_c - 1,
						truePath,
						isComplete);
		if(checkIfNotWall(array, current_r + 1, current_c)
				&& 
				(current_r + 1 != prev_r && current_c != prev_c) )
				holdPath[1] = recursiveWalk(array,
						current_r, current_c,
						current_r + 1, current_c,
						truePath,
						isComplete);
		if(checkIfNotWall(array, current_r, current_c + 1)
				&& 
				(current_r != prev_r && (current_c + 1) != prev_c) )
				holdPath[2] = recursiveWalk(array,
						current_r, current_c,
						current_r, current_c + 1,
						truePath,
						isComplete);
		if(checkIfNotWall(array, current_r -1 , current_c)
				&& 
				(current_r - 1 != prev_r && (current_c) != prev_c) )
				holdPath[3] = recursiveWalk(array,
						current_r, current_c,
						current_r - 1, current_c,
						truePath,
						isComplete);
		
		
		if(isComplete)
			truePath.add(new Point(current_r, current_c));

		return false;
	}
	
	static boolean checkIfNotWall(char[][] array, int row, int col) {
		if(array[row][col] == ' ')
			return true;
		return false;
	}
	static boolean checkExit(int current_r, int current_c) {
		if(current_r == 0 || current_r == HEIGHT - 1)
			return true;
		if(current_c == 0 || current_c == WIDTH - 1)
			return true;
		return false;
	}
	
	static void scanavailable(boolean[] availablespots, char[][] array,
								 int direction,
								 int current_r, int current_c) {
		// check left
		availablespots[0] = (array[current_r][current_c - 1] == ' ' ? true : false);
		// check down
		availablespots[1] = (array[current_r + 1][current_c] == ' ' ? true : false);
		// check right
		availablespots[2] = (array[current_r][current_c + 1] == ' ' ? true : false);
		// check up
		availablespots[3] = (array[current_r - 1][current_c] == ' ' ? true : false);
			
		switch (direction) {
		case 0:
			availablespots[2] = false;
			break;
		case 1:
			availablespots[3] = false;
			break;
		case 2:
			availablespots[0] = false;
			break;
		case 3:
			availablespots[1] = false;
			break;
		default:
			break;
		}
	}
	
	
	
}
