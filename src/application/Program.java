package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of taxpayers");
		int n = sc.nextInt();
		
		List<TaxPayer> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			System.out.println("Taxpayer #" + (i+1)+ "data");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.println("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if(type == 'i') {
				System.out.println("Health expeditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}else if (type == 'c') {
				System.out.println("Number of employees: ");
				int numberOfEmployess = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployess));
			}
		}
		System.out.println("TAXES PAID");
		
		for(TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + String.format("%.2f", tp.tax()));
		}
		
		System.out.println();
		double sum = 0.0;
		for(TaxPayer tp : list) {
			sum += tp.tax();
		}
		System.out.println("TOAL TAXES: $ " +  String.format("%.2f", sum));
		
		sc.close();

	}

}
