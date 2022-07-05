package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter worker data: \nName: ");
		String name = sc.nextLine();
		System.out.println("Level: ");
		String level = sc.nextLine();
		System.out.println("Base Salary: ");		
		Double baseSalary = sc.nextDouble();
		System.out.println("How many contracts to this worker?");
		Integer qtdContracts = sc.nextInt();
		WorkerLevel lvl = WorkerLevel.valueOf(level);
		Department nm = new Department(department);
		Worker worker = new Worker(name, lvl, baseSalary, nm);
		//System.out.println(worker.getName() + worker.getBaseSalary() + worker.getDepartment() + worker.getLevel());
		
		for (int i=0; i<qtdContracts; i++) {
			System.out.println("Enter contract #" + (i+1) + "data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.println("Duration(hours): ");
			Integer hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName() + "\nDepartment: " + worker.getDepartment().getName() + "\nIncome for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
