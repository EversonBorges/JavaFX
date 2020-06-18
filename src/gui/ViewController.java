package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.Util.Alerts;
import gui.Util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;

	@FXML
	private Button btSum;

	@FXML
	private Label lblResult;

	@FXML
	private Button btTeste;

	@FXML
	private ComboBox<Person> cbPersons;

	private ObservableList<Person> obsList;
	
	@FXML
	private Button btAll;
	
	@FXML
	public void onComboBoxPersonAction() {
		
		Person person = cbPersons.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}

	@FXML
	public void onBtTesteAction() {
		Alerts.showAlert("Alert Title", null, "Hello", AlertType.INFORMATION);
	}
	
	@FXML
	public void onBtAllAction() {
		for (Person person : cbPersons.getItems()) {
			System.out.println(person);
		}
	}

	@FXML
	public void onBtSumAction() {

		try {

			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			lblResult.setText(String.format("%.2f", sum));

		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 10);
		Constraints.setTextFieldMaxLength(txtNumber2, 10);

		List<Person> list = new ArrayList<>();
		list.add(new Person(1L, "Everson", "ever@borges.com"));
		list.add(new Person(2L, "Patricia", "ever@borges.com"));
		list.add(new Person(3L, "Marcelo", "ever@borges.com"));
		list.add(new Person(4L, "Emilly", "ever@borges.com"));

		obsList = FXCollections.observableArrayList(list);
		cbPersons.setItems(obsList);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		cbPersons.setCellFactory(factory);
		cbPersons.setButtonCell(factory.call(null));
	}

}
