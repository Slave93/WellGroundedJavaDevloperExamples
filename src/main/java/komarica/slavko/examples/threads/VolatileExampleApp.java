package komarica.slavko.examples.threads;


public class VolatileExampleApp {

	private volatile int amount = 0;
	private boolean running = false;
	private static final int WAIT_TIME_IN_SECONDS = 2;
	private static final int INCREMENT_COUNT = 500000;

	public void startExample(){
		printAmount();
		enableThreads();
		startNewIncrementorThread();
		startNewIncrementorThread();
		waitForSomeTime();
		printAmount();
		disableThreads();
		printAmount();
	}
	
	private void printAmount(){
		System.out.println("Amount is: "+amount);
	}
	
	private void enableThreads(){
		running = true;
	}	
	
	private void startNewIncrementorThread(){
		new Thread(this::incrementAmount).start();
	}
	
	private void waitForSomeTime(){
		waitForSomeTime(WAIT_TIME_IN_SECONDS);
	}
	
	private void waitForSomeTime(int timeInSeconds){
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			//not a problem
		}
	}	
	
	private void disableThreads(){
		running = false;
	}
	
	private void incrementAmount(){
		int i = 0;
		while (running) {
			if (i < INCREMENT_COUNT) {
				//line below comment is not thread safe,even though amount is volatile. It only assures that
				//fresh value will always be read from main memory and flushed immediately after change
				//but does not handle concurent writes.
				//amount++;
				incrementAmountByOne();
				i++;
			} else {
				waitForSomeTime(1);
				System.out.println("Finished incrementing");
			}
		}
	}

	private synchronized void incrementAmountByOne() {
		amount++;
	}	

}

class ExampleStarter{
	public static void main(String[] args) {
		VolatileExampleApp volatileExampleApp = new VolatileExampleApp();
		volatileExampleApp.startExample();
	}
}
