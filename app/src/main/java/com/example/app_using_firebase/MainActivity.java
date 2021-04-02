package com.example.app_using_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button logout,add;
    private EditText name;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.Main_logoutBtn);
        add = findViewById(R.id.Main_add);
        name = findViewById(R.id.Main_name);
        listView = findViewById(R.id.Main_listView);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,StartActivity.class));
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametxt = name.getText().toString();
                if (nametxt.isEmpty()){
                    Toast.makeText(MainActivity.this, "No Name Entered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    FirebaseDatabase.getInstance().getReference().child("Riddhiman").push().child("Name").setValue(nametxt);
                }
            }
        });
        ArrayList<String> list = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_items,list);

        listView.setAdapter(adapter);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("info");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                list.clear();
                   for (DataSnapshot snapshot1 : snapshot.getChildren()){
                       list.add(snapshot1.getValue().toString());
                   }
                   adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });

    }
}