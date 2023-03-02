package tictactoe;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Tic {
	
	static PrintStream print = new PrintStream(new FileOutputStream(FileDescriptor.out));
	static int flag;
	public static  void display(char array[][],int dimension)
	{
		for(int i=0;i<dimension ;i++)
		{
			for(int j=0;j<dimension;j++)
			{   
				print.print("|" + array[i][j] + "|");
			}
			print.println();
			
		}
	}
	
	public static int checkcolumn(char array[][],int d,char x)
	{  
		 flag=0;
		for(int i=0;i<d;i++)
		{ 
			for(int j=0;j<d;j++)
			{
				if(array[j][i] == x)
				{
					flag =1;
					continue;
				}
				else
				{
					flag=0;
					break;
				}
			}
			if(flag == 1)
			{
				return 1;
			}
		}
		return 0;
	}
	
	public static int checkrow(char array[][],int d,char x)
	{     
		 flag=0;
		  for(int i=0;i<d;i++)
		  {
			  for(int j=0;j<d;j++)
			  {
				  if(array[i][j] == x)
				  {
					 flag=1;
					 continue;
				  }
				  else
				  {
					  flag=0;
					  break;
				  }
			  }if(flag==1)
			  {
				  return 1;
			  }
		  }
		  return 0;
	}
	
	public static int checkdiagnol(char array[][],int d,char x)
	{    
		 flag=0;
		for(int i=0;i<d;i++)
		{
			if((array[i][d-i-1] == x) ||(array[i][i] == x) )
			{
				flag = 1;
			}
			else
			{
				return 0;
			}		
		}
		return 1;
	}
	
	public static int getinput()
	{
		do
		{
			try
			{   
				Scanner sc = new Scanner(System.in);
				int value = sc.nextInt();
				return value;
			}
			catch(InputMismatchException e)
			{
				print.println(e);
				print.println("Re-enter the value:");
			}
		}while(true);
	}
	
	public static void main(String[] args)
	{   		
		print.println("Enter the dimension:");
		int dimension = getinput();
		int position;
		int count =0;
		char[][] box = new char[dimension][dimension];	
		ArrayList<Integer> list = new ArrayList<>(dimension);

		char x=' ';
		while(count < (dimension*dimension) )
		{    
			
			if(count % 2 == 0)
			{
				
				 print.println("1st player turn:");
				 x = 'x';
			}
			else
			{
				print.println("2nd player turn:");				
				 x = 'o';
			}
			position = getinput();
			if(list.contains(position) || position >(dimension*dimension)-1)
		    {
		    	print.println("Invalid Position or Its been already filled:");
		    	print.println("Re-enter the possition");
		    	continue;
		    }
		    else
		    {  
                  list.add(position);
		    }
			count++;
			int y=0;
			for(int i=0;i<dimension;i++)
			{
				for(int j=0;j<dimension;j++)
				{
					if(y == position-1 )
					{
						box[i][j] = x;
					}
					y++;
				}
			}
			
			if(count>=(dimension*2)-1)
			{   
				if(checkrow(box,dimension,x) == 1  )
				{
					print.println( "player " + x + " wins");
					display(box,dimension);
					System.exit(0);
				}
				else if(checkcolumn(box,dimension,x) == 1)
				{
					print.println("player " + x + " wins");
					display(box,dimension);
					System.exit(0);
				}
				else if(checkdiagnol(box,dimension,x) == 1)
				{
					print.println("player " + x + " wins");
					display(box,dimension);
					System.exit(0);
				}
				
			}
						
		}
		display(box,dimension);
		print.println("Match draw");
		
	}

}
