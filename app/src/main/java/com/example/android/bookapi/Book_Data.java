package com.example.android.bookapi;

/**
 * Created by sufya on 02-08-2017.
 */

public class Book_Data {
    private String mImgid,mTitle,mAuth_nme,mPurchaseLnk,mprice;
    //private int mImgid;

    public Book_Data(String imgId,String title,String auth_nme,String price,String purLink)
    {
        this.mImgid=imgId;
        this.mTitle=title;
        this.mAuth_nme=auth_nme;
        this.mprice=price;
        this.mPurchaseLnk=purLink;
    }

    public String getImgid(){return mImgid;}
    public String getTitle(){return mTitle;}
    public String getAut_nme(){return mAuth_nme;}
    public String getMprice(){return mprice;}
    public String getPurchase_Link(){return mPurchaseLnk;}
}

