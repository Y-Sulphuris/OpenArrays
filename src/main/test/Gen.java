import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public class Gen {
	public static void main(String[] args) throws IOException {
		//while (len++ < 16) {}
		progArray();
	}

	static void powerArray() throws IOException {
		String str = String.join("\n", Files.readAllLines(new File("template/ArrayPower.txt").toPath()));
		int len = 24;
		do {
			int prev = len - 8;
			Files.write(new File("src/main/java/com/ydo4ki/openarrays/arrays/Array" + len + ".java").toPath(), Collections.singleton(powerArrayByLen(str, len, prev)));
		} while((len += 8) <= 128);
	}
	static void progArray() throws IOException {
		String str = String.join("\n", Files.readAllLines(new File("template/Array.txt").toPath()));
		int len = 0;
		while (len++ < 16)
			Files.write(new File("src/main/java/com/ydo4ki/openarrays/arrays/Array" + len + ".java").toPath(), Collections.singleton(arrayByLen(str, len)));
	}

	static String enumer(int start, int len,@Deprecated boolean forceField) {
		StringBuilder senum = new StringBuilder();
		for (int i = start; i < len; i++) {
			senum.append("e").append(i);
			if (i != len-1) senum.append(", ");
		}
		return senum.toString();
	}

	static String t_enumer(int len) {
		if (len > 128) return "T... e";
		StringBuilder tenum = new StringBuilder();
		for (int i = 0; i < len; i++) {
			tenum.append("T e").append(i);
			if (i != len-1) tenum.append(", ");
		}
		return tenum.toString();
	}
	static String this_set(int start, int len) {
		StringBuilder tenum = new StringBuilder();
		for (int i = start; i < len; i++) {
			tenum.append("this.e").append(i).append(" = ").append("e").append(i);
			tenum.append(";\n\t\t");
		}
		return tenum.toString();
	}

	static String powerArrayByLen(String array, int len, int subLen) {
		array = array.replace("<LEN>", String.valueOf(len));
		array = array.replace("<SUBLEN>", String.valueOf(subLen));

		array = array.replace("<THISENUMER>", enumer(subLen, len, false));
		array = array.replace("<THISENUMERF>", enumer(subLen, len, true));

		array = array.replace("<SUBENUMER>", enumer(0, subLen, false));
		array = array.replace("<SUBENUMERF>", enumer(0, subLen, true));

		array = array.replace("<THIS_SET>", this_set(subLen, len));

		array = array.replace("<T_ENUMER>", t_enumer(len));
		return array;
	}
	static String arrayByLen(String array, int len) {
		array = array.replace("<LEN>", String.valueOf(len));

		array = array.replace("<THIS_SET>", this_set(0, len));

		array = array.replace("<ENUMER>", enumer(0, len, true));

		array = array.replace("<T_ENUMER>", t_enumer(len));
		return array;
	}
}
