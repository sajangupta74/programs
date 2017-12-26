public class TypeCastingExample
{
	public static void main(String[] args)
	{
		Base b;
		Derived d;

		b = new Derived();
		b.print();
		b.exclusiveToBase();
		Derived b2 = (Derived) b;
		b2.exclusiveToDerived();
	}
}


class Base
{
	public void print()
	{
		System.out.println("Im calling from Base");
	}

	public void exclusiveToBase()
	{
		System.out.println("Im calling exclusively from base class");
	}
}


class Derived extends Base
{
	public void print()
	{
		System.out.println("Im calling from Derived");
	}	

	public void exclusiveToDerived()
	{
		System.out.println("Im calling exclusively from derived class");
	}
}