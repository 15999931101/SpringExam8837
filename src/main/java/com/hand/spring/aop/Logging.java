package com.hand.spring.aop;

public class Logging {
	   /** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	   public void beforeAdvice(){
	      System.out.println("Before	Insert	Film	Data.");
	   }
	   /** 
	    * This is the method which I would like to execute
	    * after a selected method execution.
	    */
	   public void afterAdvice(){
	      System.out.println("After	Insert	Film	Data");
	   }
	   /** 
	    * This is the method which I would like to execute
	    * when any method returns.
	    */
	   
	}