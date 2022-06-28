package myapp;
import java.util.Scanner;
public class MyData {
   
   ServerData obj = new ServerData();
   MyData(){		//constuctor
	   ServerData server = new ServerData();
	   this.obj = server;
	  }
  
 int savedata(StringBuffer tname,StringBuffer tnum,StringBuffer tmsg){   // save new contact
	 
	 int updatingrow = obj.vacantline;
	obj.chats[updatingrow][0] = new StringBuffer();
    obj.chats[updatingrow][0].append(tname);    
    obj.chats[updatingrow][1] = new StringBuffer();
    obj.chats[updatingrow][1].append(tnum);
    obj.chats[updatingrow][2] = new StringBuffer();
    obj.chats[updatingrow][2].append(tmsg);
    obj.vacantline++;
   
    System.out.println("current row: "+ updatingrow);
    System.out.println("nextchatnum row: "+ obj.vacantline);
    return updatingrow;
   }
 StringBuffer getname(){			//show name 
	    System.out.println();
	    System.out.println();
	    StringBuffer sbname = new StringBuffer();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter name to search ");
	    sbname.append(sc.nextLine());     // input string buffer name
	    return sbname;
	}
	int namesearch(StringBuffer sbname){		//search in database
	    System.out.println();
	    boolean flag=false;
	    String name = sbname.toString();
	    for(int row=0;row<obj.vacantline;row++){
	    	if(name.equals(obj.chats[row][0].toString())) {
	           flag = true; 
	           return row;
	    }flag = false;
	}	 if(!flag)
	    System.out.println("contact is not present in phone");
	    return 55;
	}
boolean compose(int rownum) {	  // sending new massage
	System.out.println("\n");
    Scanner sc = new Scanner(System.in);
    StringBuffer msg = new StringBuffer();
   	System.out.println("Enter your msg..");
   	msg.append(sc.nextLine());  // input new massage
    if(msg.toString().equals("back"))
    	return false;
    else 
    	obj.lastmsg[rownum][0]=new StringBuffer();
	    obj.lastmsg[rownum][0].append(msg);
        obj.chats[rownum][2].append("\n"+msg); 		//update database with new msg
       // obj.nextchatnum++;
        obj.chatwindow(rownum);						//show chating
        return true;
    
	}
	
boolean options(){
	StringBuffer sbname = new StringBuffer();
   StringBuffer sbnum = new StringBuffer();
   StringBuffer sbmsg = new StringBuffer();
   Scanner sc = new Scanner(System.in);
    int rownum = 0;
    boolean newcontact=false;
   System.out.println("\n");
   System.out.println("...Enter an option...");
   System.out.println("1. Open a chat");
   System.out.println("2. Massage new number");
   System.out.println("3. Massage existing");
   int option = sc.nextInt();
   boolean reapeat = true;
    switch(option){
    case 1:
     sbname = getname();
     rownum = namesearch(sbname);
     do {
         obj.chatwindow(rownum);
         reapeat = compose(rownum);
       }while(reapeat);
     newcontact=false;
      break;           
    case 2:
     sbname = getname();
     System.out.println("Enter mobile number ");
     sbnum.append(sc.next());
     sc.nextLine();
     System.out.println("Enter your massage");
     sbmsg.append(sc.nextLine());   
     rownum = savedata(sbname,sbnum,sbmsg);
     
     do {
          obj.chatwindow(rownum);
     
          reapeat = compose(rownum);
     
        }while(reapeat);
     newcontact=true;
      break;
    case 3:
     sbname = getname();
     rownum = namesearch(sbname);
do {
     obj.chatwindow(rownum);
//     System.out.println("\n\n press m: massge \n or  e: Exit !");
     reapeat = compose(rownum);
   }while(reapeat);
newcontact=false;
    }
	return newcontact;
   }


}	

