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
		notes.add(note);
	}

	public void removeNote(Note note) {
		notes.remove(note);
	}
	
	public void printNotes() {
		for (Note x : getNote()) {
			System.out.println(sdf.format(x.getWrittenDate()) + " - " + this.getName() + " " + this.getLastName() + ", "
					+ "Note: " + x);
		}
	}
}
