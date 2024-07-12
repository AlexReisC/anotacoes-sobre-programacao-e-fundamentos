package com.example.InnerClasses.test;

public class OuterClassTest01 {
    private String name = "Mané de Viola";
    
    class Inner{
        public void printOuterClassAtribute(){
            System.out.println(name);
            System.out.println(OuterClassTest01.this);
        }
    }

    public static void main(String[] args) {
        OuterClassTest01 outerClass = new OuterClassTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassTest01().new Inner();
        inner.printOuterClassAtribute();
        inner2.printOuterClassAtribute();
    }
}
