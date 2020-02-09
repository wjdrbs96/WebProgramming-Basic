package lecture4;

class MyResource1 {
    public MyResource1() {
        System.out.println("자원이 할당됨");
    }
    
    public void close() {
    	System.out.println("자원 할당 해제");
    }
}


public class Example3 {

    public static void main(String[] args) throws Exception {
    	MyResource1 resource = null;
        try {
        	resource = new MyResource1();
        	
        } catch (Exception e) {
        	System.out.println("작업 중 에러 발생");
        }
        
        finally {
        	if (resource != null) resource.close();
        }
    }
}