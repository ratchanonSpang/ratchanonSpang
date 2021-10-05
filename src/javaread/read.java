package javaread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;






public class read
{

public static void main(String[] args) throws IOException 
   {
	 
	 String[] ar = check.main(args);
	
	  
	  File query=new File("src\\query.txt");
	  FileWriter fw = new FileWriter(query);
	  PrintWriter pw = new PrintWriter(fw);
	  
	  
	  File f1=new File("C:\\\\Users\\\\Helpdesk\\\\Documents\\\\so1_import.log"); //Creation of File Descriptor for input file
      String[] words=null;  //Intialize the word Array
      FileReader fr = new FileReader(f1);  //Creation of File Reader object
      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
      String s;     
      String start="=========================START";   // Input word to be searched
      //String end="id=?";
      String update="[]";
      int count=0; //Intialize the word to zero
      int i = 0;
      int l=0;
      int k = 0;
      while((s=br.readLine())!=null)   //Reading Content from the file
      {
    	  
          words=s.split(" ");  //Split the word using space
          for (String word : words) 	
          {  
        	  
                 if (word.equals(start)||i==1)   //Search for the given word
                 {

                 	
                		
                     	//System.out.println(word);
                	 if(!word.isEmpty()) {
                		
                		
                	 
                     boolean end = s.contains(": binding parameter [1] as");

                 	 if (end) {
                 		 i=0;
                 		 l=0;
                 		count++;
                 		pw.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+count+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                 		//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+count+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                 		
                 	 }else {
                 		 
                 		 
                 		 i = 1;
                 		
                		 boolean up = word.contains("update"); 
                		 if (up||l==1) {
                			 l=1;
                			 String reword = word;
                			 boolean isFound = word.contains("?"); 
                			 
                    		 if (isFound) { 
                    			 String nw;
                    			 
                    			  if(ar[k].equals(update)) {
                    				  ar[k]=ar[k].replace("[]","[\"\"]");
                    				  
                    			  }
                    			    nw = ar[k].substring(1,ar[k].length()-1);
                     				reword= word.replace("?",nw);
                     				k++;
                     				/*System.out.print(m+word); //check para
                     				m++; 
                     				if(m>250) {
                     					m=0;
                     				}*/
                    			 }
                    		 pw.println(reword); //check
                    	
                    		// System.out.println(reword);
                    		
                		 }
                 		 
                 	 }
                 		 
                 	 }
                 	 
                    }
       
    
                     }
                
                 
         
      }
      if(count!=0)  //Check for count not equal to zero
      {
         System.out.println("The given word is present for "+count+ " Times in the file");
      }
      else
      {
         System.out.println("The given word is not present in the file");
      }
      
         fr.close();
         pw.close();
   }
 





   }
