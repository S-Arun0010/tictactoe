package tictactoe;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Tic {
	 static char[][] a = new char[3][3];
	 static PrintStream prints = new PrintStream(new FileOutputStream(FileDescriptor.out));
	
	public int check()
	{  
		if((a[0][0]=='X' && a[0][1]=='X' && a[0][2]=='X') || (a[0][0]=='X' && a[1][0]=='X' && a[2][0]=='X') ||
		   (a[1][0]=='X' && a[1][1]=='X' && a[1][2]=='X') || (a[0][1]=='X' && a[1][1]=='X' && a[2][1]=='X') ||
		   (a[2][0]=='X' && a[2][1]=='X' && a[2][2]=='X') || (a[0][2]=='X' && a[1][2]=='X' && a[2][2]=='X') ||
		   (a[0][0]=='X' && a[1][1]=='X' && a[2][2]=='X') || (a[0][2]=='X' && a[1][1]=='X' && a[2][0]=='X'))
		{
			prints.println("Player 1 Wins");
			return 1;
		}
		else if(   (a[0][0]=='O' && a[0][1]=='O' && a[0][2]=='O') || (a[0][0]=='O' && a[1][0]=='O' && a[2][0]=='O') ||
				   (a[1][0]=='O' && a[1][1]=='O' && a[1][2]=='O') || (a[0][1]=='O' && a[1][1]=='O' && a[2][1]=='O') ||
				   (a[2][0]=='O' && a[2][1]=='O' && a[2][2]=='O') || (a[0][2]=='O' && a[1][2]=='O' && a[2][2]=='O') ||
				   (a[0][0]=='O' && a[1][1]=='O' && a[2][2]=='O') || (a[0][2]=='O' && a[1][1]=='O' && a[2][0]=='O'))
				{
			prints.println("Player 2 Wins");
					return 1;
				}
		else
			return 0;
		
	}
	
	public static void main(String[] args)
	{   
		int res = 0;
		Tic tac = new Tic();
		Scanner sc = new Scanner(System.in); 
	    char x='0';
	    int count = 0;
	    
	    for(int i=0;i<9;i++)
	    {
	    	if(i%2 == 0)
	    	{
	    		prints.println("Player 1's turn:");
	    		x='X';
	    	}
	    	else
	    	{
	    		prints.println("Player 2's turn:");
	    		x='O';
	    	}
	    	prints.println("Enter the position:");
		    int c = sc.nextInt();
		    
	    switch (c)
	    {
	    case 1:
	    	a[0][0] = x;
	    	break;
	    case 2:
	    	a[0][1] = x;
	    	break;
	    case 3:
	    	a[0][2] = x;
	    	break;
	    case 4:
	    	a[1][0] = x;
	    	break;
	    case 5:
	    	a[1][1] = x;
	    	break;
	    case 6:
	    	a[1][2] = x;
	    	break;
	    case 7:
	    	a[2][0] = x;
	    	break;
	    case 8:
	    	a[2][1] = x;
	    	break;
	    case 9:
	    	a[2][2] = x;
	    	break;
	    default :
	    	prints.println("Enter valid position");
	    }
	    count++;
	    if(count >=5)
	       {
	    	res = tac.check();
	    	if(res == 1)
	    	{
	    	break;
	    	}
	    	else
	    		res =0;
	       }
	    }
	    for(int i=0;i<3;i++)
	    {
	    	for(int j=0;j<3;j++)
	    	{
	    		prints.print("|" + a[i][j] + "|");
	    	}
	    	prints.println("\n---------");	    	
	    }
	    if(res == 0)
	    {
	    	prints.println("Match Draw!!!");
	    }
	    
	}

}

