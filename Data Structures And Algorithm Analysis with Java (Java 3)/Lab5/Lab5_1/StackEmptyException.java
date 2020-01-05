package Lab5.Lab5_1;

class StackEmptyException extends RuntimeException
{
    public StackEmptyException(String err)
    {
        super(err);
    }
}
