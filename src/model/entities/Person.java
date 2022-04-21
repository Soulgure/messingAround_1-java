package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Person {

	private String name;
	private String lastName;
	private int age;
	private Scanner sc = new Scanner(System.in);

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	List<Note> notes = new ArrayList<>();

	public Person() {
	}

	public Person(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Note> getNote() {
		return notes;
	}

	public void addNote(Note note) {
		this.addNote(note);
	}

	public void removeNote(Note note) {
		notes.remove(note);
	}

	public void createNote() {
		System.out.print("Number of notes: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			Date date = new Date();
			System.out.printf("%dº Note: ", i);
			String txt = sc.nextLine();
			if (txt.isEmpty()) {
				System.out.printf("Failed to create %dº note, there is no text.%n", i);
			} else {
				notes.add(new Note(date, txt));
				System.out.printf("%dº note Successfully created!%n", i);
			}
		}
	}

	public void addNoteToTxtFile() {
		System.out.print("Type in the path for the notes: ");
		String path = sc.nextLine();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Note x : notes) {
				bw.write(sdf.format(x.getWrittenDate()) + ". Note: " + x.getText());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

	public void printNotes() {
		for (Note x : getNote()) {
			System.out.println(sdf.format(x.getWrittenDate()) + " - " + this.getName() + " " + this.getLastName() + ", "
					+ "Note: " + x);
		}
	}
}
