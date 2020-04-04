package com.ashish.portfolio.passwordStorage.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="tblPasswordStorage")
public class PasswordStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generated_default_id")
    @TableGenerator(
            name = "generated_default_id",
            table = "passwordStorageDefaultId",
            initialValue = 10000)
    @Column(name = "Id")
    @NotNull
    private long id;

    @NotNull(message = "Username cannot be empty.")
    @Column(name = "Username")
    private String username;

    @NotNull(message = "Password cannot be empty.")
    @Column(name = "Password")
    private String password;

    @Column(name = "Question1")
    private String question1;

    @Column(name = "Question2")
    private String question2;

    @Column(name = "Question3")
    private String question3;

    @Column(name = "Question4")
    private String question4;

    @Column(name = "Question5")
    private String question5;

    @Column(name = "Answer1")
    private String answer1;

    @Column(name = "Answer2")
    private String answer2;

    @Column(name = "Answer3")
    private String answer3;

    @Column(name = "Answer4")
    private String answer4;

    @Column(name = "Answer5")
    private String answer5;

    @CreationTimestamp
    @Column(name = "Created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "Modified")
    private LocalDateTime modified;

    @Column(name = "Deleted", columnDefinition = "TINYINT default 0")
    @NotNull
    private boolean deleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
