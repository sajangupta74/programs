public class MiniTruck implements Truck
{
	public MiniTruck()	{}

	public void start()
	{
		System.out.println("executing under start method of MiniTruck");
	}

	public void TowLorry()
	{
		System.out.println("executing under TowLorry of MiniTruck");
	}

	public static void main(String[] args)
	{
		System.out.println("printing under main method");
		MiniTruck minitruckObject = new MiniTruck();
		minitruckObject.start();
	}
}