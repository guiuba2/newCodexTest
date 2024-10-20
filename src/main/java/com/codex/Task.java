package com.codex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Serializable class to represent a Task
class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}

