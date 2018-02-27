/*InterIterApp.java
 *This is the main driver of the project. A dialog box prompts the user for input.
 *Validates the user input, and pass the input into the LinkList Class.
 *To run this program: C>java InterIterApp
 *Name: Josh Johnston
 *Date: 5/27/2015
 */
 
import java.util.Scanner;
import javax.swing.JOptionPane;   // for dialog box

public class InterIterApp{
   
   public static void main(String[] args){
      
	   
      int nPeople, start, pass;
      String input;
      boolean flag = true;   //a flag to terminate the while loop
      
		while(flag){
		
			flag = false;			
			input =JOptionPane.showInputDialog("Enter number of people,"    //prompting the user for input
                                                           + "\nstart, and pass.\n"
                                                           + "(only spaces between the numbers) ");
			
			//validating user input
			if(input == null){   //if ok or cancel is pushed without input the program exits
			
				return;
			}				
			else if(input.equals("stop") || input.matches("[A-Za-z]*\\D+")){ 
			                                                  //if input is stop or non-digits
				flag = false;                             //then flag becomes false and the while loop ends
			}
			else{
			
				
				try(Scanner scan = new Scanner(input);){   //created a new scanner object
					scan.useDelimiter( "\\D+" );
					nPeople = scan.nextInt();            //extracting integers from the string
					start = scan.nextInt();
					pass = scan.nextInt();	
				}
				
				LinkList theList = new LinkList();           // new list
                                ListIterator iter1 = theList.getIterator();  // new iter
		            
				iter1.createList(nPeople);             //inserting the number of people into a list
				iter1.WhereIsJosephus(start, pass);    //finding Josephus				
				flag = true;                          //loop repeats		            
			}			
			                          
		}//end of while
 }  // end main()  
//-------------------------------------------------------------
}  // end class InterIterApp
////////////////////////////////////////////////////////////////
