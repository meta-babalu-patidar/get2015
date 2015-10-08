/****************************************************************************************
Name            : GenerlizedListMain
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement method of generalized list
                :
****************************************************************************************/
public class GenerlizedListMain {
	
	public static void main(String[] args) {
		
		
		if(GeneralizedListValidation.isExpression(GeneralizedListConstant.GENERALIZED_STRING)){
			GenerlizedList GenralizedList = new GenerlizedList(GeneralizedListConstant.GENERALIZED_STRING);
			System.out.println(GenralizedList.list);
			//Calling of insert in to list method.
			GenralizedList.insert(GenralizedList.root);
			
			//Calling of display method
			GenralizedList.display(GenralizedList.root);
			
			//Calling of search method
			System.out.println("Element found = "+GenralizedList.search(GenralizedList.root,GeneralizedListConstant.SEARCHED_ELEMENT,GeneralizedListConstant.SEARCH));
			
			//Calling of sum method
			System.out.println("Sum of elements is ->" + GenralizedList.sumOfelements(GenralizedList.root,GeneralizedListConstant.SUM));
			
			//Calling of max method
			System.out.println("Max of elements is ->" + GenralizedList.max(GenralizedList.root,GeneralizedListConstant.MAX));
		}
		else{
			System.out.println("Enter valid list");
		}
	}
	//End of main method

}
//End of class
