package com.gl.eugene.demo.jpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gl.eugene.demo.model.Grade;

@Document("rating")
public class RatingEntity {

    @Id
    private String id;

    private int totalGames;
    private int wonGames;
    private Grade grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + totalGames;
        result = prime * result + wonGames;
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RatingEntity other = (RatingEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (totalGames != other.totalGames)
            return false;
        if (wonGames != other.wonGames)
            return false;
        if (grade != other.grade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rating [id=" + id + ", totalGames=" + totalGames + ", wonGames=" + wonGames + ", grade=" + grade + "]";
    }

}
