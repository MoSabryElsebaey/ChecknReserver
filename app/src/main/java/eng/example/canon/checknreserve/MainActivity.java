package eng.example.canon.checknreserve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView home,availability,reservation2;
    private Intent ob;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home=findViewById(R.id.home);
        availability=findViewById(R.id.availabilty);
        reservation2=findViewById(R.id.reservation2);

        //open Home activity
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ob=new Intent(MainActivity.this,Home.class);
                startActivity(ob);
            }
        });
        //open availability activity
        availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ob=new Intent(MainActivity.this,Availabilty.class);
                startActivity(ob);
            }
        });
        //open reservation activity
        reservation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ob=new Intent(MainActivity.this,Reservation2.class);
                startActivity(ob);
            }
        });
    }





    @Override
    public void onClick(View v) {

    }
}
