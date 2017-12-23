package ru.sbt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BeanUtils {
    /**
     *      * Scans object &quot;from&quot; for all getters. If object &quot;to&quot;
     * <p>
     *      * contains correspondent setter, it will invoke it
     * <p>
     *      * to set property value for &quot;to&quot; which equals to the property
     * <p>
     *      * of &quot;from&quot;.
     * <p>
     *      * &lt;p/&gt;
     * <p>
     *      * The type in setter should be compatible to the value returned
     * <p>
     *      * by getter (if not, no invocation performed).
     * <p>
     *      * Compatible means that parameter type in setter should
     * <p>
     *      * be the same or be superclass of the return type of the getter.
     * <p>
     *      * &lt;p/&gt;
     * <p>
     *      * The method takes care only about public methods.
     * <p>
     *      *
     * <p>
     *      * @param to   Object which properties will be set.
     * <p>
     *      * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {

        Method[] methods = from.getClass().getMethods();

        for (Method m : methods) {

            if (m.getName().startsWith("get") && m.getParameterCount() == 0 && !m.getReturnType().equals(Void.TYPE))
                try {
                    Object result = m.invoke(from);
                    Method setter = findCorrespondentSetter(to, m, m.getReturnType());
                    setter.invoke(to, result);

                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println(e.getMessage());

                }
        }
    }

    private static Method findCorrespondentSetter(Object object, Method m, Class<?> returnType) throws NoSuchMethodException {
        String nameOfSetter = m.getName().split("get")[1];

        if (returnType == null) {
            throw new NoSuchMethodException("Setter " + object.getClass().getName() + ".set" +
                    nameOfSetter + "(" + m.getReturnType().getName() + ")" +
                    " with correspondent parameter and name not found");
        }
        try {
            return object.getClass().getMethod("set" + nameOfSetter, returnType);
        } catch (NoSuchMethodException e) {
            return findCorrespondentSetter(object, m, returnType.getSuperclass());
        }
    }

}
