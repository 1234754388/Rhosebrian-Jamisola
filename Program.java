package project;

import java.util.*;
public class Program {
	
	// Create a data structure to store records
	public static ArrayList<String[]> records = new ArrayList<String[]>();
	public static int id = (int)(System.currentTimeMillis()/1000)%1000;

	public static void main(String[] args) {
		
		// Get user choice and do the corresponding action
		while (true) {
			System.out.println(
					"1. Add Record\n" + "2. View Record\n" + "3. Edit Record\n" + "4. Delete Record\n" + "5. Report\n");
			System.out.print("Please enter your choice: ");
			Scanner in=new Scanner(System.in);
			int choice = in.nextInt();
			
			switch (choice) {
				case 1:

					// Add record
					System.out.println("a. Add Peripheral\n" + "b. Add Peripheral to Employee\n");
					addRecord();
					break;
				case 2:
					System.out.println("a. View all peripherals\n" + "b. View available peripherals\n"
							+ "c. View not available peripherals\n" + "d. View all input devices\n"
							+ "e. View all output devices\n" + "f. View all input/output devices\n"
							+ "g. View all employees\n");
					viewRecord();
					break;
				case 3:
					System.out.println("a. Edit peripheral");
					editRecord();
					break;
				case 4:
					System.out.println("a. Delete peripheral");
					deleteRecord();
					break;
				case 5:
					System.out.println("a. Show the total number of the following conditions");
					report();
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
	}
	
	// Method to display the menu
		
	
	// Method to add record
	public static void addRecord() {
		System.out.print("Please enter your choice: ");
		Scanner in = new Scanner(System.in); 
			String input = in.nextLine();
			if (input.equals("a")) {
				// Get the details of the peripheral
				System.out.print("Please enter the peripheral name: ");
				String name = in.next();
				System.out.print("Please enter the type of the peripheral (input/output): ");
				String type = in.next();
				System.out.print("Please enter the status of the peripheral (available/NA): ");
				String status = in.next();
				
				// Create a new record
				String[] record = new String[] {String.valueOf(id + 1), name, type, status};
				
				// Add the record to the data structure
				records.add(record);
				
				// Increment the index
				id++;
				
				System.out.println("Successfully added!");
				
			} else if (input.equals("b")) {
				// Get the details of the peripheral
				System.out.print("Please enter the peripheral id: ");
				int id = in.nextInt();
				System.out.print("Please enter the employee name: ");
				String name = in.next();
				
				// Create a new record
				String[] record = new String[] {String.valueOf(id + 1), String.valueOf(id), name};
				
				// Add the record to the data structure
				records.add(record);
				
				// Increment the index
				id++;
				
				System.out.println("Successfully added!");
			}
		}
	
		
	// Method to view records
	public static void viewRecord() {
		
		System.out.print("Please enter your choice: ");
		Scanner in=new Scanner(System.in);
		String input = in.nextLine();
		
		if (input.equals("a")) {
			// View all peripherals
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record.length == 4) {
				System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
			}
			}		
		} else if (input.equals("b")) {
			// View available peripherals
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record[3].equals("available")) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
				}
			}
		} else if (input.equals("c")) {
			// View not available peripherals
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record[3].equals("NA")) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
				}
			}
		} else if (input.equals("d")) {
			// View all input devices
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record[2].equals("input")) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
				}
			}
		} else if (input.equals("e")) {
			// View all output devices
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record[2].equals("output")) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
				}
			}
		} else if (input.equals("f")) {
			// View all input/output devices
			System.out.println("id\t\tname\t\ttype\t\tstatus");
			for (String[] record : records) {
				if (record[2].equals("input/output")) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t" + record[2] + "\t\t" + record[3]);
				}
			}
		} else if (input.equals("g")) {
			// View all employees
			System.out.println("id\t\tperipheral id\t\temployee name");
			for (String[] record : records) {
				if (record.length == 3) {
					System.out.println(record[0] + "\t\t" + record[1] + "\t\t\t" + record[2]);
				}
			}
		}
	}
	
	// Method to edit record
	public static void editRecord() {
		System.out.print("Please enter the id of the peripheral you want to edit: ");
		Scanner in=new Scanner(System.in);
		int id = in.nextInt();
		
		// Loop through records and find the one with the specified id
		for (String[] record : records) {
			if (Integer.parseInt(record[0]) == id) {
				// Get the details of the peripheral
				System.out.print("Please enter the new name of the peripheral: ");
				String name = in.next();
				System.out.print("Please enter the new type of the peripheral (input/output: ");
				String type = in.next();
				System.out.print("Please enter the new status of the peripheral (available/NA): ");
				String status = in.next();
				
				// Update the record
				record[1] = name;
				record[2] = type;
				record[3] = status;
				
				System.out.println("Successfully edited!");
				break;
			}
		}
	}
	
	// Method to delete record
	public static void deleteRecord() {
		System.out.print("Please enter the id of the peripheral you want to delete: ");
		Scanner in=new Scanner(System.in);
		int id = in.nextInt();
		
		// Loop through records and find the one with the specified id
		for (String[] record : records) {
			if (Integer.parseInt(record[0]) == id) {
				// Delete the record from the data structure
				records.remove(record);
				
				System.out.println("Successfully deleted!");
				break;
			}
		}
	}  
	
	// Method to generate report
	public static void report() {
		int availablePeripherals = 0;
		int assignedPeripherals = 0;
		int inputDevices = 0;
		int outputDevices = 0;
		int employeesWithPeripherals = 0;
		
		// Loop through records and calculate the number of each condition
		for (String[] record : records) {
			if (record.length == 4) {
				if (record[3].equals("available")) {
					availablePeripherals++;
				} else {
					assignedPeripherals++;
					if (record[2].equals("input")) {
						inputDevices++;
					} else if (record[2].equals("output")) {
						outputDevices++;
					}
				}
			} else {
				employeesWithPeripherals++;
			}
		}
		
		// Display the report
		System.out.println("Number of available peripherals: " + availablePeripherals);
		System.out.println("Number of assigned peripherals: " + assignedPeripherals);
		System.out.println("Number of input devices: " + inputDevices);
		System.out.println("Number of output devices: " + outputDevices);
		System.out.println("Number of employees with peripherals assigned: " + employeesWithPeripherals);
	}
}