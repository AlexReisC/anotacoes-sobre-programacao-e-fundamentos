package InnerClasses.test;

public class OuterClassesTest02 {
    private String name = "Buiu";

    void print(){
        class LocalClass {
            public void printLocal(){
                System.out.println(name);
            }
        }
        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outerClass = new OuterClassesTest02();
        outerClass.print();
    }
}
