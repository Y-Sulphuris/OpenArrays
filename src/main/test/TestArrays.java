import com.ydo4ki.openarrays.OpenArrays;
import com.ydo4ki.openarrays.arrays.Array;

public class TestArrays {
	public static void main(String[] args) {
		Array<Object> array = OpenArrays.newArray(24);
		array.fill(5);
		System.out.println(array.get(3));
	}
}
