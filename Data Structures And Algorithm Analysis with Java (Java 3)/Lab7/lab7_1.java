package Lab7;

class lab7_1
{
    public static void main(String[] args)
    {
        //Δημιουργια ενος πινακα με αριθμους
        int matrix[] = {40, 15, 25, 50, 20, 10, 70, 55, 45, 5};
        
        //Δημιουργια ενος αντικειμενου τυπου Διαδικο Δεντρο Αναζητησης
        BSTree tree = new BSTree();
        
        //Μια For για την εισαγωγη τον αριθμων απο τον πινακα στο δεντρο
        for(int i = 0; i < matrix.length; i++)
        {
            tree.insertElement(matrix[i]);
        }
        
        //Καλουμε τις τρεις ταξινομισεις
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
        
        //Φτιαχνουμε εναν πινακα και καλουμε την sort ταξινομηση για να μπουν στον πινακα
        int[] table = tree.sort();
        
        //Και με μια For δειχνουμε το περιεχομενο του δευτερου πινακα
        for(int i : table)
        {
            System.out.print(i + " ");
        }

        System.out.println();
        
    }
}
