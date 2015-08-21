/****************************************************************************************
Name            : TrainReservationSystem
Revision Log    : 2015-08-18: Babalu patidar : created.
                : 
Use             : This class is used implement train reservation system.
                :
****************************************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class TrainReservationSystem {
	
	static String trainType="";
	static String trainno = null;
	static int amount =999;
	static String from;
	static int flag=1;
	static String to;
	static String passcsvFile ="C:/Users/Babalu/workspace/OOP3/src/passangerInput.txt";
	static String goodscsvFile="C:/Users/Babalu/workspace/OOP3/src/goodsInput.txt";
	static String csvFile="";
	static BufferedReader br = null;
	static String line = "";
	static String cvsSplitBy = ",";
	static int count=0;
	static Scanner scan=new Scanner(System.in);
	static HashMap<String, String[]> hash = new HashMap<String, String[]>();
	static String hashKey="";
	static HashMap<String, String[]> hashtrain=new HashMap<String, String[]>();
	static String hashtrainKey="";
	
	
	//Start of main method
	//@param trainType :specify type of train
	//@param train no. :specify Number of train
	//@param from :specify source station
	//@param to :specify destination station
	public static void main(String arg[]){
		

		while(flag==1)
		{ 
			flag=0;
			count=0;
			System.out.println("Enter Train Type For Passanger 'P' and For Goods 'G':");
			trainType=scan.next();
			//Condition of Enter value is p or g
			if(trainType.equalsIgnoreCase("p")||trainType.equalsIgnoreCase("g")){
				csvFile=trainType.equalsIgnoreCase("p") ? passcsvFile :goodscsvFile;
				try {
					new TrainReservationSystem().printChart();
					System.out.print("Enter From : ");
					from=scan.next(); 
					System.out.print("Enter To : ");
					to=scan.next();
					
					hashKey=from.trim()+"-"+to.trim();
					if(hash.containsKey(hashKey)==true)
					{
					
					new TrainReservationSystem().printTrainListFromTO(hashKey);
					}
					else{
						System.out.println("No train available ");
					}
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else{
				System.out.println("Please Enter P / G");
			}
			System.out.println("\n\nAre You Want TO Book Ticket Again Press 1");
			try{
				if(Integer.parseInt(scan.next().trim())==1){
					flag=1;
				}
				else{
					System.out.println("Thanks for booking");
				}
			}
			catch(Exception e)
			{
				System.out.println("Thanks for booking");
			}
		}
		//End of while loop
		scan.close();		
	}
	//End of main method
	
	
	
	//printChart method print the chart according to entery
	void printChart() throws NumberFormatException, IOException{
		br = new BufferedReader(new FileReader(csvFile));
		//While loop read file.
		while ((line = br.readLine()) != null) {
			String[] trainsInfo = line.split(cvsSplitBy);
			if(count==0||Integer.parseInt(trainsInfo[4])>0){
				count++;
				System.out.println(" "+ trainsInfo[0]+ "\t" + trainsInfo[1] + " \t"+trainsInfo[2] + " \t"+trainsInfo[3]+" \t" +trainsInfo[4]+" \t" +trainsInfo[5]+" \t" +trainsInfo[6]);
				hashKey=trainsInfo[2].trim()+ "-"+trainsInfo[3].trim();
				hash.put(hashKey,trainsInfo);
				hashtrainKey=trainsInfo[1].trim();
				hashtrain.put(hashtrainKey,trainsInfo);
			}
		}
	}
	//End of PrintChart method
	
	
	//PrintTrainListFromTo method print list of train according to key
	void printTrainListFromTO(String hashKey2) throws NumberFormatException, IOException{
		
		
			String out[]=hash.get(hashKey2);
			System.out.println(" \t" + out[1] + " \t"+out[2] + " \t"+out[3]+" \t" +out[4]+" \t" +out[5]+" \t" +out[6]);
			System.out.print("Enter Train Number : ");
			try{
				trainno=scan.next(); 
				System.out.print("Enter Seat/Weight Required : ");
				amount=Integer.parseInt(scan.next());
			}
			catch(Exception e){
				System.out.println("Please Enter Integer value");
				printTrainListFromTO(hashKey2);
			}
			
			hashtrainKey=trainno.trim();
			bookTicketOfTrain(hashtrainKey);
			
	}
	//End of PrintTrainListFromTo method
	
	
	
	//bookTicketOfTrain Method is used for book ticket
	void bookTicketOfTrain(String hashtrainKey) throws NumberFormatException, IOException{
		
		if(hashtrain.containsKey(hashtrainKey)){
			String trains[] = hashtrain.get(hashtrainKey);
			if(Integer.parseInt(trains[4].trim())>=amount){
				new PaymentMode().makePaymentAndPrintTicket(trains[1], amount,trainType,Integer.parseInt(trains[6].trim()),scan);
				new UpdateTrainList().updateTrainList(trains, amount, csvFile,Integer.parseInt(trains[0].trim()));
			}
			else{
				System.out.println("Seat/Weight is not avialable");
			}
				
		}
		else {
			System.out.println("You have enterd wrong Train number");
		}
	}
	//End of bookTicketOfTrain method
		
	
}
//End of TrainReservationSystem class
