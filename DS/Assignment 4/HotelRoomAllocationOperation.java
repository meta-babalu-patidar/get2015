/****************************************************************************************
Name            : HotelRoomAllocationOperation
Revision Log    : 2015-08-31: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement roomallocation in hotel.
                :
****************************************************************************************/

import java.util.HashMap;


public class HotelRoomAllocationOperation {
	
	private int rooms;
	private int count = 0;
	HashMap<Integer, String> hotelRoom = new HashMap<Integer, String>();
	
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	//End of setRooms method
	
	void createMap(){
		for(int count=0;count<rooms;count++){
			hotelRoom.put(count,"");
		}
	}
	//End of createMap method
	
	public int getCount() {
		return count;
	}
	//End of getCount method

	void alloteRoomToPerson(String name,int age) {
		int key = age%rooms;
		boolean flag = false;
		while(!flag){
			if(hotelRoom.get(key).equalsIgnoreCase("")){
				hotelRoom.put(key, name);
				flag=true;
				count++;
			}
			else if(key < rooms-2 ){
				key = key + 1;
			}
			else{
				key = 0;
			}
		}	
	}
	//End of alloteRoomToPerson

	public void viewRoomList() {
		for(int count =0;count<rooms;count++){
			if(hotelRoom.get(count).equalsIgnoreCase("")){
				System.out.println("Room number "+ count+" is not allocated to anyone ");
			}
			else{
				System.out.println("Room number "+ count+" is allocated to : " +hotelRoom.get(count));
			}
		}
	}
	//End of alloteRoomToPerson method
	
	 public boolean isPrimeNumber(int number){
         
        for(int count=2; count<=number/2; count++){
            if(number % count == 0){
                return false;
            }
        }
        return true;
	 }
	 //End of isPrimeNumber method
	 

}
//End of class
	
