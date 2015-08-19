package org.androidtown.mydata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수", "영희", "민희", "수지", "지민"};
    //String[] names = new String[5];

    int count = 0;

    Person[] persons = new Person[5];
    //Person person01;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //names[0] = "철수";
        //names[1] = "영희";
        //names[2] = "민희";
        //names[3] = "수지";
        //names[4] = "지민";


        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (count >= persons.length) {
                    Person[] tempPersons = new Person[persons.length + 5];
                    System.arraycopy(persons, 0, tempPersons, 0, persons.length);
                    persons = tempPersons;
                }

                int nameIndex = count % 5;
                persons[count] = new Person(names[nameIndex]);
                Toast.makeText(getApplicationContext(), "사람 " + names[nameIndex] + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                count++;

                textView.setText(count + " 명");

				/*
	    		if (count < names.length) {
	    			persons[count] = new Person(names[count]);
	    			//person01 = new Person(names[count]);
	    			Toast.makeText(getApplicationContext(),
	    		                        "사람 " + names[count] + "이 만들어졌습니다.",
	    		                        Toast.LENGTH_LONG).show();
	    		} else {
	    			Toast.makeText(getApplicationContext(),
	    		                        "사람 이름이 없습니다.",
	    		                        Toast.LENGTH_LONG).show();
	    		}

	    		count++;

	    		for (int i = 0; i < names.length; i++) {
					System.out.println(i + " : " + names[i]);
				}
	    		*/

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
