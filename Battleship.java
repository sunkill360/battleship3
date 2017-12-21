/*Sujit Kalva
Last Update: 10/11/11
Class: 1th pd  Klix
Description: Allowes user to play battleship with the computer. User plugs in points and 
computer responds.*/
import java.util.*;

public class Battleship{

   public static void main (String [] args){
      do{
         int numBoard [][] = new int [8][8];
         char display[][] = new char [8][8];
         fillArray(numBoard, display); 
         placeShip(numBoard); 
         guessing(numBoard,display);
      }while(choice());
   
   }
    //***********************************************************
   //name: fillArray(int [][] numBoard, char [][] display)
   //description: This method fills the display array with dots and 
   //             fills the number array with 0's
   //precondition: An int value for run is received.
   //postcondition: There is none               
   //***********************************************************

   public static void fillArray(int [][] numBoard, char [][] display)
   {
      for(int x=0;x<8;x++)
         for(int y=0;y<8;y++)
         {
            numBoard[x][y]= 0;
            display[x][y]='.';
         }
   }
   
   public static void placeShip(int [] [] numBoard){
      int HorV = (int)(Math.random()*2);      
      int row = (int)(Math.random()*8);      
      int col = (int)(Math.random()*8);     
   
   
      if (HorV==0)//Vertical is 0
      {
         if(row>=5)
         {
            numBoard[col][row]=1;
            numBoard[col][row-1]=1;
            numBoard[col][row-2]=1;
            numBoard[col][row-3]=1;
         }
         else
         {
            numBoard[col][row]=1;
            numBoard[col][row+1]=1;
            numBoard[col][row+2]=1;
            numBoard[col][row+3]=1;
         }
      }
         
      else
      {
         if(col>=5)//
         {
            numBoard[col][row]=1;
            numBoard[col-1][row]=1;
            numBoard[col-2][row]=1;
            numBoard[col-3][row]=1;
         }
         else
         {
            numBoard[col][row]=1;
            numBoard[col+1][row]=1;
            numBoard[col+2][row]=1;
            numBoard[col+3][row]=1;
         }     
      
      
      }     
   
   
   }
   //***********************************************************
   //name: guessing(int [][] numBoard, char [][] display)
   //description:This method takes the user coordinates and checks if it  
   //             is a hit or a miss
   //precondition: An int value for run is received.
   //postcondition: There is none               
   //***********************************************************

   public static void guessing(int[][]numBoard, char [][]display)
   {
      Scanner in = new Scanner(System.in);
      int guesses=15;
      System.out.println("You will be asked to input the column then row coordinate");
      int x,y,hit=0, hitAGAIN=0;
      for(int i=15;i>=1;i--){
      
         do{
            hitAGAIN=0;
            do{
               System.out.println("   0  1  2  3  4  5  6  7");
            
               for(int a=0;a<8;a++)
               {
                  System.out.print(a);
                  for(int b=0;b<8;b++)
                  {
                     System.out.print("  " +display[a][b]);
                     if(b==7)
                     {
                        System.out.println();
                           
                     }   
                  
                  
                  }
               }
            
               System.out.println("You have "+i+" torpedoes");
               System.out.println("Please enter the column ");
               x = in.nextInt();
               if(x<0 || x>7) 
                  System.out.println("Invalid Number");        
            }while(x<0 || x>7);
            do{
               System.out.println("Please enter the row ");
               y = in.nextInt();
               if(y<0 || y>7) 
                  System.out.println("Invalid Number") ;       
            }while(y<0 || y>7);
            if(numBoard[y][x]==0)
            {
               System.out.println("Miss!");
               numBoard[y][x]=2;
               display[y][x]='X';
            }
            else if(numBoard[y][x]==1)
            {
               System.out.println("Hit!");
               numBoard[y][x]=3;
               display[y][x]='!';
               hit++;
               
            }
            else
            {
               System.out.println("You have already chosen this coordinate");
               hitAGAIN=1;
               
            }
            
         }while(hitAGAIN>=1);
         if(hit==4)
            break;
         
      }
      if(hit==4)
         System.out.println("You Win!");
      else
      {
         System.out.println("You Lose!"); 
          
         System.out.println("Boat is made out of !");
      
      }
      System.out.println("   0  1  2  3  4  5  6  7");
            
         for(int a=0;a<8;a++)
         {
            System.out.print(a);
            for(int b=0;b<8;b++)
            {
               if(numBoard[a][b]==1)
                  display[a][b]='!';
               System.out.print("  " +display[a][b]);
               if(b==7)
               {
                  System.out.println();
                           
               }   
                  
                  
            }
         }

   }
   //***********************************************************
   //name:choice()
   //description: gets user input if they want to play again 
   //precondition: None
   //postcondition: returns a boolean statement             
   //***********************************************************

   public static boolean choice()
   {
      Scanner in = new Scanner(System.in);
      int choice;
      do{
         System.out.println("1.Play Again?"); 
         System.out.println("2.Quit"); 
         choice = in.nextInt();
         if(choice>2 || choice<1)
            System.out.println("Invalid Input");
      }while(choice>2 || choice<1);
      if(choice==1)
         return true;
      else 
         return false;
   }
}
   
