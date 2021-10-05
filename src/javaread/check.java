package javaread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class check 
{
	 
	

	

	public static String[] main(String[] args) throws IOException 
	   {
	      InputStream f1=new FileInputStream(new File("C:\\\\Users\\\\Helpdesk\\\\Documents\\\\so1_import.log")); //Creation of File Descriptor for input file
	      String[] words=null;  //Intialize the word Array
	      
	      //FileReader fr = new FileReader(f1);  //Creation of File Reader object
	      InputStreamReader isr = new InputStreamReader(f1,"UTF-8");  
	      BufferedReader br = new BufferedReader(isr); //Creation of BufferedReader object
	      String s;     
	     
	      String[] strArr = new String[20500];
	      int  i = 0,c = 0; //Intialize the word to zero
	      while((s=br.readLine())!=null)   //Reading Content from the file
	      {
	    	  words=s.split(" ");
	
     			  for (String word : words) 	
    	          {   // System.out.println(i);
     				 

     				    boolean st =s.contains("=========================START SAVE EDIT SO1==============="); 
    	                 if (st||i==1)   
    	                 {
    	                	
    	                	
    	                	 if(!word.isEmpty()) {
    	                		// System.out.println(word);
    	                		 boolean en =s.contains("=========================END SAVE EDIT SO1==============="); 

    	                     	 if (en) {
    	                     		 i=0;
    	                     		 
    	                     		
    	                     		
    	                     	 }else {
    	                		
    	                     		 
    	                     	 i=1;
        	                	 boolean getpara =s.contains("parameter"); 
        	                	 
        	             		 // System.out.println(h);
        	                      if (getpara){ 
        	                    	     int lon = words.length;
        	                    	     
        	                    	 
        	                    		 String asw = words[19];
        	                    		 
        	                    		 if(lon>20) {
        	                    			 for(int k =20;k-19<lon-19;k++) { 
        	                    			 asw=asw.concat(" "+words[k]);
        	                    			 strArr[c] = asw;
        	                    			 
        	                    			 }
        	                    			 
        	                    		 }
        	                    		 else {
        	                    			 strArr[c] = asw;
        	                    			 
        	                 			 }
        	               
        	                    		// System.out.println(c);
        	                    	     c++;
        	                    	    
        	     
        	                    	    
        	                 			 }
    	                		 
        	                      break;
    	                	 }
    	                	 } 
    	                     }                     
    	          }
     			
	      } br.close();
	      return strArr;
	 
	      

	      }

	



	   
}
