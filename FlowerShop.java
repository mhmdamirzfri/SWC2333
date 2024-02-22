import javax.swing.JOptionPane;

// Driver class
public class FlowerShop 
{
    // Driver method
    public static void main(String[] args) 
    {
        // Declaration of an array of size 10 named flowerArr
        Flower[] flowerArr = new Flower[3];

        // Declaration of all variables
        String name, color;
        double price;
        int quantity;

        for (int i = 0; i < flowerArr.length; i++) 
        {
            name = JOptionPane.showInputDialog("Enter name for Flower " + (i + 1) + ":");
            color = JOptionPane.showInputDialog("Enter color for Flower " + (i + 1) + ":");
            price = Double.parseDouble(JOptionPane.showInputDialog("Enter price for Flower " + (i + 1) + ":"));
            quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity for Flower " + (i + 1) + ":"));

            flowerArr[i] = new Flower(name, color, price, quantity);

            JOptionPane.showMessageDialog(null, flowerArr[i].toString(), "Flower " + (i + 1) + " Details", JOptionPane.INFORMATION_MESSAGE);
        }

        double totalValue = calculateTotalValue(flowerArr);
        JOptionPane.showMessageDialog(null, "Total value of flower inventory: $" + totalValue, "Total Value", JOptionPane.INFORMATION_MESSAGE);

        String searchName = JOptionPane.showInputDialog("Enter the name of the flower to search:");
        Flower searchedFlower = searchFlowerByName(flowerArr, searchName);
        if (searchedFlower != null) 
        {
            JOptionPane.showMessageDialog(null, searchedFlower.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else 
        {
            JOptionPane.showMessageDialog(null, "Flower with name '" + searchName + "' not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }//end of if

        String restockName = JOptionPane.showInputDialog("Enter the name of the flower to restock:");
        int restockQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity to restock:"));
        restockFlower(flowerArr, restockName, restockQuantity);

        StringBuilder updatedInventory = new StringBuilder("Updated Flower Inventory:\n");
        for (Flower flower : flowerArr) 
        {
            updatedInventory.append(flower).append("\n");
        }
        JOptionPane.showMessageDialog(null, updatedInventory.toString(), "Updated Inventory", JOptionPane.INFORMATION_MESSAGE);

    }

    public static Flower searchFlowerByName(Flower[] flowers, String name) 
    {
        for (Flower flower : flowers) 
        {
            if (flower.getName().equalsIgnoreCase(name)) 
            {
                return flower;
            }
        }
        return null;
    }

    public static void restockFlower(Flower[] flowers, String name, int quantity) 
    {
        Flower flower = searchFlowerByName(flowers, name);
        if (flower != null) 
        {
            flower.setQuantity(flower.getQuantity() + quantity);
            JOptionPane.showMessageDialog(null, "Restocked " + quantity + " " + name + "(s).", "Restocking Successful", JOptionPane.INFORMATION_MESSAGE);
        } else 
        {
            JOptionPane.showMessageDialog(null, "Flower with name '" + name + "' not found. Cannot restock.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static double calculateTotalValue(Flower[] flowers) 
    {
        double totalValue = 0.0;
        for (Flower flower : flowers)
        {
            totalValue += flower.getPrice() * flower.getQuantity();
        }
        return totalValue;
    }
}