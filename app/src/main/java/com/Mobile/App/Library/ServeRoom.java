package com.Mobile.App.Library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ServeRoom extends AppCompatActivity {

    private EditText titleInput, authorInput, pagesInput, durationInput;
    private Button serveButton;  // Ganti addButton menjadi serveButton
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve_room);  // Ganti R.layout.activity_main dengan R.layout.activity_serve_room

        // Inisialisasi elemen-elemen dari layout
        titleInput = findViewById(R.id.title_input);
        authorInput = findViewById(R.id.author_input);
        pagesInput = findViewById(R.id.pages_input);
        durationInput = findViewById(R.id.duration_input);
        serveButton = findViewById(R.id.add_button);  // Ganti addButton dengan serveButton
        imageView = findViewById(R.id.imageView);

        // Mengatur onClickListener untuk tombol "Serve"
        serveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle aksi ketika tombol "Serve" ditekan
                serveRoom();
            }
        });
    }

    // Metode untuk menangani aksi ketika tombol "Serve" ditekan
    private void serveRoom() {
        // Ambil nilai dari EditText
        String title = titleInput.getText().toString();
        String author = authorInput.getText().toString();
        String pages = pagesInput.getText().toString();
        String duration = durationInput.getText().toString();

        // Lakukan sesuatu dengan nilai-nilai yang diambil, misalnya, tampilkan dalam log atau kirim ke server

        // Tampilkan pesan sukses
        String successMessage = "Success Add Room: ";

        // Anda dapat menyesuaikan cara menampilkan pesan sukses, seperti dengan Toast atau Snackbar
        // Contoh menggunakan Toast:
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show();

        // Kirim hasil kembali ke MainActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("resultKey", successMessage);
        setResult(RESULT_OK, resultIntent);

        // Tutup aktivitas ServeRoom
        finish();
    }
}
