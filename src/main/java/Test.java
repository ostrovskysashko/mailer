

public class Test {
    public static void main(String[] args) {
        TestClient client = new TestClient();
        System.out.println(client.getMessage().getBody());
    }
}
