// Java program to illustrate Constructor Chaining
// within same class Using this() keyword
// and changing order of constructors
class Temp4
{   
	int x = 5, y = 15;
	
	// default constructor 1
	Temp4()
	{
		System.out.println("default constructor");
	}

	// parameterized constructor 2
	Temp4(int x)
	{
		this.x = x;
		System.out.println("parameterized constructor 2");
	}

	// parameterized constructor 3
	Temp4(int x, int y)
	{
		this.x = x;
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

