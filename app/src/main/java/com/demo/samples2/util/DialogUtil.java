package com.demo.samples2.util;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import com.demo.samples2.R;

/**
 * Helper to show dialogs
 */
public class DialogUtil {

    /**
     * Dims the background when popup appears
     * @param dialog
     */
    public static void dimBackground(Dialog dialog) {

      ColorDrawable dw = new ColorDrawable(0xb0000000);
      dialog.getWindow().setBackgroundDrawable(dw);
    }

    public static Dialog showInfoMessageDialog(Activity activity, String msg) {

      return DialogUtil.showMessageDialog(activity, "Bubble App", msg);
    }

    public static Dialog showErrorMessageDialog(Activity activity, String msg) {

      return DialogUtil.showMessageDialog(activity, "Error", msg);
    }

    public static Dialog showMessageDialog(Activity activity, String title, String msg) {

        final Dialog dialog = new Dialog(activity, R.style.Theme_Dialog);

        dialog.setContentView(R.layout.message_dialog);

        // set the custom dialog components - text, image and button
        TextView header = (TextView) dialog.findViewById(R.id.dialog_header);
        header.setText(title);

        TextView text = (TextView) dialog.findViewById(R.id.message_text);
        text.setText(msg);

        TextView dialogButton = (TextView) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        return dialog;
    }

}
