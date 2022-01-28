package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	
	static final String myprojectfilepath="D:\\Classes\\lockMeFiles";
	static final String errormessage="Some error occured please contact admin@lockedMe.com";
	

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int ch;
		do
		{
			displayMenu();
			System.out.println("Enter your choice");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			case 1:
				getAllFiles();
			break;
			case 2:
				createFiles();
				break;
			case 3:
				deleteFiles();
				break;
			case 4:
				searchFiles();
				break;
			case 5:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid option");
					break;
			
			}
		}
		while(true);
		

     
	}
	public static void displayMenu()
	{
		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*");
		System.out.println("\t\tWelocome to LockedMe.com by Saloni Swaroop");
		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*");
		System.out.println("\t\t1.Display All Files");
		System.out.println("\t\t2.Add A New File");
		System.out.println("\t\t3.Delete a file");
		System.out.println("\t\t4.Search a File");
		System.out.println("\t\t5.Exit");


	}
	/**
	 * This function returns list of all the files
	 */
	public static void getAllFiles()
	{
		try
		{
		File folder= new File(myprojectfilepath);
		File[] listOfFiles=folder.listFiles();
		if(listOfFiles.length==0)
			System.out.println("No Files exist in directory");
		else
		{
			
		   for (var l : listOfFiles)
		    {
			  System.out.println(l.getName());
		    }
		}
		
		}
	catch(Exception ex)
		{
		System.out.println(errormessage);
		}
	}
	/**
	 * Function to create New file
	 */
	public static void createFiles()
	{
		Scanner obj=new Scanner(System.in);
			try
			{ 
			String FileName;
			System.out.println("Enter the File Name");
			FileName=obj.nextLine();
			System.out.println("Enter no. of lines in file");
			int linesCount;
			linesCount=Integer.parseInt(obj.nextLine());
			FileWriter myWriter=new FileWriter(myprojectfilepath+"\\" +FileName);
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the file line");
				myWriter.write(obj.nextLine()+"/n");
			}
			System.out.println("File Created Successfully");
			myWriter.close();
	
		   }
		catch(Exception ex)
		{
			System.out.println(errormessage);
		}
	}
	/**
	 * This function deletes the file Name.
	 */
	public static void deleteFiles()
	{
		Scanner obj=new Scanner(System.in);
		try
			{
			String FileName;
			System.out.println("Enter the filename to be deleted");
			FileName=obj.nextLine();
			File file=new File(myprojectfilepath+"\\" +FileName);
			if(file.exists())
			{
			file.delete();
			System.out.println("File deleted Successfully"+FileName);
			}
			else
			{
				System.out.println("File does not exist");
			}
			}
			catch(Exception ex)
		{
				System.out.println(errormessage);
		}
		}
	/**
	 * Function to search any file name
	 */
	
	public static void searchFiles()
	{
		Scanner obj=new Scanner(System.in);
		try
			{
			String FileName;
			System.out.println("Enter the filename to be searched");
			FileName=obj.nextLine();
			File folder= new File(myprojectfilepath);
			File[] listOfFiles=folder.listFiles();
			LinkedList<String> filenames=new LinkedList<String>();
			
			for(var l:listOfFiles)
			{
				filenames.add(l.getName());
			}
			      if(filenames.contains(FileName))
			      {
				    System.out.println("File is found");
			      }
			else
			{
				System.out.println("File not found");
			}
			}
			catch(Exception ex)
		{
				System.out.println(errormessage);
		}

	}

}
