//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//driver class
public class LabTest
{
    //Driver method
    public static void main(String[]args) throws IOException
    {
        //Instantiate the object of DecimalFormat
        DecimalFormat df = new DecimalFormat("0.00");

        //try block
        try 
        {
            BufferedReader inputFile = new BufferedReader(new FileReader("/Users/macbookpro/Downloads/employeeSalaries.txt"));

            PrintWriter employeeData = new PrintWriter(new FileWriter("employeeData.txt"));

            employeeData.println("List of employees and their annual salaries");
            employeeData.println("\nEmployees Name\t\tBase Salary(RM)\t\t Years of service\t\t Annual Salary (RM)");
            employeeData.println("----------------------------------------------------------------------------------------------------");

            String inputData;
            while ((inputData = inputFile.readLine()) != null) {
                StringTokenizer sT = new StringTokenizer(inputData, ";");

                String name = sT.nextToken().trim();
                double baseSalary = Double.parseDouble(sT.nextToken().trim());
                int yearsOfService = Integer.parseInt(sT.nextToken().trim());

                if (baseSalary < 0) {
                    throw new IllegalArgumentException();
                }

                double annualSalary = baseSalary * (1 + yearsOfService * 0.05);

                employeeData.println(name + "\t\t" + df.format(baseSalary) + "\t\t\t" + yearsOfService + "\t\t\t" + df.format(annualSalary));
            }

            System.out.println("Employee data has been written to employeeData.txt");
            inputFile.close();
            employeeData.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Error reading input file: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            System.err.println("Invalid number format in input file: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}