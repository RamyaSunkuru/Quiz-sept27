package com.example.ramya.quiz;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class SubmitActivity extends android.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure, you wanted to submit ?");
        setCancelable(false);
        builder.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Bundle bundle= getArguments();
                int mScore =  bundle.getInt("mScore");

               //Intent intent= new Intent(SubmitActivity.this,ScoreBoardActivity.class);

                Intent intent = new Intent(getActivity(),ScoreBoardActivity.class);
                intent.putExtra("score",mScore);
                startActivity(intent);
                getActivity().finish();


                // User clicked OK, so save the mSelectedItems results somewhere
                // or return them to the component that opened the dialog
            }
        });
        return builder.create();
    }
}