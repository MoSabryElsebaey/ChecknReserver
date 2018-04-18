package eng.example.canon.checknreserve;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Availabilty extends AppCompatActivity implements View.OnClickListener {
    Button sDate,sTime,bnext;
    EditText eDate,eTime;
    private int year,month,day,hour,minute;
    private Intent obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabilty);

        sDate=findViewById(R.id.sDate);
        sTime=findViewById(R.id.sTime);
        eDate=findViewById(R.id.eDate);
        eTime=findViewById(R.id.eTime);
        bnext=findViewById(R.id.bnext);

        sDate.setOnClickListener(this);
        sTime.setOnClickListener(this);
        //open reservation activity
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj=new Intent(Availabilty.this,Reservation2.class);
                startActivity(obj);

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v==sDate){
            final Calendar c = Calendar.getInstance();
            day= c.get(Calendar.DAY_OF_MONTH);
            month= c.get(Calendar.MONTH);
            year= c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eDate.setText(dayOfMonth +"/"+ (month+1) +"/"+ year);

                }
            }
            ,day,month,year);
            datePickerDialog.show();

            }

            if (v==sTime){
                final Calendar c = Calendar.getInstance();
                hour= c.get(Calendar.HOUR_OF_DAY);
                minute= c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        eTime.setText(hourOfDay+" : "+minute);
                    }
                }
                ,hour,minute,false);
                timePickerDialog.show();

            }
        }

    }


