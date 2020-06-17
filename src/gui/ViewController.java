package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.w3c.dom.Text;

import gui.Util.Alerts;
import gui.Util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	
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
	public void onBtTesteAction() {
		Alerts.showAlert("Alert Title", null , "Hello", AlertType.INFORMATION);
	}
	
	@FXML
	public void onBtSumAction() {
		
		try {
			
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			lblResult.setText(String.format("%.2f", sum));
			
		}catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 10);
		Constraints.setTextFieldMaxLength(txtNumber2, 10);
	}

}
