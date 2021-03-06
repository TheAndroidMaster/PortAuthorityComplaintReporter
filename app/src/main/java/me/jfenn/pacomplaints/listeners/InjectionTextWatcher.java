package me.jfenn.pacomplaints.listeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import me.jfenn.pacomplaints.Complainter;

public class InjectionTextWatcher implements TextWatcher {

    private EditText editText;
    private String id;
    private String name;
    private int index;

    public InjectionTextWatcher(EditText editText, String id) {
        this.editText = editText;
        this.id = id;

        editText.addTextChangedListener(this);
        onTextChanged("", 0, 0, 0);
    }

    public InjectionTextWatcher(EditText editText, String name, int index) {
        this.editText = editText;
        this.name = name;
        this.index = index;

        editText.addTextChangedListener(this);
        onTextChanged("", 0, 0, 0);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (id != null)
            ((Complainter) editText.getContext().getApplicationContext()).setAttribute(id, "value", "\"" + editText.getText().toString() + "\"");
        else
            ((Complainter) editText.getContext().getApplicationContext()).setAttributeByName(name, index, "value", "\"" + editText.getText().toString() + "\"");
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
