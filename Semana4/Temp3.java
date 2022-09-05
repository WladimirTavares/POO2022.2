// Java program to illustrate Constructor Chaining
// within same class Using this() keyword
// and changing order of constructors
class Temp3
{   
	int x = 0, y = 0;
	//init block
	{
	    System.out.println("init block");
	}
	
	// default constructor 1
	Temp3()
	{
		System.out.println("default constructor");
	}

	// parameterized constructor 2
	Temp3(int x)
	{
		this();
		this.x = x;
		System.out.println("parameterized constructor 2");
	}

	// parameterized constructor 3
	Temp3(int x, int y)
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
		Temp3 t1 = new Temp3();
		Temp3 t2 = new Temp3(5);
		Temp3 t3 = new Temp3(8,9);
		System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
		
	}
}

