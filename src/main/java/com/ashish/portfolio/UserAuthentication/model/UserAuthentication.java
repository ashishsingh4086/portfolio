package com.ashish.portfolio.UserAuthentication.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblAuthentication")
public class UserAuthentication {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id")
  private long id;

  @NotNull
  @Column(name = "Username")
  private String username;

  @NotNull
  @Column(name = "Password")
  private String password;

  @CreationTimestamp
  @Column(name = "Created")
  private LocalDateTime created;

  @UpdateTimestamp
  @Column(name = "Modified")
  private LocalDateTime modified;

  @NotNull
  @Column(name = "Deleted")
  private boolean deleted;

  @NotNull
  @Column(name = "UserRole")
  private String userROles;

  @NotNull
  @Column(name = "Active", columnDefinition = "BIT default 1")
  private boolean isActive;

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

  public String getUserROles() {
    return userROles;
  }

  public void setUserROles(String userROles) {
    this.userROles = userROles;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
