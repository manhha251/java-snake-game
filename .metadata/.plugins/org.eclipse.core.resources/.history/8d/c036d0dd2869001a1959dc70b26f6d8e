package snake;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Render extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -828351722785477807L;
	private ArrayList<ObjectRender> render_list;
	
	public Render() {
		render_list = new ArrayList<>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (ObjectRender object: render_list) {
			object.render(g);
		}
	}
	
	public void addToRenderList(ObjectRender object) {
		render_list.add(object);
	}
	
	public void removeFromRenderList(ObjectRender object) {
		if (render_list.contains(object)) {
			render_list.remove(object);
		}
	}
	
	public ArrayList<ObjectRender> getRenderList() {
		return render_list;
	}
	
}
