/*
Name: Joseph Park * Raymond Lam, Group 13
Date: September 2, 2014
Assignment: Lab 3, Problem 4.22
Input: User inputs how many marbles to take from a game of Nim
Process: Processes the computer's turn and determines who wins
Output: Outputs the winner
*/
package lab3_p4.pkg22;
import java.util.Scanner;
public class Lab3_P422 {
    static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        int pileSize = SetPileSize();
        int whoseTurn = SetFirstPlayer();
        int diff = SetDifficulty();
        boolean gameOver = false;
        System.out.println(diff);
        while(!gameOver){
            Display(pileSize);
            if(whoseTurn == 0){
                pileSize = CompTurn(diff,pileSize);
                if(CheckLoss(pileSize))
                    gameOver = true;
                else
                    whoseTurn = 1;
            }
            else{
                pileSize = PlayerTurn(pileSize);
                if(CheckLoss(pileSize))
                    gameOver = true;
                else
                    whoseTurn = 0;
            }
        }
        if(whoseTurn == 0)
            System.out.println("You won!");
        else
            System.out.println("Computer won!");

    }
    static int SetPileSize(){
        return (int)(Math.random() * 91) + 10;
    }
    static int SetFirstPlayer(){
        return (int)(Math.random() * 2);
    }
    static int SetDifficulty(){
        return (int)(Math.random() * 2);
    }
    static int CompTurn(int diff, int size){
        int remove;
        if(diff == 0) //Stupid
            remove = (int)(Math.random() * (size / 2)) + 1; 
        else{
            if(size >= 2){
                int powOfTwo, exp = 0;
                for(int i = 1; i <= 7; i++){
                    powOfTwo = (int)Math.pow(2, i);
                    if(powOfTwo > size){
                        exp = i - 1;
                        break;
                    }
                    else if(powOfTwo == size){
                        exp = i;
                        break;
                    }
                }
                remove = size - ((int)Math.pow(2, exp) - 1);
            }
            else
                remove = 1;
        }
        return size - remove;  
    }
    static int PlayerTurn(int size){
        int remove = 0;
        while(!CheckInput(remove,size)){
            System.out.println("Enter: ");
            remove = In.nextInt();
        }
        return size - remove;
    }
    static boolean CheckLoss(int size){
        return size == 0;
    }
    static boolean CheckInput(int input, int size){
        if(size > 1)
            return input >= 1 && input <= size / 2;
        else
            return input == 1;
    }
    static void Display(int size){
        System.out.println("Pile Size: " + size);
    }
}

/*
1
Pile Size: 59
Enter: 
-1
Enter: 
0
Enter: 
50
Enter: 
24
Pile Size: 35
Pile Size: 31
Enter: 
22
Enter: 
11
Pile Size: 20
Pile Size: 15
Enter: 
5
Pile Size: 10
Pile Size: 7
Enter: 
3
Pile Size: 4
Pile Size: 3
Enter: 
1
Pile Size: 2
Pile Size: 1
Enter: 
1
Computer won!
*/