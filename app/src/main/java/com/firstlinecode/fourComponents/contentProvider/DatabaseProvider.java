package com.firstlinecode.fourComponents.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import org.litepal.tablemanager.Connector;

import java.util.regex.Matcher;

public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR=0;
    public static final int BOOK_ITEM=1;
    public static final int CATEGORY_DIR=2;
    public static final int CATEGORY_ITEM=3;
    public static final String AUTHORITY="com.firstlinecode.provider";//定义内容提供则时候的authorityName，打开androidManifest.xml看一下就可以了
    public static UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);//可供外部访问的Uri的枚举
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);
    }

    private SQLiteDatabase db;

    public DatabaseProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        db=Connector.getDatabase();
        int deleteRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRows=db.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookid=uri.getPathSegments().get(1);
                deleteRows=db.delete("Book","id=?",new String[]{bookid});
        }
        return deleteRows;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.dir/vnd.com.firstlinecode.book";//前半截表示book表所有的行，规定写法，后半截vnd+包名+表名
            case BOOK_ITEM:
                return "vnd.android.item/vnd.com.firstlinecode.book";//前半截表示book表中的某一行，规定写法，后半截vnd+包名+表名
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        db = Connector.getDatabase();
        Uri uriReturn=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long bookid=db.insert("book",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/book/"+bookid);
                break;

        }
        return uriReturn;
    }

    @Override
    public boolean onCreate() {
        db = Connector.getDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        db = Connector.getDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor=db.query("book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                cursor=db.query("book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor=db.query("book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CATEGORY_ITEM:
                cursor=db.query("book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        db=Connector.getDatabase();
        int updateRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRows=db.update("book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String newBookId=uri.getPathSegments().get(1);
                updateRows=db.update("book",values,"id=?",new String[]{newBookId});
                break;
        }
        return updateRows;
    }
}
