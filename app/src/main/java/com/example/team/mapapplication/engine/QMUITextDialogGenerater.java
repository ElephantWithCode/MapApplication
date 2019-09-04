package com.example.team.mapapplication.engine;

import android.content.Context;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class QMUITextDialogGenerater {

    private QMUIDialog mDialog;
    private QMUIDialog.MessageDialogBuilder mBuider;

    public QMUITextDialogGenerater(Context context, String message){
        mBuider = new QMUIDialog.MessageDialogBuilder(context)
                .setMessage(message)
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                });
        mDialog = mBuider.create();
    }

    public QMUIDialog getDialog(){
        return mDialog;
    }

}
