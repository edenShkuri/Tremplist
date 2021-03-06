package com.myapp.tremplist_update.viewModel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

// This class is in charge of the TimePicking in any situation on the app
public class TimePickerFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        Calendar c = Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute= c.get(Calendar.MINUTE);
        int style = AlertDialog.THEME_HOLO_DARK;
        return new TimePickerDialog(getActivity(), style, (TimePickerDialog.OnTimeSetListener)getActivity(), hour, minute,true);
    }
}
