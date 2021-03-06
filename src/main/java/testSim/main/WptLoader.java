package testSim.main;

//comment
import edu.illinois.mitra.cyphyhouse.objects.ItemPosition;
import edu.illinois.mitra.cyphyhouse.objects.PositionList;

import java.io.*;
public final class WptLoader {
	
	private WptLoader() {
	}
	
	public static PositionList<ItemPosition> loadWaypoints(String file) {
		PositionList<ItemPosition> waypoints = new PositionList<>();
		BufferedReader in = null;
        InputStream inputStream =
                WptLoader.class.getClassLoader().getResourceAsStream(file);
        if(inputStream != null){
            in = new BufferedReader(new InputStreamReader(inputStream));
        }else{

            try {
                in = new BufferedReader(new FileReader("waypoints/" + file));
            } catch (FileNotFoundException e) {
                System.err.println("File " + file + " not found! No waypoints loaded.");
                return new PositionList<>();
            }
        }
		String line;
		try {
			while((line = in.readLine()) != null) {
				String[] parts = line.replace(" ", "").split(",");
				if(parts[0].equals("WAY") && parts.length == 6) {
					System.out.println(Integer.parseInt(parts[1]));
					System.out.println(Integer.parseInt(parts[2]));
					System.out.println(Integer.parseInt(parts[3]));
					System.out.println(parts[5]);
					ItemPosition wpt = new ItemPosition(parts[4], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[5]));
					waypoints.update(wpt);
				}
				if(parts[0].equals("WAY") && parts.length == 5) {
					ItemPosition wpt = new ItemPosition(parts[4], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
					waypoints.update(wpt);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading waypoints file!");
		}
		return waypoints;
	}
}
