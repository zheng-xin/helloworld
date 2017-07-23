package contrustorandmethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class Test implements TestInteface{
	public Test() {
		System.out.println("用无参构造器实例化了一个对象。");
	}

	// 有参构造器
	public Test(String s) {
		System.out.println("用有参构造器实例化了一个对象。参数为" + s);
	}

	// 无参方法
	public void method() {
		System.out.println("执行了无参方法。");
	}

	// 有参方法
	public void method(String s) {
		System.out.println("执行了有参方法。参数为：" + s);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
			Class<?> testclass = Class.forName("contrustorandmethod.Test");
			Test test = (Test)testclass.newInstance();
			Constructor<?> test1 = testclass.getConstructor(String.class);
			System.out.println("构造器名"+test1.getName());
			Test test2 = (Test) test1.newInstance("sss");
		}

	@Override
	public void aaa() {
		
		System.out.println("ssss");
		
	}
}
