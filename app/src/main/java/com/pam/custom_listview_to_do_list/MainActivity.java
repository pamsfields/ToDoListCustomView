package com.pam.custom_listview_to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewButton = (Button) findViewById(R.id.new_todo_item_button);
        final EditText newToDoEditText = (EditText) findViewById(R.id.new_todo_item_edittext);

        ListView todoListView = (ListView) findViewById(R.id.todo_listview);

        //Create ArrayAdapter
        final ToDoListAdapter todoListAdapter = new ToDoListAdapter(this, R.layout.todo_list_item);

        //Configure the ListView to use this Adapter for data
        todoListView.setAdapter(todoListAdapter);

        //Add listener to the button, to add items to the ListView
        addNewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Read whatever user has typed into newToDoEditText
                String newItemText = newToDoEditText.getText().toString();

                //Make sure some data was entered. Show error Toast and return if not
                if (newItemText.length()==0){
                    Toast.makeText(MainActivity.this, "Enter a todo item", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Else, create a new ToDoItem from the text, and add to the ArrayAdapter
                ToDoItem newItem = new ToDoItem(newItemText);
                todoListAdapter.add(newItem);

                //And notify the ArrayAdapter that the data set has changed, to request UI update
                todoListAdapter.notifyDataSetChanged();;

                //Clear EditText, ready to type in next item
                newToDoEditText.getText().clear();
            }
        });

    }
}
