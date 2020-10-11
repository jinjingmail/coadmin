package com.gitee.coadmin.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


class UnSerializeResult {
    public Object value;
    public int hv;
    public UnSerializeResult() {}

    public UnSerializeResult(Object value, int hv) {
        this.value = value;
        this.hv = hv;
    }
}

interface Serializable {
    byte[] serialize();
    void unserialize(byte[] ss);
}

/** @ClassName PHPSerializer
 * @Description java 实现PHP serialize()  unserialize接口
 * @author jiangshiwen
 * @date 2015-6-17 上午11:05:03
 */
public class PHPSerializer {
    private static Package[] __packages = Package.getPackages();
    private static final byte __Quote = 34;
    private static final byte __0 = 48;
    private static final byte __1 = 49;
    private static final byte __Colon = 58;
    private static final byte __Semicolon = 59;
    private static final byte __C = 67;
    private static final byte __N = 78;
    private static final byte __O = 79;
    private static final byte __R = 82;
    private static final byte __U = 85;
    private static final byte __Slash = 92;
    private static final byte __a = 97;
    private static final byte __b = 98;
    private static final byte __d = 100;
    private static final byte __i = 105;
    private static final byte __r = 114;
    private static final byte __s = 115;
    private static final byte __LeftB = 123;
    private static final byte __RightB = 125;
    private static final String __NAN = new String("NAN");
    private static final String __INF = new String("INF");
    private static final String __NINF = new String("-INF");
    private PHPSerializer() {}

    public static byte[] serialize(Object obj) {
        return serialize(obj, "UTF-8");
    }

