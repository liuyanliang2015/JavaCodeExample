// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Test.java

package com.test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Test
{

	public Test()
	{
	}

	public static void main(String args[])
	{
		ArrayList array = new ArrayList();
		array.add("java");
		array.add("javascript");
		array.add("golang");
		String s;
		for (Iterator it = array.iterator(); it.hasNext(); System.out.println(s))
			s = (String)it.next();

		System.out.println("------------------");
		for (int x = 0; x < array.size(); x++)
		{
			String s = (String)array.get(x);
			System.out.println(s);
		}

		System.out.println("------------------");
		String s;
		for (Iterator iterator = array.iterator(); iterator.hasNext(); System.out.println(s))
			s = (String)iterator.next();

	}
}
