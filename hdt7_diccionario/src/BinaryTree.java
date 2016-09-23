
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/*
 * Codigo tomado de http://javabeat.net/binary-search-tree-traversal-java/
 */

public class BinaryTree<E> {
    
  public Node<E> root;
  protected BinaryTree<E> parent; // parent of node
  protected BinaryTree<E> left, right; // children of node
  protected E val;
  private ArrayList<String> orden = new ArrayList();
  protected BinaryTree<E> roots; // root of subtree to be traversed
  protected Stack<BinaryTree<E>> todo; // stack of unvisited ancestors
  
  
  	public BinaryTree()
	// post: constructor that generates an empty node
	{
		val = null;
		parent = null; left = right = this;
	}
  public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
  
  public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty()) return;
		if (left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
        protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty()) {
		parent = newParent;
		}
	}
        public void setRight(BinaryTree<E> newRight)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty()) return;
		if (right != null && right.parent() == this) right.setParent(null);
		right = newRight;
		right.setParent(this);
	}
        public BinaryTree<E> getRight(){
            return right;
        }
        public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    {
    return left;
    }
  public boolean isEmpty(){
      return this == null;
  }
  public BinaryTree<E> parent(){
	// post: returns reference to parent node, or null
      return this.parent;
  }
  public void insert(E value){
    Node node = new Node<E>(value);
    if ( root == null ) 
    {
      root = node;
      return;
    }
    insertRec(root, node);
  }
  
  private void insertRec(Node latestRoot, Node node){
    if ( latestRoot.getValue() != node.getValue()){
      if ( latestRoot.left == null ){
        latestRoot.left = node;
        //return;
      }
      else{
        insertRec(latestRoot.left, node);
      }
   }
    else{
      if (latestRoot.right == null){
        latestRoot.right = node;
        //return;
      }
      else{
        insertRec(latestRoot.right, node);
      }
    }
  }
  
  public E value(Node<E> nodo)
	// post: returns value associated with this node
	{
		return nodo.getValue();
	}
  
  public E value(){
      return val;
  }
  
  /*
  //EMPEZAR RECORRIDO INORDEN
    public synchronized void recorridoInorden()
    {
        ayudanteInorden(root);
    }
     
    //meoto recursivo para recorrido inorden
    public void ayudanteInorden( Node nodo){
      if (nodo != null)
      {
         ayudanteInorden(nodo.left);
         orden.add(nodo.toString());
         ayudanteInorden(nodo.right);
      } 
    }
    
    public E buscar(E element){
        
        return null;
    }*/
  class BTInorderIterator<E> /*extends AbstractIterator<E>*/{
       protected BinaryTree<E> roots; // root of subtree to be traversed
  protected Stack<BinaryTree<E>> todo; // stack of unvisited ancestors
  public void reset()
// post: resets the iterator to retraverse
        {
            todo.clear();
        // stack is empty. Push on nodes from root to
        // leftmost descendant
            BinaryTree<E> current = roots;
        while (!current.isEmpty()) {
            todo.push(current);
        current = current.left();
        }
}
        public E next()
        // pre: hasNext()
        // post: returns current value, increments iterator
        {
        BinaryTree<E> old = todo.pop();
        E result = old.value();
        // we know this node has no unconsidered left children;
        // if this node has a right child,
        // we push the right child and its leftmost descendants:
        // else
        // top element of stack is next node to be visited
        if (!old.getRight().isEmpty()) {
        BinaryTree<E> current = old.getRight();
        do {
        todo.push(current);
        current = current.left();
        } while (!current.isEmpty());
        }
        return result;
        }
  }
    
}
