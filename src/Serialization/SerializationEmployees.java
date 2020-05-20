package Serialization;
import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SerializationEmployees {
    public static void main(String[] args){

        Employees employees = new Employees();

        try (BufferedWriter output = Files.newBufferedWriter(Paths.get("employees.xml"))) {

            Scanner scanner = new Scanner(System.in);

            try {
                Employee employee = new Employee(scanner.next(), scanner.next(), scanner.next(),
                            scanner.nextDouble(), scanner.nextInt());

                employees.employees.add(employee);

                JAXB.marshal(employees, output);

                }catch(InputMismatchException e)
                    {
                        System.out.println("Input exception." + e);
                    }
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }