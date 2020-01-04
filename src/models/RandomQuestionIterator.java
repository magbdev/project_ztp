package models;

public class RandomQuestionIterator extends MyIterator {
    @Override
    public boolean hasNext() {
        return false;
    }
    public Question next(){
        return new Question();
    }
}
