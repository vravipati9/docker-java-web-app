public class Hello {
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true  && i < 100)
            {
                Thread.sleep(2 * 2000);
                System.out.println(" counting i value " + i);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}