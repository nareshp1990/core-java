/**
 * Sometimes we can declare inner class without name such type of inner classes are called anonymous inner classes.
 * The main objective of anonymous inner classes is "just for instant use".
 * There are 3 types of anonymous inner classes
 *  1. Anonymous inner class that extends a class.
 *  2. Anonymous inner class that implements an interface.
 *  3. Anonymous inner class that defined inside method arguments.
 */

/**
 * Note: Inside Anonymous inner classes we can take or declare new methods but outside of anonymous inner classes we can't call these methods directly because we are depending on parent reference.
 * [parent reference can be used to hold child class object but by using that reference we can't call child specific methods]. 
 * These methods just for internal purpose only.
 */
class PopCorn
{
	public void taste()
	{
		System.out.println("spicy");
	}
}
class Test 
{
	public static void main(String[] args) 
	{
		PopCorn p=new PopCorn(){
			public void taste()
			{
				System.out.println("salty");
			}
		};
		p.taste();//salty
		PopCorn p1=new PopCorn();
		p1.taste();//spicy
	}
}