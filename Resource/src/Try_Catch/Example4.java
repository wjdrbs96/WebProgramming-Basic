package Try_Catch;

class MyResource implements AutoCloseable {
	public void MyResource() {
		System.out.println("�ڿ��� �Ҵ��");
	}
	
	public void �۾�() throws Exception {
		System.out.println("�۾� �� ���� �߻�");
		throw new Exception();
	}
	 
	public void close() throws Exception {
		System.out.println("�ڿ��� �ݳ���");
	}
}

public class Example4 {
	
	public static void main(String[] args) throws Exception {
		try (MyResource resource = new MyResource()) {
			resource.�۾�();
		}
	}

	
}
