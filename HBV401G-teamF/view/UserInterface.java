package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class UserInterface {

	protected Shell shlFlugLeitarvl;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UserInterface window = new UserInterface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFlugLeitarvl.open();
		shlFlugLeitarvl.layout();
		while (!shlFlugLeitarvl.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFlugLeitarvl = new Shell();
		shlFlugLeitarvl.setSize(617, 441);
		shlFlugLeitarvl.setText("Flug leitarv\u00E9l");
		
		List list = new List(shlFlugLeitarvl, SWT.BORDER);
		list.setBounds(10, 126, 581, 266);
		
		DateTime dateTime = new DateTime(shlFlugLeitarvl, SWT.BORDER);
		dateTime.setBounds(45, 49, 88, 22);
		
		Combo combo = new Combo(shlFlugLeitarvl, SWT.NONE);
		combo.setBounds(139, 49, 103, 23);
		
		Combo combo_1 = new Combo(shlFlugLeitarvl, SWT.NONE);
		combo_1.setBounds(424, 48, 111, 23);
		
		DateTime dateTime_1 = new DateTime(shlFlugLeitarvl, SWT.BORDER);
		dateTime_1.setBounds(318, 49, 100, 22);
		
		Label lblDepartureDate = new Label(shlFlugLeitarvl, SWT.NONE);
		lblDepartureDate.setBounds(45, 28, 88, 15);
		lblDepartureDate.setText("Departure date:");
		
		Label lblDepartureLocation = new Label(shlFlugLeitarvl, SWT.NONE);
		lblDepartureLocation.setText("Departure location:");
		lblDepartureLocation.setBounds(139, 28, 138, 15);
		
		Label lblReturnDate = new Label(shlFlugLeitarvl, SWT.NONE);
		lblReturnDate.setText("Return date:");
		lblReturnDate.setBounds(318, 28, 100, 15);
		
		Label lblReturnLocation = new Label(shlFlugLeitarvl, SWT.NONE);
		lblReturnLocation.setText("Return location:");
		lblReturnLocation.setBounds(424, 28, 100, 15);

	}
}
