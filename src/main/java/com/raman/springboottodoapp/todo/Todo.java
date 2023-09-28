package com.raman.springboottodoapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Size(min = 10, message = "Enter at-least 10 characters")
    private String description;
    private LocalDate date;
    private boolean done;

    public Todo() {

    }

    public Todo(int id, String name, String description, LocalDate date, boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", isCompleted=" + done +
                '}';
    }
}
