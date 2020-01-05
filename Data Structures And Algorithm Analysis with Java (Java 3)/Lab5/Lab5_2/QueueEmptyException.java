package Lab5.Lab5_2;

class QueueEmptyException extends RuntimeException
{
    public QueueEmptyException(String err)
    {
        super(err);
    }
}
