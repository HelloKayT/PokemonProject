public class PictureMaker {
	public static final int SPRITEW = 50;
	public static final int SPRITEH = 60;
	public static final int BATTLEW = 100;
	public static final int BATTLEH = 130;

	public static void main(String[] args) {
		String toFix = args[0];
		int period = toFix.lastIndexOf('.');
		String pieces = toFix.substring(0, period);
		Picture source = new Picture(toFix);
		Picture sprite = new Picture(SPRITEW, SPRITEH);
		Picture battle = new Picture(BATTLEW, BATTLEH);

		for (int tx = 0; tx < SPRITEW; tx++) {
			for (int ty = 0; ty < SPRITEH; ty++) {
				int sx = tx * source.width() / SPRITEW;
				int sy = ty * source.height() / SPRITEH;
				sprite.set(tx, ty, source.get(sx, sy));
			}
		}

		for (int tx = 0; tx < BATTLEW; tx++) {
			for (int ty = 0; ty < BATTLEH; ty++) {
				int sx = tx * source.width() / BATTLEW;
				int sy = ty * source.height() / BATTLEH;
				battle.set(tx, ty, source.get(sx, sy));
			}
		}
		sprite.save(pieces + ".jpg");
		battle.save(pieces + ".png");
		Display.setBounds();
		StdDraw.picture(0, 0, pieces + ".jpg");
		StdDraw.picture(0.5, 0.5, pieces + ".png");
	}
}