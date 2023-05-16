package sevenone.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import sevenone.lostandfound.data.DatabaseHelper;
import sevenone.lostandfound.model.Item;

public class CreateItemActivity extends AppCompatActivity {
    CheckBox lostCheckbox;
    CheckBox foundCheckbox;
    EditText nameText;
    EditText numberText;
    EditText descriptionText;
    EditText dateText;
    EditText locationText;
    Button submitButton;
    DatabaseHelper db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_advert);
        db = new DatabaseHelper(this);
        lostCheckbox = findViewById(R.id.checkBox);
        foundCheckbox = findViewById(R.id.checkBox2);
        nameText = findViewById(R.id.editTextTextPersonName);
        numberText = findViewById(R.id.editTextPhone);
        descriptionText = findViewById(R.id.editTextTextPersonName2);
        dateText = findViewById(R.id.editTextDate);
        locationText = findViewById(R.id.editTextTextPersonName3);
        submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean lost = lostCheckbox.isChecked();
                Boolean found = foundCheckbox.isChecked();
                String name = nameText.getText().toString();
                String number = numberText.getText().toString();
                String description = descriptionText.getText().toString();
                String date = dateText.getText().toString();
                String location = locationText.getText().toString();
                String status = null;

                if(lost == true && found == false)
                {
                    status = "Lost";
                }
                else if(lost == false && found == true)
                {
                    status = "found";
                }
                else
                {
                    status = "unknown";
                }
                long result = db.insertItem(new Item(status, name, description, location, number, date));
                if(result > 0)
                {
                    Toast.makeText(CreateItemActivity.this, "Successfully entered item into database", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(CreateItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
