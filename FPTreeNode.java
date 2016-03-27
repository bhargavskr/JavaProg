import java.util.Collection;
import java.util.LinkedList;

public class FPTreeNode {

	String itemName;
	FPTreeNode parent;
	int itemCount=0;
	Collection<FPTreeNode> child;//this is for all the direct children 
	boolean marker;
/////////////////////////////////////////////////////////////////////////////////////////	
	//each time a new node, point it to the previous same name node.
	//this is left to the second round traverse to add more links
	FPTreeNode former = null;
	
	
	
	public FPTreeNode(String s, FPTreeNode t){
		child = new LinkedList<FPTreeNode>();
		parent = t;
		itemName=s;
		itemCount++;
		marker = false;
		//former
	}

	public FPTreeNode SubNode(String s){//iterate through all the first level children, not for all 
		//find the 's' name child
		if(child != null){
			for(FPTreeNode eachchild:child){
				//System.out.println("FPTreeNode : itemName "+ eachchild.itemName+"; itemCount  "+eachchild.itemCount);
				if(eachchild.itemName.equalsIgnoreCase(s)){
					return eachchild;
				}
			}
		}
		return null;
	}
	/////////////////////////////////////////////////////////childNode()

	/////////////////////////////////////////////////////////
	public FPTreeNode PrintNode(FPTreeNode root){
		if(child != null){
			for(FPTreeNode eachchild:child){
				if(eachchild.itemName != null){
					System.out.println("FPTreePrintNode : itemName "+ eachchild.itemName+"; itemCount  "+eachchild.itemCount);
					
				}
			}
		}
		return null;
	}
}