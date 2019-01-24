/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_runnable;


public class Csci230_runnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        Csci230_runnable run = new Csci230_runnable();
        Thread mythread = new Thread(run);
        mythread.start();
    }

}