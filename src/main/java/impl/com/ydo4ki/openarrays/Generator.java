package impl.com.ydo4ki.openarrays;

import com.ydo4ki.openarrays.arrays.OpenArray;
import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

public class Generator {
    public static final int CLASS_VERSION = 52;
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Class<? extends OpenArray<?>> generateCheckedArray(Class<?> elementClass, Class<? extends OpenArray> baseClass) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | (CLASS_VERSION >= 7 ? ClassWriter.COMPUTE_FRAMES : 0));
        String className = baseClass.getSimpleName() + "$" + elementClass.getName().replace(".","$$");
        cw.visit(
                CLASS_VERSION,
                ACC_PUBLIC | ACC_SUPER,
                className,
                null,
                baseClass.getName().replace(".","/"),
                null
        );

        return (Class<? extends OpenArray<?>>) ArrayClassLoader.loader.loadClass(className, cw.toByteArray());
    }
}
class ArrayClassLoader extends ClassLoader {
    public static ArrayClassLoader loader = new ArrayClassLoader();
    public Class<?> loadClass(String name, byte[] data) {
        return defineClass(name, data, 0, data.length);
    }
}