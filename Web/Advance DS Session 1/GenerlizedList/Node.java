/****************************************************************************************
Name            : Node
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create node generalized list
                :
****************************************************************************************/
//@param Object store data .
//@param next : Store address of next node of list.
//@param tag :Specify that node has list as object or element.
public class Node {
    private Object data;
    private Node next;
    private int tag;
    
    //Default Contsructor
    Node(){
		tag=0;
		data=null;
	}
    
    //Parametrized Contsructor
    Node(int tag,Object data){
    	this.data=data;
	    next=null;
	    this.tag=tag;
	
    }
    
    //Starting of getter setter
    public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getData() {
        return data;
    }
    public int getTag() {
        return tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }
    public void setData(Object data) {
        this.data = data;
    }
   
}
//End of class