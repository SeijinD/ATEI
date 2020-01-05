package Lab5.Lab5_1;

class StackFullException extends RuntimeException
{
    public StackFullException(String err)
    {
        super(err);
    }
}
