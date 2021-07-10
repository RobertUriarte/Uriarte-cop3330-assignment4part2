/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */
package ucf.assignments;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.*;

public class TodoList_Controller implements Initializable {
    @FXML
    private TableView<Todo_Item> tableView;
    @FXML
    private TableColumn<Todo_Item, String> title;
    @FXML
    private TableColumn<Todo_Item, String> description;
    @FXML
    private TableColumn<Todo_Item, LocalDate> due_date;
    @FXML
    private TableColumn<Todo_Item, String> status;

    //Initialize Empty List<Todo_list>

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private DatePicker dueDatePicker;
    @FXML
    private TextField statusTextField;

    public ObservableList<Todo_Item> item_list = FXCollections.observableArrayList();

    //Initialize file chooser
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Set file chooser to a specific directory
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        due_date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setItems(item_list);

        tableView.setEditable(true);

        title.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void FilePrint(File file, List<Todo_List> list) {
        //Use print writer to print list data to our new file
        //Close file
    }


    public void ParseData(File file) {
        //Takes in a file, preferably a text file
        //Initialize a scanner
        //Scan line by line and scan for list and items within a list
        //Store these list and/or items in our already existing List of lists
    }

    @FXML
    public void DisplayAllButtonClicked(ActionEvent actionEvent) {
        //Set the tableview to display all items in the List of items of current List
        tableView.setItems(item_list);
    }

    @FXML
    public void DisplayIncompleteButtonClicked(ActionEvent actionEvent) {
        //Initialize new list
        //Copy over the items that don't have their status as "complete" into our new list
        //Set the tableview values to the newly created Incomplete items list

        FilteredList<Todo_Item> items = new FilteredList<>(item_list,b -> true);
        items.setPredicate(Todo_Item -> {
            if(Todo_Item.getStatus().equals("I") || Todo_Item.getStatus().equals("i")){
                return true;
            }
            else{
                return false;
            }
        });
        tableView.setItems(items);
    }

    @FXML
    public void DisplayCompletedButtonClicked(ActionEvent actionEvent) {
        //Initialize new list
        //Copy over the items that have their status as "complete" into our new list
        //Set the tableview values to the newly created Incomplete items list
        FilteredList<Todo_Item> items = new FilteredList<>(item_list,b -> true);
        items.setPredicate(Todo_Item -> {
            if(Todo_Item.getStatus().equals("C") || Todo_Item.getStatus().equals("c")){
                return true;
            }
            else{
                return false;
            }
        });
        tableView.setItems(items);
    }

    @FXML
    public void AddItemButtonClicked(ActionEvent actionEvent) throws IOException {
        //Create a new parent for the AddNewItem Scene
        //Create a new scene for AddNewItem scene
        //Create an Item with blank values
        //Sets tableview with the single blank item so it can be edited in order to create a new item from user.
        //Add new item to current List
        //Get the current stage we are on
        //Set the current stage to the AddNewItem scene

        Todo_Item new_item = new Todo_Item(titleTextField.getText(), descriptionTextField.getText(), dueDatePicker.getValue(), statusTextField.getText());
        tableView.getItems().add(new_item);
    }

    @FXML
    public void RemoveItemButtonClicked(ActionEvent actionEvent) {
        //Gets the index of the item
        //Removes that item from item list
        //Display new tableview with removed item

        ObservableList<Todo_Item> selectedRows, allItems;
        allItems = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        if(selectedRows != null)
            allItems.removeAll(selectedRows);

    }

    @FXML
    public void ClearAllButtonClicked(ActionEvent actionEvent) {
        ObservableList<Todo_Item> allItems, all;
        allItems = tableView.getItems();
        all = tableView.getItems();
        allItems.removeAll(all);
    }

    @FXML
    public void SaveButtonClicked(ActionEvent actionEvent) {
        //Initialize a file to be saved
        //Get all our items from current list to be saved
        //Call FilePrint() function
    }


    @FXML
    public void ChangeTitleCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the Title cell to new user input
        //Update the Title string value of our item

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setTitle(newCell.getNewValue().toString());
    }

    @FXML
    public void ChangeDescriptionCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the description cell to new user input
        //Update the Description string value of our item

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        String user_input = newCell.getNewValue().toString();
        if(user_input.length() < 1){
        }
        else if(user_input.length() > 256){
            String cutString = user_input.substring(1, 256);
            item_selected.setDescription(cutString);
        }
        else{
            item_selected.setDescription(user_input);
        }
    }

    @FXML
    public void ChangeDueDateCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the DueDate cell to new user input
        //Checks if user input is in YYY-MM-DD format
        //If input is not in correct format, input is changed to correct format
        //Update the Due Date string value of our item
        //Note: Date picker in Scene builder could be used here as alternative

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setDue_date((LocalDate) newCell.getNewValue());

    }

    @FXML
    public void ChangeStatusCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the status cell to new user input
        //Update the Status string value of our item

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setStatus(newCell.getNewValue().toString());
    }
}