    @SuppressWarnings("rawtypes")
    public static byte[] serialize(Object obj, String charset) {
        HashMap ht = new HashMap();
        int hv = 1;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        hv = serialize(stream, obj, ht, hv, charset);
        byte[] result = stream.toByteArray();

        try {
            stream.close();
        } catch (Exception e) {}
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static int serialize(ByteArrayOutputStream stream, Object obj, HashMap ht, int hv, String charset) {
        if (obj == null) {
            hv++;
            writeNull(stream);
        } else {
            if (obj instanceof Boolean) {
                hv++;
                writeBoolean(stream, ((Boolean) obj).booleanValue() ? __1 : __0);
            } else if ((obj instanceof Byte) || (obj instanceof Short)
                    || (obj instanceof Integer)) {
                hv++;
                writeInteger(stream, getBytes(obj));
            } else if (obj instanceof Long) {
                hv++;
                writeDouble(stream, getBytes(obj));
            } else if (obj instanceof Float) {
                hv++;
                Float f = (Float) obj;

                if (f.isNaN()) {
                    writeDouble(stream, getBytes(__NAN));
                } else if (f.isInfinite()) {
                    if (f.floatValue() > 0) {
                        writeDouble(stream, getBytes(__INF));
                    } else {
                        writeDouble(stream, getBytes(__NINF));
                    }
                } else {
                    writeDouble(stream, getBytes(f));
                }
            } else if (obj instanceof Double) {
                hv++;
                Double d = (Double) obj;

                if (d.isNaN()) {
                    writeDouble(stream, getBytes(__NAN));
                } else if (d.isInfinite()) {
                    if (d.doubleValue() > 0) {
                        writeDouble(stream, getBytes(__INF));
                    } else {
                        writeDouble(stream, getBytes(__NINF));
                    }
                } else {
                    writeDouble(stream, getBytes(d));
                }
            } else if ((obj instanceof Character) || (obj instanceof String)) {
                hv++;
                writeString(stream, getBytes(obj, charset));
            } else if (obj.getClass().isArray()) {
                if (ht.containsKey(new Integer(obj.hashCode()))) {
                    writePointRef(stream, getBytes(ht.get(new Integer(obj.hashCode()))));
                } else {
                    ht.put(new Integer(obj.hashCode()), new Integer(hv++));
                    hv = writeArray(stream, obj, ht, hv, charset);
                }
            } else if (obj instanceof ArrayList) {
                if (ht.containsKey(new Integer(obj.hashCode()))) {
                    writePointRef(stream, getBytes(ht.get(new Integer(obj.hashCode()))));
                } else {
                    ht.put(new Integer(obj.hashCode()), new Integer(hv++));
                    hv = writeArrayList(stream, (ArrayList) obj, ht, hv, charset);
                }
            } else if (obj instanceof HashMap) {
                if (ht.containsKey(new Integer(obj.hashCode()))) {
                    writePointRef(stream, getBytes(ht.get(new Integer(obj.hashCode()))));
                } else {
                    ht.put(new Integer(obj.hashCode()), new Integer(hv++));
                    hv = writeHashMap(stream, (HashMap) obj, ht, hv, charset);
                }
            } else {
                if (ht.containsKey(new Integer(obj.hashCode()))) {
                    hv++;
                    writeRef(stream, getBytes(ht.get(new Integer(obj.hashCode()))));
                } else {
                    ht.put(new Integer(obj.hashCode()), new Integer(hv++));
                    hv = writeObject(stream, obj, ht, hv, charset);
                }
            }
        }
        return hv;
    }

    private static void writeNull(ByteArrayOutputStream stream) {
        stream.write(__N);
        stream.write(__Semicolon);
    }

    private static void writeRef(ByteArrayOutputStream stream, byte[] r) {
        stream.write(__r);
        stream.write(__Colon);
        stream.write(r, 0, r.length);
        stream.write(__Semicolon);
    }

    private static void writePointRef(ByteArrayOutputStream stream, byte[] p) {
        stream.write(__R);
        stream.write(__Colon);
        stream.write(p, 0, p.length);
        stream.write(__Semicolon);
    }

    private static void writeBoolean(ByteArrayOutputStream stream, byte b) {
        stream.write(__b);
        stream.write(__Colon);
        stream.write(b);
        stream.write(__Semicolon);
    }

    private static void writeInteger(ByteArrayOutputStream stream, byte[] i) {
        stream.write(__i);
        stream.write(__Colon);
        stream.write(i, 0, i.length);
        stream.write(__Semicolon);
    }

    private static void writeDouble(ByteArrayOutputStream stream, byte[] d) {
        stream.write(__d);
        stream.write(__Colon);
        stream.write(d, 0, d.length);
        stream.write(__Semicolon);
    }

    private static void writeString(ByteArrayOutputStream stream, byte[] s) {
        byte[] slen = getBytes(new Integer(s.length));

        stream.write(__s);
        stream.write(__Colon);
        stream.write(slen, 0, slen.length);
        stream.write(__Colon);
        stream.write(__Quote);
        stream.write(s, 0, s.length);
        stream.write(__Quote);
        stream.write(__Semicolon);
    }

    private static int writeArray(ByteArrayOutputStream stream, Object a, HashMap ht, int hv, String charset) {
        int len = Array.getLength(a);
        byte[] alen = getBytes(new Integer(len));

        stream.write(__a);
        stream.write(__Colon);
        stream.write(alen, 0, alen.length);
        stream.write(__Colon);
        stream.write(__LeftB);
        for (int i = 0; i < len; i++) {
            writeInteger(stream, getBytes(new Integer(i)));
            hv = serialize(stream, Array.get(a, i), ht, hv, charset);
        }
        stream.write(__RightB);
        return hv;
    }

    private static int writeArrayList(ByteArrayOutputStream stream, ArrayList a, HashMap ht, int hv, String charset) {
        int len = a.size();
        byte[] alen = getBytes(new Integer(len));

        stream.write(__a);
        stream.write(__Colon);
        stream.write(alen, 0, alen.length);
        stream.write(__Colon);
        stream.write(__LeftB);
        for (int i = 0; i < len; i++) {
            writeInteger(stream, getBytes(new Integer(i)));
            hv = serialize(stream, a.get(i), ht, hv, charset);
        }
        stream.write(__RightB);
        return hv;
    }

    private static int writeHashMap(ByteArrayOutputStream stream, HashMap h, HashMap ht, int hv, String charset) {
        int len = h.size();
        byte[] hlen = getBytes(new Integer(len));

        stream.write(__a);
        stream.write(__Colon);
        stream.write(hlen, 0, hlen.length);
        stream.write(__Colon);
        stream.write(__LeftB);
        for (Iterator keys = h.keySet().iterator(); keys.hasNext();) {
            Object key = keys.next();

            if ((key instanceof Byte) || (key instanceof Short)
                    || (key instanceof Integer)) {
                writeInteger(stream, getBytes(key));
            } else if (key instanceof Boolean) {
                writeInteger(stream, new byte[] { ((Boolean) key).booleanValue() ? __1 : __0 });
            } else {
                writeString(stream, getBytes(key, charset));
            }
            hv = serialize(stream, h.get(key), ht, hv, charset);
        }
        stream.write(__RightB);
        return hv;
    }

    private static int writeObject(ByteArrayOutputStream stream, Object obj, HashMap ht, int hv, String charset) {
        Class cls = obj.getClass();

        if (obj instanceof java.io.Serializable) {
            byte[] className = getBytes(getClassName(cls), charset);
            byte[] classNameLen = getBytes(new Integer(className.length));

            if (obj instanceof Serializable) {
                byte[] cs = ((Serializable) obj).serialize();
                byte[] cslen = getBytes(new Integer(cs.length));

                stream.write(__C);
                stream.write(__Colon);
                stream.write(classNameLen, 0, classNameLen.length);
                stream.write(__Colon);
                stream.write(__Quote);
                stream.write(className, 0, className.length);
                stream.write(__Quote);
                stream.write(__Colon);
                stream.write(cslen, 0, cslen.length);
                stream.write(__Colon);
                stream.write(__LeftB);
                stream.write(cs, 0, cs.length);
                stream.write(__RightB);
            } else {
                Method __sleep;

                try {
                    __sleep = cls.getMethod("__sleep", new Class[0]);
                } catch (Exception e) {
                    __sleep = null;
                }
                int fl = 0;
                Field[] f;

                if (__sleep != null) {
                    String[] fieldNames;

                    try {
                        __sleep.setAccessible(true);
                        fieldNames = (String[]) __sleep.invoke(obj, new Object[0]);
                    } catch (Exception e) {
                        fieldNames = null;
                    }
                    f = getFields(obj, fieldNames);
                } else {
                    f = getFields(obj);
                }
                AccessibleObject.setAccessible(f, true);
                byte[] flen = getBytes(new Integer(f.length));

                stream.write(__O);
                stream.write(__Colon);
                stream.write(classNameLen, 0, classNameLen.length);
                stream.write(__Colon);
                stream.write(__Quote);
                stream.write(className, 0, className.length);
                stream.write(__Quote);
                stream.write(__Colon);
                stream.write(flen, 0, flen.length);
                stream.write(__Colon);
                stream.write(__LeftB);
                for (int i = 0, len = f.length; i < len; i++) {
                    int mod = f[i].getModifiers();

                    if (Modifier.isPublic(mod)) {
                        writeString(stream, getBytes(f[i].getName(), charset));
                    } else if (Modifier.isProtected(mod)) {
                        writeString(stream,
                                getBytes("\0*\0" + f[i].getName(), charset));
                    } else {
                        writeString(stream,
                                getBytes(
                                        "\0" + getClassName(f[i].getDeclaringClass())
                                                + "\0" + f[i].getName(),
                                        charset));
                    }
                    Object o;

                    try {
                        o = f[i].get(obj);
                    } catch (Exception e) {
                        o = null;
                    }
                    hv = serialize(stream, o, ht, hv, charset);
                }
                stream.write(__RightB);
            }
        } else {
            writeNull(stream);
        }
        return hv;
    }

    private static byte[] getBytes(Object obj) {
        try {
            return obj.toString().getBytes("US-ASCII");
        } catch (Exception e) {
            return obj.toString().getBytes();
        }
    }

    private static byte[] getBytes(Object obj, String charset) {
        try {
            return obj.toString().getBytes(charset);
        } catch (Exception e) {
            return obj.toString().getBytes();
        }
    }

    private static String getString(byte[] data, String charset) {
        try {
            return new String(data, charset);
        } catch (Exception e) {
            return new String(data);
        }
    }

    private static Class getClass(String className) {
        try {
            Class cls = Class.forName(className);

            return cls;
        } catch (Exception e) {}
        for (int i = 0; i < __packages.length; i++) {
            try {
                Class cls = Class.forName(
                        __packages[i].getName() + "." + className);

                return cls;
            } catch (Exception e) {}
        }
        return null;
    }

    private static String getClassName(Class cls) {
        return cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    private static Field getField(Object obj, String fieldName) {
        Class cls = obj.getClass();

        while (cls != null) {
            try {
                Field result = cls.getDeclaredField(fieldName);
                int mod = result.getModifiers();

                if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
                    return null;
                }
                return result;
            } catch (Exception e) {}
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Field[] getFields(Object obj, String[] fieldNames) {
        if (fieldNames == null) {
            return getFields(obj);
        }
        int n = fieldNames.length;
        ArrayList fields = new ArrayList(n);

        for (int i = 0; i < n; i++) {
            Field f = getField(obj, fieldNames[i]);

            if (f != null) {
                fields.add(f);
            }
        }
        return (Field[]) fields.toArray(new Field[0]);
    }

    private static Field[] getFields(Object obj) {
        ArrayList fields = new ArrayList();
        Class cls = obj.getClass();

        while (cls != null) {
            Field[] fs = cls.getDeclaredFields();

            for (int i = 0; i < fs.length; i++) {
                int mod = fs[i].getModifiers();

                if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)) {
                    fields.add(fs[i]);
                }
            }
            cls = cls.getSuperclass();
        }
        return (Field[]) fields.toArray(new Field[0]);
    }

    public static Object newInstance(Class cls) {
        try {
            Constructor ctor = cls.getConstructor(new Class[0]);
            int mod = ctor.getModifiers();

            if (Modifier.isPublic(mod)) {
                return ctor.newInstance(new Object[0]);
            }
        } catch (Exception e) {}
        try {
            Constructor ctor = cls.getConstructor(new Class[] { Integer.TYPE });
            int mod = ctor.getModifiers();

            if (Modifier.isPublic(mod)) {
                return ctor.newInstance(new Object[] { new Integer(0) });
            }
        } catch (Exception e) {}
        try {
            Constructor ctor = cls.getConstructor(new Class[] { Boolean.TYPE });
            int mod = ctor.getModifiers();

            if (Modifier.isPublic(mod)) {
                return ctor.newInstance(new Object[] { new Boolean(false) });
            }
        } catch (Exception e) {}
        try {
            Constructor ctor = cls.getConstructor(new Class[] { String.class });
            int mod = ctor.getModifiers();

            if (Modifier.isPublic(mod)) {
                return ctor.newInstance(new Object[] { "" });
            }
        } catch (Exception e) {}
        Field[] f = cls.getFields();

        for (int i = 0; i < f.length; i++) {
            if (f[i].getType() == cls && Modifier.isStatic(f[i].getModifiers())) {
                try {
                    return f[i].get(null);
                } catch (Exception e) {}
            }
        }
        Method[] m = cls.getMethods();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getReturnType() == cls
                    && Modifier.isStatic(m[i].getModifiers())) {
                try {
                    return m[i].invoke(null, new Object[0]);
                } catch (Exception e) {}
                try {
                    return m[i].invoke(null, new Object[] { new Integer(0) });
                } catch (Exception e) {}
                try {
                    return m[i].invoke(null, new Object[] { new Boolean(false) });
                } catch (Exception e) {}
                try {
                    return m[i].invoke(null, new Object[] { "" });
                } catch (Exception e) {}
            }
        }
        return null;
    }

    public static Number cast(Number n, Class destClass) {
        if (destClass == Byte.class) {
            return new Byte(n.byteValue());
        }
        if (destClass == Short.class) {
            return new Short(n.shortValue());
        }
        if (destClass == Integer.class) {
            return new Integer(n.intValue());
        }
        if (destClass == Long.class) {
            return new Long(n.longValue());
        }
        if (destClass == Float.class) {
            return new Float(n.floatValue());
        }
        if (destClass == Double.class) {
            return new Double(n.doubleValue());
        }
        return n;
    }

    public static Object cast(Object obj, Class destClass) {
        if (obj == null || destClass == null) {
            return obj;
        } else if (obj.getClass() == destClass) {
            return obj;
        } else if (obj instanceof Number) {
            return cast((Number) obj, destClass);
        } else if ((obj instanceof String) && destClass == Character.class) {
            return new Character(((String)obj).charAt(0));
        } else if ((obj instanceof ArrayList) && destClass.isArray()) {
            return toArray((ArrayList) obj, destClass.getComponentType());
        } else if ((obj instanceof ArrayList) && destClass == HashMap.class) {
            return toHashMap((ArrayList) obj);
        } else {
            return obj;
        }
    }

    private static HashMap toHashMap(ArrayList a) {
        int n = a.size();
        HashMap h = new HashMap(n);

        for (int i = 0; i < n; i++) {
            h.put(new Integer(i), a.get(i));
        }
        return h;
    }

    private static Object toArray(ArrayList obj, Class componentType) {
        int n = obj.size();
        Object a = Array.newInstance(componentType, n);

        for (int i = 0; i < n; i++) {
            Array.set(a, i, cast(obj.get(i), componentType));
        }
        return a;
    }

    private static int getPos(ByteArrayInputStream stream) {
        try {
            Field pos = stream.getClass().getDeclaredField("pos");

            pos.setAccessible(true);
            return pos.getInt(stream);
        } catch (Exception e) {
            return 0;
        }
    }

    private static void setPos(ByteArrayInputStream stream, int p) {
        try {
            Field pos = stream.getClass().getDeclaredField("pos");

            pos.setAccessible(true);
            pos.setInt(stream, p);
        } catch (Exception e) {}
    }

    public static Object unserialize(byte[] ss) throws IllegalAccessException {
        return unserialize(ss, null, "UTF-8");
    }

    public static Object unserialize(byte[] ss, String charset) throws IllegalAccessException {
        return unserialize(ss, null, charset);
    }

    public static Object unserialize(byte[] ss, Class cls) throws IllegalAccessException {
        return unserialize(ss, cls, "UTF-8");
    }

    public static Object unserialize(byte[] ss, Class cls, String charset) throws IllegalAccessException {
        int hv = 1;
        ByteArrayInputStream stream = new ByteArrayInputStream(ss);
        Object result = unserialize(stream, new HashMap(), hv, new HashMap(), charset).value;

        try {
            stream.close();
        } catch (Exception e) {}
        return cast(result, cls);
    }

    private static UnSerializeResult unserialize(ByteArrayInputStream stream, HashMap ht, int hv, HashMap rt, String charset) throws IllegalAccessException {
        Object obj;

        switch (stream.read()) {
            case __N:
                obj = readNull(stream);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __b:
                obj = readBoolean(stream);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __i:
                obj = readInteger(stream);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __d:
                obj = readDouble(stream);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __s:
                obj = readString(stream, charset);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __U:
                obj = readUnicodeString(stream);
                ht.put(new Integer(hv++), obj);
                return new UnSerializeResult(obj, hv);

            case __r:
                return readRef(stream, ht, hv, rt);

            case __a:
                return readArray(stream, ht, hv, rt, charset);

            case __O:
                return readObject(stream, ht, hv, rt, charset);

            case __C:
                return readCustomObject(stream, ht, hv, charset);

            case __R:
                return readPointRef(stream, ht, hv, rt);

            default:
                return null;
        }
    }

    private static String readNumber(ByteArrayInputStream stream) {
        StringBuffer sb = new StringBuffer();
        int i = stream.read();

        while ((i != __Semicolon) && (i != __Colon)) {
            sb.append((char) i);
            i = stream.read();
        }
        return sb.toString();
    }

    private static Object readNull(ByteArrayInputStream stream) {
        stream.skip(1);
        return null;
    }

    private static Boolean readBoolean(ByteArrayInputStream stream) {
        stream.skip(1);
        Boolean b = new Boolean(stream.read() == __1);

        stream.skip(1);
        return b;
    }

    private static Number readInteger(ByteArrayInputStream stream) {
        stream.skip(1);
        String i = readNumber(stream);

        try {
            return new Byte(i);
        } catch (Exception e1) {
            try {
                return new Short(i);
            } catch (Exception e2) {
                return new Integer(i);
            }
        }
    }

    private static Number readDouble(ByteArrayInputStream stream) {
        stream.skip(1);
        String d = readNumber(stream);

        if (d.equals(__NAN)) {
            return new Double(Double.NaN);
        }
        if (d.equals(__INF)) {
            return new Double(Double.POSITIVE_INFINITY);
        }
        if (d.equals(__NINF)) {
            return new Double(Double.NEGATIVE_INFINITY);
        }
        try {
            return new Long(d);
        } catch (Exception e1) {
            try {
                Float f = new Float(d);

                if (f.isInfinite()) {
                    return new Double(d);
                } else {
                    return f;
                }
            } catch (Exception e2) {
                return new Float(0);
            }
        }
    }

    private static String readString(ByteArrayInputStream stream, String charset) {
        stream.skip(1);
        int len = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        byte[] buf = new byte[len];

        stream.read(buf, 0, len);
        String s = getString(buf, charset);

        stream.skip(2);
        return s;
    }

    private static String readUnicodeString(ByteArrayInputStream stream) {
        stream.skip(1);
        int l = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        StringBuffer sb = new StringBuffer(l);
        int c;

        for (int i = 0; i < l; i++) {
            if ((c = stream.read()) == __Slash) {
                char c1 = (char) stream.read();
                char c2 = (char) stream.read();
                char c3 = (char) stream.read();
                char c4 = (char) stream.read();

                sb.append(
                        (char) (Integer.parseInt(
                                new String(new char[] { c1, c2, c3, c4 }), 16)));
            } else {
                sb.append((char) c);
            }
        }
        stream.skip(2);
        return sb.toString();
    }

    private static UnSerializeResult readRef(ByteArrayInputStream stream, HashMap ht, int hv, HashMap rt) {
        stream.skip(1);
        Integer r = new Integer(readNumber(stream));

        if (rt.containsKey(r)) {
            rt.put(r, new Boolean(true));
        }
        Object obj = ht.get(r);

        ht.put(new Integer(hv++), obj);
        return new UnSerializeResult(obj, hv);
    }

    private static UnSerializeResult readPointRef(ByteArrayInputStream stream, HashMap ht, int hv, HashMap rt) {
        stream.skip(1);
        Integer r = new Integer(readNumber(stream));

        if (rt.containsKey(r)) {
            rt.put(r, new Boolean(true));
        }
        Object obj = ht.get(r);

        return new UnSerializeResult(obj, hv);
    }

    private static UnSerializeResult readArray(ByteArrayInputStream stream, HashMap ht, int hv, HashMap rt, String charset) throws IllegalAccessException {
        stream.skip(1);
        int n = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        HashMap h = new HashMap(n);
        ArrayList al = new ArrayList(n);
        Integer r = new Integer(hv);

        rt.put(r, new Boolean(false));
        int p = getPos(stream);

        ht.put(new Integer(hv++), h);
        for (int i = 0; i < n; i++) {
            Object key;

            switch (stream.read()) {
                case __i:
                    key = cast(readInteger(stream), Integer.class);
                    break;

                case __s:
                    key = readString(stream, charset);
                    break;

                case __U:
                    key = readUnicodeString(stream);
                    break;

                default:
                    return null;
            }
            UnSerializeResult result = unserialize(stream, ht, hv, rt, charset);

            hv = result.hv;
            if (al != null) {
                if ((key instanceof Integer) && (((Integer) key).intValue() == i)) {
                    al.add(result.value);
                } else {
                    al = null;
                }
            }
            h.put(key, result.value);
        }
        if (al != null) {
            ht.put(r, al);
            if (((Boolean) (rt.get(r))).booleanValue()) {
                hv = r.intValue() + 1;
                setPos(stream, p);
                for (int i = 0; i < n; i++) {
                    int key;

                    switch (stream.read()) {
                        case __i:
                            key = ((Integer) cast(readInteger(stream), Integer.class)).intValue();
                            break;

                        default:
                            return null;
                    }
                    UnSerializeResult result = unserialize(stream, ht, hv, rt,
                            charset);

                    hv = result.hv;
                    al.set(key, result.value);
                }
            }
        }
        rt.remove(r);
        stream.skip(1);
        return new UnSerializeResult(ht.get(r), hv);
    }

    private static UnSerializeResult readObject(ByteArrayInputStream stream, HashMap ht, int hv, HashMap rt, String charset) throws IllegalAccessException {
        stream.skip(1);
        int len = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        byte[] buf = new byte[len];

        stream.read(buf, 0, len);
        String cn = getString(buf, charset);

        stream.skip(2);
        int n = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        Class cls = getClass(cn);
        Object o;

        if (cls != null) {
            if ((o = newInstance(cls)) == null) {
                o = new HashMap(n);
            }
        } else {
            o = new HashMap(n);
        }
        ht.put(new Integer(hv++), o);
        for (int i = 0; i < n; i++) {
            String key;

            switch (stream.read()) {
                case __s:
                    key = readString(stream, charset);
                    break;

                case __U:
                    key = readUnicodeString(stream);
                    break;

                default:
                    return null;
            }
            if (key.charAt(0) == (char) 0) {
                key = key.substring(key.indexOf("\0", 1) + 1);
            }
            UnSerializeResult result = unserialize(stream, ht, hv, rt, charset);

            hv = result.hv;
            if (o instanceof HashMap) {
                ((HashMap) o).put(key, result.value);
            } else {
                Field f = getField(o, key);

                f.setAccessible(true);
                f.set(o, result.value);
            }
        }
        stream.skip(1);
        Method __wakeup = null;

        try {
            __wakeup = o.getClass().getMethod("__wakeup", new Class[0]);
            __wakeup.invoke(o, new Object[0]);
        } catch (Exception e) {}
        return new UnSerializeResult(o, hv);
    }

    private static UnSerializeResult readCustomObject(ByteArrayInputStream stream, HashMap ht, int hv, String charset) {
        stream.skip(1);
        int len = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        byte[] buf = new byte[len];

        stream.read(buf, 0, len);
        String cn = getString(buf, charset);

        stream.skip(2);
        int n = Integer.parseInt(readNumber(stream));

        stream.skip(1);
        Class cls = getClass(cn);
        Object o;

        if (cls != null) {
            o = newInstance(cls);
        } else {
            o = null;
        }
        ht.put(new Integer(hv++), o);
        if (o == null) {
            stream.skip(n);
        } else if (o instanceof Serializable) {
            byte[] b = new byte[n];

            stream.read(b, 0, n);
            ((Serializable) o).unserialize(b);
        } else {
            stream.skip(n);
        }
        stream.skip(1);
        return new UnSerializeResult(o, hv);
    }


}
