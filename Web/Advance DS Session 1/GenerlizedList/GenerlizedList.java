/****************************************************************************************
Name            : GenerlizedList
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create and implement all method of generalized list
                :
****************************************************************************************/


public class GenerlizedList {

	Node root;
	String list;
	String listString = "";
	int position = 0;

	//Default Constructor of class
	public GenerlizedList() {
		list = null;
	}

	//Parameterized constructor
	public GenerlizedList(String string) {
		list = string;
	}

	//Insert method is used to insert element in list from string 
	void insert(Node node) {

		//If condtion for lenth of list
		if (position < list.length()) {
			
			//Condition for null check of node.
			if (node == null) {
				Node temp;
				if (list.charAt(position) == '(') {
					temp = new Node(1, null);
				}
				else {
					while (list.charAt(position) != ',' && list.charAt(position) != '(' && list.charAt(position) != ')') {
						listString += list.charAt(position);
						position++;
						System.out.println(listString);
					}
					temp = new Node(0, Integer.parseInt(listString));
					listString = "";
				}
				root = temp;
				position++;
				insert(temp);
			} else if (list.charAt(position) == '(') {
				Node temp = new Node(1, null);
				node.setNext(temp);
				position++;
				insert(node.getNext());
				insert(node.getNext());
			} else if (list.charAt(position) == ')') {
				position++;
				return;
			} else if (list.charAt(position) == ',') {
				position++;
				insert(node);
			} 
			//ELse when node is not null
			else {
				
				while (list.charAt(position) != ',' && list.charAt(position) != '(' && list.charAt(position) != ')') {
					listString += list.charAt(position);
					position++;
				}
				
				Node temp = new Node(0, Integer.parseInt(listString));
				listString = "";
				
				//Node tag is 0 then list has only one element.
				if (node.getTag() == 0) {
					node.setNext(temp);
					position++;
					insert(temp);
				} 
				//When tag is 1 and list has no data then add in to new list next node.
				else if (node.getTag() == 1 && node.getData() != null) {
					node.setNext(temp);
					position++;
					insert(temp);
				} 
				//ADD to current list.
				else {
					node.setData(temp);
					position++;
					insert(temp);
				}

			}

		}
	}
	//End of insert method.

	//sumOfElements method is used to find sum of all elements of list
 	int sumOfelements(Node node,int sum) {
	
		if (node != null) {
			if (node.getTag() == 0) {
				sum = sum + (int) node.getData();
				sum=sumOfelements(node.getNext(),sum);
			} else {
				sum=sumOfelements((Node) node.getData(),sum);
				sum=sumOfelements(node.getNext(),sum);
			}

		}
		return sum;
	}
 	//End of sumOfElements method
 	
 	//Display method is used to display all element of list
	void display(Node node) {
		if (node != null) {
			if (node.getTag() == 0) {
				System.out.println(node.getData());
				display(node.getNext());
			} else {
				display((Node) node.getData());
				display(node.getNext());
			}
		}
	}
	//End of display method

	//Max method is used to find max element in generalized list
	int max(Node node,int max) {
		if (node != null) {
			if (node.getTag() == 0) {
				if(max<(int)node.getData())
					max=(int)node.getData();
			max=max(node.getNext(), max);

			} else {
				max=max((Node) node.getData(), max);
				max=max(node.getNext(), max);
		
			}
		}
		return max;
	}
	//End of max method

	//Search method is used to search an element in generalized list 
	boolean search(Node node, int element,boolean search) {
       		 if (node != null) {
				if (node.getTag() == 0) {
		            if((int)node.getData()==element)
		            {
		            	return true;
		            
		            }
			         	search=search(node.getNext(), element,search);

				} else {

					search=search((Node) node.getData(), element,search);
					search=search(node.getNext(), element,search);
				}

			}
          return search;
	}
	//End of search method
	
}
//End of class generalizedList