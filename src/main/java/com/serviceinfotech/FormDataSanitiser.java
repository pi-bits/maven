package com.serviceinfotech;

public interface FormDataSanitiser<T> {
    public void sanitise(T formData);
}
