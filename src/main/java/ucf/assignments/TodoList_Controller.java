/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TodoList_Controller implements Initializable {

    //Initialize Empty List<Todo_list>

    //Initialize file chooser
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Set file chooser to a specific directory
    }

    @FXML
    public void FileSaveClicked(ActionEvent actionEvent) {
        //Initialize a file to be saved
        //Get all the list to save all the items from our Existing List<Todo_list>
        //Call FilePrint(file,all the list) function
    }

    public void FilePrint(File file, List<Todo_List> list){
        //Use print writer to print list data to our new file
        //Close file
    }

    @FXML
    public void FileLoadClicked(ActionEvent actionEvent) {
        //Initialize a file to the file selected by the user
        //Call ParseData() function to get the data from the file selected
        //Display newly updated List(s)
    }

    public void ParseData(File file){
        //Takes in a file, preferably a text file
        //Initialize a scanner
        //Scan line by line and scan for list and items within a list
        //Store these list and/or items in our already existing List of lists
    }

    @FXML
    public void ListSelectedMouse(ActionEvent actionEvent){
        //Store list name in string
        //Get index of selected list
        //Set the text bar to list name selected
        //return value of text bar
    }

    @FXML
    public void ViewButtonClicked(ActionEvent actionEvent) {
        //Get the index of the list selected
        //Create a new parent for the ItemsView Scene
        //Create a new scene for ItemsView scene
        //Get the current stage we are on
        //Set the current stage to the ItemsView scene
        //Set values of Table view to the selected list's values
    }

    @FXML
    public void EditButtonClicked(ActionEvent actionEvent) {
        //Get the text in the text bar/User input for the new name
        //Set the name of the current list with the new name
        //Display updated values
    }

    @FXML
    public void AddButtonClicked(ActionEvent actionEvent) {
        //Get the text in the text bar
        //Create a new empty list with name in text bar
        //Add new list to List of lists
        //Display updated List of lists
    }

    @FXML
    public void RemoveButtonClicked(ActionEvent actionEvent) {
        //Remove the selected list using the index
    }

    @FXML
    public void ItemSelectedMouse(ActionEvent actionEvent){
        //Get index of the item selected
    }

    @FXML
    public void BackButtonPushed(ActionEvent actionEvent) {
        //Create a new parent for the Main Scene
        //Create a new scene for Main scene
        //Get the current stage we are on
        //Set the current stage to the Main scene
    }

    @FXML
    public void DisplayAllButtonClicked(ActionEvent actionEvent) {
        //Set the tableview to display all items in the List of items of current List
    }

    @FXML
    public void DisplayIncompleteButtonClicked(ActionEvent actionEvent) {
        //Initialize new list
        //Copy over the items that don't have their status as "complete" into our new list
        //Set the tableview values to the newly created Incomplete items list
    }

    @FXML
    public void DisplayCompletedButtonClicked(ActionEvent actionEvent) {
        //Initialize new list
        //Copy over the items that have their status as "complete" into our new list
        //Set the tableview values to the newly created Incomplete items list
    }

    @FXML
    public void AddItemButtonClicked(ActionEvent actionEvent) {
        //Create a new parent for the AddNewItem Scene
        //Create a new scene for AddNewItem scene
        //Create an Item with blank values
        //Sets tableview with the single blank item so it can be edited in order to create a new item from user.
        //Add new item to current List
        //Get the current stage we are on
        //Set the current stage to the AddNewItem scene
    }

    @FXML
    public void RemoveItemButtonClicked(ActionEvent actionEvent) {
        //Gets the index of the item
        //Removes that item from item list
        //Display new tableview with removed item
    }

    @FXML
    public void SaveButtonClicked(ActionEvent actionEvent) {
        //Initialize a file to be saved
        //Get all our items from current list to be saved
        //Call FilePrint() function
    }

    @FXML
    public void CancelButtonClicked(ActionEvent actionEvent) {
        //Create a new parent for the ItemsView Scene
        //Create a new scene for ItemsView scene
        //Get the current stage we are on
        //Set the current stage to the ItemsView scene
    }

    @FXML
    public void FinishButtonClicked(ActionEvent actionEvent) {
        //Get the values currently in the tableview
        //Create a new item and inserts current values of table view
        //Adds new item to current list
        //Create a new parent for the ItemsView Scene
        //Create a new scene for ItemsView scene
        //Get the current stage we are on
        //Set the current stage to the ItemsView scene
    }

    @FXML
    public void ChangeTitleCell(){
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the Title cell to new user input
        //Update the Title string value of our item
    }

    @FXML
    public void ChangeDescriptionCell(){
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the description cell to new user input
        //Update the Description string value of our item
    }

    @FXML
    public void ChangeDueDateCell(){
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the DueDate cell to new user input
        //Checks if user input is in YYY-MM-DD format
        //If input is not in correct format, input is changed to correct format
        //Update the Due Date string value of our item
        //Note: Date picker in Scene builder could be used here as alternative
    }
    @FXML
    public void ChangeStatusCell(){
        //Get the selected cell
        //Set cell to editable
        //Get user input from cell value
        //Set the status cell to new user input
        //Update the Status string value of our item
    }
}
