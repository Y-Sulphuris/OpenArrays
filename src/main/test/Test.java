import com.ydo4ki.openarrays.ftable.FTable;
import com.ydo4ki.openarrays.ftable.FTableByte;

import java.lang.invoke.MethodHandles;

public class Test {
    final Object o1;
    final Object o2;

    static final FTable<Test, Object> ftable = FTable.newTable(MethodHandles.lookup(), Test.class, Object.class, "o1", "o2");

    Object get(int index) {
        try {
            return ftable.unsafeGet(this, index);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Test(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public static void main(String[] args) {
        PrimitiveTest t = new PrimitiveTest((byte) 3, (byte) 7, (byte) 2, (byte) 5);
        System.out.println(t.get(3)); // да ладно, с первого раза сработало, да не может быть такого
    }
}
class PrimitiveTest {
    byte b0, b1, b2, b3;
    static final FTableByte<PrimitiveTest> ftable = FTableByte.newTable(MethodHandles.lookup(), PrimitiveTest.class, "b", 4);

    PrimitiveTest(byte b0, byte b1, byte b2, byte b3) {
        this.b0 = b0;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    byte get(int index) {
        try {
            return ftable.unsafeGet(this, index);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}