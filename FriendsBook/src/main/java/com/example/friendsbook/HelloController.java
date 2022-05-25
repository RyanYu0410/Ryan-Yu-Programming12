package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController{
    @FXML
    private ListView<String> allList;
    @FXML
    private TextField phoneNumText;
    @FXML
    private TextField ageText;
    @FXML
    private TextField nameText;
    @FXML
    private ListView<Friends> listOfFriend= new ListView<>();
    @FXML
    private Label infoFriendName;
    @FXML
    private Label infoAge;
    @FXML
    private Label infoPhoneNum;
    @FXML
    private Label infoNumberOfList;

    public void createFriend() {
        Friends temp = new Friends(nameText.getText(),Integer.parseInt(ageText.getText()),Integer.parseInt(phoneNumText.getText()));
        listOfFriend.getItems().add(temp);
        nameText.clear();
        ageText.clear();
        phoneNumText.clear();
        allList.getItems().clear();
        setAllList();
    }

    public void displayFriend() {
        Friends temp;
        temp = listOfFriend.getSelectionModel().getSelectedItem();
        infoFriendName.setText(temp.getName());
        infoAge.setText(Integer.toString(temp.getAge()));
        infoPhoneNum.setText(Integer.toString(temp.getPhoneNum()));
        infoNumberOfList.setText(Integer.toString(listOfFriend.getSelectionModel().getSelectedIndex() + 1));
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friends temp;
        temp = listOfFriend.getSelectionModel().getSelectedItem();
        listOfFriend.getItems().remove(temp);
        setAllList();
    }

    public void showAll(Event event) {
        int i=0;
        for (Friends item : listOfFriend.getItems()) {
            i++;
            allList.getItems().add("" + i + "    " + item.getName() + "    " + item.getAge() + "    " + item.getPhoneNum());
        }
    }

    public void setAllList() {
        allList.getItems().clear();
        allList.getItems().add("" + "Serial" + "    " + "Name" + "    " + "Age" + "    " + "PhoneNumber");
        int i=0;
        for (Friends item : listOfFriend.getItems()) {
            i++;
            allList.getItems().add("" + i + "    " + item.getName() + "    " + item.getAge() + "    " + item.getPhoneNum());
        }
    }
}