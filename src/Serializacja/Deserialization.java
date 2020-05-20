package Serializacja;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Deserialization {
    public static void main(String[] args) {
        try{
            BufferedReader input = Files.newBufferedReader(Paths.get("employees.xml"));
            Employees employees1 = JAXB.unmarshal(input, Employees.class);

            for (Employee employee : employees1.getEmployees()){
                System.out.printf("%s, %s, %s, %.2f, %d", employee.getFirstName(), employee.getLastName()
                        , employee.getEmail(), employee.getSalary(), employee.getAge());
            }
        }catch (IOException e){
            System.out.println("File not exist." + e);
        }

    }
}
