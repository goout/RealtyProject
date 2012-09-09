package org.realty.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    //private String commentatorName;
    private int commentId;
    private String addedDate;
    private String text;
    private Long userId;
    private Long advertId;

  //     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  //Date date = new Date();
  //  dateFormat.format(date);


    public Comment() {
    }

    /*	public String getcommentatorName() {
         return commentatorName;
     }*/
    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    public int getCommentId() {

        return commentId;
    }
    @Column(name="text")
    public String getText() {

        return text;
    }

/*	public void setcommentatorName(String newVal) {
		commentatorName = newVal;
	}*/

    public void setCommentId(int newVal) {
        commentId = newVal;
    }

    public void setText(String newVal) {
        text = newVal;
    }
    @Column(name="user_id")
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
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {

          this.addedDate = addedDate;
    }
}