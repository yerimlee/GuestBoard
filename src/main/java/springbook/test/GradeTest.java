package springbook.test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import springbook.user.domain.Grade;
import springbook.user.process.GradeProcess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GradeTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		ArrayList<Grade> list = new ArrayList<Grade>();
		
		GradeProcess gp = context.getBean("gradeProcess", GradeProcess.class);
		Scanner scan = new Scanner(System.in);
		gp.deleteAllProcess();
		
		while(true){
			System.out.println("******* Select MENU *********");
            System.out.println("1. Insert Grade Data");
            System.out.println("2. Print Grade Data");
            System.out.println("3. EXIT");       
            System.out.print("Select : ");
            int menu = scan.nextInt();
            
            if(menu==1) gp.insertProcess();
            else if(menu == 2) gp.printProcess();
            else if(menu == 3) System.exit(0);
		}
	}
}
