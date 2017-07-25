package com.modelssm.thread;

public class TestTread extends Thread {
	 @Override
	    public void run()
	    {
	        String name = Thread.currentThread().getName();
	        int i = 0;
	        for(i = 0;i<10;i++)
	        {
	            System.out.println(name+":--- "+i);
	        }
	        try
	        {
	            Thread.sleep(1000);
	        } catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	        for( ;i<20;i++)
	        {
	            System.out.println(name+":-- "+i);
	        }
	    }
	    public static void main(String[] args)
	    {
	        Thread thread = new TestTread();
	        thread.start();
//	        thread.run();
	        try
	        {
	            Thread.sleep(1000);
	        } catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	         
	        String name = Thread.currentThread().getName();
	        for(int i = 0;i<10;i++)
	        {
	            System.out.println(name+":撒 "+i);
	        }
	     
	         
	    }
}
