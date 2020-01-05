package Lab5.Lab5_2;

class QueueFullException extends RuntimeException
{
    public QueueFullException(String err)
    {
        super(err);
    }
}
