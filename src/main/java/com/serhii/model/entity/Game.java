package com.serhii.model.entity;

public class Game {
    private int id;
    private Long teamId;
    private int viewerScore;
    private int teamScore;
    private String currentAnswer;
    private Long currentQuestionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getViewerScore() {
        return viewerScore;
    }

    public void setViewerScore(int viewerScore) {
        this.viewerScore = viewerScore;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public Long getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(Long currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", viewerScore=" + viewerScore +
                ", teamScore=" + teamScore +
                ", currentAnswer='" + currentAnswer + '\'' +
                ", currentQuestionId=" + currentQuestionId +
                '}';
    }

    public static Builder builder() {
        return new Game().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder id(int id) {
            Game.this.id = id;
            return this;
        }

        public Builder viewerScore(int viewerScore) {
            Game.this.viewerScore = viewerScore;
            return this;
        }

        public Builder teamScore(int teamScore) {
            Game.this.teamScore = teamScore;
            return this;
        }


        public Builder currentAnswer(String currentAnswer) {
            Game.this.currentAnswer = currentAnswer;
            return this;
        }

        public Builder teamId(Long teamId) {
            Game.this.teamId = teamId;
            return this;
        }

        public Builder currentQuestionId(Long currentQuestionId) {
            Game.this.currentQuestionId = currentQuestionId;
            return this;
        }

        public Game build() {
            return Game.this;
        }
    }
}
