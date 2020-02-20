package com.serhii.model.entity;


public class Question {
    private Long id;
    private String title;
    private String description;
    private String help;
    private String answer;
    private Long gameId;
    private boolean answered;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHelp() {
        return help;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getGameId() {
        return gameId;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", help='" + help + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Question().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder title(String title) {
            Question.this.title = title;
            return this;
        }

        public Builder description(String description) {
            Question.this.description = description;
            return this;
        }

        public Builder help(String help) {
            Question.this.help = help;
            return this;
        }


        public Builder answer(String answer) {
            Question.this.answer = answer;
            return this;
        }

        public Builder id(Long id) {
            Question.this.id = id;
            return this;
        }

        public Builder gameId(Long gameId) {
            Question.this.gameId = gameId;
            return this;
        }

        public Builder answered(boolean answered) {
            Question.this.answered = answered;
            return this;
        }

        public Question build() {
            return Question.this;
        }
    }
}
