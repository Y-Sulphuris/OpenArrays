package com.ydo4ki.openarrays.ftable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

public interface FTableInt<O> {
    int unsafeGet(O owner, int index) throws Throwable;

    int unsafeGetExact(O owner, int index) throws Throwable;

    void unsafeSet(O owner, int index, int newValue) throws Throwable;

    void unsafeSetExact(O owner, int index, int newValue) throws Throwable;

    static <O> FTableInt<O> newTable(MethodHandles.Lookup lookup, Class<O> owner, String fieldNamesBase, int length) throws FieldTableFormingException {
        String[] names = new String[length];
        for (int i = 0; i < length; i++) {
            names[i] = fieldNamesBase + i;
        }
        return newTable(lookup, owner, names);
    }

    static <O> FTableInt<O> newTable(MethodHandles.Lookup lookup, Class<O> owner, String... fieldNames) throws FieldTableFormingException {
        if (FTableUnsafe.isAllowed) try {
            int len = fieldNames.length;
            Field[] fields = new Field[len];
            for (int i = 0; i < len; i++) {
                fields[i] = owner.getDeclaredField(fieldNames[i]);
            }
            return new FTableUnsafeInt<>(owner, fields);
        } catch (FieldTableFormingException e) {
            throw e;
        } catch (Exception e) {
            throw new FieldTableFormingException(e);
        }
        return new FTableMethodHandlesInt<>(lookup, owner, fieldNames);
    }
}
