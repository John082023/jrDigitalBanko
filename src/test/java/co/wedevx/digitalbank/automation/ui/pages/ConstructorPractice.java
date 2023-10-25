package co.wedevx.digitalbank.automation.ui.pages;

public class ConstructorPractice {


    String name;
    String lastName;

    public ConstructorPractice(){

    }

    public ConstructorPractice(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

}

class Constructor2Practice{
    public static void main(String[] args) {
        ConstructorPractice c1 = new ConstructorPractice();
        c1.lastName = "test";
        c1.name = "ing";
    }
}
