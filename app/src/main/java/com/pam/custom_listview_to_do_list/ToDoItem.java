package com.pam.custom_listview_to_do_list;

import java.util.Date;

/**
 * Created by Pam on 9/27/2017.
 */

public class ToDoItem {
    String text;
    Date created;

    public ToDoItem(String text){
        this.text = text;
        this.created = new Date();
    }

    public Date getCreated(){
        return created;
    }

    public String getText(){
        return text;
    }
}
