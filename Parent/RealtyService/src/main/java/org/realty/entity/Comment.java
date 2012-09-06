package org.realty.entity;


import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    //private String commentatorName;
    private int commentId;
    private String text;
    private Long userId;
    private Long advertId;


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

}