/****************************************************************************************
Name            : HotelRoomAllocation
Revision Log    : 2015-08-31: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement roomallocation in hotel.
                :
****************************************************************************************/

import java.util.Scanner;

public class HotelRoomAllocation{
	
	public static void main(String []args){
		Scanner scan = new Scanner(System.in);
		HotelRoomAllocationOperation hotelRoomAllocationOperation = new HotelRoomAllocationOperation();
		int rooms =0 ;
		int choice=0;
		
		//While loop is for take input from user 
		while(rooms==0){
			System.out.println("Enter total rooms avialable ::");
			try{
				int room= Integer.parseInt(scan.next());
				if(hotelRoomAllocationOperation.isPrimeNumber(room)==false){
					System.out.println("Enter prime number");
				}
				else{
					rooms=room;
				}
			}
			catch(Exception e){
				System.out.println("Enter integer number");
			}
			
		}
		
		hotelRoomAllocationOperation.setRooms(rooms);
		hotelRoomAllocationOperation.createMap();
		
		//While loop is used for perform all room operation
		while(true){
			System.out.println("Enter your choice \n1. For Add Guest\n2. For Show List");
			try{
				choice = Integer.parseInt(scan.next());
			}
			catch(Exception e){
				System.out.println("Enter integer number");
			}
			
			//Start of Switch case
			switch (choice) {
			case 1:
				
				if(hotelRoomAllocationOperation.getCount()<rooms){
					try{
						System.out.println("Enter age of person:");
						int age = Integer.parseInt(scan.next());
						System.out.println("Enter Name of person:");
						String name = scan.next();
						hotelRoomAllocationOperation.alloteRoomToPerson(name,age);
					}
					catch(Exception e){
						System.out.println("Enter integer number");
					}
				}
				else{
					System.out.println("No Room Available");
					return;
				}
				break;
				
			case 2:
				hotelRoomAllocationOperation.viewRoomList();
				break;

			default:
				System.out.println("Enter valid option:");
				break;
				
			}
			//End of switch loop
			
		}
		//End of while loop
	}
	//End of main method
}
//End of class HotelRoomAllocation