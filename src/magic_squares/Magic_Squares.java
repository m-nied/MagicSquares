/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package magic_squares;

/**
 *
 * @author Mike
 */
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Magic_Squares
{
    private static Scanner input = new Scanner(System.in);
//    private static String fileLoc = new String("");
//    private static File file = new File(fileLoc);
    private static int num=2;
    
    public static void main(String[] args) 
    { 
        menu();
    }
    public static void menu()
    {
        int choice=0;
    
       while(choice <=0 ||  choice > 3)//validates user choice
        {
            System.out.println("Enter the type of algorithm to execute: "
                            +"\n(1)\t Input magic values from file"
                            +"\n(2)\t Construct magic squares from input size and write to file"
                            +"\n(3)\t Exit");
            choice= input.nextInt();
        }
       // if(choice == 1)
           // inputMagicValues();
        
       if(choice == 2)
          constructMagicSquares();
        
        else
        {
            System.out.println("Thank You!");
            System.exit(0);
        }          
    }
    public static void constructMagicSquares()
    {
        try {
            PrintWriter outStream = new PrintWriter("5x5.txt");
       
//        System.out.println("Please enter a file name to save the magic squares");
//        String fileLoc = new String("");
//        
//        fileLoc=input.nextLine();
//        
//       File file = new File(fileLoc);
//        input.nextLine();
        while(num %2==0)
        {
            System.out.println("Please enter an odd number");
            num=input.nextInt();
        }//end while

        int[][] magic = new int[num][num];

        int row = num-1;
        int col = num/2;
        magic[row][col] = 1;

        for (int i = 2; i <= num*num; i++)
        {
            if (magic[(row + 1) % num][(col + 1) % num] == 0)
            {
                row = (row + 1) % num;
                col = (col + 1) % num;
            }//end if
            else 
            {
                row = (row - 1 + num) % num;
            }//end else
            magic[row][col] = i;
        }//end for

        // print results
        for (int i = 0; i < num; i++)
        {
            for (int j = 0; j < num; j++)
            {
                if (magic[i][j] < 10)  {
                    System.out.print(" ");  // for alignment
                    outStream.print(" ");  // for alignment
                }
                if (magic[i][j] < 100) {
                    System.out.print(" ");  // for alignment
                    outStream.print(" ");  // for alignment
                }
                System.out.print(magic[i][j] + " ");
                outStream.print(magic[i][j] + " ");
            }//end for
            System.out.println();
            outStream.println();
        }//end for
        
        //close the file stream
        outStream.close();
        
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Magic_Squares.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try
//        {
//            PrintWriter outStream = new PrintWriter("5x5.txt");
//            magic = new int[num][num];
//            row = num-1;
//            col = num/2;
//            magic[row][col] = 1;
//
//            for (int i = 2; i <= num*num; i++)
//            {
//                if (magic[(row + 1) % num][(col + 1) % num] == 0)
//                {
//                    row = (row + 1) % num;
//                    col = (col + 1) % num;
//                }//end if
//                else 
//                {
//                    row = (row - 1 + num) % num;
//                }//end else
//                magic[row][col] = i;
//            }//end for
//
//            for (int i = 0; i < num; i++)
//            {
//                for (int j = 0; j < num; j++)
//                {
//                    if (magic[i][j] < 10)  
//                        outStream.print(" ");  // for alignment
//                    if (magic[i][j] < 100) 
//                        outStream.print(" ");  // for alignment
//                    outStream.print(magic[i][j] + " ");
//                }//end for
//            outStream.println();
//            }//end for
//        }//end try
//        catch (IOException ex)
//        { 
//            System.out.println("IOERROR: " + ex.getMessage() + "\n"); 
//            ex.printStackTrace(); 
//        }//end catch

    }
}
