import java.awt.Color;

public class Theme {
	
	public static final Theme CHRISTMAS = new Theme(new Color(15, 138, 95), new Color(35, 94, 111), new Color(245, 98, 77), new Color(212, 175, 55), new Color(204, 35, 30));
	public static final Theme Christmas = new Theme(new Color(15, 138, 95), new Color(35, 94, 111), new Color(245, 98, 77), new Color(212, 175, 55), new Color(204, 35, 30));
	public static final Theme christmas = new Theme(new Color(15, 138, 95), new Color(35, 94, 111), new Color(245, 98, 77), new Color(212, 175, 55), new Color(204, 35, 30));
	
	public static final Theme WINTER = new Theme(new Color(139, 197, 225), new Color(132, 150, 173), new Color(102, 126, 155), new Color(218, 243, 247), new Color(67, 91, 126));
	public static final Theme Winter = new Theme(new Color(139, 197, 225), new Color(132, 150, 173), new Color(102, 126, 155), new Color(218, 243, 247), new Color(67, 91, 126));
	public static final Theme winter = new Theme(new Color(139, 197, 225), new Color(132, 150, 173), new Color(102, 126, 155), new Color(218, 243, 247), new Color(67, 91, 126));
	
	public static final Theme THANKSGIVING = new Theme(new Color(112, 54, 42), new Color(161, 124, 34), new Color(222, 191, 126), new Color(181, 173, 21), new Color(213, 103, 59));
	public static final Theme Thanksgiving = new Theme(new Color(112, 54, 42), new Color(161, 124, 34), new Color(222, 191, 126), new Color(181, 173, 21), new Color(213, 103, 59));
	public static final Theme thanksgiving = new Theme(new Color(112, 54, 42), new Color(161, 124, 34), new Color(222, 191, 126), new Color(181, 173, 21), new Color(213, 103, 59));
	
	public static final Theme SUMMER = new Theme(new Color(255, 92, 1), new Color(255, 231, 83), new Color(255, 173, 94), new Color(255, 132, 22), new Color(255, 208, 1));
	public static final Theme Summer = new Theme(new Color(255, 92, 1), new Color(255, 231, 83), new Color(255, 173, 94), new Color(255, 132, 22), new Color(255, 208, 1));
	public static final Theme summer = new Theme(new Color(255, 92, 1), new Color(255, 231, 83), new Color(255, 173, 94), new Color(255, 132, 22), new Color(255, 208, 1));
	
	public static final Theme SUMMERHOLIDAY = new Theme(new Color(92, 187, 252), new Color(213, 249, 243), new Color(108, 230, 221), new Color(47, 156, 137), new Color(181, 238, 147));
	public static final Theme SummerHoliday = new Theme(new Color(92, 187, 252), new Color(213, 249, 243), new Color(108, 230, 221), new Color(47, 156, 137), new Color(181, 238, 147));
	public static final Theme summerholiday = new Theme(new Color(92, 187, 252), new Color(213, 249, 243), new Color(108, 230, 221), new Color(47, 156, 137), new Color(181, 238, 147));
	
	public static final Theme SUMMERAFTERNOON = new Theme(new Color(255, 179, 123), new Color(255, 255, 255), new Color(217, 225, 255), new Color(255, 247, 170), new Color(175, 197, 255));
	public static final Theme SummerAfternoon = new Theme(new Color(255, 179, 123), new Color(255, 255, 255), new Color(217, 225, 255), new Color(255, 247, 170), new Color(175, 197, 255));
	public static final Theme summerafternoon = new Theme(new Color(255, 179, 123), new Color(255, 255, 255), new Color(217, 225, 255), new Color(255, 247, 170), new Color(175, 197, 255));
	
	public static final Theme SPRING = new Theme(new Color(240, 168, 255), new Color(255, 240, 168), new Color(168, 240, 255), new Color(255, 140, 164), new Color(216, 255, 168));
	public static final Theme Spring = new Theme(new Color(240, 168, 255), new Color(255, 240, 168), new Color(168, 240, 255), new Color(255, 140, 164), new Color(216, 255, 168));
	public static final Theme spring = new Theme(new Color(240, 168, 255), new Color(255, 240, 168), new Color(168, 240, 255), new Color(255, 140, 164), new Color(216, 255, 168));
	
	private Color walls, start, end, path, backgr;
	
	public Theme(Color walls, Color start, Color end, Color path, Color backgr) {
		this.walls = walls; this.start = start; this.end = end; this.path = path; this.backgr = backgr;
	}
	
	public Theme(Theme theme) {
		this.walls = theme.getColor(); this.start = theme.getStart(); this.end = theme.getEnd(); this.path = theme.getPath(); this.backgr = theme.getBackgr();
	}
	
	public Theme() {
		this(Color.CYAN, Color.RED, Color.MAGENTA, Color.ORANGE, Color.WHITE);
	}

	public Color getColor() {
		return walls;
	}

	public Color getStart() {
		return start;
	}

	public Color getEnd() {
		return end;
	}

	public Color getPath() {
		return path;
	}
	
	public Color getBackgr() {
		return backgr;
	}
	
}
