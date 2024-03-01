/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author ADMIN
 */
public class myThread  extends Thread{
    private Thread t;
    private int x;

   myThread(int i) {
        this.x = i;
    }

    @Override
    public void run() {
        try {
            if(this.x==0){
                for(int i=0; i<=10; i++)
                    if(i%2==0){ System.out.print(i+" "); Thread.sleep(50);}
            }
            if(this.x==1){
                for(int i=0; i<=10; i++)
                    if(i%2!=0){ System.err.print(i+" "); Thread.sleep(50);}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myThread t1 = new myThread(1);
        myThread t2 = new myThread(0);
        t1.setPriority(MAX_PRIORITY);
        t2.setPriority(MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
