class ArrayQueue implements Queue
{
    public static final int CAPACITY = 100;
    private int capacity;
    private Object[] object;
    private int first = 0, last = 0;

    ArrayQueue()
    {
        this(CAPACITY);
    }

    ArrayQueue(int capacity)
    {
        this.capacity = capacity;
        object = new Object[capacity];
    }

    public int size()
    {
        return last - first;
    }

    public boolean isEmpty()
    {
        return first == last;
    }

    public boolean isFull()
    {
        return size() == capacity;
    }

    public Object front() throws QueueEmptyException
    {
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is empty");
        }

        return object[first];
    }


    private void aristera(){
    	for (int i=first;i<last ;i++) {
    		object[i-first]=object[i];
    		last=last-first;
    		first=0;
    	}
    }

    public void enqueue(Object item) throws QueueFullException
    {
        if(isFull())
        {
            throw new QueueFullException("Queue overflow");
        }
        if (last=object.length){
        	aristera();
        }

        object[last++] = item;
    }

    public Object dequeue() throws QueueEmptyException
    {
        if(isEmpty())
        {
            throw new QueueEmptyException("Queue is empty");
        }

        Object tmp;
        tmp = object[first];
        object[first++] = null;

        return tmp;
    }
}
