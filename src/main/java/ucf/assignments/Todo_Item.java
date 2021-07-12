/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;



public class Todo_Item {
    //Set name
    //Set description
    //Set due date
    //Set status
    private SimpleStringProperty title;
    private SimpleStringProperty description;
    private SimpleStringProperty date;
    private SimpleStringProperty status;

    //constructor for item
    public Todo_Item(String title, String description, String date, String status) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
    }

    //getter for item
    public String getTitle() { return title.get(); }
    public String getDescription() { return description.get(); }
    public String getDate() { return date.get(); }
    public String getStatus() { return status.get(); }



    //setter for item
    public void setTitle(String title) { this.title = new SimpleStringProperty(title); }
    public void setDescription(String description) { this.description = new SimpleStringProperty(description); }
    public void setDate(String date) { this.date = new SimpleStringProperty(date); }
    public void setStatus(String status) { this.status = new SimpleStringProperty(status); }


}
