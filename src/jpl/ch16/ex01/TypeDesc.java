package jpl.ch16.ex01;

import java.lang.reflect.*;

public class TypeDesc {
    public static void main(String[] args) {

        String[] strs = {"java.util.HashMap","java.awt.Button", "java.lang.annotation.IncompleteAnnotationException"};
        mainMethod(strs);
    }


    public static void mainMethod(String[] args) {
        TypeDesc desc = new TypeDesc();
        for(String name : args) {
            try {
                Class<?> startClass = Class.forName(name);
                desc.printType(startClass, 0, basic );
            } catch(ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }


    private java.io.PrintStream out = System.out;

    private static String[] basic =
    {"class","interface","enum","annotation"},
                            supercl = {"extends", "implements"},
                            iFace = { null, "extends"};

    private void printType(Type type, int depth, String[] labels)
    {
        if(type == null) {
            return;
        }

        Class<?> cls = null;
        if(type instanceof Class<?>) {
            cls = (Class<?>) type;
        } else if( type instanceof ParameterizedType) {
            cls = (Class<?>) ((ParameterizedType) type).getRawType();
        } else {
            throw new Error("non-class Type");
        }
        try {
            if(cls == Class.forName("java.lang.Object")) {
                return;
            }
        }  catch(ClassNotFoundException e) {
            System.out.println(e);
        }

        for(int i = 0; i < depth; i++) {
            out.print(" ");
        }
        int kind = cls.isAnnotation() ? 3 :
        cls.isEnum() ? 2:
        cls.isInterface() ? 1 :0;
        out.print(labels[kind] + " ");
        out.print(cls.getCanonicalName());

        TypeVariable<?>[] params = cls.getTypeParameters();
        if(params.length > 0 ) {
            out.print('<');
            for(TypeVariable<?> param:params) {
                out.print(param.getName());
                out.print(", ");
            }
            out.println("\b\b>");
        } else {
            out.println();
        }

        Type[] interfaces = cls.getGenericInterfaces();
        for(Type iface : interfaces) {
            printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
        }
        printType(cls.getGenericSuperclass(), depth + 1, supercl );
    }
}
