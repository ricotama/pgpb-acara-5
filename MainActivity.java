package com.example.pgpbacara5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pgpbacara5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final String[] provinces = {
            "Aceh",
            "Bali",
            "Bangka Belitung",
            "Banten",
            "Bengkulu",
            "Gorontalo",
            "Jakarta",
            "Jambi",
            "Jawa Barat",
            "Jawa Tengah",
            "Jawa Timur",
            "Kalimantan Barat",
            "Kalimantan Selatan",
            "Kalimantan Tengah",
            "Kalimantan Timur",
            "Kalimantan Utara",
            "Kepulauan Riau",
            "Lampung",
            "Maluku",
            "Maluku Utara",
            "Nusa Tenggara Barat",
            "Nusa Tenggara Timur",
            "Papua",
            "Papua Barat",
            "Papua Pegunungan",
            "Papua Selatan",
            "Papua Tengah",
            "Riau",
            "Sulawesi Barat",
            "Sulawesi Selatan",
            "Sulawesi Tengah",
            "Sulawesi Tenggara",
            "Sulawesi Utara",
            "Sumatera Barat",
            "Sumatera Selatan",
            "Sumatera Utara",
            "Yogyakarta",

    };

    private String[] negara = {"Indonesia", "Malaysia", "Singapura", "Thailand", "Vietnam", "Filipina",
            "Brunei", "Kamboja", "Laos", "Myanmar", "Jepang", "Korea Selatan", "Tiongkok", "India",
            "Australia", "Amerika Serikat", "Kanada", "Meksiko", "Brasil", "Argentina",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));

        setContentView(binding.getRoot());

        ArrayAdapter<String> adapterProvince =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, provinces);
        adapterProvince.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerProvince.setAdapter(adapterProvince);

        ArrayAdapter<String> adapterNegara =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, negara);
        adapterNegara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerNegara.setAdapter(adapterNegara);

        binding.datePicker.init(
                binding.datePicker.getYear(),
                binding.datePicker.getMonth(),
                binding.datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(MainActivity.this, selectedDate, Toast.LENGTH_LONG).show();
                    }
                }
        );

        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String selectedTime = String.format("%02d:%02d", hourOfDay, minute);
                Toast.makeText(MainActivity.this, selectedTime, Toast.LENGTH_LONG).show();
            }
        });
    }
}