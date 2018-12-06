
public class ChartElement {
    
    public String name;
    public int value1;
    public int value2;
    public int value3;
    public int value4;
    
    public ChartElement(String name, int value1) {
        this.name = name;
        this.value1 = value1;
    }
    public ChartElement(String name, int value1, int value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }
    public ChartElement(String name, int value1, int value2, int value3) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
    public ChartElement(String name, int value1, int value2, int value3, int value4) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }
    
    public String getName() {
        return name;
    }  
    public int getValue1() {
        return value1;
    }
    public int getValue2() {
        return value2;
    }
    public int getValue3() {
        return value3;
    }
    public int getValue4() {
        return value4;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setValue1(int value1) {
        this.value1 = value1;
    }
    public void setValue2(int value2) {
        this.value2 = value2;
    }
    public void setValue3(int value3) {
        this.value3 = value3;
    }
    public void setValue4(int value4) {
        this.value4 = value4;
    }
}
