package Tableview.model;

import TestEditableTable.Controller;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class Variable
{
    String x1, x2, x3, x4;
    Button update;

    public Variable(String id, String x2, String x3, String x4, Button update) {
        this.x1 = id;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.update = update;

        update.setOnAction(e -> {
            ObservableList<Variable> variables = Controller.table_info_2.getSelectionModel().getSelectedItems();
            for (Variable variable : Controller.data_table)
            {
                if(variable.getUpdate() == update)
                {
                    System.out.println("x1: " + variable.getId());
                    System.out.println("x2: " + variable.getX2());
                    System.out.println("x3: " + variable.getX3());
                    System.out.println("x4: " + variable.getX4());

                }
            }
        }
        );
    }

    public String getId() {
        return x1;
    }

    public String getX2() {
        return x2;
    }

    public String getX3() {
        return x3;
    }

    public String getX4() {
        return x4;
    }

    public Button getUpdate() {
        return update;
    }

    public void setId(String id) {
        this.x1 = id;
    }

    public void setX2(String x2) {
        this.x2 = x2;
    }

    public void setX3(String x3) {
        this.x3 = x3;
    }

    public void setX4(String x4) {
        this.x4 = x4;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }
}
