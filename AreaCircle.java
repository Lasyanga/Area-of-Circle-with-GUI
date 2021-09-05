import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class AreaCircle extends JFrame implements KeyListener{

	private JLabel arealbl;
	private JTextField diametertxt, radiustxt, areatxt;

	private double radius, diameter, area;

	public AreaCircle(){
		initialized();
	}

	private void initialized(){
		Border border = BorderFactory.createLineBorder(Color.red, 1);

		this.setTitle("Area of Circle");
		this.setSize(new Dimension(300, 200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		JLabel l1 = new JLabel("Diameter:");
		l1.setFont(new Font("Consolas", Font.PLAIN, 14));
		l1.setForeground(Color.black);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setLocation(new Point(5, 10));
		l1.setSize(new Dimension(80, 30));
		l1.setOpaque(true);
		l1.setBackground(Color.decode("#ff8c1a"));

		diametertxt = new JTextField();
		diametertxt.setFont(new Font("Consolas", Font.PLAIN, 14));
		diametertxt.setForeground(Color.black);
		diametertxt.setHorizontalAlignment(JTextField.CENTER);
		diametertxt.setSize(new Dimension(180, 30));
		diametertxt.setLocation(new Point(90, 10));
		diametertxt.addKeyListener(this);

		JLabel l2 = new JLabel("Radius:");
		l2.setFont(new Font("Consolas", Font.PLAIN, 14));
		l2.setForeground(Color.black);
		l2.setSize(new Dimension(80, 30));
		l2.setLocation(new Point(5, 50));
		l2.setOpaque(true);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setBackground(Color.decode("#d966ff"));

		radiustxt = new JTextField();
		radiustxt.setFont(new Font("Consolas", Font.PLAIN, 14));
		radiustxt.setHorizontalAlignment(JTextField.CENTER);
		radiustxt.setForeground(Color.black);
		radiustxt.setSize(new Dimension(180, 30));
		radiustxt.setLocation(new Point(90, 50));
		radiustxt.addKeyListener(this);

		JLabel l3 = new JLabel("Area:");
		l3.setFont(new Font("Consolas", Font.PLAIN, 14));
		l3.setForeground(Color.black);
		l3.setSize(new Dimension(80, 30));
		l3.setLocation(new Point(5, 90));
		l3.setOpaque(true);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setBackground(Color.decode("#6666ff"));

		areatxt  = new JTextField();
		areatxt.setFont(new Font("Consolas", Font.PLAIN, 14));
		areatxt.setForeground(Color.black);
		areatxt.setSize(new Dimension(180, 30));
		areatxt.setLocation(new Point(90, 90));
		areatxt.setHorizontalAlignment(JTextField.CENTER);
		areatxt.addKeyListener(this);

		this.add(l1);
		this.add(l2);
		this.add(l3);
		this.add(diametertxt);
		this.add(radiustxt);
		this.add(areatxt);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	private void diameter(double diameter){
		this.radius = diameter / 2;
		this.area = Math.PI * Math.pow(radius, 2);

		radiustxt.setText(String.valueOf(this.radius));
		areatxt.setText(String.valueOf(this.area));
	}

	private void radius(double radius){
		this.diameter = radius * 2;
		this.area = Math.PI * Math.pow(radius, 2);

		diametertxt.setText(String.valueOf(this.diameter));
		areatxt.setText(String.valueOf(this.area));
	}

	private void area(double area){
		this.radius = Math.sqrt(area / Math.PI);
		this.diameter = radius * 2;

		radiustxt.setText(String.valueOf(this.radius));
		diametertxt.setText(String.valueOf(this.diameter));
	}

	@Override
	public void keyTyped(KeyEvent e){
		if(e.getSource() == diametertxt){
			char ch = e.getKeyChar();
			if(!Character.isDigit(ch) && ch != '.' && !Character.isISOControl(ch)){
				e.consume();
			}
		}

		if(e.getSource() == radiustxt){
			char ch = e.getKeyChar();
			if(!Character.isDigit(ch) && ch != '.' && !Character.isISOControl(ch)){
				e.consume();
			}
		}

		if(e.getSource() == areatxt){
			char ch = e.getKeyChar();
			if(!Character.isDigit(ch) && ch != '.' && !Character.isISOControl(ch)){
				e.consume();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e){


	}

	@Override
	public void keyReleased(KeyEvent e){
		if(e.getSource() == diametertxt){
			if(!diametertxt.getText().isEmpty()){
				diameter(Double.parseDouble(diametertxt.getText()));
			}else{
				diameter(0d);
			}
			
		}

		if(e.getSource() == radiustxt){
			if(!radiustxt.getText().isEmpty()){
				radius(Double.parseDouble(radiustxt.getText()));
			}else{
				radius(0d);
			}
			
		}

		if(e.getSource() == areatxt){
			if(!areatxt.getText().isEmpty()){
				area(Double.parseDouble(areatxt.getText()));
			}else{
				area(0d);
			}
			
		}
		
	}

	public static void main(String []args){
		new AreaCircle();
	}
}