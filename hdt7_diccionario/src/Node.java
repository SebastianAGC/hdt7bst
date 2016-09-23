/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo Arriaza;
 */
public class Node<E> {
    
	E data;
	Node left;
	Node right;	
	public Node(E data){
		this.data = data;
		left = null;
		right = null;
	}
        public E getValue()
	// post: returns value associated with this node
	{
		return data;
	}

}
