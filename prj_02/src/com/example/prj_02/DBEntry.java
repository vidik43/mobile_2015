package com.example.prj_02;

/**
 * @author vidik43
 */
public class DBEntry {

    private long id;
    private String text;
    private boolean selected;

    public DBEntry(long id) {
        this.id = id;
        this.text = "";
        this.selected = false;
    }

    public DBEntry(long id, String text) {
        this(id);
        this.text = text;
        this.selected = false;
    }

    public DBEntry(long id, String text, boolean selected) {
        this(id, text);
        this.selected = selected;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return String.format("%d \"%s\" - %b", this.id, this.text, this.selected);
    }
}
