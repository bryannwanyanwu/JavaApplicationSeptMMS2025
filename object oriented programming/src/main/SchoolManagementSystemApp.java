
package main;

import java.time.LocalDate;
import java.util.Scanner;
import school.student;
import school.Graduate; 
import school.UnderGraduateStudent; 


public class SchoolManagementSystemApp {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter 1 for Graduate Student");
        System.out.println("Enter 2 for Under Graduate Student");
        System.out.println("Enter 3 to Pay School Feess");
        
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt(); 
        
        switch(choice){
            case 1:{ 
                
                
                System.out.print("Enter your student ID: ");
                int studentID = scan.nextInt(); 
                scan.nextLine();
                
                System.out.print("Enter First Name ");
                String firstName = scan.nextLine();
                
                System.out.print("Enter Last Name ");
                String lastName = scan.nextLine();
                
                System.out.print("Enter gender:  ");
                char gender = scan.next().charAt(0);
                scan.nextLine();
                
                System.out.print("Enter Date of Birth(YYYY-MM-DD) ");
                String dateOfBirth = scan.nextLine();
                
                System.out.print("Enter Phone Number ");
                String phoneNumber = scan.nextLine();
                
                System.out.print("Enter Final Year Project");
                String finalYearProject = scan.nextLine();
                
                Graduate gStudent = new Graduate(studentID,firstName,lastName,gender,LocalDate.parse(dateOfBirth),phoneNumber,finalYearProject);
                
                System.out.println(""); 
                System.out.println("=============================");
                gStudent.displayStudentInfo();
                break; 
        }
            case 2: {
                System.out.print("Enter your student ID: ");
                int studentID = scan.nextInt(); 
                scan.nextLine();
                
                System.out.print("Enter First Name: ");
                String firstName = scan.nextLine();
                
                System.out.print("Enter Last Name: ");
                String lastName = scan.nextLine();
                
                System.out.print("Enter gender:  ");
                char gender = scan.next().charAt(0);
                scan.nextLine();
                
                System.out.print("Enter Date of Birth(YYYY-MM-DD): ");
                String dateOfBirth = scan.nextLine();
                
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scan.nextLine();
                
                System.out.print("Enter level");
                int level = scan.nextInt();
                
                UnderGraduateStudent uGStudent = new UnderGraduateStudent(studentID,firstName,lastName,gender,LocalDate.parse(dateOfBirth),phoneNumber,level);
                
                System.out.println(""); 
                System.out.println("=============================");
                uGStudent.displayStudentInfo();
                break; 
            }
            case 3: {
                System.out.println("Choose the following option");
                System.out.println("Enter 1: Amount only");
                System.out.println("Enter 2: Amount, Full Name Only");
                System.out.println("Enter 3: Amount, Full Name, Payment Method Only");
                
                System.out.print("Enter your option: ");
                int myOption = scan.nextInt();
                
                
                switch(myOption){
                    case 1:{
                        System.out.print("Enter StudentID");
                        int studentID = scan.nextInt();
                        scan.nextLine();
                        
                        System.out.print("Enter FirstName:");
                        String firstName = scan.nextLine();
                        
                        System.out.print("Enter LastName: ");
                        String lastName = scan.nextLine();
                        
                        System.out.print("Enter Gender: ");
                        char gender = scan.next().charAt(0);
                        scan.nextLine();
                        
                        System.out.print("Enter Date of Birth(YYYY-MM-DD): ");
                        String birthDate = scan.nextLine();
                        
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scan.nextLine();
                         
                        student student = new student(studentID,
                        firstName,lastName,gender,LocalDate.parse(birthDate),
                        phoneNumber
                        );       
                        System.out.print("Enter Amount :");
                        double amount = scan.nextDouble();
                        student.payFees(amount);
                        
                    }
                    case 2:{
                        System.out.print("Enter StudentID :");
                        int studentID = scan.nextInt();
                        scan.nextLine();
                        
                        System.out.print("Enter FirstName :");
                        String firstName = scan.nextLine();
                        
                        System.out.print("Enter LastName :");
                        String lastName = scan.nextLine();
                        
                        System.out.print("Enter Gender:");
                        char gender = scan.next().charAt(0);
                        scan.nextLine();
                        
                        System.out.print("Enter Date of Birth(YYYY-MM-DD): ");
                        String birthDate = scan.nextLine();
                        
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scan.nextLine();
                        
                        student student = new student(studentID,
                        firstName,lastName,gender,LocalDate.parse(birthDate),
                        phoneNumber
                        );       
                        System.out.print("Enter Amount:");
                        double amount = scan.nextDouble();
                        
                        System.out.print("Enter Full Name:");
                        String fullName = scan.nextLine();
                        student.payFees(amount,fullName);
                    }
                    case 3:{
                        System.out.print("Enter StudentID:");
                        int studentID = scan.nextInt();
                        scan.nextLine();
                        
                        System.out.print("Enter FirstName:");
                        String firstName = scan.nextLine();
                        
                        System.out.print("Enter LastName:");
                        String lastName = scan.nextLine();
                        
                        System.out.print("Enter Gender:");
                        char gender = scan.next().charAt(0);
                        scan.nextLine();
                        
                        System.out.print("Enter Date of Birth(YYYY-MM-DD): ");
                        String birthDate = scan.nextLine();
                        
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scan.nextLine();
                        
                        student student = new student(studentID,
                        firstName,lastName,gender,LocalDate.parse(birthDate),
                        phoneNumber
                        );       
                        System.out.print("Enter Amount:");
                        double amount = scan.nextDouble();
                        
                        System.out.print("Enter Full Name:");
                        String fullName = scan.nextLine();
                        
                        System.out.print("Enter Payment Method:");
                        String paymentMethod = scan.nextLine();
                        student.payFees(amount,fullName);
                    }
                    default:
                        System.out.println("Invalid Option");
                }

            break;    
            }
            default:
                System.out.println("Invalid input");
        }
        
        
      
    }
}
     

