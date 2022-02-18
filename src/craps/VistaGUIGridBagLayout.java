package craps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import misComponentes.Titulos;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIGridBagLayout.
 */
public class VistaGUIGridBagLayout extends JFrame {
	
	/** The zona resultados. */
	//atributos
	private JPanel zonaJuego, zonaResultados;
	private JLabel dado1, dado2, tiro, punto;
	private JTextField valorTiro, valorPunto;
	private JButton salir, lanzar;
	private ImageIcon imagen;
	private JTextArea mensajes;
	private Titulos titulo, resultados;
	private ControlCraps controlCraps; 
	private Escucha escucha;
	private JFrame vistaGridBagLayout;
	
	//metodos
	
    /**
	 * Instantiates a new vista GUI grid bag layout.
	 */
	public VistaGUIGridBagLayout() {
	    initGUI();
	
	    //set default window configuration
		//this.setTitle("Juego Craps");
	    this.setUndecorated(true);
	    this.setBackground(new Color(0,0,0,10));
		this.pack();
		//this.setSize(310,180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    }

	/**
	 * Inits the GUI.
	 */
	private void initGUI() {
		// set up conatainer - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		
		
		// create objectos escucha control y cualquier otro
		escucha = new Escucha();
		controlCraps = new ControlCraps();
		vistaGridBagLayout=this;
		
		//set up GUIComponents
		titulo = new Titulos("Juego Craps", 30, new Color(0,0,0));
		titulo.addMouseListener(escucha);
		titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		contraints.gridx=0;
		contraints.gridy=0;	
		contraints.gridwidth=2;
		contraints.fill=GridBagConstraints.HORIZONTAL;
		
		add(titulo,contraints);
		
		//zonaJuego
		zonaJuego = new JPanel();
		imagen = new ImageIcon("src/imagenes/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);
		lanzar = new JButton("lanzar");
		lanzar.addActionListener(escucha);
		zonaJuego.add(dado1);
		zonaJuego.add(dado2);
		zonaJuego.add(lanzar);
		zonaJuego.setPreferredSize(new Dimension(310,180));
		zonaJuego.setBorder(new TitledBorder("zona juego"));
		contraints.gridx=0;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=3;
		contraints.fill=GridBagConstraints.NONE;
		
		add(zonaJuego, contraints);
		
		//salir
		salir = new JButton("salir");
		salir.addActionListener(escucha);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contraints.gridx=0;
		contraints.gridy=4;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.LAST_LINE_END;
		
		add(salir, contraints);
		
		//titulos resultados
		resultados = new Titulos("Resultados",24,new Color(255, 20,155));
		contraints.gridx=1;
		contraints.gridy=1;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.HORIZONTAL;
		contraints.anchor=GridBagConstraints.CENTER;
		
		add(resultados, contraints);
		
		//zonaResultados
		zonaResultados = new JPanel();
		zonaResultados.setLayout(new GridLayout(2,2));
		zonaResultados.setBackground(new Color(0,0,0,0));
		tiro = new JLabel("Tiro");
		punto = new JLabel("Punto");
		valorTiro = new JTextField(2);
		valorTiro.setEditable(false);
		valorPunto = new JTextField(2);
		valorPunto.setEditable(false);
		zonaResultados.add(tiro);
		zonaResultados.add(valorTiro);
		zonaResultados.add(punto);
		zonaResultados.add(valorPunto);
		zonaResultados.setBackground(Color.WHITE);
		contraints.gridx=1;
		contraints.gridy=2;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill=GridBagConstraints.NONE;
		contraints.anchor=GridBagConstraints.CENTER;
		
		add(zonaResultados,contraints);
		
		//mensaje
		
		mensajes = new JTextArea(10,20);
		mensajes.setText("Lanza los dados para iniciar el juego. \n");
		mensajes.setEditable(false);
		JScrollPane scroll = new JScrollPane(mensajes);
		contraints.gridx=1;
		contraints.gridy=3;
		contraints.gridwidth=1;
		contraints.gridheight=2;
		contraints.fill=GridBagConstraints.VERTICAL;
		contraints.anchor=GridBagConstraints.CENTER;
		
		add(scroll,contraints);
		
	}

    /**
     * The Class Escucha.
     */
    private class Escucha implements ActionListener, MouseListener, MouseMotionListener {
    	
    	/** The y. */
	    private int x, y;
    	
	    /**
	     * Action performed.
	     *
	     * @param eventAction the event action
	     */
	    @Override
    	public void actionPerformed(ActionEvent eventAction) {
    		// TODO Auto-generated method stub
    		if(eventAction.getSource()==salir) {
    			System.exit(0);
    		}else {
    			controlCraps.calcularTiro();
    			imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados1()+".png");
    			dado1.setIcon(imagen);
    			imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados2()+".png");
    			dado2.setIcon(imagen);
    			
    			controlCraps.determinarJuego();
    			valorTiro.setText(String.valueOf(controlCraps.getTiro()));
    			
    			switch(controlCraps.getEstado()) {
    			case 1://gano
    				   mensajes.append("Has ganado!! \n");
    			       break;
    			case 2://perdio
 				       mensajes.append("Has perdido!! \n");
    				   break;
    			case 3://punto
    				   valorPunto.setText(String.valueOf(controlCraps.getPunto()));
    				   String mensaje = "Estas en punto!!  \nDebes seguir lanzando  \n"+
    				                    "Ganas si sacas nuevamente "+String.valueOf(controlCraps.getPunto())+
    				                    "\nPierde si antes sacas 7 \n";
    				   mensajes.append(mensaje);
    				   break;
    			}
    		}
    	
    	}

		/**
		 * Mouse clicked.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseClicked(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			//zonaResultados.setBackground(Color.CYAN);
			
		}

		/**
		 * Mouse pressed.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			//lanzar.setBackground(Color.RED);
			x = eventMouse.getX();
			y = eventMouse.getY();
			//System.out.println("x="+x);
			//System.out.println("y="+y);
			
			
		}

		/**
		 * Mouse released.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseReleased(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			salir.setBackground(Color.ORANGE);
			
		}

		/**
		 * Mouse entered.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			//salir.setBackground(Color.BLUE);
			
		}

		/**
		 * Mouse exited.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse) {
			// TODO Auto-generated method stub
			//salir.setBackground(Color.GREEN);
			
		}

		/**
		 * Mouse dragged.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			//System.out.println("Mouse Motion Dragged"+eventMouseMotion.getX()); 
			setLocation(vistaGridBagLayout.getLocation().x+eventMouseMotion.getX()-x,
					    vistaGridBagLayout.getLocation().y+eventMouseMotion.getY()-y);
		}

		/**
		 * Mouse moved.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			//System.out.println("Mouse Motion Moved"+eventMouseMotion.getX()); 
			
		}
    	
    }

}
