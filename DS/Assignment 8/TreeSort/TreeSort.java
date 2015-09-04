/****************************************************************************************
Name            : TreeSort
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement treeSort  method 
                :
****************************************************************************************/
public class TreeSort {
	
		int nodeData;
		TreeSort leftChild;
		TreeSort rightChild;
		TreeSort rootNode=null;
	
		//Constructor of TreeSort class
		TreeSort(){
			nodeData=0;
			rightChild=null;
			leftChild=null;
		}
		//TreeSort Method is used to create a new node
		TreeSort createNode(int data){
			TreeSort newnode=new TreeSort();
			newnode.nodeData=data;
			return newnode;	
		}
		
		//addNode method is used to addNode in binarySearch Tree
		void addNode(int data){
			TreeSort nnode=createNode(data);
			if(rootNode==null){
				rootNode=nnode;
			}
			else{
				TreeSort first=rootNode;
				while(true){
					if(data<first.nodeData){
						if(first.leftChild!=null){
							first=first.leftChild;
						}
						else{
							break;
						}
					}
					else{
						if(first.rightChild!=null){
							first=first.rightChild;
						}
						else{
							break;
						}
					}
				}
				//End of while loop
				if(data<first.nodeData){
					first.leftChild=nnode;
				}
				else{
					first.rightChild=nnode;
				}
			}
			//End of else 
		}
		//End of addNode Method
		
		
		
		int count=0;
		//inorder method is used to store element in array in inorder travaersal of tree
		void inOrder(TreeSort first,int array[]){
			
			if(first.leftChild!=null){
				inOrder(first.leftChild,array);
			}
			array[count++]=first.nodeData;
			if(first.rightChild!=null){
				inOrder(first.rightChild,array);
			}
		}
		//End of inorder method
		
		//treeSort method is used to sort an input array
		void treeSort(int array[]){
			//For loop is used to insert all element in binary search tree
			for(int i=0;i<array.length;i++){
				addNode(array[i]);
			}
			//Calling of inorder method
			inOrder(rootNode, array);
		}
		//End of treeSort method

}
//End of TreeSort class
