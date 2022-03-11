package agendaproduccio.utils;

public class MyTimer {
	private MySemaphor m_semaphoreMutex;
   public MyTimer() {
	   this.m_semaphoreMutex = new MySemaphor(1);
   }
}
