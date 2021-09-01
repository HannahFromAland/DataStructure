public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> emp = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            Character curr = word.charAt(i);
            emp.addLast(curr);
        }

        return emp;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> curr) {
        if (curr.size() <= 1) {
            return true;
        }
        Character first = curr.removeFirst();
        Character last = curr.removeLast();
        if (first == last) {
            return isPalindrome(curr);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    private boolean isPalindrome(Deque<Character> curr, CharacterComparator cc) {
        if (curr.size() <= 1) {
            return true;
        }
        Character first = curr.removeFirst();
        Character last = curr.removeLast();
        if (cc.equalChars(first, last)) {
            return isPalindrome(curr, cc);
        } else {
            return false;
        }
    }


}
