package agendaproduccio.utils;

import java.util.concurrent.Semaphore;

public class Semaphor {
	private Semaphore m_semaphore;

	public Semaphor(int slotLimit) {
		this.m_semaphore = new Semaphore(slotLimit);
	}

	public void acquire() {
		try {
			m_semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}

	public boolean tryConnection() {
		return this.m_semaphore.tryAcquire();
	}

	public void releaseConection() {
		this.m_semaphore.release();
		return;
	}

	public int availableConnections() {
		return this.m_semaphore.availablePermits();
	}

}
