package com.Mobile.App.Library;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class ExtendLoanActivity extends AppCompatActivity {

    EditText editTextBookId;
    TextView textViewSelectedDate;
    Button buttonSelectDate, buttonExtendLoan;
    String selectedDueDate = "";
    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_loan);

        editTextBookId = findViewById(R.id.editTextBookId);
        textViewSelectedDate = findViewById(R.id.textViewSelectedDate);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        buttonExtendLoan = findViewById(R.id.buttonExtendLoan);
        myDB = new MyDatabaseHelper(this);

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ExtendLoanActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                selectedDueDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                                textViewSelectedDate.setText("Selected Date: " + selectedDueDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        buttonExtendLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookId = editTextBookId.getText().toString();
                if (!bookId.isEmpty() && !selectedDueDate.isEmpty()) {
                    myDB.extendBookLoan(Integer.parseInt(bookId), selectedDueDate);
                } else {
                    Toast.makeText(ExtendLoanActivity.this, "Please select a book and a date", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
