public class Engine<T>
{
	T type;
	public Engine(T type)
	{
		this.type = type;
	}

	public T getEngineType()
	{
		return this.type;
	}


	public static void main(String[] args)
	{
		Engine object = new Engine<String>(args[0]);
		System.out.println(object.getEngineType());
	}
}