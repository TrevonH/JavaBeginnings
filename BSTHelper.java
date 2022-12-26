
    public class BSTHelper {

        public static void main(String[] args) {

            System.out.println("Binary Search Tree");
            int[] dataset = { 43, 58, 54, 3, 67, 53, 82, 55 };
            BST bst = new BST();
            for (int x : dataset) {
                bst.insert(x);
            }

            bst.traverseInOrder();
            System.out.println();

            bst.delete(55); //delete leaf node
            bst.delete(67); //delete node with one child
            bst.delete(58); //delete node with two children


            bst.traverseInOrder();
            System.out.println();

            System.out.println(bst.height(bst.getRoot()));
            System.out.println(bst.numOfLeafNodes(bst.getRoot()));



            //degenerated tree
            int[] dataset2 = { 1,2,3,4,5,6,7,8 };
            BST bst2 = new BST();
            for (int x : dataset2) {
                bst2.insert(x);
            }

            System.out.println(bst2.height(bst2.getRoot()));
            System.out.println(bst2.numOfLeafNodes(bst2.getRoot()));

            //solution - insertion-based
            BST bst3 = BST.createFromSortedArray(dataset2);

            System.out.println(bst3.height(bst3.getRoot()));
            System.out.println(bst3.numOfLeafNodes(bst3.getRoot()));


        } // end main
    }

     class Node {

        public Integer key;
        //private Integer value;
        public Node leftChild;
        public Node rightChild;

        public Node(Integer key) {
            this.key = key;
        }

        public Integer getKey() { //no setter method for key
            return this.key;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(Node left) {
            this.leftChild = left;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(Node right) {
            this.rightChild = right;
        }


    }

    class BST {

        private Node root;

        public void insert(Integer key) {
            if (this.root == null)
                this.root = new Node(key);
            else
                insert(this.root, key);
        }

        public void insert(Node curr, int key){
            if (key >= curr.key){
                // our key is GREATER/EQUAL than the current value
                // we want to go right
                if(curr.rightChild == null) {
                    Node newNode = new Node(key);
                    curr.rightChild = newNode;
                } else {
                    insert(curr.rightChild, key);
                }
            } else {
                // our key is LESS than our current value
                // (we're ignore duplicates)
                // we want to go left
                if(curr.leftChild == null) {
                    Node newNode = new Node(key);
                    curr.leftChild = newNode;
                } else {
                    insert(curr.leftChild, key);
                }
            }
        }


        public Node find(Integer key) {
            if (root != null)
                return findHelper(this.root, key);
            return null;
        }

        public Node findHelper(Node curr, Integer key) {
            if (curr.key == key)
                return curr;
            if (key < curr.key && curr.leftChild != null)
                return findHelper(curr.leftChild, key);
            if (curr.rightChild != null)
                return findHelper(curr.rightChild, key);
            return null;
        }


        public void delete(Integer data) {
            Node current = this.root;
            Node parent = this.root;
            boolean isLeftChild = false;

            if (current == null)
                return; // tree is empty

            while (current != null && current.getKey() != data) {
                parent = current;
                if (data < current.getKey()) {
                    current = current.getLeftChild();
                    isLeftChild = true;
                } else {
                    current = current.getRightChild();
                    isLeftChild = false;
                }
            }
            if (current == null)
                return; // node to be deleted not found

            // case 1: node to be deleted has no children
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                if (current == root) {
                    root = null; // no elements in tree now
                } else {
                    if (isLeftChild)
                        parent.setLeftChild(null);
                    else
                        parent.setRightChild(null);
                }
            }
            // case 2: node to be deleted has 1 child
            else if (current.getRightChild() == null) {// current has left child
                if (current == root) {
                    root = current.getLeftChild();
                } else if (isLeftChild) {
                    parent.setLeftChild(current.getLeftChild());
                } else {
                    parent.setRightChild(current.getLeftChild());
                }
            } else if (current.getLeftChild() == null) {// current has right child
                if (current == root) {
                    root = current.getRightChild();
                } else if (isLeftChild) {
                    parent.setLeftChild(current.getRightChild());
                } else {
                    parent.setRightChild(current.getRightChild());
                }
            }
            // case 3: node to be deleted has 2 children)
            else
            {
                Node succesor = current;
                if (current == root) root = succesor;
                else if (isLeftChild) parent.setLeftChild(succesor);
                else parent.setRightChild(succesor);
                succesor.setLeftChild(current.getLeftChild());
            }
        }




        public int height(Node node)
        {
            if (node == null)
                return 0;
            int lefty = height(node.getLeftChild());
            int righty = height(node.getRightChild());
            return lefty > righty ? (lefty + 1) : (righty + 1);
        }


        public int numOfLeafNodes(Node node)
        {
            if(node == null)
                return 0;
            else if (isLeaf(getRoot()))
                return 1;
            return numOfLeafNodes(node.getLeftChild()) + numOfLeafNodes(node.getRightChild());

        }


        public void traverseInOrder(){
            // is the tree empty?
            if(this.root == null){
                return;
            }
            inOrderHelper(root);
        }

        public void inOrderHelper(Node curr){
            if(curr == null){
                return;
            }
            inOrderHelper(curr.leftChild);
            System.out.print(curr.key + " ");
            inOrderHelper(curr.rightChild);
        }


        public static Node addSorted(int[] data, int start, int end) {
            if (end >= start) {
                int mid = (start+end)/2;
                Node newNode = new Node(data[mid]);
                newNode.setLeftChild(addSorted(data, start, mid-1));
                newNode.setRightChild(addSorted(data, mid+1, end));
                return newNode;
            }
            return null;
        }


        public static BST createFromSortedArray(int[] data) {
            BST bst = new BST();
            if (data != null && data.length > 0) {
                bst.root = addSorted(data, 0, data.length-1);
            }
            return bst;
        }

        public Node getRoot() { return this.root; };


        public boolean isLeaf(Node node) {
            return node.getLeftChild() == null && node.getRightChild() == null;
        }

    }

