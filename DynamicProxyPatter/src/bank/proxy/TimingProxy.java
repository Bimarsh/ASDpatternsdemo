package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {
	
	Object object;
	
	public static Object newInstance(Object obj) {
		
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj

                .getClass().getInterfaces(), new TimingProxy(obj));

    }
	
	public TimingProxy(Object object) {
		this.object=object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime= System.currentTimeMillis();
		Object obj=method.invoke(object, args);
		long endtime= System.currentTimeMillis();
		System.out.println("Totaltime taken to execute "+method.getName()+" is "+(endtime-startTime));
		return obj;
	}

}
