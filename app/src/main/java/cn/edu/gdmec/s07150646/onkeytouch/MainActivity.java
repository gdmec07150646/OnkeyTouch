package cn.edu.gdmec.s07150646.onkeytouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tView=new TextView(this);
        tView.setText("请单击按钮或屏幕");
        setContentView(tView);
    }

    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("按下Home键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("按下菜单键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("按下回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("按下声音加大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("按下声音减小键");
                event.startTracking();
                return true;
            default:
                SetMessage("按下的键是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode,event);
    }
    public boolean onKeyUp(int keyCode,KeyEvent event)
    {
        switch (keyCode) {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("你放开了Home键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("你放开了菜单键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("你放开了回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("你放开了声音加大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("你放开了声音减少键");
                break;
            default:
                SetMessage("放开的键是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode,event);
    }

    public boolean onKeyLongPress(int keyCode,KeyEvent event){
        SetMessage("长时间按键");
        return super.onKeyLongPress(keyCode,event);

    }
    public  boolean onTouchEvent(MotionEvent event){
        int action= event.getAction();
        if(action == MotionEvent.ACTION_CANCEL||action == MotionEvent.ACTION_DOWN||action == MotionEvent.ACTION_MOVE)
        {
            return false;
        }
        String x = String.valueOf(event.getX());
        String y = String.valueOf(event.getY());
        SetMessage("触点坐标:("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("你按下返回键了");
    }

    public void SetMessage(String str){
        String str1=tView.getText().toString();
        String str2=str1+"\n"+str;

        tView.setText(str2);
    }


}