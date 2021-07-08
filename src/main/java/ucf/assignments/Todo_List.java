/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */

package ucf.assignments;

import java.util.List;

public class Todo_List {
    //Set name
    //Set List of Items
    private String name;
    private List<Todo_Item> ItemList;

    //constructor for list
    public Todo_List(String name, List<Todo_Item> ItemList) {
        this.name = name;
        this.ItemList = ItemList;
    }

    //getter for list
    public String getName() { return name; }
    public List<Todo_Item> getItemList() { return ItemList; }

    //setter for list
    public void setName(String name) { this.name = name; }
    public void setItemList(List<Todo_Item> ItemList) { this.ItemList = ItemList; }
}
