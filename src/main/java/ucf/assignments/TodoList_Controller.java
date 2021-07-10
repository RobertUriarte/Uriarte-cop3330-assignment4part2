/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Robert Uriarte
 */
package ucf.assignments;

//Set up imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TodoList_Controller implements Initializable {
    //Initialize TableView and all its columns
    @FXML
    private TableView<Todo_Item> tableView;
    @FXML
    private TableColumn<Todo_Item, String> title;
    @FXML
    private TableColumn<Todo_Item, String> description;
    @FXML
    private TableColumn<Todo_Item, String> date;
    @FXML
    private TableColumn<Todo_Item, String> status;

    //Initialize three text field and datePicker for adding a new item
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private TextField statusTextField;

    //Initialize Observable Todo list
    public ObservableList<Todo_Item> item_list = FXCollections.observableArrayList();

    //Initialize file chooser
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize cellValueFactory of cells of tableview
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        //Initialize allowing multiple selection mode
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Set our tableView to empty item list
        tableView.setItems(item_list);

        //Set tableView to be editable
        tableView.setEditable(true);

        //Initialize text fields of cells of tableview
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    @FXML
    public TableView<Todo_Item> DisplayAllButtonClicked(ActionEvent actionEvent) {
        //Set the tableview to display all items in the List of items of current List
        tableView.setItems(item_list);
        return tableView;
    }

    @FXML
    public void DisplayIncompleteButtonClicked(ActionEvent actionEvent) {
        //Initialize filtered list
        //set predicates for incomplete list
        //Set the tableview values to the newly created Incomplete items list

        FilteredList<Todo_Item> items = new FilteredList<>(item_list,b -> true);
        items.setPredicate(Todo_Item -> {
            return Todo_Item.getStatus().equals("I") || Todo_Item.getStatus().equals("i");
        });
        tableView.setItems(items);
    }

    @FXML
    public void DisplayCompletedButtonClicked(ActionEvent actionEvent) {
        //Initialize filtered list
        //set predicates for completed list
        //Set the tableview values to the newly created completed items list

        FilteredList<Todo_Item> items = new FilteredList<>(item_list,b -> true);
        items.setPredicate(Todo_Item -> {
            return Todo_Item.getStatus().equals("C") || Todo_Item.getStatus().equals("c");
        });
        tableView.setItems(items);
    }

    @FXML
    public void AddItemButtonClicked(ActionEvent actionEvent){
        //Create new item with textField values from user input
        //set tableView back to all items
        //Add new item to all items

        Todo_Item new_item = new Todo_Item(titleTextField.getText(), descriptionTextField.getText(), format_date(), statusTextField.getText());
        tableView.setItems(item_list);
        tableView.getItems().add(new_item);
    }

    public String format_date(){
        //Initialize date formatter
        //format date in text field
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTextField.getValue().format(formatter);
    }

    @FXML
    public void RemoveItemButtonClicked(ActionEvent actionEvent) {
        //Initialize observable list
        //Set tableView to all items list
        //Get all the items currently in list
        //Get selected rows
        //Check if there are any selected rows
        //If there are selected rows, remove them

        ObservableList<Todo_Item> selectedRows, allItems;
        tableView.setItems(item_list);
        allItems = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        if(selectedRows != null)
            allItems.removeAll(selectedRows);

    }

    @FXML
    public void ClearAllButtonClicked(ActionEvent actionEvent) {
        //Initialize observable list
        //Set tableView to all items list
        //Get all the items currently in list
        //Remove all the items in the tableView

        ObservableList<Todo_Item> allItems, all;
        tableView.setItems(item_list);
        allItems = tableView.getItems();
        all = tableView.getItems();
        allItems.removeAll(all);
    }

    @FXML
    public void SaveButtonClicked(ActionEvent actionEvent) {
        //Set the tableView to all items list
        //Initialize new ExcelExporter
        //Call exporter

        tableView.setItems(item_list);
        ExcelExport<Todo_Item> exporter = new ExcelExport<>();
        exporter.export(tableView);
    }

    @FXML
    public void LoadButtonClicked(ActionEvent actionEvent){
        //Set the tableview to all items list
        //Call Json parser

        tableView.setItems(item_list);
        ParseJson.parse(tableView);
    }


    @FXML
    public void ChangeTitleCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set the selected cell to user input

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setTitle(newCell.getNewValue().toString());
    }

    @FXML
    public void ChangeDescriptionCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Get user input
        //Check if user input is within 1-256 range.
        //If user is above 256 character trim
        //If user is under 1 do nothing
        //If user is within range set selected cell to user input

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
    public void ChangeDateCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Check if selected cell is a valid date input
        //If date is valid we set selected cell to user input

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        if(is_date_valid(newCell.getNewValue().toString()))
            item_selected.setDate(newCell.getNewValue().toString());
    }

    public boolean is_date_valid(String user_date){
        //Initialize our date format
        //Set up try catch
        //Parse our date

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(user_date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @FXML
    public void ChangeStatusCell(TableColumn.CellEditEvent newCell) {
        //Get the selected cell
        //Set the selected cell to user input

        Todo_Item item_selected = tableView.getSelectionModel().getSelectedItem();
        item_selected.setStatus(newCell.getNewValue().toString());
    }
}

