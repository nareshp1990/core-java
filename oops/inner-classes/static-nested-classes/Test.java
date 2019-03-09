/**
 * Sometimes we can declare inner classes with static modifier such type of inner classes are called static nested classes.
 * In the case of normal or regular inner classes without existing outer class object there is no chance of existing inner class object.
 * i.e., inner class object is always strongly associated with outer class object.
 * But in the case of static nested class without existing outer class object there may be a chance of existing static nested class object.
 * i.e., static nested class object is not strongly associated with outer class object.
 */
class Test 
{
    int x = 10;
    static int y = 20;

	static class Nested
	{
        /**
         * From the normal inner class we can access both static and non static members of outer class but 
         * from static nested class we can access only static members of outer class.
         */
		public void methodOne()
		{
            System.out.println("nested class method");
            // System.out.println(x); // error: non-static variable x cannot be referenced from a static context
            System.out.println(y);
            System.out.println(new Test().x);
        }
        
        /**
         * Inside static nested classes we can declare static members including main() method also. 
         * Hence it is possible to invoke static nested class directly from the command prompt.
         */
        public static void main(String[] args) {
            System.out.println("Inside nested class main");
            Nested nested = new Nested();
            nested.methodOne();
        }

	}
	public static void main(String[] args)
	{
		Test.Nested t=new Test.Nested();
		t.methodOne();
	}
}