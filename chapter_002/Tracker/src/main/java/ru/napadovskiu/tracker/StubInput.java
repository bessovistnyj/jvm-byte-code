package ru.napadovskiu.tracker;

/**
 *
 */
public class StubInput implements  Input {

    /**
     *
     */
    private String[] answers;
    /**
     *
     */
    private  int position = 0;

    /**
     *
     * @param answers
     */
    public  StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * 
     * @param question
     * @return
     */
    public String ask(String question) {
        return answers[this.position++];
    }

}
