package model.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Note;
import model.entities.Person;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		// Disclaimer**
		// The code in this project is
		// just me trying to get something done
		// by any means necessary, therefore the code is probably
		// not as optimized/organized as it could be.

		Person renato = new Person("Renato", "Freitas", 21);
		Person roberto = new Person("Roberto", "Araujo", 45);

		System.out.print("Number of notes: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		// Creating notes
		
		for (int i = 1; i <= n; i++) {
			Date date = new Date();
			System.out.printf("%dº Note: ", i);
			String txt = sc.nextLine();
			if (txt.isEmpty()) {
				System.out.printf("Failed to create %dº note, there is no text.%n", i);
			} else {
				renato.addNote(new Note(date, txt));
				System.out.printf("%dº note Successfully created!%n", i);
			}
		}
		
		// Adding notes to text file
		
		System.out.print("Type in the path for the notes: ");
		String path = sc.nextLine();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Note x : renato.getNote()) {
				bw.write(sdf.format(x.getWrittenDate()) + ". Note: " + x.getText());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		// Printing notes
		
		renato.printNotes();
		
		sc.close();
	}
}
