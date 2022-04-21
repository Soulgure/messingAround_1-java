package model.application;

import model.entities.Person;

public class Program {
	public static void main(String[] args) {

		// Disclaimer**
		// The code in this project is
		// just me trying to get something done
		// by any means necessary, therefore the code is probably
		// not as optimized/organized as it could be.

		Person renato = new Person("Renato", "Freitas", 21);
		Person roberto = new Person("Roberto", "Araujo", 45);

		renato.createNote();
		renato.printNotes();
		renato.addNoteToTxtFile();
	}
}
