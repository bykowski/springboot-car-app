package pl.bykowski.springbootcarapp.gui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.springbootcarapp.model.Car;
import pl.bykowski.springbootcarapp.model.CarType;
import pl.bykowski.springbootcarapp.repository.CarRepo;

@Route("car")
public class CarGuiAdder extends VerticalLayout {


    @Autowired
    public CarGuiAdder(CarRepo carRepo) {
        TextField textFieldModel = new TextField("Model:");
        TextField textFieldMark = new TextField("Mark:");
        ComboBox<CarType> carTypeComboBox = new ComboBox<>("Car Type", CarType.values());
        DatePicker datePicker = new DatePicker("Production date");
        Button button = new Button("Save");

        button.addClickListener(clickEvent ->{
            Car car = new Car();
            car.setModel(textFieldModel.getValue());
            car.setMark(textFieldMark.getValue());
            car.setProdYear(datePicker.getValue());
            car.setCarType(carTypeComboBox.getValue());
            carRepo.save(car);

            Label content = new Label(
                    "You added new item to db");
            NativeButton buttonInside = new NativeButton("Super");
            Notification notification = new Notification(content, buttonInside);
            notification.setDuration(5000);
            notification.setPosition(Notification.Position.MIDDLE);
            notification.open() ;
        });
        add(textFieldModel, textFieldMark, carTypeComboBox,datePicker, button);
    }
}
