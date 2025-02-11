public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello world");
        String s = sb.toString();

        for (char c = 'a'; c <= 'z'; c++){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
