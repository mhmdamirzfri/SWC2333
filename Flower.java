/**
 * Program Purpose: 
 * 
 * Programmer: Amir Zafri
 * Date: 22 February 2024
 */

public class Flower
{
    //attributes
    private String name;
    private String color;
    private double price;
    private int quantity;
    
    //constructor without param
    public Flower()
    {
        name = null;
        color = null;
        price = 0.00;
        quantity = 0;
    }//end of constructor
    
    //constructor with param
    public Flower(String name, String color, double price, int quantity)
    {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }//end of constructor
    
    //Accessor
    public String getName()
    {
        return name;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    //Mutators
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    //tostring method
    public String toString()
    {
        return ("Flower name = " + name +
                "\n Color = " + color +
                "\n price = " + price +
                "\n quantity = " + quantity);
    }//end of tostring 
}//end of class 
