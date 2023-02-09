package tictactoe;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Tic {
	 static char[][] a = new char[3][3];
	 static PrintStream prints = new PrintStream(new FileOutputStream(FileDescriptor.out));	
	public int check(char x)
	{   
		if( a[0][0] == x && a[1][1]==x && a[2][2]==x )
		{
		 	return 1;
	    }
		else if( a[0][2] == x && a[1][1]==x  && a[2][0]==x )
		 	return 1;
		for(int j=0;j<a.length;j++)
		{
			
			if((a[0][j] == x) && (a[1][j] == x) && (a[2][j] == x) )
			{
				return 1;
			}
			
		}
		for(int i=0;i<a.length;i++)
		{   			
			if((a[i][0] == x)  && (a[i][1] == x) && (a[i][2] == x) )
			{
				return 1;
			}			
		}		
		return 0;
	}
	public static void result(int count)
	{
		if(count%2 == 0)
		{
			prints.println("Player 2 Wins");
		}
		else
			prints.println("Player 1 Wins");
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
	    	res = tac.check(x);
	       }
	    	if(res == 1)
	    	{
	    		tac.result(count);
	    			
	    	 break;
	    	}
	    	else
	    		res =0;
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

