package com.serviceinfotech.controllers;

import org.springframework.beans.PropertyValuesEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.beans.PropertyEditorSupport;

public class CustomIntegerEditor extends CustomNumberEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setAsText(text);
    }

    @Override
    public String getAsText() {
        return "";
    }

    public CustomIntegerEditor(Class<? extends Number> numberClass, boolean allowEmpty) throws IllegalArgumentException {
        super(numberClass, allowEmpty);
    }

    @Override
    public Object getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Object value) {
        getValue().getClass();
        super.setValue(value);
    }
}
