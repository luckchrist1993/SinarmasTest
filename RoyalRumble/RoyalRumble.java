import java.util.Collections;
import java.util.List;

public class RoyalRumble {
	
	public String encodeRomawi(int number) {
		String result = "";
		String temp = "";
		while (number != 0) {
			String parse = String.valueOf(number);
			if (
				parse.charAt(parse.length() - 1) == '4' ||
				parse.charAt(parse.length() - 1) == '9'
			) {
				switch (parse.charAt(parse.length() - 1)) {
				case '4':
					number -= 4;
					temp = "IV";
					break;
				case '9':
					number -= 9;
					temp = "IX";
					break;
				default:
					break;
				}
		    } else {
		    	if (number >= 1000) {
					number -= 1000;
					result += "M";
				} else if (number >= 500) {
					number -= 500;
					result += "D";
				} else if (number >= 100) {
					number -= 100;
					result += "C";
				} else if (number >= 50) {
					number -= 50;
					result += "L";
				} else if (number >= 10) {
					number -= 10;
					result += "X";
				} else if (number >= 5) {
					number -= 5;
					result += "V";
				} else if (number >= 1) {
					number -= 1;
					result += "I";
				}
			}
		}
		return result + temp;
	}
	
	public int decodeRomawi(String romawi) {
		int result = 0;
		for (int j = 0; j < romawi.length(); j++) {
			if (
				j == romawi.length() - 1 && (
					romawi.charAt(j) == 'V' ||
					romawi.charAt(j) == 'X'
				)
			) {
				switch (romawi.substring(j - 1, j + 1)) {
				case "IV":
					result += 3;
					break;
				case "IX":
					result += 8;
					break;
				default:
					break;
				}
			} else {
				switch (romawi.charAt(j)) {
				case 'M':
					result += 1000;
					break;
				case 'D':
					result += 500;
					break;
				case 'C':
					result += 100;
					break;
				case 'L':
					result += 50;
					break;
				case 'X':
					result += 10;
					break;
				case 'V':
					result += 5;
					break;
				case 'I':
					result += 1;
					break;
				default:
					break;
				}
			}
		}
		return result;
	}

	public List<String> getSortedList(List<String> names) {
		Collections.sort(names);
		for (int i = 0; i < names.size(); i++) {
			int amount = 0;
			String[] justSplit = names.get(i).split(" ");
			amount = decodeRomawi(justSplit[1]);
			names.set(i, justSplit[0] + " " + amount);
		}
		Collections.sort(names);
		for (int i = 0; i < names.size(); i++) {
			String romawi = "";
			String[] justSplit = names.get(i).split(" ");
			romawi = encodeRomawi(Integer.parseInt(justSplit[1]));
			names.set(i, justSplit[0] + " " + romawi);
		}
	    return names;
	}
}
