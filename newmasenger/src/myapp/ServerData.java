package myapp;

public class ServerData {
  int vacantline = 0;
  int numbers[]  = new int[50];
  StringBuffer lastmsg[][] = new StringBuffer[50][1];
  StringBuffer chats[][] = new StringBuffer[50][3];
//  MyData my =new MyData();
  String tempchats[] = {"aman","705888","mayu call me please !!","komal","957940","are you comming tomorow","mayu","726395","hii ! its been long time no see"};
  
   
  ServerData(){
	int i=0,j=2;
	boolean flag = true;
    for(int row = 0; row<3;row++){
    		for(int col=0;col<3;col++){
    			chats[row][col]= new StringBuffer();
    			chats[row][col].append(tempchats[i]);
    			i++;        
    		}	vacantline++;
    			if(row>2) {
    				break;    				
    			}
    				lastmsg[row][0] = new StringBuffer();
    				lastmsg[row][0].append(tempchats[j]);
    				j += 3;
       }
  }
        
  
  void showhomechats(int lastinput){ //showing home window of app
	  System.out.print("===============================================\n");
	  System.out.println("\t      MASSENGER 2.0 HOME\t");
	  System.out.print("===============================================");
    for(int row = 0; row<lastinput;row++){
    	System.out.println("\n_______________________________________________");
            System.out.print(" "+chats[row][0]+"  \n");
            System.out.print("   "+lastmsg[row][0]+"  ");
    
        } 
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  void chatwindow(int rownum){   // chating screen
	  System.out.println("\n\n\n");
	  System.out.println("enter back to go homepage");
    System.out.println("--------------------------------");
    System.out.println(" 	  "+chats[rownum][0]+"  ("+chats[rownum][1]+")");
    System.out.println("--------------------------------");
    System.out.println(this.chats[rownum][2]);
    }   
  } //end of class