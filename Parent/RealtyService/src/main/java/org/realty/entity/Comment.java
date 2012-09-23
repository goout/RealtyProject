package org.realty.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    //private String commentatorName;
    private Long commentId;
    private String addedDate;
    private String text;
    private User user;
    private Advert advert;
  //  private Long userId;
  //  private Long advertId;

  //     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  //Date date = new Date();
  //  dateFormat.format(date);


    public Comment() {
    }


    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    public Long getCommentId() {

        return commentId;
    }
    @Column(name="text")
    public String getText() {

        return text;
    }


    public void setCommentId(Long newVal) {
        commentId = newVal;
    }

    public void setText(String newVal) {
        text = newVal;
    }
/*    @Column(name="user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Column(name="advert_id")
    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }*/

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {

          this.addedDate = addedDate;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name="advert_id")
    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}