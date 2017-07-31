package com.wexos.guru.education;



        import android.content.Intent;
        import android.graphics.PixelFormat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

public class Flash extends AppCompatActivity {
    TextView sample;


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        StartAnimations();
    }
    private void StartAnimations() {
        sample= (TextView) findViewById(R.id.text);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade);
        anim.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.relative);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
        sample.setVisibility(View.VISIBLE);
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Flash.this,
                            Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Flash.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Flash.this.finish();
                }

            }
        };
        splashTread.start();

    }
}
