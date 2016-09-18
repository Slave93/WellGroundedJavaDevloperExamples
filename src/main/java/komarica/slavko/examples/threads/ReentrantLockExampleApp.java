package komarica.slavko.examples.threads;

public class ReentrantLockExampleApp {
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLockExampleApp reentrantLockTest = new ReentrantLockExampleApp();
		MyBean1 myBean1 = new MyBean1();
		MyBean2 myBean2 = new MyBean2();
		myBean1.method(reentrantLockTest);
		myBean2.method(reentrantLockTest);
	}

	
	
	
	public synchronized void syncMethod() throws InterruptedException{
		System.out.println("syncMethod called");
		Thread.sleep(10000);
		/**
		 * Thread that acquired lock for syncMethod() will be allowed to enter syncMethod2(). Even
		 * though that method is synchronized it asks for lock on the same object as syncMethod() wich 
		 * current threads certainly has. This is Java ReentrantLock in action.
		 */
		syncMethod2();
		System.out.println("syncMethod ended");
	}
	
	private synchronized void syncMethod2() throws InterruptedException{
		System.out.println("syncMethod2 called");
		Thread.sleep(10000);
		System.out.println("syncMethod2 ended");
	}


}

class MyBean1{
	public void method(ReentrantLockExampleApp reentrantLockTest) throws InterruptedException{
		reentrantLockTest.syncMethod();
	}
}

class MyBean2{
	public void method(ReentrantLockExampleApp reentrantLockTest) throws InterruptedException{
		reentrantLockTest.syncMethod();
	}
}

