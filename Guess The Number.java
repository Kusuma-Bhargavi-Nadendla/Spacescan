import java.util.*;

class Main{

int max=100;
int min=1;
int chances=5;
   Main(){
         Scanner sc=new Scanner(System.in);
         int guess_no;
         int number=(int)Math.floor(Math.random()*(max-min+1)+min);

         System.out.println("A random number generated between 1 and 100\nYou have 5 chances. Guess the number....");
         for(int i=0;i<chances;i++){
                 guess_no=sc.nextInt();
                 if(guess_no==number){
                            System.out.println("Congratulations.... You Guessed the number.");
                            return;
                 }
                 else if(guess_no>number){
                           System.out.println(guess_no+" is greater than the number.");
                 }
                 else{
                           System.out.println(guess_no+" is smaller than the number.");
                 }
       }
          System.out.println(" Chances over... The number is "+number);
                 
   }

public static void main(String[] args){
     new Main();
}
}
                           
         
