public class Beetle extends Creature {
    Beetle(char _beetleChar) {
        creatureChar = _beetleChar;
    }
    public int move(String str) {
        int zeroCounter = numZeroGet(str);
        int direction = 0;
        switch (zeroCounter) {
            case 0:
                direction = 0;
                break;
            case 1:
                int case1Ind1 = 0, case1Ind2 = 0, case1Ind3 = 0;
                for (int i = 0; i < 4; i++) {
                    if (str.charAt(i) != '0' && case1Ind1 == 0) {
                        case1Ind1 = i;
                    }
                    else if (str.charAt(i) != '0' &&  case1Ind1 != 0 && case1Ind2 == 0) {
                        case1Ind2 = i;
                    }
                    else if (str.charAt(i) != '0' && case1Ind1 != 0 && case1Ind2 != 0 && case1Ind3 == 0) {
                        case1Ind3 = i;
                    }
                }
                if (str.charAt(case1Ind2) > str.charAt(case1Ind1)) {
                    direction = case1Ind1;
                }
                else if (str.charAt(case1Ind2) < str.charAt(case1Ind1)) {
                    direction = case1Ind2;
                }
                else {
                    direction = case1Ind1;
                }
            case 2:
                int case2Ind1 = 0, case2Ind2 = 0;
                for (int i = 0; i < 4; i++) {
                    if (str.charAt(i) != '0' && case2Ind1 == 0) {
                        case2Ind1 = i;
                    }
                    else if (str.charAt(i) != '0' &&  case2Ind1 != 0) {
                        case2Ind2 = i;
                    }
                }
                if (str.charAt(case2Ind2) > str.charAt(case2Ind1)) {
                    direction = case2Ind1;
                }
                else if (str.charAt(case2Ind2) < str.charAt(case2Ind1)) {
                    direction = case2Ind2;
                }
                else {
                    direction = case2Ind1;
                }
                break;
            case 3:
                if (str.charAt(0) != '0') {
                    direction = 0;
                }
                else if (str.charAt(1) != '0') {
                    direction = 1;
                }
                else if (str.charAt(2) != '0') {
                    direction = 2;
                }
                else if (str.charAt(3) != '0') {
                    direction = 3;
                }
                break;
            default:
                direction = -1;
                break;
        }
        return direction;
    }
    public int breed() {
        return 1;

    }
    public int starve() {
        return 2;
    }
    public char getChar () {
        return creatureChar;
    }
}