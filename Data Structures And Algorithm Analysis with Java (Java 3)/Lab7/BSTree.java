package Lab7;

class BSTree
{
    //Δημιουργια ενος Node για root
    private TreeNode root;

    //Δημιουργια ενος κενου δομητη
    BSTree()
    {
        root = null;
    }

    //Επιστρεφει το μεγεθος της λιστας καλοντας την size
    public int size()
    {
        return (size(root));
    }
    
    
    private int size(TreeNode node) { 
        if (node == null) return(0); 
        else { 
            return(size(node.getLeftNode()) + 1 + size(node.getRightNode())); 
        }
    }
    //Τελος
    
    //Επιστρεφει αν η λιστα ειναι αδεια χρησιμοποιοντας το root για να δει αν ειναι null
    public boolean isEmpty()
    {
        return root == null;
    }
    
    //Εισαγωγη δεδομενου στο δεντρο
    public void insertElement(int data)
    { 
        try{
            insertNode(data, root);
        }catch(Exception e){
            if(isEmpty())
            root = new TreeNode(data);
        }
    }
    
    //Οι ταξινομισεις()
    public void inOrderTraversal()
    {
        System.out.println("INORDER TRAVERSAL");
        inOrder(root);
        System.out.println();
    }

    public void preOrderTraversal()
    {
        System.out.println("PREORDER TRAVERSAL");
        preOrder(root);
        System.out.println();
    }

    public void postOrderTraversal()
    {
        System.out.println("POSTORDER TRAVERSAL");
        postOrder(root);
        System.out.println();
    }
    //Τελος
    
    //Ταξινομηση Sort
    private int counter = 0;

    public int[] sort()
    {
        int[] newTable = new int[size()];

        System.out.println("SORT ");

        counter = 0;

        inOrderSort(root, newTable);

        return newTable;
    }

    private void inOrderSort(TreeNode node, int[] table)
    {
        if(node == null)
        {
            return;
        }

        inOrderSort(node.getLeftNode(), table);
        table[counter++] = node.getNodeData();
        inOrderSort(node.getRightNode(), table);
    }
    //Τελος
    
    //Εισαγωγη δεδομενου σε συγκεκριμενο node
    private void insertNode(int data, TreeNode node)
    {
        try{
            root.insert(data);
        }catch(Exception e){
            if(root == null)
                root = new TreeNode(data);
        }
    }
    
    //Οι ιδιοτηκες μεθοδοι για τις ταξινομησεις
    private void inOrder(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        inOrder(node.getLeftNode());

        System.out.print(node.getNodeData() + " ");

        inOrder(node.getRightNode());
    }

    private void preOrder(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        System.out.print(node.getNodeData() + " ");

        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }

    private void postOrder(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());

        System.out.print(node.getNodeData() + " ");
    }
    //Τελος
    
    public int treeHeight()
    {
        return treeHeight(root);
    }
    
    public int treeHeight(Object data)
    {
        if(data == null)
        {
            return 0;
        }

        int left = treeHeight(((TreeNode) data).getLeftNode());
        int right = treeHeight(((TreeNode) data).getRightNode());

        if(left > right)
        {
            return left + 1;
        }
        else
        {
            return right + 1;
        }
    }
    
    
}
