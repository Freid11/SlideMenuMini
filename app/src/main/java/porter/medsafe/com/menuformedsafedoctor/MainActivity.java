package porter.medsafe.com.menuformedsafedoctor;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MySlidingPane splLeft;
    MySlidingPane splRight;
    public static String TAG_LOG = "LogLouco";
    public static int width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        splLeft = (MySlidingPane) findViewById(R.id.spl_left);
        splRight = (MySlidingPane) findViewById(R.id.spl_right);
        splLeft.setSide(MySlidingPane.SIDE_LEFT);
        splRight.setSide(MySlidingPane.SIDE_RIGHT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.left_menu:
                if(splLeft.isOpen())splLeft.closePane();
                else splLeft.openPane();
                break;
            case R.id.right_menu:
                if(splRight.isOpen())splRight.closePane();
                else splRight.openPane();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class ListenerSlide implements SlidingPaneLayout.PanelSlideListener{
        private String NameSPL;

        ListenerSlide(String nameSPL) {
            NameSPL = nameSPL;
        }

        @Override
        public void onPanelSlide(View panel, float slideOffset) {
        }

        @Override
        public void onPanelOpened(View panel) {
        }

        @Override
        public void onPanelClosed(View panel) {
        }
    }
}
