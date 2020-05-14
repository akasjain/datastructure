package patterns.iterator;

public class TopicIterator implements Iterator {

    Topic[] topics;
    private int position;

    public TopicIterator(Topic[] topics) {
        this.topics = topics;
        position = 0;
    }

    @Override
    public void reset() {
        position = 0;
    }

    @Override
    public Object next() {
        return topics[position++];
    }

    @Override
    public Object currentItem() {
        return topics[position];
    }

    @Override
    public boolean hasNext() {
        if(position >= topics.length)
            return false;

        return true;
    }
}
