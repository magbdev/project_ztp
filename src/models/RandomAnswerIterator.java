package models;

public class RandomAnswerIterator extends MyIterator {
    @Override
    public boolean hasNext() {
        return false;
    }
    public Answer next(){
        return new Answer();
    }
}
