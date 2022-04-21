package model.entities;

import java.util.Date;

public class Note {
	private int nOfNotes;
	private Date writtenDate;
	private String text;

	public Note() {
	}

	public Note(Date writtenDate, String text) {
		this.writtenDate = writtenDate;
		this.text = text;
	}

	public int getnOfNotes() {
		return nOfNotes;
	}

	public void setnOfNotes(int nOfNotes) {
		this.nOfNotes = nOfNotes;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return this.getText();
	}
}
