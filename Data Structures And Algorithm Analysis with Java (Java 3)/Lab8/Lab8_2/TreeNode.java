package Lab8.Lab8_2;

class TreeNode
{
    //Δημιουργια ενος αντικειμενου για τα δεδομενα, δημιου�?για ενος Node για το δηλωση του αριστερου Node και ενα για του δεξιου Node
    private TreeNode left;
    private Object item;
    private TreeNode right;

    //Δηλωσει ενος δομητη που δηνουμε το δεδομενο
    TreeNode(Object data)
    {
        item = data;
        left = right = null;
    }

    //Περνουμε το δεδομενο απο το node
    public Object getNodeData()
    {
        return item;
    }

    //Περνουμε το αριστερο node απο το node
    public TreeNode getLeftNode()
    {
        return left;
    }

    //Περνουμε το δεξιο node απο το node
    public TreeNode getRightNode()
    {
        return right;
    }

    //Περνουμε True η False αν ο κομβος ειναι φυλο, δηλαδη αν απο κατω του δεν εχει κανενα αλλο Node, ουτε αριστερα ουτε δεξια
    public boolean isLeaf()
    {
        return right == null && left == null;
    }

    //Εισαγωγη του αριστερου node στο node
    public void setLeftNode(TreeNode node)
    {
        left = node;
    }

    //Εισαγωγη του δεξιου node στο node
    public void setRightNode(TreeNode node)
    {
        right = node;
    }

    //Εισαγωγη του δεδομενου στο node
    public void insert(Object d)
    {
        if(((Comparable) item).compareTo(((Comparable) d)) > 0)
        {
            if(left == null)
            {
                left = new TreeNode(d);
            }
            else
            {
                left.insert(d);
            }
        }
        else
        {
            if(right == null)
            {
                right = new TreeNode(d);
            }
            else
            {
                right.insert(d);
            }
        }
    }
}
