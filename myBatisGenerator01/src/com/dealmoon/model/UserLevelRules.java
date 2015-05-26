package com.dealmoon.model;

public class UserLevelRules {
    private Integer id;

    private Integer level;

    private Integer minScore;

    private Integer maxScore;

    private Integer commentLimit;

    private Integer postLimit;

    private String name;

    private Boolean vip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getCommentLimit() {
        return commentLimit;
    }

    public void setCommentLimit(Integer commentLimit) {
        this.commentLimit = commentLimit;
    }

    public Integer getPostLimit() {
        return postLimit;
    }

    public void setPostLimit(Integer postLimit) {
        this.postLimit = postLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }
}