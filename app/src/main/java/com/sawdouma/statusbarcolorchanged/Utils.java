package com.sawdouma.statusbarcolorchanged;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

class Utils {
    private static int getStatusBarHeight(Context context) {
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId = appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    static void setStatusbarColor(Activity activity, View view) {
        Window w = activity.getWindow();
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            int statusBarHeight = getStatusBarHeight(activity);
            view.setLayoutParams(new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT
                    , view.getLayoutParams().height + statusBarHeight));
            view.setPadding(0, statusBarHeight, 0, 0);
        }
    }
}