package fun.observe.touchy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class ReflectionUtils {

    static void makeFieldNonFinal(Field targetField) {

        try {

            Class classField = Field.class;

            Field accessFlagsField = classField.getDeclaredField("accessFlags");

            accessFlagsField.setAccessible(true);

            targetField.setAccessible(true);

            accessFlagsField.setInt(targetField, targetField.getModifiers() & ~Modifier.FINAL);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
