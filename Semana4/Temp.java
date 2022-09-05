class Temp
{
    int x, y;
    // default constructor 1
    // default constructor will call another constructor
    // using this keyword from same class
    Temp()
    {
        // calls constructor 2
        this(5);
        System.out.println("The Default constructor");
    }
 
    // parameterized constructor 2
    Temp(int x)
    {
        // calls constructor 3
        this(x, 15);
        System.out.println("Parameterized constructor 2");
        
    }
 
    // parameterized constructor 3
    Temp(int x, int y)
    {
        System.out.println("Parameterized constructor 3");
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return String.format("x = %d, y = %d", x, y);
    }
 
    public static void main(String args[])
    {
        // invokes default constructor first
        Temp t1 = new Temp();
        Temp t2 = new Temp(2);
        Temp t3 = new Temp(3,5);
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        
        
        
    }
}

