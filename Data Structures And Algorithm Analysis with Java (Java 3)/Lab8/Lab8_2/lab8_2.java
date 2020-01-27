package Lab8.Lab8_2;

class lab8_2
{
    public static void main(String[] args)
    {
        //Δημιουργια ενος αντικειμενου Διαδικου Δεντρου
        BSTree tree = new BSTree();

        //Δημιουργια ενος πινακα 5 φοιτητων
        Student[] students = new Student[5];

        //Εισαγωγη φοιτητων
        students[0] = new Student(1, "Kappa");
        students[1] = new Student(5, "Keepo");
        students[2] = new Student(3, "Asdasd");
        students[3] = new Student(2, "Dsasad");
        students[4] = new Student(4, "GFsssd");

        //Μια for για την εισαγωγη των φοιτητων του πινακα στο δεντρο
        for(int i = 0; i < students.length; i++)
        {
            tree.insertElement(students[i]);
        }

        //Δημιουργια ενα πινακα τυπου Object και καλουμε την sort του αντικειμενου tree που φτιαξαμε
        Object[] newStudent = tree.sort();

        //Μια for για να εμφανισουμε τους φοιτητες απο τον πινακα τυπου object που φτιαξαμε πριν ταξινομημενους
        for(int i = 0; i < newStudent.length; i++)
        {
            System.out.println(((Student) newStudent[i]).getAM() + " " + ((Student) newStudent[i]).getName());
        }
    }
}
