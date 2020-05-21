package Tableview.model;

import TestEditableTable.Controller.tableController;
import javafx.scene.control.Button;

public class Variable
{
    String x1, x2, x3, x4, x5, x6, y1;


    public Variable(String x1, String x2, String x3, String x4, String x5, String x6, String y1) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.y1 = y1;
    }

    public Variable(String x1, String x2, String x3, String x4, String x5, String y1)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.y1 = y1;

    }

    public Variable(String x1, String x2, String x3, String x4, String y1) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;

    }

    public Variable(String x1, String x2, String x3,  String y1) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
    }

    public Variable(String x1, String x2,  String y1) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
    }

    public Variable(String x1,  String y1)
    {

        this.x1 = x1;
        this.y1 = y1;
    }

    public Variable() {
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

    public String getY1(){return y1;}


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

    public void setY1(String y1) {
        this.y1 = y1;
    }
}
