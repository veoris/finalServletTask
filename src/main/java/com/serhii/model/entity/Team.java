package com.serhii.model.entity;

public class Team {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Team().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder id(Long id) {
            Team.this.id = id;
            return this;
        }

        public Builder name(String name) {
            Team.this.name = name;
            return this;
        }

        public Team build() {
            return Team.this;
        }
    }
}
