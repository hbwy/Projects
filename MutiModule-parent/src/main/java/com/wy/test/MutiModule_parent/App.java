package com.wy.test.MutiModule_parent;

import com.wy.test.dao.Dao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Dao dao = new Dao();
    	dao.say();
       System.out.println("testParent.....................");
    }
}
