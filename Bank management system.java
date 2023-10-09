import java.util.*;

class User{
    private String username,acc_no,acc_type,status;
    private double balance;
    public User(){
        username="";
        acc_no="";
        acc_type="";
        status="";
        balance=0;
    }
    public User(String username,String acc_no,String acc_type,double balance){
        this.username=username;
        this.acc_no=acc_no;
        this.acc_type=acc_type;
        this.balance=balance;
        this.status="Active";
    }
    public void displayUser(){
        System.out.println("\nUser details\nName of the Account holder:"+username+"\nAccount number:"+acc_no+
        "\nAccount type:"+acc_type+"\nCurrent Balance:"+balance+"\nStatus:"+status);
    }
    public void checkBalance (){
    System.out.println ("Your current Balance:" + balance);
    }
    public void withdrawMoney (double amount){
    if(status=="Blocked"){
        System.out.println("Your Account is Blocked.Consult the Bank for further details.");
        return;
    }
    if (amount > 0){
	        if (amount <= balance){
	                balance -= amount;
	                 System.out.println ("Withdraw successful\nYour current Balance:" +balance);
	        }else{
	                  System.out.println ("Insufficient balance");
	        }
    }else{
	System.out.println ("Invalid amount entered\nTry again...");
    }
    }
    public void depositMoney (double amount) {
        if(status=="Blocked"){
        System.out.println("Your Account is Blocked.Consult the Bank for further details.");
        return;
    }
    if (amount > 0){
	     balance += amount;
	     System.out.println ("Deposit successful\nYour current Balance:" +balance);
    }else{
	System.out.println ("Invalid amount entered\nTry again...");
     }
    }
    public String getAccNo (){
         return this.acc_no;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return this.status;
    }
}
class Employee {
    private static String username="employee", password="emp@123" ;
    
    private void blockAccount(String acc_no){
        int bui=Customers.findUser(acc_no);
        if(bui!=-1){
            Customers.userList[bui].setStatus("Blocked");
        }
        else{
            System.out.print("Account Number Invalid.");
        }
    }
    public static boolean validateEmployee(String uname,String pwd){
        if(username.equals(uname)&&password.equals(pwd)){
            return true;
        }
        return false;
    }
}
class Customers
{
  static int customers_count;
  static User[] userList = new User[20];


  public Customers ()
  {
    customers_count = 0;
  }
  public static int findUser (String acc_no){

    for (int i = 0; i < customers_count; i++){

	if (userList[i].getAccNo().equals (acc_no)){
         return i;
	}
    }
    return -1;
  }
  public static int createUser (String uname,String acc_no, String acc_type,double deposit)
  {
    userList[customers_count] = new User (uname,acc_no,acc_type,deposit);
    customers_count++;
    return customers_count - 1;
  }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String x,y,z;
		int option,k,uid;
		User user=new User();
		Customers list = new Customers ();
		while (true)
      {

      loop1:while (true)
	  {
	    System.out.
	      print ("1.User Login\n2.Employee Login\n3.Exit\nChoose your option:");
	    option = sc.nextInt ();
	    switch (option)
	      {
	      case 1:System.out.print ("Enter your Account Number:");
		         x = sc.next ();
		         k = Customers.findUser (x);
		         if(k==-1){
		             System.out.println("User not found. Try again...");
		         }else{
		              uid=k;
		              user = Customers.userList[k];
		              break loop1;
		         }
		         break;
		
		case 2:System.out.print ("Enter Username:");
		       x = sc.next ();
		       System.out.print ("Enter Password:");
		       y = sc.next();
		       if(Employee.validateEmployee (x, y))
		       {
		             System.out.println ("Login successful\n");
		             uid=-1;
		             break loop1;
		       }else{
		              System.out.println ("Login failed. Try again...\n");
		       }

		       break;
		
		
		case 3:System.exit(0);
		default:System.out.println("Invalid option.");
	}
	  }
	  loop2:while(true){
	      
	      if(uid==-1){
	              while(true){
	                  System.out.print("\n1.Display all Account details\n2.Search by Account Number\n3.Block Account\n4.Un Block Account\n5.Add new User\n6.Exit\nChoose your option:");
	                  option=sc.nextInt();
	                  switch(option){
	                      case 1:for(int i=0;i<Customers.customers_count;i++){
	                                   Customers.userList[i].displayUser();
	                            }
	                            break;
	                       case 2:System.out.print("Enter Account Number:");
	                             x=sc.next();
	                             k=Customers.findUser(x);
	                             if(k!=-1){
	                                 Customers.userList[k].displayUser();
	                             }else{
	                                 System.out.println("Account Number Invalid");
	                             }
	                             break;
	                       case 3:System.out.print("Enter Account Number to be Blocked:");
	                              x=sc.next();
	                             k=Customers.findUser(x);
	                             if(k!=-1){
	                                 if(Customers.userList[k].getStatus().equals("Blocked")){
	                                     System.out.println("Account is in Blocked status.");
	                                     break;
	                                 }
	                                 Customers.userList[k].setStatus("Blocked");
	                                 System.out.println("Account Blocked");
	                             }else{
	                                 System.out.println("Account Number Invalid");
	                             }
	                             break;
	                       case 4:System.out.print("Enter Account Number to be Un Blocked:");
	                              x=sc.next();
	                             k=Customers.findUser(x);
	                             if(k!=-1){
	                                 if(Customers.userList[k].getStatus().equals("Active")){
	                                     System.out.println("Account is in Active status.");
	                                     break;
	                                 }
	                                 Customers.userList[k].setStatus("Active");
	                                 System.out.println("Account Un Blocked");
	                             }else{
	                                 System.out.println("Account Number Invalid");
	                             }
	                             break;
	                       case 5:System.out.print("Enter Account holder name:");
		                          x=sc.next();
		                          System.out.print("Enter Account Number:");
		                           y=sc.next();
		                           System.out.print("Enter Account type:");
		                          z=sc.next();
		                          System.out.print("Enter Deposit money:");
		                          double d=sc.nextDouble();
		                          Customers.createUser(x,y,z,d);
		                          break;
	                       case 6:break loop2;
	                       default:System.out.println("Invalid option choosen.");
	                  }
	              }
	       
	          }else{
	              while(true){
	                  System.out.print("\n1.Check Balance\n2.Deposit money\n3.Withdraw money\n4.Get complete details\n5.Exit\nChoose your option:");
	                  option=sc.nextInt();
	                  switch(option){
	                      case 1:user.checkBalance();
	                             break;
	                      case 2:System.out.print("Enter amount to Deposit:");
	                             k=sc.nextInt();
	                             user.depositMoney(k);
	                             break;
	                      case 3:System.out.print("Enter amount to Withdraw:");
	                             k=sc.nextInt();
	                             user.withdrawMoney(k);
	                             break;
	                       case 4:System.out.println("Your Account details");
	                             user.displayUser();
	                             break;
	                       case 5:break loop2;
	                       default:System.out.println("Invalid option choosen.");
	                      
	                      
	                  }
	                      
	                  
	              }
	          }
	      
	         }
      }
}
}

