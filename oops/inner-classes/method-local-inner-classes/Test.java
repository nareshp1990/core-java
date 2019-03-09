/**
 * Sometimes we can declare a class inside a method such type of inner classes are called method local inner classes.
 * The main objective of method local inner class is to define method specific repeatedly required functionality.
 * Method Local inner classes are best suitable to meet nested method requirement.
 * We can access method local inner class only within the method where we declared it. That is from outside of the method we can't access. As the scope of method local inner classes is very less, this type of inner classes are most rarely used type of inner classes.
 */
class Test{
    int x = 10;
    static int y = 20;
    public void methodOne(){
        int z = 100;
        class Inner{
            public void sum(int i,int j){
                System.out.println("The sum:"+(i+j));
            }
            /**
             * If we are declaring inner class inside instance method then we can access both static and non static members of outer class directly.
             */
            public void methodTwo(){
                System.out.println(x);
                System.out.println(y);
            }

            /**
             * From method local inner class we can't access local variables of the method in which we declared it. But if that local variable is declared as final then we won't get any compile time error.
             */
            public void methodFive(){
                System.out.println(z);
            }

            /**
             * If we declare methodTwo() as static then we will get compile time error because we can't declare static members inside inner classes.
             */

            /**
             * The only applicable modifiers for method local inner classes are:
             * final
             * abstract
             * strictfp
             * By mistake if we are declaring any other modifier we will get compile time error.
             */

        }
        Inner inner=new Inner();
        inner.sum(10,2);
        inner.methodTwo();
        inner.methodFive();
    }

    public static void methodThree(){
        class Inner{
            /**
             * But if we are declaring inner class inside static method then we can access only static members of outer class directly and we can't access instance members directly.
             */
            public void methodFour(){
                //System.out.println(x); // Test.java:34: error: non-static variable x cannot be referenced from a static context
                System.out.println(y);
            }
        }
    }
    public static void main(String[] args) {
        new Test().methodOne();
    }
}