package www.bmsit.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button bstart,bstop;
TextView tv;
int counter=1;
Handler myhandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bstart = findViewById(R.id.button_start);
        bstop = findViewById(R.id.button_stop);
        tv=findViewById(R.id.tv_timer);
        bstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            myhandler.postDelayed(Timer_Thread,0);

        }});
        bstop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            myhandler.removeCallbacks(Timer_Thread);
            }});
    }
    private final Runnable Timer_Thread=new Runnable() {
        @Override
        public void run() {
        tv.setText(""+counter);
        myhandler.postDelayed(this,2000);
        counter++;
        }
    };
}
