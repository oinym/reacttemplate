import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\ofird\\Downloads\\IntellijProjects\\CSVReaDemo\\src\\test.csv";
        String line = "";
        String cvsSplitBy = ",";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        
            while ((line = br.readLine()) != null) {
            
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
            
                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
}
