package Mini_Projects;

import java.util.Scanner;

class MyThread extends Thread{
	
    public void run(){
    	
    	Scanner sc= new Scanner(System.in);
    	System.out.print("Enter How Minutes You Want : ");
    	int time = sc.nextInt();
    	
    	System.out.println();
    	
    	int minutes = 1;
    	
        for(int i=0;i<time;i++){
        	
        	for(int j=1;j<=60;j++) {
        		try{
            		Thread.sleep(100);
            		System.out.println(i+" : "+j);
            	}
            	catch(InterruptedException ie){ 
            		
            	}        	
        	}
        	System.out.println("\n....... "+minutes+" Minute is Completes....... \n");
        	minutes++;
        }
        System.out.println("........Your Time is Finished.......");
        sc.close();
    }
}
public class Timer {

    public static void main(String[] args) {
    	
        MyThread t = new MyThread();
        t.start();
        
        System.out.println(".............++...Timer...++.............\n");
    }
}