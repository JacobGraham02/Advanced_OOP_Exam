import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    CarLot carLot = new CarLot(CarLoader.loadCars());

    @FXML private ImageView imgView;

    @FXML private Button sellButton;

    @FXML private Button brandselectButton;

    @FXML private Text valueField = new Text();

    @FXML private ChoiceBox<String> brandChoice;

    @FXML private TableView<Car> carsTable;
    @FXML private TableColumn<Car, Integer> yearCol;
    @FXML private TableColumn<Car, String> brandCol;
    @FXML private TableColumn<Car, String> modelCol;
    @FXML private TableColumn<Car, Integer> kilometersCol;
    @FXML private TableColumn<Car, Double> priceCol;

    private String brand = "";

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        String text = "[No Cars]";
        valueField.setText(text);
        brandChoice.getItems().addAll(carLot.getBrands());
        brandChoice.getItems().add("All Brands");

        yearCol.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
        brandCol.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        kilometersCol.setCellValueFactory(new PropertyValueFactory<Car, Integer>("kilometers"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Car, Double>("price"));
    }

    public void popTable()
    {
        carsTable.getItems().addAll(carLot.getCars(brand));
        if (brand == "All Brands")
        {
            imgView.setImage((new Image(new File("./images/default.png").getPath())));
        }
        else
        {
            imgView.setImage((new Image(new File("./images/"+brand+".png").getPath())));
        }
        valueField.setText(carLot.getInventoryValue(brand));
    }

    public void reloadTable()
    {
        carsTable.getItems().clear();
        popTable();
    }

    public void sellButtonPressed(ActionEvent actionEvent)
    {
        carLot.sellCar(carsTable.getSelectionModel().getSelectedItem());
        reloadTable();
    }


    public void brandselectPressed(ActionEvent actionEvent)
    {
        brand = brandChoice.getValue();
        reloadTable();
    }
}
