// Java program to illustrate Constructor Chaining
// within same class Using this() keyword
// and changing order of constructors
class Temp2
{   
	int x = 0, y = 0;
	// default constructor 1
	Temp2()
	{
		System.out.println("default constructor");
	}

	// parameterized constructor 2
	Temp2(int x)
	{
		this();
		this.x = x;
		System.out.println("parameterized constructor 2");
	}

	// parameterized constructor 3
	Temp2(int x, int y)
	{
		this(x);
		this.y = y;
        System.out.println("parameterized constructor 3");
    }
    
    public String toString(){
        return String.format("x = %d, y = %d", x, y);
    }
    
	public static void main(String args[])
	{
		Temp2 t1 = new Temp2();
		Temp2 t2 = new Temp2(5);
		Temp2 t3 = new Temp2(8,9);
		System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
		
	}
}

