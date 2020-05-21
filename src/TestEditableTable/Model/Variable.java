package Tableview.model;

import TestEditableTable.Controller.tableController;
import javafx.scene.control.Button;

public class Variable
{
    String x1, x2, x3, x4, x5,x6;
    Button update;

    public Variable(String x1, String x2, String x3, String x4, String x5, String x6, Button update) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.update = update;

        update.setOnAction(e -> {

            for (Variable variable : tableController.data_table)
            {
                if(variable.getUpdate() == update)
                {
                    System.out.println("x1: " + variable.getX1());
                    System.out.println("x2: " + variable.getX2());
                    System.out.println("x3: " + variable.getX3());
                    System.out.println("x4: " + variable.getX4());
                    System.out.println("x5: " + variable.getX5());
                    System.out.println("x6: " + variable.getX6());

                }
            }
        }
        );
    }

    public Variable(String x1, String x2, String x3, String x4, String x5, Button update) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;

        this.update = update;

        update.setOnAction(e -> {

                    for (Variable variable : tableController.data_table)
                    {
                        if(variable.getUpdate() == update)
                        {
                            System.out.println("x1: " + variable.getX1());
                            System.out.println("x2: " + variable.getX2());
                            System.out.println("x3: " + variable.getX3());
                            System.out.println("x4: " + variable.getX4());
                            System.out.println("x5: " + variable.getX5());

                        }
                    }
                }
        );
    }

    public Variable(String x1, String x2, String x3, String x4, Button update) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;

        this.update = update;

        update.setOnAction(e -> {

                    for (Variable variable : tableController.data_table)
                    {
                        if(variable.getUpdate() == update)
                        {
                            System.out.println("x1: " + variable.getX1());
                            System.out.println("x2: " + variable.getX2());
                            System.out.println("x3: " + variable.getX3());
                            System.out.println("x4: " + variable.getX4());

                        }
                    }
                }
        );
    }

    public Variable(String x1, String x2, String x3,  Button update) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        this.update = update;

        update.setOnAction(e -> {

                    for (Variable variable : tableController.data_table)
                    {
                        if(variable.getUpdate() == update)
                        {
                            System.out.println("x1: " + variable.getX1());
                            System.out.println("x2: " + variable.getX2());
                            System.out.println("x3: " + variable.getX3());
                        }
                    }
                }
        );
    }

    public Variable(String x1, String x2,  Button update) {
        this.x1 = x1;
        this.x2 = x2;

        this.update = update;

        update.setOnAction(e -> {

                    for (Variable variable : tableController.data_table)
                    {
                        if(variable.getUpdate() == update)
                        {
                            System.out.println("x1: " + variable.getX1());
                            System.out.println("x2: " + variable.getX2());

                        }
                    }
                }
        );
    }

    public Variable(String x1,  Button update) {
        this.x1 = x1;


        this.update = update;

        update.setOnAction(e -> {

                    for (Variable variable : tableController.data_table)
                    {
                        if(variable.getUpdate() == update)
                        {
                            System.out.println("x1: " + variable.getX1());


                        }
                    }
                }
        );
    }


    public String getX1() {
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

    public String getX5() {
        return x5;
    }

    public String getX6() {
        return x6;
    }

    public Button getUpdate() {
        return update;
    }

    public void setX1(String x1) {
        this.x1 = x1;
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

    public void setX5(String x5) {
        this.x5 = x5;
    }

    public void setX6(String x6) {
        this.x6 = x6;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }
}
