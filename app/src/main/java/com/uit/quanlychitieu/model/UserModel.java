package com.uit.quanlychitieu.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.Observable;

import com.uit.quanlychitieu.BR;
import com.uit.quanlychitieu.MainActivity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserModel extends BaseObservable {
    private int userId;
    private String displayName;
    private String userName;
    private String password;
    private String email;
    private byte[] imageAvatar;
    private String dateAdd;
    private String dateModify;

    @Bindable
    public String dateAddFormated;

    @Bindable
    public String dateModifyFormated;

    @Bindable
    public Bitmap bitmap;

    public void formatData() {
        if (imageAvatar != null) {
            bitmap = BitmapFactory.decodeByteArray(imageAvatar, 0, imageAvatar.length);
        }

        String sDateAdd = dateAdd + "";
        String sDateModify = dateModify + "";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        //Định dạng ngày tháng
        Date dateAdd = new SimpleDateFormat("yyyy-MM-dd").parse(sDateAdd, new ParsePosition(0));
        dateAddFormated = dateFormat.format(dateAdd);

        //Định dạng ngày tháng
        Date dateModify = new SimpleDateFormat("yyyy-MM-dd").parse(sDateModify, new ParsePosition(0));
        dateModifyFormated = dateFormat.format(dateModify);
    }

    public UserModel(int userId, String displayName, String userName, String password, String email, byte[] imageAvatar, String dateAdd, String dateModify) {
        this.userId = userId;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.imageAvatar = imageAvatar;
        this.dateAdd = dateAdd;
        this.dateModify = dateModify;

        formatData();
    }

    @Bindable
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Bindable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public byte[] getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(byte[] imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    @Bindable
    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Bindable
    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }
}
