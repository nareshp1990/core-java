/**
 * The applicable modifiers for outer classes are:
 * public
 * default
 * final
 * abstract
 * strictfp
 */
class Outer{

    int x=10;
	static int y=20;

    /**
     * From inner class we can access all members of outer class (both static and non-static, private and non private methods and variables) directly.
     */
    /**
     * Within the inner class "this" always refers current inner class object. To refer current outer class object we have to use "outer class name.this".
     */
    /**
     * But for the inner classes in addition to this the following modifiers also allowed. 
     * private
     * protected
     * static
     */
    class Inner{
        // static members not allowed in regular inner classes, hence main method cannot be declared, we cannot inoke from command prompt
        /* Compile time error saying
        Outer.java:4: error: Illegal static declaration in inner class Outer.Inner
        public static void main(String args[]){
        modifier 'static' is only allowed in constant variable declarations
        */
        /*public static void main(String args[]){
            System.out.println("Inner class main method");
        }*/
        int x = 100;
        public void methodOne(){
            int x=1000;
            System.out.println("in method one");

            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
			System.out.println(y);
        }

        /**
         * Nesting of Inner classes :
         * We can declare an inner class inside another inner class 
         */

         class Inner2{
             public void methodThree(){
                 System.out.println("in method three");
             }
         }

    }

    // Accessing inner class code from instance area of outer class: 
    public void methodTwo(){
        Inner inner = new Inner();
        inner.methodOne();
    }

    public static void main(String args[]){
        
        System.out.println("Outer class main method");

        // Accessing inner class code from static area of outer class: 
        /**
         * Method 1
         */
        /*Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.methodOne();*/

        /**
         * Method 2
         */
        /*Outer.Inner inner = new Outer().new Inner();
        inner.methodOne();*/

        /**
         * Method 3
         */
        // new Outer().new Inner().methodOne();

        /*Outer outer=new Outer();
        outer.methodTwo();*/
        
        // Nesting of Inner classes
        new Outer().new Inner().new Inner2().methodThree();

    }
}
// Accessing inner class code from outside of outer class:
class Test{
    public static void main(String[] args) {
        new Outer().new Inner().methodOne();
    }
}