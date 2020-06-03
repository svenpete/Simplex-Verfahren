package SimplexFunktioniert.Model;

public class Variable
{
    private static Integer  counter = 0;
    String x1, x2, x3, x4, x5, x6, y1;
    String s1,s2,s3,s4,s5,s6;



    public Variable(String x1, String x2, String x3, String x4, String x5, String x6, String y1,String s1, String s2, String s3, String s4, String s5, String s6) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.y1 = y1;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;


    }

    public Variable(String x1, String x2, String x3, String x4, String x5, String y1,String s1, String s2, String s3, String s4, String s5) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.y1 = y1;


        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;


    }

    public Variable(String x1, String x2, String x3, String x4, String y1, String s1, String s2, String s3, String s4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;




    }

    public Variable(String x1, String x2, String x3,  String y1, String s1, String s2, String s3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;



    }

    public Variable(String x1, String x2,  String y1, String s1, String s2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;

        this.s1 = s1;
        this.s2 = s2;




    }

    public Variable(String x1,  String y1,String s1)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.s1 = s1;

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

    public String getY1(){
        return y1;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }

    public String getS4() {
        return s4;
    }

    public String getS5() {
        return s5;
    }

    public String getS6() {
        return s6;
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

    public void setY1(String y1) {
        this.y1 = y1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public void setS5(String s5) {
        this.s5 = s5;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }
}
