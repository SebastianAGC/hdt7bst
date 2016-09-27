
import java.util.ArrayList;

public class BinarySearchTree<E> {
	public Node root;
	public BinarySearchTree(){
		this.root = null;
	}
        private Node<E> current;
        ArrayList<String> content = new ArrayList();
	
	public boolean find(E id){
		Node<E> current = root;
		while(current!=null){
			if(current.data==id){
                                //setCurrent(current);
				return true;
			}else if((current.data.toString()).compareTo(id.toString())>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
        
        public boolean find(String key)
        {
		Node<Association> current = root;
		while(current!=null){
                    String thekey = current.data.KeyToString();
                    if(thekey.compareTo(key)==0){
                            setCurrent(current);
                        return true;
                    }else if(thekey.compareTo(key)>0){
                            current = current.left;
                    }else{
                        current = current.right;
                    }
		}
		return false;
	}
        public void setCurrent(Node current){
            this.current=current;
        }
        public E getCurrent(){
            return current.data;
        }
        /*
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}*/
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
        //funciona totalmente bien ordenando los datos
	public void insert(E id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id.toString().compareTo(current.data.toString())<0){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
        public void inOrder(Node root) { 
            
            root=this.root;
            if(root.left != null) 
            { 
                inOrder(root.left);
            }
            content.add(root.data.toString());
            inOrder(root.right); 
        }
        public ArrayList<String> getTranslations (){
            return content;
        }
//Read more at http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html#kfz7RyIxkYLIacE0.99
        //funciona bien
	public String display(Node root)
        {
            String res = null;
		if(root!=null){
			display(root.left);
			res=" " + root.data;
			display(root.right);
	}
                return res;
    }


public void printInorder(){
  printInOrderRec(root);
  //System.out.println("");
}
private void printInOrderRec(Node currRoot){
  if ( currRoot == null ){
    return;
  }
  printInOrderRec(currRoot.left);
  content.add(currRoot.data+"");
  printInOrderRec(currRoot.right);
}
}

