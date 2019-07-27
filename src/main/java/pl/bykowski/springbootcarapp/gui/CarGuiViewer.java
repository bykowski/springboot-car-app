package pl.bykowski.springbootcarapp.gui;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.springbootcarapp.model.Car;
import pl.bykowski.springbootcarapp.repository.CarRepo;

@Route("car-viewer")
public class CarGuiViewer extends VerticalLayout {

    @Autowired
    public CarGuiViewer(CarRepo carRepo) {
        Grid<Car> carGrid = new Grid<>(Car.class);
        carGrid.setItems(carRepo.findAll());
        add(carGrid);
    }
}
