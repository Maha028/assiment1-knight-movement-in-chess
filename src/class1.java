
	// -----------------------------------------------------
			// Assignment 1
			// Written by: Maha Ali AL-Zboon 

	// -----------------------------------------------------
	import java.util.*;
	public class class1 {

		public static void main(String[] args) {
			  System.out.println("Hello, i'm MAHA");//welcome message which includes my name
			  Scanner keyboard=new Scanner (System.in);
			  int [][] board=new int[8][8];
			  int [] horizontal= new int[8];
			  int [] vertical=new int[8];
			  int moveNumber,counter=0,attempts;
			  int i,j,current_row,current_column,current_row2,current_column2;
			  for(i=0;i<=7;i++)
				    for(j=0;j<=7;j++)
				    	board[i][j]=0;
			  //------------------------------------

			  horizontal[0]=2;
			  horizontal[1]=1;
			  horizontal[2]=-1;
			  horizontal[3]=-2;
			  horizontal[4]=-2;
			  horizontal[5]=-1;
			  horizontal[6]=1;
			  horizontal[7]=2;
			  
			  vertical[0]=-1;
			  vertical[1]=-2;
			  vertical[2]=-2;
			  vertical[3]=-1;
			  vertical[4]=1;
			  vertical[5]=2;
			  vertical[6]=2;
			  vertical[7]=1;
			  
			  //--------------------------------
			  //Enter the first position of the knight
			  System.out.print("Enter first row position ");
			  int row =keyboard.nextInt();
			  while((row<1)||(row>8)) //Validate row number. 
			  { System.out.print("Value should be between 1 and 8\n");
			    System.out.print("Enter row value ");
			    row =keyboard.nextInt();
			    
			  }
			  
			  System.out.print("Enter first column position ");
			  int column= keyboard.nextInt();
			  while((column<1)||(column>8)) //Validate column number.
			  { System.out.print("Value should be between 1 and 8\n");
			    System.out.print("Enter column value ");
			    column= keyboard.nextInt();
			  }
			  row--;     //Reduce the row and column 1 to match the index
			  column--;

			  board[row][column]=1; //ensure this cell visited.
			  counter++; //Increase the counter to show the number of moves made.
			  current_row=row;    //Indicate that this is the first row and column.
			  current_column=column;

			  System.out.print("\nThe board with the initial position of the knight\n");
			  for(i=0;i<=7;i++)                //Print the initial board showing the cell visited
			    {for(j=0;j<=7;j++)
				System.out.print(board[i][j]);
				System.out.println();
			    }
			  
			  //----------------------------------------
			     //make moves on the table
			  
			  for(j=1;j<=63;j++) // Need to go to 63 since one is already visited on initialisation.
			  {  
				  System.out.print("Enter move number: ");
				  moveNumber=keyboard.nextInt();//This is the move number of the knight
				  current_row2=current_row;  //I used current_row2 and current_column2 as temporary variables.
			   	  current_column2=current_column;  //to test first if the move is ok.
			 		     /*If it is, I then give the the values stored
			 		     there in to current_row and current_columnumn. If the move is outside the board I then start from the current
			 		     position and try to make another correct move.*/
				   current_row2+=vertical[moveNumber];
				   current_column2+=horizontal[moveNumber];
				   attempts=0;
				   //try another move if the move outside the board
				    while(((current_row2>7)||(current_row2<0)) ||((current_column2>7)||(current_column2<0)))
				    {
				    	System.out.print("your move not valid, ");
				    	System.out.print("Enter move number: ");
				        moveNumber=keyboard.nextInt();
				        current_row2=current_row; //Start again from the current position
				        current_column2=current_column;
				        current_row2+=vertical[moveNumber];  
				        current_column2+=horizontal[moveNumber];
				        attempts++; //These are attempts to make a move.
				        if(attempts==20) { //If fails to make move in 20 attempts then shows that there are no legal moves possible.
				  
				        	System.out.println("No more legal moves possible");
				    	    j=100;    //to terminate the outer for loop.
				         }          
				     }//end while

				    //Test  cell visited or not.
				    if(board[current_row2][current_column2]==1) { //The cell visited if the value of cell = 1
				        System.out.println("the cell visited");
				    	j--;}
				    else          
				     {
				      current_row+=vertical[moveNumber];    //This part makes the actual move of the knight.
				      current_column+=horizontal[moveNumber]; 
				      board[current_row][current_column]=1; //Indicate that the cell has been visited.
				      counter++; //Count this move because its a valid move;
				     }
			    } //end for
			  System.out.println("\nThe board showing all the moves");
			  for(i=0;i<=7;i++)      //Print the whole board again.
			    {for(j=0;j<=7;j++)
			    	System.out.print(board[i][j]);
			    	System.out.println();
			    }
			  System.out.println("The number of moves made by the knight are "+counter);
			  
			  //----------------<3
			  System.out.println("The program is ended");//closing message 

		}

	}


