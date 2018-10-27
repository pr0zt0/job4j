package ru.job4j.calculate;

/**
*	Класс Calculate выводит 
*	сообщение Hello World
*	
*	@author MKG
*	@version 1.0
*/
public class Calculate {
	/**
	*	Main
	*	@param args - arg.
	*	
	*/
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	/**
	*	Method echo.
	*	@param name Your name
	*	@return Echo plus your name
	*/
	public String echo(String name) {
		return "Echo, echo, echo: " + name;
	}
}