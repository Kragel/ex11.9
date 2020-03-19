package t_11_holdingYourObjects.ex09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence implements Iterable<Object> {
    private List<Object> items;

    public Sequence(int size)
    {
        items = new ArrayList<Object>(size);
    }

    public void add(Object x)
    {
        items.add(x);
    }

    private class SequenceInterator implements Iterator<Object> {
        private int i = 0;

        @Override
        public boolean hasNext()
        {
            return i < items.size();
        }

        @Override
        public Object next()
        {
            return items.get(i++);
        }

    }

    public static void main(String[] args)
    {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
        {
            sequence.add(Integer.toString(i));
        }

        Iterator<Object> iterator = sequence.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
    }

    @Override
    public Iterator<Object> iterator()
    {
        return new SequenceInterator();
    }
}
