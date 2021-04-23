public class StringToInteger {
    public int myAtoi(String s) {
        String temp = "";
        int digitStartIdx = -1;
        boolean isNeg = false;
        if(s.isEmpty())
            return 0;
        if(s.length() == 1) {
            if(s.charAt(0) == '-' || s.charAt(0) == '+')
                return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if(i != s.length() - 1 && s.charAt(i) == '0' &&( s.charAt(i + 1) == ' ' || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'))
                return 0;
//            if( i != s.length() - 1 && s.charAt(i) == '0' && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'))
//                return 0;
            if( i != s.length() - 1 && i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+') && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) {
                return 0;
            }
            if (Character.isLetter(s.charAt(i))) {
                if (i == 0)
                    return 0;
            }
            if (Character.isDigit(s.charAt(i))  || s.charAt(i) == '.') {
                temp += s.charAt(i);
            } else if (s.charAt(i) == ' ' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                        if(s.charAt(i) == '-') isNeg = true;
                        digitStartIdx = i + 1;
                        break;
                    }
                }
            }
        }


        if (digitStartIdx != -1) {
            for (int i = digitStartIdx; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)))
                    break;
                temp += s.charAt(i);
            }
        }

        int newNumber = 0;
        for (char ch : temp.toCharArray()) {
            if(((int) ch - 48) < 0) {
                break;
            }
            int tempNewNumber = newNumber * 10 + Math.abs(48 - (int) ch);
            if(tempNewNumber/10 != newNumber) {
                if(isNeg) {
                    newNumber = Integer.MIN_VALUE * -1;
                } else {
                    newNumber = Integer.MAX_VALUE ;
                }
                return newNumber;
            }
            newNumber = tempNewNumber;
        }
        if(isNeg)
            newNumber *= -1;

        return newNumber;
    }
}
