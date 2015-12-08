package com.example.prj_02;

/**
 * @author vidik43
 */
public enum ExtraData {

    TASK_TEXT("taskText"),
    TASK_ID("taskID");

    public final String NAME;

    ExtraData(String name) {
        this.NAME = name;
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
