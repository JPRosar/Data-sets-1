//John Rosar
//COSC 2436
//Assignment 2


import java.util.Collections;

public class JohnRosarAssignment2{
	public static void main(String[] args) throws Exception {
	  int[] arr={};
	    JohnRosarArray arrlist = new JohnRosarArray(arr);
		  System.out.println(arr);

	    for(int i=0;i<arr.length;i++)
	     {
	    JohnRosarArrayList.insert(arr[i]);
	  }

	   JohnRosarQueue que = new JohnRosarQueue(100);
	    for(int i=0;i<arr.length;i++)
	     {
	    JohnRosarQueue.insert(arr[i]);
	    }
	}
	
	}


