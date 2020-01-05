package Lab5.Lab5_1;

class LinkedStack implements Stack
{
    private SimpleLinkedList simpleLinkedList;

    LinkedStack()
    {
        simpleLinkedList = new SimpleLinkedList();
    }

    public int size()
    {
        return simpleLinkedList.size();
    }

    public boolean isEmpty()
    {
        return simpleLinkedList.isEmpty();
    }

    public boolean isFull()
    {
        return false;
    }

    public Object top() throws StackEmptyException
    {
        if(isEmpty())
        {
            throw new StackEmptyException("Stack is empty.");
        }

        return simpleLinkedList.getFirst();
    }

    public void push(Object item) throws StackFullException
    {
        simpleLinkedList.insertFirst(item);
    }

    public Object pop() throws StackEmptyException
    {
        if(isEmpty())
        {
            throw new StackEmptyException("Stack is empty.");
        }

        return simpleLinkedList.removeFirst();
    }
}
