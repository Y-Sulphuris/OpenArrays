import com.ydo4ki.openarrays.arrays.Array4;
import impl.com.ydo4ki.openarrays.Generator;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) throws Exception {
		Class ia4 = Generator.generateCheckedArray(Integer.class, Array4.class);
		System.out.println(ia4.toGenericString());
		System.out.println(Arrays.toString(ia4.getMethods()));
		System.out.println(Arrays.toString(TestArray4.class.getMethods()));
		// вот сюда смотрите, выше не смотрите
		b();
	}
	static <T> void  a() {
		Array4<T> test = (Array4<T>)(Object)new TestArray4();
		test.e0 = (T) (Object)"abc";
		System.out.println(test.e0);
		// ОНО РАБОТАЕТ, НУ И В ЧЁМ СМЫСЛ?????????
		// а погодите надо ещё методы проверить
		// НЕТ СТОП МЫ ЖЕ БУДЕМ ЗНАТЬ РАЗМЕР И У НАС БУДЕТ ПРЯМОЙ ДОСТУП К ПОЛЯМ ВАШЩПГЫЗПЫВШАЩПГЫВЗАПШ
		// Единственный способ избежать этого
		// Так погодите
		// а вдруг это и с java массивами будет работать
	}
	static <T> void b() {
		T[] test = (T[]) new Integer[4];
		test[0] = (T) (Object)"abc";
		System.out.println(test[0]);
		// Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
		// ЧООООООООООООООООООООООООООО
		// ОНИ ДАЖЕ ОТДЕЛЬНОЕ ИСКЛЮЧЕНИЕ СДЕЛАЛИ ДЛЯ ЭТОГО
		// ладно я всё понял
		// надо всё-таки хранить объект Class<ELEMENT_TYPE>
		// но их я всё равно буду генерировать потому что не хочу забивать библиотеку тем для чего и так api особо не нужен
	}
}

// todo: посмотреть в байткоде как это выглядит
class TestArray4 extends Array4<Integer> {
	@Override
	public Integer get(int index) {
		return super.get(index);
	}

	@Override
	public void set(int index, Integer element) {
		super.set(index, element);
	}

	@Override
	public Integer[] toJavaArray() {
		return super.toJavaArray();
	}
}