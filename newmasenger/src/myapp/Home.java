package myapp;
import java.util.Scanner;
public class Home extends MyData {  

	public static void main(String[] args) {
		MyData mydata = new MyData();
       Scanner sc = new Scanner(System.in);
      boolean repeat = true;
    
      do {
    	   mydata.obj.showhomechats(mydata.obj.vacantline ); 
       boolean newcontact = mydata.options();
      
       System.out.println("Enter q for Exit app or r for Home page options");
       String ch = sc.next();
       if(ch.equals("q")){
    	   System.out.println("thanks to use massenger 2.0");
    	   repeat = false;
       }else {
    	   repeat = true;
         }
      }while(repeat);
       
    }
}