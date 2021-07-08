/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */
package ucf.assignments;

public class Todo_Item {
    //Set name
    //Set description
    //Set due date
    //Set status
    private String name;
    private String description;
    private String due_date;
    private String status;

    //constructor for item
    public Todo_Item(String name, String description, String due_date, String status) {
        this.name = name;
        this.description = description;
        this.due_date = due_date;
        this.status = status;
    }

    //getter for item
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDue_date() { return due_date; }
    public String getStatus() { return status; }


    //setter for item
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setDue_date(String due_date) { this.due_date = due_date; }
    public void setStatus(String status) { this.status = status; }

}
