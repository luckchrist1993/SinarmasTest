import java.util.List;

public class DefenderArcade {
	
	public String setTime(String time) {
		if (time.length() == 3) {
			time = "0" + time;
		}
		time = time.substring(0, 2) + ":" + time.substring(2, 4);
		return time;
	}
	
	public int countArcades(List<String> times) {
		String lastTime = "";
		int result = 0;
		for (int i = 0; i < times.size(); i++) {
			String[] range = times.get(i).split(" ");
			if (i > 0) {
				String firstTime = setTime(range[0]);
				
				String[] splitLastTime = lastTime.split(":");
				String[] splitFirstTime = firstTime.split(":");
				
				int minuteLastTime = Integer.parseInt(splitLastTime[0]) * 60 + Integer.parseInt(splitLastTime[1]);
				int minuteFirstTime = Integer.parseInt(splitFirstTime[0]) * 60 + Integer.parseInt(splitFirstTime[1]);
				
				if (minuteLastTime > minuteFirstTime) {
					result++;
				}
			}
			lastTime = setTime(range[1]);
		}
		return result;
	}
}
