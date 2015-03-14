package blankDoc;
import java.util.Scanner;



public class BlankDoc {
	/*
	 * ==================================PROPERTIES==============================
	 * ==================
	 */
	private String type;
	private String receiver;
	private String sender;
	private String text;

	/*
	 * ==================================CONSTRUCTORS============================
	 * ===================
	 */
	/*public BlankDoc(String type, String receiver, String sender, String text) 
	{
		this.type = type;
		this.receiver = receiver;
		this.sender = sender;
		this.text = text;
	}

/*	public BlankDoc() // Constructor
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter type of the document: \t");
		setType(input.nextLine());
		
		System.out.print("Enter receiver of the document: \t");
		setReceiver(input.nextLine());
		
		System.out.print("Enter sender of the document: \t");
		setSender(input.nextLine());
		
		System.out.print("Enter text of the document: \t");
		setText(input.nextLine());
	}

	/*
	 * =================================GET/SET==================================
	 * ===================
	 */
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/*
	 * ====================================ACTION
	 * METHODS==========================================
	 */
	public void printDoc() {
		//text = formatText(getText());
		System.out
				.println("---------------------------------------------------------------------");
		System.out.print("\t \t \t \t \t \t \t \t \t To " + receiver
				+ "\n \n \t \t \t \t \t " + type + "\n\n\t \t \t \t \t From "
				+ sender + " \n\n Dear Sir/Madam " + receiver + "\n \n " + text
				+ "\n \n" + "\t \t \t \t \t \t \t \t \t Best Regards \n"
				+ "\t \t \t \t \t \t \t \t \t " + sender + "\n");
		System.out
				.println("---------------------------------------------------------------------");

	}

	public String formatText(String text) {

		int currentInverval = 1;
		int endLine = 1;
		String newText = "" + text.charAt(0);

		for (int i = 1; i < text.length(); i++) {

			if (text.charAt(i) == ' ') {
				currentInverval = i;
			}

			if (endLine % 70 != 0) {
				newText += text.charAt(i);
				++endLine;
			} else {
				newText = newText.substring(0, currentInverval) + "\n";
				i = currentInverval;
				endLine = 1;
			}
		}
		return newText;
	}
	public void writeInFile() {
		Scanner input = new Scanner(System.in);
		String output;
		System.out.println("Enter FileName: ");
		String nameFile=input.nextLine();
		output = ("\t \t \t \t \t \t \t \t \t To " + receiver
				+ "\n \n \t \t \t \t \t " + type + "\n\n\t \t \t \t \t From "
				+ sender + " \n\n Dear Sir/Madam " + receiver + "\n \n " + text
				+ "\n \n" + "\t \t \t \t \t \t \t \t \t Best Regards \n"
				+ "\t \t \t \t \t \t \t \t \t " + sender + "\n");
		java.io.PrintStream out = null;
		try {
			out = new java.io.PrintStream(new java.io.FileOutputStream(
					nameFile+".doc"));
			out.print(output);

		} catch (java.io.FileNotFoundException e) {
			System.err.println("FileNotFound");
			return;
		} finally {
			if (out != null)
				out.close();
		}
	}
}
