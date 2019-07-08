package com.sanjana.canvas;

import com.sanjana.canvas.command.*;
import com.springer.nature.canvas.command.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class CanvasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CanvasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		final Map<String, Command> commandMap = getCommandMap();
		String[][] canvas = null;
		while (true) {
			System.out.print("enter command: ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine().trim();
			String command = input.split(" ")[0];
            try {
            	if(commandMap.containsKey(command)){
					commandMap.get(command).handle(input, canvas);
					continue;
				}
				System.out.println("Invalid input. For help Press 'H'.");
			}catch (Exception e){
				System.out.println(getErrorMessage().get(e.getClass()));
			}
		}
	}

	private Map<String, Command> getCommandMap(){
		final Map<String, Command> commandMap = new HashMap<>();
		commandMap.put("C", new CreateCanvasCommand());
		commandMap.put("L", new CreateLineCommand());
		commandMap.put("R", new CreateRectangleCommand());
		commandMap.put("B", new BucketFillCommand());
		commandMap.put("H", new HelpCommand());
		commandMap.put("Q", new ExitCanvasCommand());
		return commandMap;
	}

	private Map<Class, String> getErrorMessage(){
		final Map<Class, String> errorMap = new HashMap<>();
		errorMap.put(IllegalStateException.class, "Please provide all arguments. For help Press 'H'.");
		errorMap.put(ArrayIndexOutOfBoundsException.class, "Provided input is out of the canvas. Please provide valid input. For help Press 'H'.");
		errorMap.put(RuntimeException.class, "Please create canvas (eg: using 'C 20 4') first!");
		return errorMap;
	}
}
