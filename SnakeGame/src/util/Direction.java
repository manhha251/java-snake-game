package util;

public enum Direction {
	UP(0, -1) {
		@Override
		public Direction opposite() {
			// TODO Auto-generated method stub
			return DOWN;
		}
	},
	DOWN(0, 1) {
		@Override
		public Direction opposite() {
			// TODO Auto-generated method stub
			return UP;
		}
	},
	LEFT(-1, 0) {
		@Override
		public Direction opposite() {
			// TODO Auto-generated method stub
			return RIGHT;
		}
	},
	RIGHT(1, 0) {
		@Override
		public Direction opposite() {
			// TODO Auto-generated method stub
			return LEFT;
		}
	};
	
	public int x, y;
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract Direction opposite();
}
