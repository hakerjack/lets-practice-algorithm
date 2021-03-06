package com.hakerjack.crackthecodinginterview.data;

import com.orm.SugarRecord;

/**
 * Created by kjia on 3/23/16.
 */
public class Problem extends SugarRecord {
    private String title;
    private String content;
    private String example;
    private String note;

    private int visitedTime;
    private int completedTime;


    public Problem() {}

    public Problem(Builder builder) {
        Problem p = new Problem();
        p.title = builder.title;
        p.content = builder.content;
        p.example = builder.example;
        p.note = builder.note;
        p.visitedTime = 0;
        p.completedTime = 0;
        p.save();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getExample() {
        return example;
    }

    public String getNote() {
        return note;
    }

    public void incrementVisitedTime() {
        visitedTime++;
    }

    public void incrementCompleteTime() {
        completedTime++;
    }

    public final static class Builder {
        private String title;
        private String content;
        private String example;
        private String note;

        public Builder() {}

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setExample(String example) {
            this.example = example;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public Problem build() {
            return new Problem(this);
        }
    }
}
