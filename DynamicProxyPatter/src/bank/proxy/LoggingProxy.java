package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {
	Object target;
	
	public static Object newInstance(Object obj) {
		
		        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
		
		                .getClass().getInterfaces(), new LoggingProxy(obj));
		
		    }


	public LoggingProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println(method.getName() + " method has been called");
		return method.invoke(target, args);
	}

}
