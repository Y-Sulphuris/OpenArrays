import com.ydo4ki.openarrays.OpenArrays;
import com.ydo4ki.openarrays.arrays.Array;
import com.ydo4ki.openarrays.arrays.Array1;

public class TestArrays {
	public static void main(String[] args) {
		Array1<Object> array = new Array1<>(2);
		array.fill(5);
		System.out.println(array);
		System.out.println(array.get(3));
	}
}
