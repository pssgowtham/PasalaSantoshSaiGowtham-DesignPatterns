package com.epam.design_patterns;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.out.println("Creational Patterns:\n");
    	Creational a=new Creational();
    	a.baka();
    	System.out.println("\n\nStructural Patterns:\n");
    	Structural b=new Structural();
    	b.ittop();
    	System.out.println("\n\nBehavioral Patterns:\n");
    	Behavioral c=new Behavioral();
    	c.bakaittop();
    }
}
