public class FindDuplicateCharacter {
    public static String solution(String S) {
        int[] occurrences = new int[25];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 0; i < 25; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        System.out.println(solution("heaao"));
        
        soloution2();
    }

    private static void soloution2() {
    }
}