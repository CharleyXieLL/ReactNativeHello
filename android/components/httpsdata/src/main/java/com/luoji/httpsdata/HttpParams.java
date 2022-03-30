package com.luoji.httpsdata;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class HttpParams
        implements ParameterizedType {

    private final Class aClassValue;
    private final Type[] typesValue;
    private final Type typeValue;

    public HttpParams(Class aClassValue, Type[] typesValue, Type typeValue) {
        this.aClassValue = aClassValue;
        this.typesValue = typesValue != null ? typesValue : new Type[0];
        this.typeValue = typeValue;
        try {
            aliMaMaWalletCheckArgs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aliMaMaWalletCheckArgs() throws Exception {
        if (aClassValue == null) {
            throw new Exception("Class class can't be null");
        }
        TypeVariable[] aClassTypeParametersValue = aClassValue.getTypeParameters();
        if (typesValue.length != 0 && aClassTypeParametersValue.length
                != typesValue.length) {
            throw new Exception(
                    aClassValue.getName()
                            + " expect " +
                            aClassTypeParametersValue.length
                            + " arg(s), got " +
                            typesValue.length);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderValue = new StringBuilder();
        stringBuilderValue.append(aClassValue.getName());
        if (typesValue.length != 0) {
            stringBuilderValue.append('<');
            for (int aliMaMaWallet = 0; aliMaMaWallet < typesValue.length; aliMaMaWallet++) {
                if (aliMaMaWallet != 0) {
                    stringBuilderValue.append(", ");
                }
                Type httpTypeValue = typesValue[aliMaMaWallet];
                if (httpTypeValue instanceof Class) {
                    Class aClassValue = (Class) httpTypeValue;
                    if (aClassValue.isArray()) {
                        int tagValue = 0;
                        do {
                            tagValue++;
                            aClassValue = aClassValue.getComponentType();
                        } while (aClassValue.isArray());

                        stringBuilderValue.append(aClassValue.getName());

                        for (int ppp = tagValue; ppp > 0; ppp--) {
                            stringBuilderValue.append("[]");
                        }
                    } else {
                        stringBuilderValue.append(aClassValue.getName());
                    }
                } else {
                    stringBuilderValue.append(typesValue[aliMaMaWallet].toString());
                }
            }
            stringBuilderValue.append('>');
        }
        return stringBuilderValue.toString();
    }


    @Override
    public Type[] getActualTypeArguments() {
        return typesValue;
    }

    @Override
    public Type getRawType() {
        return aClassValue;
    }

    @Override
    public Type getOwnerType() {
        return typeValue;
    }

    @Override
    public boolean equals(Object objectValue) {
        if (this == objectValue) {
            return true;
        }
        if (objectValue == null || getClass() != objectValue.getClass()) {
            return false;
        }

        HttpParams
            aliMaMaWalletAppHttpParamsValue = (HttpParams) objectValue;

        if (!aClassValue.equals(aliMaMaWalletAppHttpParamsValue.aClassValue)) {
            return false;
        }
        if (!Arrays.equals(typesValue, aliMaMaWalletAppHttpParamsValue.typesValue)) {
            return false;
        }
        return Objects.equals(typeValue, aliMaMaWalletAppHttpParamsValue.typeValue);
    }

    @Override
    public int hashCode() {
        int httpResultValue = aClassValue.hashCode();
        httpResultValue = 31 * httpResultValue + Arrays.hashCode(typesValue);
        httpResultValue = 31 * httpResultValue + (typeValue != null ? typeValue.hashCode() : 0);
        return httpResultValue;
    }


}
