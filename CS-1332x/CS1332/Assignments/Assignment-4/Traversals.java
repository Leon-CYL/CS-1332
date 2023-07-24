// 10/10

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */


    private void preOrderHelper(List l, TreeNode<T> node){
      if (node == null){
        return;
      }
      else{
        l.add(node.getData());
        preOrderHelper(l, node.getLeft());
        preOrderHelper(l, node.getRight());
      }
    }

  
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      
      List<T> temp = new ArrayList<T>();
      preOrderHelper(temp, root);
      return temp;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */

    private void inOrderHelper(List l, TreeNode node){
      if (node == null){
        return;
      }
      else{
        inOrderHelper(l, node.getLeft());
        l.add(node.getData());
        inOrderHelper(l, node.getRight());
      }
    }

  
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      List<T> temp = new ArrayList<T>();
      inOrderHelper(temp, root);
      return temp;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */

    private void postOrderhelper(List l, TreeNode node){
      if (node == null){
        return;
      }
      else{
        postOrderhelper(l, node.getLeft());
        postOrderhelper(l, node.getRight());
        l.add(node.getData());
      }
    }
  
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      List<T> temp = new ArrayList<T>();
      postOrderhelper(temp, root);
      return temp;
    }
}