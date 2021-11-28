package dev.dworks.apps.anexplorer.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import dev.dworks.apps.anexplorer.HelloActivity;
import dev.dworks.apps.anexplorer.R;
import dev.dworks.apps.anexplorer.common.DialogBuilder;
import dev.dworks.apps.anexplorer.common.DialogFragment;
import dev.dworks.apps.anexplorer.misc.AnalyticsManager;

public class HelloFragment extends DialogFragment {

    public static void show(FragmentManager fm) {
        final HelloFragment dialog = new HelloFragment();
        dialog.show(fm, "hello");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Context context = getActivity();
        final DialogBuilder builder = new DialogBuilder(context);
        final LayoutInflater dialogInflater = LayoutInflater.from(context);
        final View view = dialogInflater.inflate(R.layout.dialog_create_dir, null, false);
        builder.setTitle("Hello");
        builder.setView(view);
        builder.setPositiveButton("Hello", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), HelloActivity.class);
                EditText editText = view.findViewById(android.R.id.text1);
                intent.putExtra("message", editText.getText().toString());
                startActivity(intent);
                AnalyticsManager.logEvent("hello_open");
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        return builder.create();
    }

}
